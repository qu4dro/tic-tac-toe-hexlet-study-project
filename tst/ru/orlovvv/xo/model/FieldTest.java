package ru.orlovvv.xo.model;

import org.junit.jupiter.api.Test;
import ru.orlovvv.xo.model.exceptions.AlreadyOccupiedException;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {

        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void getFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }


    @Test
    void getFigureWhenXIsLessThenZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    void getFigureWhenYIsLessThenZero() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    void getFigureWhenXIsMoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    void getFigureWhenYIsMoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

    @Test
    void getFigureWhenXAndYIsMoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {
        }

    }

}