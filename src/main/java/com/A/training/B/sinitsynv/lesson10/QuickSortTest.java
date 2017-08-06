package com.A.training.B.sinitsynv.lesson10;

import static com.A.training.B.util.Assert.assertEquals;

public class QuickSortTest {
    public static void main(String[] args) {
        testQuickSort();
    }

    private static void testQuickSort() {
        int[] array = {5, 3, 1, 2, 4};
        int[] expectedArray = {1, 2, 3, 4, 5};
        assertEquals("BubbleSortTest.testQuickSort", expectedArray, QuickSort.quickSort(array));
    }
}
