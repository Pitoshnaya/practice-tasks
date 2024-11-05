package org.pitoshnaya.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DropGeneratorTest {
    public DropGenerator generator = new DropGenerator();

    @Test
    public void getRandomItem() {
        Map<String, Integer> allCombinations = new HashMap<>();

        int counter = 0;
        while (++counter < 100) {
            String item = generator.getRandomItem();

            assertNotNull(item, "Ожидалось, что генератор вернет название предмета");
            allCombinations.compute(item, (name, amountOfAppearences) -> amountOfAppearences == null ? 1 : amountOfAppearences + 1);
        }

        assertEquals(5, allCombinations.size(), "Генератор должен возвращать 5 разных предметов");
    }
}
