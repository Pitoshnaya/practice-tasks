package org.pitoshnaya.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DropGenerator {
    public static void main(String[] args) {

    }
    public String getRandomItem() {
        Random generator = new Random();
        List<String> items = new ArrayList<>();
        items.add("Item1");
        items.add("Item2");
        items.add("Item3");
        items.add("Item4");
        items.add("Item5");
        var randomItem = items.get(generator.nextInt(items.size()));
        System.out.println(randomItem);

        return randomItem;
    }
}