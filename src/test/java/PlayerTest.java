import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    DeckOfCards deckOfCards;

    @BeforeEach
    void setUp() {
        player = new Player("1");
        deckOfCards = new DeckOfCards();
    }

    @AfterEach
    void tearDown() {
        player = null;
        deckOfCards = null;
    }

    @Test
    void testPlayerAcceptCards(){
        assertEquals(0, player.getPlayerCards().size(),"player has more than 0 cards");
        deckOfCards.dealCards(player, 1);
        assertEquals(1, player.getPlayerCards().size(), "player does not have one card");
    }
}