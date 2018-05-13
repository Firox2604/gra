public class Game {
    static final Character EMPTY = ' ';
    private Character[][] gameBoard = {
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY},
            {EMPTY,EMPTY,EMPTY}
    };
    private void isValidPlace(int position)
    {
        if(position  < 1 || position > 3)
        {
            throw new RuntimeException();
        }
    }

    public void placeMark(int c, int r){
        isValidPlace(c);
        isValidPlace(r);
        if(isAvailablePlace(c,r))
        {
            gameBoard[c - 1][r - 1] = 'X';
        }
    }

    private boolean isAvailablePlace(int c, int r) {
        Character field = gameBoard[c - 1][r - 1];
        if(field != EMPTY)
        {
            throw new RuntimeException("Field already occupied");
        }
        return true;
    }
}
