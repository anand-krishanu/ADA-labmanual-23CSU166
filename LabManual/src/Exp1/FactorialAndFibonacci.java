package Exp1;

import java.util.Scanner;

public class FactorialAndFibonacci {
    int n;

    public static int fib(int n) {
        if (n <= 1) {
            return 0;
        }
        int current = 0;
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public static int fibRec(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fac(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static int facRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * facRec(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        sc.close();

        long startTime, endTime;

        startTime = System.nanoTime();
        int fibIterative = fib(n);
        endTime = System.nanoTime();
        System.out.println("Fibonacci using iteration for " + n + ": " + fibIterative);
        System.out.println("Execution Time (Iteration): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int fibRecursive = fibRec(n);
        endTime = System.nanoTime();
        System.out.println("Fibonacci using recursion for " + n + ": " + fibRecursive);
        System.out.println("Execution Time (Recursion): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int facIterative = fac(n);
        endTime = System.nanoTime();
        System.out.println("Factorial using iteration for " + n + ": " + facIterative);
        System.out.println("Execution Time (Iteration): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int facRecursive = facRec(n);
        endTime = System.nanoTime();
        System.out.println("Factorial using recursion for " + n + ": " + facRecursive);
        System.out.println("Execution Time (Recursion): " + (endTime - startTime) + " ns");
    }
}
