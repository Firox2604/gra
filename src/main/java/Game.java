public class Game {
    static final Character EMPTY = ' ';
    private Character[][] gameBoard = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    private Character nextPLayer = 'X';

    private String winner = "NN";

    private void isValidPlace(int position) {
        if (position < 1 || position > 3) {
            throw new RuntimeException();
        }
    }

    public void placeMark(int c, int r) {
        isValidPlace(c);
        isValidPlace(r);
        if (isAvailablePlace(c, r)) {
            gameBoard[c - 1][r - 1] = nextPLayer;
        }

        isTheWinnerKnown();
        changeNextPlayer();
    }

    private void isTheWinnerKnown() {
        for (int iterator = 1; iterator < 4; iterator++) {
            if (getMarkSightAt(1, iterator)
                    + getMarkSightAt(2, iterator)
                    + getMarkSightAt(3, iterator)
                    == nextPLayer * 3) {
                winner = String.valueOf(nextPLayer);
                return;
            }

            if (getMarkSightAt(iterator, 1)
                    + getMarkSightAt(iterator, 2)
                    + getMarkSightAt(iterator, 3)
                    == nextPLayer * 3) {
                winner = String.valueOf(nextPLayer);
                return;
            }
        }

        if (getMarkSightAt(1, 1)
                + getMarkSightAt(2, 2)
                + getMarkSightAt(3, 3)
                == nextPLayer * 3) {
            winner = String.valueOf(nextPLayer);
            return;
        }

        if (getMarkSightAt(3, 1)
                + getMarkSightAt(2, 2)
                + getMarkSightAt(1, 3)
                == nextPLayer * 3) {
            winner = String.valueOf(nextPLayer);
            return;
        }
    }

    private void changeNextPlayer() {
        nextPLayer = (nextPLayer == 'X') ? 'O' : 'X';
    }

    private boolean isAvailablePlace(int c, int r) {
        Character field = gameBoard[c - 1][r - 1];
        if (field != EMPTY) {
            throw new RuntimeException("Field already occupied");
        }
        return true;
    }

    public Character getNextPlayer() {
        return nextPLayer;
    }

    public Character getMarkSightAt(int c, int r) {
        return gameBoard[c - 1][r - 1];
    }

    public String andTheWinnerIs() {
        return "The winner is " + winner;
    }
}
