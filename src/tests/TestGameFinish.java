package tests;

import board.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGameFinish {

    @Test
    public void testGameFinish_Empty() {
        //should return false
        Board b = new Board();
        Assertions.assertFalse(b.isGameFinished());
    }

    @Test
    public void testGameFinish_ScatteredPieces() {
        boolean debug = false;

        //all the cases in here should return false
        //following: horizontal and vertical cases
        Board a = new Board();
        a.addPiece(1);
        a.addPiece(2);
        a.addPiece(3);
        a.addPiece(4);
        a.addPiece(5);
        a.addPiece(6);
        a.addPiece(7);
        if (debug) a.printBoard();

        Board b = new Board();
        for(int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                for (int i = 0; i < 3; i++) {
                    b.addPiece(1 + 2*k + j);
                    b.addPiece(2 + 2*k + j);
                }
            }
        }
        if (debug) b.printBoard();

        Board c = new Board();
        c.addPiece(1);
        c.addPiece(1);
        c.addPiece(2);
        c.addPiece(2);
        c.addPiece(3);
        c.addPiece(3);
        c.addPiece(1);
        c.addPiece(4);
        c.addPiece(2);
        c.addPiece(5);
        c.addPiece(3);
        c.addPiece(6);
        c.addPiece(7);
        if (debug) c.printBoard();

        Board d = new Board();
        d.addPiece(1);
        d.addPiece(2);
        d.addPiece(1);
        d.addPiece(2);
        d.addPiece(1);
        d.addPiece(2);
        d.addPiece(5);
        d.addPiece(3);
        d.addPiece(5);
        d.addPiece(3);
        d.addPiece(5);
        d.addPiece(3);
        d.addPiece(6);
        d.addPiece(4);
        d.addPiece(6);
        d.addPiece(4);
        d.addPiece(6);
        d.addPiece(4);
        d.addPiece(2);
        d.addPiece(1);
        d.addPiece(3);
        d.addPiece(5);
        d.addPiece(4);
        d.addPiece(6);
        if (debug) d.printBoard();

        //following: diagonal cases
        Board e = new Board();
        e.addPiece(1);
        e.addPiece(2);
        e.addPiece(2);
        e.addPiece(3);
        e.addPiece(3);
        e.addPiece(4);
        e.addPiece(3);
        e.addPiece(4);
        e.addPiece(5);
        e.addPiece(5);
        e.addPiece(3);
        e.addPiece(5);
        e.addPiece(5);
        e.addPiece(6);
        e.addPiece(5);
        e.addPiece(4);
        if (debug) e.printBoard();

        Assertions.assertFalse(a.isGameFinished() || b.isGameFinished() || c.isGameFinished() || d.isGameFinished() || e.isGameFinished());
    }
}