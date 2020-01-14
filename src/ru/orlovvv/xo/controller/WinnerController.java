package ru.orlovvv.xo.controller;

import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0, i));
            }

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(0, 2));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean check(final Field field, final Point currentPoint, final IPointChanger pointChanger) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null) return false;

            nextFigure = field.getFigure(nextPoint);

        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointChanger);
    }

    private interface IPointChanger {
        Point next(final Point p);
    }
}
