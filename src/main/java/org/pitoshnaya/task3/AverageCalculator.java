package org.pitoshnaya.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AverageCalculator {

    private  double count;
    private int sum;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public AverageCalculator() {
        this.count = 0;
        this.sum = 0;
    }

    public static void main(String[] args) {
        AverageCalculator ac  = new AverageCalculator();
        ac.addNumber(5);
        ac.addNumber(5);
        ac.addNumber(3);
        System.out.println("вывод + " + ac.toString());
        System.out.println("вывод среднего числа "+ ac.getAverage());
    }

    public void addNumber(int number) {

        sum = sum + number;
        count = count + 1;
    }

    public double getAverage() {

        if(count == 0) {
            return 0;
        }

        return sum/count;

    }

    @Override
    public String toString() {
        return "AverageCalculator{" +
                "count=" + count +
                ", sum=" + sum +
                '}';
    }
}
