import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game(2);
    }

    @AfterEach
    void tearDown() {
        game = null;
    }
    @Test
    void testGameWinner () {

    }
}