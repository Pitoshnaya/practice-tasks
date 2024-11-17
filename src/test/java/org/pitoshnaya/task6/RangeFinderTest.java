package org.pitoshnaya.task6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RangeFinderTest {
    private final RangeFinder rangeFinder = new RangeFinder();

    @ParameterizedTest
    @MethodSource("maximumRangeProvider")
    public void findMaximum(int[] numbers, int expectedStart, int expectedEnd, int expectedRange) throws Exception {
        var result = rangeFinder.findMaximum(numbers);
        assertEquals(expectedStart, result.start);
        assertEquals(expectedEnd, result.end);
        assertEquals(expectedRange, result.getValue());
    }

    @Test
    public void findMaximumFailure() {
        assertThrows(Exception.class, () -> rangeFinder.findMaximum(new int[]{}));
        assertThrows(Exception.class, () -> rangeFinder.findMaximum(new int[]{0}));
    }

    private static Stream<Arguments> maximumRangeProvider() {
        return Stream.of(
                Arguments.of(new int[]{15, 0, -4, 32, -1}, -4, 32, 36),
                Arguments.of(new int[]{15, 0, 32, -1}, -1, 32, 33),
                Arguments.of(new int[]{15, 0, -1}, -1, 15, 16),
                Arguments.of(new int[]{0, -1}, -1, 0, 1),
                Arguments.of(new int[]{0, 1}, 0, 1, 1),
                Arguments.of(new int[]{0, 1000, -1000, 999}, -1000, 1000, 2000),
                Arguments.of(new int[]{0, 0, 0}, 0, 0, 0),
                Arguments.of(new int[]{-5, -5, -5}, -5, -5, 0),
                Arguments.of(new int[]{5, 5}, 5, 5, 0),
                Arguments.of(new int[]{-5, 5}, -5, 5, 10)
        );
    }
}
