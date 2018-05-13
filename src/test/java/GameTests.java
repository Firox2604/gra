import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTests {
    private  Game game;

    @Before
    public void setUp()
    {
        game = new Game();
    }
    @Test
    public void gameExist() {
        assertNotNull(game);
    }

    @Test(expected = RuntimeException.class)
    public void whenMoveOuterBoundThenException() {
        game.placeMark(5, -1);
        game.placeMark(-2, 4);

    }

    @Test(expected = RuntimeException.class)
    public void whenFieldIsOccupiedTheException() {
        game.placeMark(2,2);
        game.placeMark(2,2);
    }
}