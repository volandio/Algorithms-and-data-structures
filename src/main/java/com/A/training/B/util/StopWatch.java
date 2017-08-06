package com.A.training.B.util;

public class StopWatch {
    public static long startTime;
    public static long endTime;

    public static long start() {
        startTime = System.currentTimeMillis();
        return startTime;
    }

    public static long getElapsedTime() {
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
