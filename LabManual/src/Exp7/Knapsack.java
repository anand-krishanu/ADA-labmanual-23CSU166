package Exp7;

public class Knapsack {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int maxWeight = 50;

        System.out.println("Maximum Profit achieved with the Knapsack: " +knapsack(value, weight, maxWeight, value.length));
    }

    public static int knapsack (int[] value, int[] weight, int maxWeight, int n) {
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], (value[i - 1] + dp[i - 1][j - weight[i - 1]]));
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][maxWeight];
    }
}
