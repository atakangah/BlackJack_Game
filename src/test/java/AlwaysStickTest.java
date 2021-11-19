import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysStickTest {
    Player player;
    Card card1;
    Card card2;
    @BeforeEach
    void setUp() {
        this.card1 = new Card(Suit.CLUB, "2 Of Clubs", 2);
        this.card2 = new Card(Suit.CLUB, "5 Of Hearts", 5);
        this.player = new Player("1", new AlwaysStick());
    }

    @AfterEach
    void tearDown() {
        this.player = null;
        this.card1 = null;
        this.card2 = null;
    }

    @Test
    void testReturnsFalseAfterPlayerDealtTwoCards() {
        this.player.acceptDeal(card1);
        this.player.acceptDeal(card2);
        assertFalse(this.player.getPlayerStrategyChoice(), "Player is still accepting cards");
    }
}