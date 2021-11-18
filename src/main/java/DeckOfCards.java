import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DeckOfCards {
    private final List<Card> deckOfCards;

    public DeckOfCards() {
        deckOfCards = new ArrayList<Card>();
        createDeckCards();
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void createDeckCards() {
        IntStream.iterate(0, i -> i + 1).forEach(System.out::println);
    }
}
