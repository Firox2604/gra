import org.junit.Test;

import static org.junit.Assert.*;

public class GameTests {

    @Test
    public void gameExist() {
        Game game = new Game();
        assertNoNull(game);
    }
}