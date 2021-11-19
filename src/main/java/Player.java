import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerId;
    private final List<Card> playerCards;

    public Player(String playerId) {
        this.playerId = playerId;
        this.playerCards = new ArrayList<>();
    }

    public String getPlayerId() {
        return playerId;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void acceptDeal(Card card) {
        this.playerCards.add(card);
    }

    public int getPlayerScore() {
        return playerCards.stream().mapToInt(Card::getValue).sum();
    }

    public boolean isWinner() {
        return false;
    }
}
