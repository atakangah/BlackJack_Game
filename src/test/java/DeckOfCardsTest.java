import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testShuffleStillHas52Cards() {
        deckOfCards.shuffleCards();
        assertEquals(52, deckOfCards.getDeckOfCards().size(), "Deck of cards does not have size 52");
    }

    @Test
    void testCardsAreShuffled() {
        deckOfCards.shuffleCards();
        assertNotEquals("2 Of Hearts", deckOfCards.getDeckOfCards().get(0).getCardName(), "2 of Hearts is still in its place");
    }
}