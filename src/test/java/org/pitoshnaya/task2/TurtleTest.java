package org.pitoshnaya.task2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TurtleTest {
    @Test
    public void moveUp() {
        var jessy = new Turtle();

        var coordinates = jessy.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        jessy.moveUp();

        assertTurtleCoordinates(x, y-1, jessy);
    }

    @Test
    public void moveDown() {
        var jessy = new Turtle();

        var coordinates = jessy.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        jessy.moveDown();

        assertTurtleCoordinates(x, y+1, jessy);
    }

    @Test
    public void moveLeft() {
        var jessy = new Turtle();

        var coordinates = jessy.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        jessy.moveLeft();

        assertTurtleCoordinates(x-1, y, jessy);
    }

    @Test
    public void moveRight() {
        var jessy = new Turtle();

        var coordinates = jessy.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        jessy.moveRight();

        assertTurtleCoordinates(x+1, y, jessy);
    }
    
    @Test
    public void complexMovement() {
        var jessy = new Turtle();

        var coordinates = jessy.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();

        jessy.moveRight();
        assertTurtleCoordinates(x+1, y, jessy);
        jessy.moveRight();
        assertTurtleCoordinates(x+2, y, jessy);
        jessy.moveDown();
        assertTurtleCoordinates(x+2, y+1, jessy);
        jessy.moveDown();
        assertTurtleCoordinates(x+2, y+2, jessy);
        jessy.moveDown();
        assertTurtleCoordinates(x+2, y+3, jessy);
        jessy.moveRight();
        assertTurtleCoordinates(x+3, y+3, jessy);
        jessy.moveUp();
        assertTurtleCoordinates(x+3, y+2, jessy);
        jessy.moveLeft();
        assertTurtleCoordinates(x+2, y+2, jessy);
    }

    @Test
    public void randomPositionForEachTurtle() {
        var jessy = new Turtle();
        var mikki = new Turtle();
        // Допускаем, что раз в год данные могут и пересечься. Пробуем пересоздать и проверить еще раз
        if (isInSamePosition(jessy, mikki)) {
            mikki = new Turtle();
        }

        assertFalse(isInSamePosition(jessy, mikki), "Черепашка должна каждый раз быть в случайной позиции");
    }
    
    private void assertTurtleCoordinates(int x, int y, Turtle turtle) {
        var newCoordinates = turtle.getCoordinates();

        assertEquals(x, newCoordinates.getX(), "у черепашки координата X не совпадает с ожидаемой");
        assertEquals(y, newCoordinates.getY(), "у черепашки координата Y не совпадает с ожидаемой");
    }

    private boolean isInSamePosition(Turtle a, Turtle b) {
        var firstPosition = a.getCoordinates();
        var secondPosition = b.getCoordinates();

        return firstPosition.getX() == secondPosition.getX() && firstPosition.getY() == secondPosition.getY();
    }
}
