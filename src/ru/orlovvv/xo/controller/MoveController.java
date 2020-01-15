package ru.orlovvv.xo.controller;

import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.exceptions.AlreadyOccupiedException;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException,
                                                        InvalidPointException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
