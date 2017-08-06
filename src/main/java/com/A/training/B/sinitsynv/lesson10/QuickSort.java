package com.A.training.B.sinitsynv.lesson10;

public class QuickSort {
    static public int[] quickSort(int[] array) {
        return quicksort(array, 0, array.length - 1);
    }

    static private int[] quicksort(int[] array, int first, int last) {
        int i = first;
        int j = last;
        int x = array[(first + last) / 2];
        do {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last) {
            quicksort(array, i, last);
        }
        if (first < j) {
            quicksort(array, first, j);
        }
        return array;
    }
}
