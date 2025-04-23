package Exp10;

import java.util.*;

public class KnapsackBranchBound {

    static class Item {
        int weight, profit;
        double ratio;
        Item(int p, int w) {
            profit = p;
            weight = w;
            ratio = (double)p / w;
        }
    }

    static class Node {
        int level, profit, weight;
        double bound;
        Node(int l, int p, int w, double b) {
            level = l; profit = p; weight = w; bound = b;
        }
    }

    public static int knapsack(int W, int[] profits, int[] weights) {
        int n = profits.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++)
            items[i] = new Item(profits[i], weights[i]);
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.bound, a.bound));
        pq.add(new Node(-1, 0, 0, getBound(-1, 0, 0, items, W)));

        int maxProfit = 0;

        while (!pq.isEmpty()) {
            Node u = pq.poll();
            if (u.bound <= maxProfit || u.level == n - 1) continue;

            int level = u.level + 1;
            Item item = items[level];

            // Take item
            int wtWith = u.weight + item.weight;
            int profWith = u.profit + item.profit;
            if (wtWith <= W && profWith > maxProfit) maxProfit = profWith;
            double boundWith = getBound(level, profWith, wtWith, items, W);
            if (boundWith > maxProfit) pq.add(new Node(level, profWith, wtWith, boundWith));

            // Skip item
            double boundWithout = getBound(level, u.profit, u.weight, items, W);
            if (boundWithout > maxProfit) pq.add(new Node(level, u.profit, u.weight, boundWithout));
        }

        return maxProfit;
    }

    private static double getBound(int level, int profit, int weight, Item[] items, int W) {
        if (weight >= W) return 0;
        double bound = profit;
        int i = level + 1;
        while (i < items.length && weight + items[i].weight <= W) {
            weight += items[i].weight;
            bound += items[i].profit;
            i++;
        }
        if (i < items.length) bound += (W - weight) * items[i].ratio;
        return bound;
    }

    public static void main(String[] args) {
        int[] profits = {10, 10, 12, 18};
        int[] weights = {2, 4, 6, 9};
        int W = 32;

        int maxProfit = knapsack(W, profits, weights);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
