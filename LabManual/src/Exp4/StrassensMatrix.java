package Exp4;

import java.util.Scanner;

public class StrassensMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] ans = new int[2][2];

        System.out.println("Enter elements of the first 2x2 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of the second 2x2 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        int m1 = (arr1[0][0] + arr1[1][1]) * (arr2[0][0] + arr2[1][1]);
        int m2 = (arr1[1][0] + arr1[1][1]) * arr2[0][0];
        int m3 = arr1[0][0] * (arr2[0][1] - arr2[1][1]);
        int m4 = arr1[1][1] * (arr2[1][0] - arr2[0][0]);
        int m5 = (arr1[0][0] + arr1[0][1]) * arr2[1][1];
        int m6 = (arr1[1][0] - arr1[0][0]) * (arr2[0][0] + arr2[0][1]);
        int m7 = (arr1[0][1] - arr1[1][1]) * (arr2[1][0] + arr2[1][1]);

        ans[0][0] = m1 + m4 - m5 + m7;
        ans[0][1] = m3 + m5;
        ans[1][0] = m2 + m4;
        ans[1][1] = m1 - m2 + m3 + m6;

        System.out.println("Product achieved using Strassen's algorithm:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ans[i][j] + "\t");
            }
            System.out.println();
        }
    }
}