package com.A.training.B.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class Assert {
    public static void assertEquals(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, int[] expected, int[] actual) {
        if (Arrays.toString(actual).equals(Arrays.toString(expected))) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + Arrays.toString(expected)
                + ", actual " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, int[][] expected, int[][] actual) {
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + Arrays.deepToString(expected)
                + ", actual " + Arrays.deepToString(actual));
        }
    }

    public static void assertEquals(String testName, Object[] expected, Object[] actual) {
        if (Objects.equals(Arrays.toString(actual), Arrays.toString(expected))) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + Arrays.toString(expected)
                + ", actual " + Arrays.toString(actual));
        }
    }

    public static void assertEquals(String testName, Collection expected, Collection actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String testName, Map expected, Map actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + ", actual " + actual);
        }
    }

    public static void fail(String msg) {
        throw new AssertionError(msg);
    }

    public static void assertEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("Test throw Exception passed");
        } else {
            System.out.println("Failed: expected " + expected + ", actual " + actual);
        }
    }
}
