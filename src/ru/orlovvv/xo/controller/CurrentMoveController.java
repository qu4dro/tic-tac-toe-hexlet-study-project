package ru.orlovvv.xo.controller;

import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int count = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                if (field.getFigure(new Point(x, y)) != null) count++;
            }
        }

        if (count == field.getSize() * field.getSize()) return null;

        if (count % 2 == 0) return Figure.X;

        return Figure.O;
    }


}
