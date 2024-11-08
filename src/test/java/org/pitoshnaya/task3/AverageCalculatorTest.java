package org.pitoshnaya.task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class AverageCalculatorTest {

    @ParameterizedTest
    @MethodSource("averageResultProvider")
    public void calculateAverage(int[] numbers, double expectancy) {
        var calculator = new AverageCalculator();

        for (int number: numbers) {
            calculator.addNumber(number);
        }

        assertEquals(expectancy, calculator.getAverage());
    }

    @Test
    public void calculateAverageConsistency() {
        var calculator = new AverageCalculator();

        // x1 => 10
        calculator.addNumber(10);
        assertEquals(10.0, calculator.getAverage());

        // x2 => 12
        calculator.addNumber(2);
        assertEquals(6, calculator.getAverage());

        // x3 => 15
        calculator.addNumber(3);
        assertEquals(5, calculator.getAverage());

        // x4 => 100
        calculator.addNumber(85);
        assertEquals(25, calculator.getAverage());

        // x5 => 101
        calculator.addNumber(1);
        assertEquals(20.20, calculator.getAverage());

        // x6 => 90
        calculator.addNumber(-11);
        assertEquals(15.0, calculator.getAverage());


        // x7 => -210
        calculator.addNumber(-300);
        assertEquals(-30.0, calculator.getAverage());
    }

    private static Stream<Arguments> averageResultProvider() {
        return Stream.of(
                Arguments.of(new int[]{147}, 147.0),
                Arguments.of(new int[]{147, 3}, 75.0),
                Arguments.of(new int[]{147, 3, 60}, 70.0),
                Arguments.of(new int[]{4000, 8000, 12000}, 8000.0),
                Arguments.of(new int[]{-10, 30, -5}, 5.0),
                Arguments.of(new int[]{0, 3, 0}, 1.0),
                Arguments.of(new int[]{0, 0, 0}, 0.0),
                Arguments.of(new int[]{}, 0.0)
        );
    }
}
