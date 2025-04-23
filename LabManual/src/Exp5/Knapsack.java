package Exp5;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight, value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack {
    public static double fractionalKnapsack(int W, Item[] items) {

        Arrays.sort(items, Comparator.comparingDouble(i -> -((double) i.value / i.weight)));

        double maxValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= W) {
                currentWeight += item.weight;
                maxValue += item.value;
            } else {
                int remainingWeight = W - currentWeight;
                maxValue += (double) item.value * remainingWeight / item.weight;
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 600), new Item(20, 1000), new Item(30, 1200) };
        int W = 50;

        System.out.println("Maximum value in Knapsack: " + fractionalKnapsack(W, items));
    }
}
