import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int numberOfPlayers;
    private final List<Player> gamePlayers;
    private DeckOfCards deckOfCards;
    boolean isStartOfGame = true;

    public Game(int numberOfPlayers) {
        this.gamePlayers = new ArrayList<>();
        this.numberOfPlayers = numberOfPlayers;

        initGame();
    }

    public void initGame() {
        deckOfCards = new DeckOfCards();
        deckOfCards.shuffleCards();

        for (int i = 1; i <= this.numberOfPlayers; i++) {
            this.gamePlayers.add(new Player(i));
        }
    }

    public void playGame() {
        do {
            gamePlayers.stream().filter(player -> player.getPlayerScore() < 17).forEach(player -> this.deckOfCards.dealCards(player, isStartOfGame ? 2 : 1));
            isStartOfGame = false;
            checkGameStatus();
        } while (!isGameEnd());
        getWinner();
    }

    public void checkGameStatus() {
        List<Player> bustPlayers = gamePlayers.stream().filter(player -> player.getPlayerScore() > 21).collect(Collectors.toList());
        bustPlayers.stream().forEach(player -> this.gamePlayers.remove(player));
    }

    public boolean isGameEnd() {
        List<Player> stuckPlayers = this.gamePlayers.stream().filter(player -> player.getPlayerScore() >= 17).collect(Collectors.toList());
        if (stuckPlayers.size() == gamePlayers.size()) return true;

        List<Player> exactly21Players = this.gamePlayers.stream().filter(player -> player.getPlayerScore() == 21).collect(Collectors.toList());
        if (exactly21Players.size() > 0) {
            // TO-DO
            // Calculate game winner (must be player with highest score but below 21)
            getWinner();
            return true;
        }

        if (gamePlayers.size() == 1) return true;

        return false;
    }

    public int getWinner() {
        if (gamePlayers.size() == 1) return gamePlayers.get(0).getPlayerId();

        int maximumScore = gamePlayers.stream().filter(player -> player.getPlayerScore() < 21).mapToInt(player -> player.getPlayerScore()).max().orElse(-2);
        if (maximumScore == -2) return -2;
        else if (maximumScore != -2)
            return gamePlayers.stream().filter(player -> player.getPlayerScore() == maximumScore).findFirst().orElse(null).getPlayerId();

        return -1;
    }
}