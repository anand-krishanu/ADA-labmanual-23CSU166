package Exp3;

import java.util.Arrays;

import static Exp2.Sorting.swap;

public class Exp3 {
    public static void main(String[] args) {
        int[] arr = new int[]{98, 23, 42, 34, 76, 13, 17, 65, 102, 1};

        System.out.println(Arrays.toString(mergeSort(arr)));

        arr = new int[]{98, 23, 42, 34, 76, 13, 17, 65, 102, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int minIndex = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, minIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, minIndex, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combinedArray = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combinedArray[index] = arr1[i];
                index++;
                i++;
            } else {
                combinedArray[index] = arr2[j];
                index++;
                j++;
            }
        }

        while (i < arr1.length) {
            combinedArray[index] = arr1[i];
            index++;
            i++;
        }
        while (j < arr2.length) {
            combinedArray[index] = arr2[j];
            index++;
            j++;
        }

        return combinedArray;
    }

    public static int pivot (int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap (arr,pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSortHelper (int[] arr, int left, int right) {
        if(left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
    }

    public static void quickSort (int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
}
