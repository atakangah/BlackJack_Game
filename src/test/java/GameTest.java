import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game(List.of(new Player("1", new Default()), new Player("2", new Default())));
    }

    @AfterEach
    void tearDown() {
        game = null;
    }

    @Test
    void testGameWinner() {

    }
}