package Exp8;

public class TSP {
    static int N = 4;
    static int[][] dist = {
            {0, 10, 15, 20},
            {5, 0, 9, 10},
            {6, 13, 0, 12},
            {8, 8, 9, 0}
    };

    static int[][] dp = new int[1 << N][N];

    static int tsp(int mask, int pos) {
        if (mask == (1 << N) - 1) {
            return dist[pos][0];
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int min = Integer.MAX_VALUE;

        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(mask | (1 << city), city);
                min = Math.min(min, newCost);
                System.out.println(min);
            }
        }

        return dp[mask][pos] = min;
    }

    public static void main(String[] args) {

        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int result = tsp(1, 0);
        System.out.println("Minimum cost: " + result);
    }
}
