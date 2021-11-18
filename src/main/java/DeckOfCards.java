import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final List<Card> deckOfCards;

    public DeckOfCards() {
        deckOfCards = new ArrayList<Card>();
        createDeckCards();
        shuffleCards();
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void createDeckCards() {
        for (int i = 2; i <= 14; i++) deckOfCards.add(new Card(Suit.HEART, generateCardName(i) + " Of Hearts", i));
        for (int i = 2; i <= 14; i++) deckOfCards.add(new Card(Suit.DIAMOND, generateCardName(i) + " Of Diamonds", i));
        for (int i = 2; i <= 14; i++) deckOfCards.add(new Card(Suit.SPADE, generateCardName(i) + " Of Spades", i));
        for (int i = 2; i <= 14; i++) deckOfCards.add(new Card(Suit.CLUB, generateCardName(i) + " Of Clubs", i));
    }

    private String generateCardName (int cardValue) {
        String cardName = cardValue+"";
        if (cardValue == 11) cardName = "Jack";
        if (cardValue == 12) cardName = "Queen";
        if (cardValue == 13) cardName = "King";
        if (cardValue == 14) cardName = "Ace";
        return cardName;
    }

    public void dealCards(Player player, int numberOfCards) {
        for(int i = 0; i  < numberOfCards; i++) {
            Card card = deckOfCards.get(0);
            player.acceptDeal(card);
            removeDealtCard();
        }
    }

    private void removeDealtCard() {
        deckOfCards.remove(0);
    }

    public void shuffleCards() {
        Random r = new Random();
        for (int i = deckOfCards.size()-1; i > 0; i--) {
            int j = r.nextInt(i + 1);

            Card temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(j));
            deckOfCards.set(j, temp);
        }
    }
}
