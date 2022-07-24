import board.Board;

public class Main {
    public static void main(String[] args) {
        Board boardGame = new Board(new int[]{1,2,2,3,3,4,3,4,4,6,4});
        boardGame.isGameFinished();

    }
}