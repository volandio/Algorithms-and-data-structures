package com.A.training.B.sinitsynv.lesson06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.A.training.B.util.Assert.assertEquals;

public class MapTest {
    public static void main(String[] args) {
        testSize();
        testIsEmpty();
        testContainsKey();
        testContainsValue();
        testGetAndPut();
        testRemove();
        testPutAll();
        testClear();
        testKeySet();
        testValues();
    }

    private static void testGetAndPut() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        assertEquals("MapTest.testGetAndPut", 2, map.get(1));
    }

    private static void testValues() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(0, 2);
        assertEquals("MapTest.testValues", "[2, 2]", map.values().toString());
    }

    private static void testKeySet() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        Set<Integer> set = new HashSet<Integer>() {{
            add(1);
            add(2);
        }};
        assertEquals("MapTest.testKeySet", set.toString(), map.keySet().toString());
    }

    private static void testClear() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.clear();
        assertEquals("MapTest.testClear", 0, map.size());
    }

    private static void testPutAll() {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        secondMap.put(1, 2);
        firstMap.putAll(secondMap);
        assertEquals("MapTest.testPutAll", secondMap.toString(), firstMap.toString());
    }

    private static void testRemove() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.remove(1);
        assertEquals("MapTest.testRemove", true, map.isEmpty());
    }

    private static void testContainsValue() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        assertEquals("MapTest.testContainsValueTest1", true, map.containsValue(1));
        assertEquals("MapTest.testContainsValueTest2", false, map.containsValue(2));
    }

    private static void testContainsKey() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        assertEquals("MapTest.testContainsKeyTest1", true, map.containsKey(1));
        assertEquals("MapTest.testContainsKeyTest2", false, map.containsKey(2));
    }

    private static void testIsEmpty() {
        Map<Integer, Integer> map = new HashMap<>();
        assertEquals("MapTest.testIsEmptyTest1", true, map.isEmpty());
        map.put(1, 1);
        assertEquals("MapTest.testIsEmptyTest2", false, map.isEmpty());
    }

    private static void testSize() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        assertEquals("MapTest.testSize", 1, map.size());
    }
}
