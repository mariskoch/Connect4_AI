package tests;

import board.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGameFinish {

    @Test
    public void testGameFinish_Empty() {
        Board b = new Board();
        Assertions.assertFalse(b.isGameFinished());
    }

    @Test
    public void testGameFinish_ScatteredPieces() {
        boolean debug = true;

        List<Board> boards = new ArrayList<>();
        boards.add(new Board(new int[]{1, 2, 3, 4, 5, 6, 7}));
        boards.add(new Board(new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7}));
        boards.add(new Board(new int[]{1, 1, 2, 2, 3, 3, 1, 4, 2, 5, 3, 6, 7}));
        boards.add(new Board(new int[]{1, 2, 1, 2, 1, 2, 5, 3, 5, 3, 5, 3, 6, 4, 6, 4, 6, 4, 2, 2, 3, 2, 4}));
        boards.add(new Board(new int[]{1, 2, 2, 3, 3, 4, 3, 4, 5, 5, 3, 5, 5, 6, 5, 4}));

        if (debug) printDebugLists("Scattered Pieces", boards);
        boards.forEach(board -> Assertions.assertFalse(board.isGameFinished()));
    }

    @Test
    public void testGameFinish_Horizontal() {
        boolean debug = true;
        List<Board> boards = new ArrayList<>();

        boards.add(new Board(new int[]{1, 1, 2, 2, 3, 3, 4}));
        boards.add(new Board(new int[]{7, 1, 1, 2, 2, 3, 3, 4}));
        boards.add(new Board(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 2, 3, 4, 1, 1, 2, 3, 4, 1, 7, 2, 7, 3, 7, 4}));
        boards.add(new Board(new int[]{4, 5, 6, 7, 4, 5, 6, 7, 5, 6, 7, 4, 1, 2, 3, 1, 1, 2, 4, 1, 5, 4, 4, 5, 6, 2, 7}));

        if (debug) printDebugLists("Horizontal", boards);
        boards.forEach(board -> Assertions.assertTrue(board.isGameFinished()));
    }

    @Test
    public void testGameFinish_Vertical() {
        boolean debug = true;
        List<Board> boards = new ArrayList<>();

        boards.add(new Board(new int[]{1, 2, 1, 2, 1, 2, 1}));
        boards.add(new Board(new int[]{7, 6, 7, 6, 5, 7, 1, 7, 1, 7, 1, 7}));

        if (debug) printDebugLists("Vertical", boards);
        boards.forEach(board -> Assertions.assertTrue(board.isGameFinished()));
    }

    @Test
    public void testGameFinish_Diagonal() {
        boolean debug = true;
        List<Board> boards = new ArrayList<>();

        boards.add(new Board(new int[]{1, 2, 2, 3, 3, 4, 3, 4, 4, 6, 4}));
        boards.add(new Board(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 2, 3, 3, 7, 3, 7, 7, 6, 6, 7, 6, 7, 4, 4, 4}));

        if (debug) printDebugLists("Diagonal", boards);
        boards.forEach(board -> Assertions.assertTrue(board.isGameFinished()));
    }

    private void printDebugLists(String label, List<Board> boards) {
        System.out.println("\n" + label + ":\n");
        boards.forEach(Board::printBoard);
        System.out.println("******************************************\n******************************************");
    }
}