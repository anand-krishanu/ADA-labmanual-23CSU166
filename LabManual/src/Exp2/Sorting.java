package Exp2;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {98, 23, 42, 34, 76, 13, 17};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j>= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
}
