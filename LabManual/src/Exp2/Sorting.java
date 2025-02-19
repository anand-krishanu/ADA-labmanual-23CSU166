package Exp2;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[]{98, 23, 42, 34, 76, 13, 17};

        System.out.println(Arrays.toString(selectionSort(arr)));

        arr = new int[]{98, 23, 42, 34, 76, 13, 17};
        System.out.println(Arrays.toString(insertionSort(arr)));

    }

    //Time Complexity of Insertion Sort: O(n^2)
    //Space Complexity of Insertion Sort: O(1)
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

    //Time Complexity of Selection Sort: O(n^2)
    //Space Complexity of Selection Sort: O(1)
    public static int[] selectionSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i; j <arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if(i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
