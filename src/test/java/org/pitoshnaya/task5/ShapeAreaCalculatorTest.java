package org.pitoshnaya.task5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ShapeAreaCalculatorTest {
    private final ShapeAreaCalculator calculator = new ShapeAreaCalculator();

    @ParameterizedTest
    @MethodSource("circleDataProvider")
    public void calculateCircleArea(double radius, double expectedArea) {
        assertEquals(expectedArea, calculator.calculateCircleArea(radius));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.123, 15, 300, 4.15, 10, 10000.005, 0})
    public void calculateSquareArea(double side) {
        assertEquals(side * side, calculator.calculateSquareArea(side), "Неправильная площадь у квадрата со стороной " + side);
    }


    @Test
    public void calculateSquareAreaImaginary() {
        assertEquals(15 * 15, calculator.calculateSquareArea(-15), "Квадрат с отрицательной стороной должен иметь неотрицательную площадь");
    }

    @ParameterizedTest
    @MethodSource("rectangleDataProvider")
    public void calculateRectangleArea(double width, double length, double expectedArea) {
        assertEquals(expectedArea, calculator.calculateRectangleArea(length, width), "Неправильная площадь у прямоугольника со сторонами " + width + " и " + length );
        assertEquals(calculator.calculateRectangleArea(width, length), calculator.calculateRectangleArea(length, width), "При перестановке ширины и длины должна получаться та же площадь");
    }

    private static Stream<Arguments> circleDataProvider() {
        return Stream.of(
                Arguments.of(5, 5 * 5 * Math.PI),
                Arguments.of(14, 14 * 14 * Math.PI),
                Arguments.of(1300, 1300 * 1300 * Math.PI),
                Arguments.of(14.56, 14.56 * 14.56 * Math.PI),
                Arguments.of(0.15, 0.15 * 0.15 * Math.PI),
                Arguments.of(0.16, 0.16 * 0.16 * Math.PI),
                Arguments.of(-15, 15 * 15 * Math.PI), // Пограничное условие с воображаемым радиусом
                Arguments.of(0, 0) // Пограничное условие с воображаемым кругом
        );
    }

    private static Stream<Arguments> rectangleDataProvider() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(6, 3, 18),
                Arguments.of(6, 6, 36),
                Arguments.of(6.6, 6.6, 6.6 * 6.6),
                Arguments.of(6.6, 6.5, 6.6 * 6.5),
                Arguments.of(321, 654, 321 * 654),
                Arguments.of(0, 654, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(-321, 654, 321 * 654), // Воображаемая площадь случай 1
                Arguments.of(-5, -5, 25) // Воображаемая площадь случай 2
        );
    }
}
