import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysHitTest {
    AlwaysHit alwaysHit;
    Player player;
    Card card1;
    Card card2;

    @BeforeEach
    void setUp() {
        this.card1 = new Card(Suit.CLUB, "10 Of Clubs", 10);
        this.card2 = new Card(Suit.CLUB, "7 of Clubs", 7);
        this.player = new Player("1", new AlwaysHit());
    }

    @AfterEach
    void tearDown() {
        this.alwaysHit = null;
    }

    @Test
    void testPlayerAlwaysAcceptsCard() {
        this.player.acceptDeal(card1);
        this.player.acceptDeal(card2);
        assertTrue(this.player.getPlayerStrategyChoice(), "Player is not accepting cards anymore");
    }
}