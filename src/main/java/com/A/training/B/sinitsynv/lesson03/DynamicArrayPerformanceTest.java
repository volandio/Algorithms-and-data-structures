package com.A.training.B.sinitsynv.lesson03;

import java.util.ArrayList;
import java.util.List;

import static com.A.training.B.util.StopWatch.getElapsedTime;
import static com.A.training.B.util.StopWatch.start;
import static java.lang.System.out;

public class DynamicArrayPerformanceTest {
    public static void main(String[] args) {
        out.println("-------- Addition to the begin --------");
        out.println("DynamicArray.add(index, e): " + testAddToBeginDynamicArray() + " ms");
        out.println("ArrayList.add(index, e): " + testAddToBeginArrayList() + " ms");
        out.println();
        out.println("-------- Addition to the middle --------");
        out.println("DynamicArray.add(index, e): " + testAddToMiddleDynamicArray() + " ms");
        out.println("ArrayList.add(index, e): " + testAddToMiddleArrayList() + " ms");
        out.println();
        out.println("-------- Addition to the end --------");
        out.println("DynamicArray.add(e): " + testAddToEndDynamicArray() + " ms");
        out.println("ArrayList.add(e): " + testAddToEndArrayList() + " ms");
        out.println();
        out.println("-------- Removing in the begin --------");
        out.println("DynamicArray.remove(index): " + testRemoveInBeginDynamicArray() + " ms");
        out.println("ArrayList.remove(index): " + testRemoveInBeginArrayList() + " ms");
        out.println();
        out.println("-------- Removing in the middle --------");
        out.println("DynamicArray.remove(index): " + testRemoveInMiddleDynamicArray() + " ms");
        out.println("ArrayList.remove(index): " + testRemoveInMiddleArrayList() + " ms");
        out.println();
        out.println("-------- Removing in the end --------");
        out.println("DynamicArray.remove(index): " + testRemoveInEndDynamicArray() + " ms");
        out.println("ArrayList.remove(index): " + testRemoveInEndArrayList() + " ms");
    }

    private static long testAddToBeginDynamicArray() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 10_000_000; i++) {
            array.add(i);
        }
        start();
        for (int i = 0; i < 150; i++) {
            array.add(0, i);
        }
        return getElapsedTime();
    }

    private static long testAddToBeginArrayList() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        start();
        for (int i = 0; i < 150; i++) {
            list.add(0, i);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleDynamicArray() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 10_000_000; i++) {
            array.add(i);
        }
        start();
        for (int i = 0; i < 400; i++) {
            array.add(5_000_000, i);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleArrayList() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        start();
        for (int i = 0; i < 400; i++) {
            list.add(5_000_000, i);
        }
        return getElapsedTime();
    }

    private static long testAddToEndDynamicArray() {
        DynamicArray array = new DynamicArray();
        start();
        for (int i = 0; i < 20_000_000; i++) {
            array.add(i);
        }
        return getElapsedTime();
    }

    private static long testAddToEndArrayList() {
        List<Object> list = new ArrayList<>();
        start();
        for (int i = 0; i < 20_000_000; i++) {
            list.add(i);
        }
        return getElapsedTime();
    }

    private static long testRemoveInBeginDynamicArray() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 100_000; i++) {
            array.add(i);
        }
        start();
        for (int i = 0; i < 50_000; i++) {
            array.remove(0);
        }
        return getElapsedTime();
    }

    private static long testRemoveInBeginArrayList() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }
        start();
        for (int i = 0; i < 50_000; i++) {
            list.remove(0);
        }
        return getElapsedTime();
    }

    private static long testRemoveInMiddleDynamicArray() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 200_000; i++) {
            array.add(i);
        }
        start();
        for (int i = 0; i < 50_000; i++) {
            array.remove(100_000);
        }
        return getElapsedTime();
    }

    private static long testRemoveInMiddleArrayList() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            list.add(i);
        }
        start();
        for (int i = 0; i < 50_000; i++) {
            list.remove(100_000);
        }
        return getElapsedTime();
    }

    private static long testRemoveInEndDynamicArray() {
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 400_000; i++) {
            array.add(i);
        }
        start();
        for (int i = 0; i < 200_000; i++) {
            array.remove(array.size() - 1);
        }
        return getElapsedTime();
    }

    private static long testRemoveInEndArrayList() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 400_000; i++) {
            list.add(i);
        }
        start();
        for (int i = 0; i < 200_000; i++) {
            list.remove(list.size() - 1);
        }
        return getElapsedTime();
    }
}