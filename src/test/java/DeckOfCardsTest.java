import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    DeckOfCards deckOfCards;

    @BeforeEach
    void setUp() {
        deckOfCards = new DeckOfCards();
    }

    @AfterEach
    void tearDown() {
        deckOfCards = null;
    }

    @Test
    void testDeckHas52Cards() {
        assertEquals(52, deckOfCards.getDeckOfCards().size(), "Deck of cards does not have size 52");
    }
}