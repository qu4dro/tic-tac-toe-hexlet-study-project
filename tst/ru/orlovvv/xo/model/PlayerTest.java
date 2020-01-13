package ru.orlovvv.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        final String testName = "Peter";

        final String expectedName = testName;

        final Player player = new Player(testName, null);

        final String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void getFigure() {

        final Figure testValue = Figure.X;

        final Figure expectedValue = testValue;

        final Player player = new Player(null, testValue);

        final Figure actualFigure = player.getFigure();

        assertEquals(expectedValue, actualFigure);
    }
}