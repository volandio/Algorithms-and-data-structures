package com.A.training.B.sinitsynv.lesson01;

public class Task07 {
    public static int[] swapArithmeticOne(int a, int b) {
        a += b;
        b = a - b;
        a -= b;
        return new int[] {a, b};
    }

    public static int[] swapArithmeticTwo(int a, int b) {
        a *= b;
        b = a / b;
        a /= b;
        return new int[] {a, b};
    }

    public static int[] swapBitwiseOne(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        return new int[] {a, b};
    }

    public static int[] swapBitwiseTwo(int a, int b) {
        a = (a | b) & (~a | ~b);
        b = (a | b) & (~a | ~b);
        a = (a | b) & (~a | ~b);
        return new int[] {a, b};
    }
}
