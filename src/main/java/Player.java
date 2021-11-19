import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerId;
    private Strategy playerStrategy;
    private final List<Card> playerCards;

    public Player(String playerId, Strategy playerStrategy) {
        this.playerId = playerId;
        this.playerStrategy = playerStrategy;
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

    public boolean getPlayerStrategyChoice() {
        return this.playerStrategy.getStrategyChoice(this);
    }
}
