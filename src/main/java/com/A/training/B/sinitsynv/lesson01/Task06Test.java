package com.A.training.B.sinitsynv.lesson01;

import static com.A.training.B.sinitsynv.lesson01.Task06.*;
import static com.A.training.B.util.Assert.assertEquals;

public class Task06Test {
    public static void main(String[] args) {
        testGetTwoInDegree();
        testGetTwoInDegrees();
        testGetNumberWithResetLowerBits();
        testGetNumberWithBitIsOne();
        testInvertBit();
        testToSetBitIsZero();
        testReturnLowerBits();
        testReturnBit();
        testReturnByteInBits();
    }

    private static void testReturnByteInBits() {
        assertEquals("Task06Test.testReturnByteInBits", "00000111", returnByteInBits((byte) 7));
    }

    private static void testReturnBit() {
        assertEquals("Task06Test.testReturnBit", 1, returnBit(7, 3));
    }

    private static void testReturnLowerBits() {
        assertEquals("Task06Test.testReturnLowerBits", 7, returnLowerBits(7, 4));
    }

    private static void testToSetBitIsZero() {
        assertEquals("Task06Test.testToSetBitIsZero", 3, toSetBitIsZero(7, 3));
    }

    private static void testInvertBit() {
        assertEquals("Task06Test.testInvertBit", 5, invertBit(7, 2));
    }

    private static void testGetNumberWithBitIsOne() {
        assertEquals("Task06Test.testGetNumberWithBitIsOne", 15, getNumberWithBitIsOne(7, 4));
    }

    private static void testGetNumberWithResetLowerBits() {
        assertEquals("Task06Test.testGetNumberWithResetLowerBits", 4, getNumberWithResetLowerBits(7, 2));
    }

    private static void testGetTwoInDegrees() {
        assertEquals("Task06Test.testGetTwoInDegrees", 12, getTwoInDegrees(2, 3));
    }

    private static void testGetTwoInDegree() {
        assertEquals("Task06Test.testGetTwoInDegree", 4, getTwoInDegree(2));
    }
}
