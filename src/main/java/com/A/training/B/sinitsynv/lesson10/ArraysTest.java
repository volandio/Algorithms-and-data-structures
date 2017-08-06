package com.A.training.B.sinitsynv.lesson10;

import java.util.Arrays;
import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class ArraysTest {
    public static void main(String[] args) {
        testAsList();
        testBinarySearch();
        testCopyOf();
        testCopyOfRange();
        testEquals();
        testDeepEquals();
        testFill();
        testSort();
    }

    private static void testDeepEquals() {
        int[][] firstArray = new int[][] {{1}, {5}};
        int[][] secondArray = new int[][] {{1}, {5}};
        assertEquals("ArraysTest.testDeepEquals", true, Arrays.deepEquals(firstArray, secondArray));
    }

    private static void testSort() {
        int[] array = new int[] {3, 5, 1};
        Arrays.sort(array);
        assertEquals("ArraysTest.testSort", new int[] {1, 3, 5}, array);
    }

    private static void testFill() {
        int[] array = new int[3];
        Arrays.fill(array, 5);
        assertEquals("ArraysTest.testFill", new int[] {5, 5, 5}, array);
    }

    private static void testEquals() {
        int[] firstArray = new int[] {1, 5};
        int[] secondArray = new int[] {1, 5};
        assertEquals("ArraysTest.testEquals", true, Arrays.equals(firstArray, secondArray));
    }

    private static void testCopyOfRange() {
        int[] actualArray = new int[] {1, 3, 5};
        int[] expectedArray = Arrays.copyOfRange(actualArray, 0, actualArray.length);
        assertEquals("ArraysTest.testCopyOfRange", expectedArray, actualArray);
    }

    private static void testCopyOf() {
        int[] actualArray = new int[] {1, 3, 5};
        int[] expectedArray = Arrays.copyOf(actualArray, actualArray.length);
        assertEquals("ArraysTest.testCopyOf", expectedArray, actualArray);
    }

    private static void testBinarySearch() {
        int[] array = new int[] {1, 3, 5};
        assertEquals("ArraysTest.testBinarySearch", 1, Arrays.binarySearch(array, 3));
    }

    private static void testAsList() {
        List<Integer> list = Arrays.asList(1, 2);
        assertEquals("ArraysTest.testAsList", "[1, 2]", list.toString());
    }
}
