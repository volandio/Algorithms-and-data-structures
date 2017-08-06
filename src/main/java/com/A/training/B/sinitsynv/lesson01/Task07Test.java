package com.A.training.B.sinitsynv.lesson01;

import static com.A.training.B.sinitsynv.lesson01.Task07.*;
import static com.A.training.B.util.Assert.assertEquals;

public class Task07Test {
    public static void main(String[] args) {
        testSwapArithmeticOne();
        testSwapArithmeticTwo();
        testSwapBitwiseOne();
        testSwapBitwiseTwo();
    }

    private static void testSwapBitwiseTwo() {
        assertEquals("Task07Test.testSwapBitwiseTwo", new int[] {5, 3}, swapBitwiseTwo(3, 5));
    }

    private static void testSwapBitwiseOne() {
        assertEquals("Task07Test.testSwapBitwiseOne", new int[] {5, 3}, swapBitwiseOne(3, 5));
    }

    private static void testSwapArithmeticTwo() {
        assertEquals("Task07Test.testSwapArithmeticTwo", new int[] {5, 3}, swapArithmeticTwo(3, 5));
    }

    private static void testSwapArithmeticOne() {
        assertEquals("Task07Test.testSwapArithmeticOne", new int[] {5, 3}, swapArithmeticOne(3, 5));
    }
}
