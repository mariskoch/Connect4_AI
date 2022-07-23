package board;

import player.AIPlayer;
import player.HumanPlayer;
import player.Player;

public class Board {
    public static final int ROWS = 6;      //horizontal
    public static final int COLUMNS = 7;   //vertical

    private Piece[][] board = new Piece[ROWS][COLUMNS];
    private Player player1 = new HumanPlayer();     //gets color yellow
    private Player player2 = new AIPlayer();     //gets color red

    private int currentPlayer = 1;

    public Board() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = null;
            }
        }
    }

    public Board(int[] inputs) {
        for (int num : inputs) {
            addPiece(num);
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            System.out.print("|| ");
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == null) System.out.print(". ");
                else System.out.print(board[i][j].getColor() == Color.YELLOW ? "Y " : "R ");
            }
            System.out.print("||\n");
        }
        System.out.println();
    }

    public boolean addPiece(int colToAdd) {
        if (colToAdd > COLUMNS || colToAdd <= 0) return false;
        int i = 0;
        while (i < ROWS && board[i][colToAdd - 1] == null) i++;
        if (i == 0) return false;
        else board[i - 1][colToAdd - 1] = new Piece(currentPlayer == 1 ? Color.YELLOW : Color.RED);
        currentPlayer = currentPlayer == 1 ? 2 : 1;
        return true;
    }

    public boolean isGameFinished() {
        for (int i = ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == null) continue;
                Color c = board[i][j].getColor();
                for (int k = 1; k < 4; k++) {
                    if (board[i][j+k] == null) break;
                    if (board[i][j + k].getColor() == c) {
                        if (k == 3) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
