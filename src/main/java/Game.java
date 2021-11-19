import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Player> gamePlayers;
    private DeckOfCards deckOfCards;
    boolean isStartOfGame = true;

    public Game(List<Player> gamePlayers) {
        this.gamePlayers = gamePlayers;

        initGame();
        playGame();
    }

    public void initGame() {
        deckOfCards = new DeckOfCards();
        deckOfCards.shuffleCards();
    }

    public void playGame() {
        int currentRound = 1;
        do {
            logRound(currentRound);
            gamePlayers.stream().filter(player -> player.getPlayerStrategyChoice()).forEach(player -> this.deckOfCards.dealCards(player, isStartOfGame ? 2 : 1));
            isStartOfGame = false;
            checkGameStatus();
            currentRound+=1;
        } while (!isGameEnd());
        System.out.println("\nThe winner is: " + getWinner());
    }

    public void logRound(int currentRound) {
        System.out.println("\nRound " + currentRound + "\n");
    }

    public void checkGameStatus() {
        List<Player> bustPlayers = gamePlayers.stream().filter(player -> player.getPlayerScore() > 21).collect(Collectors.toList());
        bustPlayers.stream().forEach(player -> this.gamePlayers.remove(player));
    }

    public boolean isGameEnd() {
        List<Player> stuckPlayers = this.gamePlayers.stream().filter(player -> player.getPlayerScore() >= 17).collect(Collectors.toList());
        if (stuckPlayers.size() == gamePlayers.size()) return true;

        List<Player> exactly21Players = this.gamePlayers.stream().filter(player -> player.getPlayerScore() == 21).collect(Collectors.toList());
        if (exactly21Players.size() > 0) return true;

        if (gamePlayers.size() == 1) return true;

        return false;
    }

    public String getWinner() {
        if (gamePlayers.size() == 1) return gamePlayers.get(0).getPlayerId();

        List<Player> possibleWinners = gamePlayers.stream().filter(player -> player.getPlayerScore() == 21).collect(Collectors.toList());
        if (possibleWinners.size() > 0) return possibleWinners.stream().findFirst().orElse(null).getPlayerId();

        int max = gamePlayers.stream().mapToInt(Player::getPlayerScore).max().orElse(0);
        return gamePlayers.stream().filter(player -> player.getPlayerScore() == max).findFirst().orElse(null).getPlayerId();
    }
}