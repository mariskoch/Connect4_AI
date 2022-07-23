import board.Board;

public class Main {
    public static void main(String[] args) {
        Board boardGame = new Board();
        boardGame.printBoard();
        boardGame.addPiece(1);
        boardGame.addPiece(1);
        boardGame.addPiece(2);
        boardGame.addPiece(2);
        boardGame.addPiece(3);
        boardGame.addPiece(3);
        boardGame.addPiece(4);
        boardGame.addPiece(4);
        boardGame.printBoard();

    }
}