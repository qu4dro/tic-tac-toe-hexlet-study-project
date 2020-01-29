package ru.orlovvv.xo.controller;

import org.junit.jupiter.api.Test;
import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinnerWinnerRow() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<Figure> (3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerNoWinnerRow() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<Figure> (3);
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWinnerCol() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<Figure> (3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerNoWinnerCol() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<Figure> (3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWinnerDiag1() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<Figure> (3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerNoWinnerDiag1() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<Figure> (3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    void getWinnerWinnerDiag2() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<Figure> (3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerNoWinnerDiag2() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<Figure> (3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }
}