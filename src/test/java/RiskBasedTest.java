import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiskBasedTest {

    Player player;
    Card card1;
    Card card2;

    @BeforeEach
    void setUp() {
        this.card1 = new Card(Suit.CLUB, "10 Of Clubs", 10);
        this.card2 = new Card(Suit.CLUB, "6 Of Hearts", 6);
        this.player = new Player("1", new RiskBased());
    }

    @AfterEach
    void tearDown() {
        this.player = null;
        this.card1 = null;
        this.card2 = null;
    }

    @Test
    void testPlayerAcceptsCardWhenScoreIsLessThan17() {
        this.player.acceptDeal(card1);
        this.player.acceptDeal(card2);
        assertTrue(this.player.getPlayerStrategyChoice(), "Player does not accept card when score below 17");
    }

    @Test
    void testPlayerDoesNotAcceptCardAfterScoreIsGreaterThan17() {
        this.card2.setValue(10);
        this.player.acceptDeal(card1);
        this.player.acceptDeal(card2);
        assertFalse(this.player.getPlayerStrategyChoice(), "Player does accepts card even after score is greater than 17");
    }
}
