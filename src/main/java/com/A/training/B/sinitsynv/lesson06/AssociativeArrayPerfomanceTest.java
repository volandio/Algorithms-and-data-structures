package com.A.training.B.sinitsynv.lesson06;

import java.util.HashMap;
import java.util.Map;

import static com.A.training.B.util.StopWatch.getElapsedTime;
import static com.A.training.B.util.StopWatch.start;

public class AssociativeArrayPerfomanceTest {
    private final static Map<Integer, Integer> MAP = new HashMap<>();
    private final static AssociativeArray<Integer, Integer> ASSOCIATIVEARRAY = new AssociativeArray<>();
    private final static int FIVEMILLIONS = 5_000_000;

    public static void main(String[] args) {
        System.out.println("-------- Addition --------");
        System.out.println("AssociativeArray.add(K k, V v): " + testAddToAssociativeArray() + " ms");
        System.out.println("HashMap.put(K k, V v): " + testAddToHashMap() + " ms");
        System.out.println();
        System.out.println("-------- Getting --------");
        System.out.println("HashMap.get(K k): " + testGetHashMap() + " ms");
        System.out.println("AssociativeArray.get(K k): " + testGetAssociativeArray() + " ms");
        System.out.println("-------- Removing --------");
        System.out.println("AssociativeArray.remove(K k): " + testRemoveInToAssociativeArray() + " ms");
        System.out.println("HashMap.remove(K k): " + testRemoveInToHashMap() + " ms");
        System.out.println();
        System.out.println("-------- Addition Special keys --------");
        System.out.println("AssociativeArray.addSpecialKeys(): " + testAddSpecialKeysToAssociativeArray() + " ms");
        System.out.println("HashMap.addSpecialKeys(): " + testAddSpecialKeysToHashMap() + " ms");

    }

    private static long testAddSpecialKeysToHashMap() {
        Map<String, Integer> map = new HashMap<>();
        start();
        for (int i = 0; i < 50_000_000; i++) {
            map.put("polygenelubricants", 1);
            map.put("random", 1);
        }
        return getElapsedTime();
    }

    private static long testAddSpecialKeysToAssociativeArray() {
        AssociativeArray<String, Integer> associativeArray = new AssociativeArray<>();
        start();
        for (int i = 0; i < 50_000_000; i++) {
            associativeArray.add("polygenelubricants", 1);
            associativeArray.add("random", 2);
        }
        return getElapsedTime();
    }

    private static long testGetHashMap() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            MAP.get(i);
        }
        return getElapsedTime();
    }

    private static long testGetAssociativeArray() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            ASSOCIATIVEARRAY.get(i);
        }
        return getElapsedTime();
    }

    private static long testRemoveInToHashMap() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            MAP.remove(i);
        }
        return getElapsedTime();
    }

    private static long testRemoveInToAssociativeArray() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            ASSOCIATIVEARRAY.remove(i);
        }
        return getElapsedTime();
    }

    private static long testAddToHashMap() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            MAP.put(i, i);
        }
        return getElapsedTime();
    }

    private static long testAddToAssociativeArray() {
        start();
        for (int i = 0; i < FIVEMILLIONS; i++) {
            ASSOCIATIVEARRAY.add(i, i);
        }
        return getElapsedTime();
    }
}
