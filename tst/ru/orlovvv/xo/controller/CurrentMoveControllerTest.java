package ru.orlovvv.xo.controller;

import org.junit.jupiter.api.Test;
import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMoveO() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }

    }

    @Test
    void currentMoveX() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }

    }

    @Test
    void currentMoveNull() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.X);
            field.setFigure(new Point(0, 2), Figure.O);
            field.setFigure(new Point(1, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(1, 2), Figure.O);
            field.setFigure(new Point(2, 0), Figure.X);
            field.setFigure(new Point(2, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);
            assertNull(currentMoveController.currentMove(field));

    }
}
