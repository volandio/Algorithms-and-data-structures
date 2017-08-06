package com.A.training.B.sinitsynv.lesson01;

public class Task06 {
    /**
     * Calculate 2^n
     *
     * @param n a degree
     * @return number two in degree n
     */
    public static int getTwoInDegree(int n) {
        return 1 << n;
    }

    /**
     * Calculate 2^n+2^m
     *
     * @param n first degree
     * @param m second degree
     * @return truth table OR between two numbers two in degrees
     */
    public static int getTwoInDegrees(int n, int m) {
        return 1 << n | 1 << m;
    }

    /**
     * Reset n lower bits of number
     *
     * @param a number in which reset lower n bits
     * @param n count of lower bits
     * @return number with lower bits make equals zero
     */
    public static int getNumberWithResetLowerBits(int a, int n) {
        int mask = -1 << n;
        return a & mask;
    }

    /**
     * Set given bit of number is one
     *
     * @param a number in which indispensably to set given bit is one
     * @param n number bit, which must to do equal one
     * @return number with changed given number bit on one
     */
    public static int getNumberWithBitIsOne(int a, int n) {
        int mask = 1 << n - 1;
        return a | mask;
    }

    /**
     * Invert given bits
     *
     * @param a number in which indispensably invert given bits
     * @param n bit which must to invert
     * @return number with invert given bits
     */
    public static int invertBit(int a, int n) {
        int mask = 1 << n - 1;
        return a ^ mask;
    }

    /**
     * To set given number bit is zero
     *
     * @param a number in which indispensably to set given number bit is zero
     * @param n number bit which must to do is zero
     * @return number with to set given number bit is zero
     */
    public static int toSetBitIsZero(int a, int n) {
        int mask = 1 << n - 1;
        return a & ~mask;
    }

    /**
     * Return given lower bits
     *
     * @param a number from which indispensably return given lower bits
     * @param n count of lower bits
     * @return number which have bits is given count of lower bits
     */
    public static int returnLowerBits(int a, int n) {
        int mask = -1 << n;
        return a & ~mask;
    }

    /**
     * Return bit which number is given
     *
     * @param a number from which indispensably return
     * @param n number bit which must to be return
     * @return bit which number is given
     */
    public static int returnBit(int a, int n) {
        int mask = a >> n - 1;
        return mask & 1;
    }

    /**
     * Return bits representation of byte
     *
     * @param a byte which must output
     * @return string which have bits of given byte
     */
    public static String returnByteInBits(byte a) {
        StringBuilder builder = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            if ((a & 1 << i) != 0) {
                builder.append('1');
            } else {
                builder.append('0');
            }
        }
        return builder.toString();
    }
}
