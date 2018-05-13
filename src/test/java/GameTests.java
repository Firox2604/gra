import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

//import static org.junit.Assert.*;


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

    @Test
    public void whenIsNewGameNextPlayerIsX() {
        Character player = game.getNextPlayer();
        assertThat('X', is(equalTo(player)));
    }

    @Test
    public void secondMoveIsForPlayer() {
        game.placeMark(1,1);
        Character player = game.getNextPlayer();
        assertThat('O', is(equalTo(player)));
    }

    @Test
    public void secondMoveIsForPlayerOAndMarkIsO() {
        game.placeMark(1,1);
        game.placeMark(2,2);
        Character xSign = game.getMarkSightAt(1,1);
        Character oSign = game.getMarkSightAt(2,2);
        assertThat('X', is(equalTo(xSign)));
        assertThat('O', is(equalTo(oSign)));
    }

    @Test
    public void threeSignInRowAtRowWin() {
//        game.placeMark(1,1);
//        game.placeMark(2,3);
//        game.placeMark(2,1);
//        game.placeMark(2,2);
//        game.placeMark(3,1);
        game.placeMark(1,2);
        game.placeMark(1,1);
        game.placeMark(2,2);
        game.placeMark(3,1);
        game.placeMark(3,2);
        String winner = game.andTheWinnerIs();
        assertThat(winner, is(equalTo("The winner is X")));
    }

    @Test
    public void threeSignInRowAtColumnWin() {
        game.placeMark(1,1);
        game.placeMark(3,1);
        game.placeMark(1,2);
        game.placeMark(3,2);
        game.placeMark(2,2);
        game.placeMark(3,3);
        String winner = game.andTheWinnerIs();
        assertThat(winner, is(equalTo("The winner is O")));
    }

    @Test
    public void threeSignInRowAtDiagonalFromLeftToRightWin() {
        game.placeMark(2,1);
        game.placeMark(1,1);
        game.placeMark(3,1);
        game.placeMark(2,2);
        game.placeMark(1,3);
        game.placeMark(3,3);
        String winner = game.andTheWinnerIs();
        assertThat(winner, is(equalTo("The winner is O")));
    }

    @Test
    public void threeSignInRowAtDiagonalFromRightToLeftWin() {
        game.placeMark(2,1);//x
        game.placeMark(3,1);//o
        game.placeMark(3,2);//x
        game.placeMark(2,2);//o
        game.placeMark(2,3);//x
        game.placeMark(1,3);//o
        String winner = game.andTheWinnerIs();
        assertThat(winner, is(equalTo("The winner is O")));
    }
}