package com.A.training.B.sinitsynv.lesson09;

import java.util.SortedMap;
import java.util.TreeMap;

import static com.A.training.B.util.Assert.assertEquals;

public class SortedMapTest {
    private static SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 2);
        put(3, 3);
    }};

    public static void main(String[] args) {
        testFirstKey();
        testHeadMap();
        testLastKey();
        testSubMap();
        testTailMap();
    }

    private static void testTailMap() {
        SortedMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(2, 2);
            put(3, 3);
        }};
        assertEquals("SortedMapTest.testTailMap", expectedMap, map.tailMap(2));
    }

    private static void testSubMap() {
        SortedMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(2, 2);
            put(3, 3);
        }};
        assertEquals("SortedMapTest.testSubMap", expectedMap, map.subMap(2, 4));
    }

    private static void testLastKey() {
        assertEquals("SortedMapTest.testLastKey", 3, map.lastKey());
    }

    private static void testHeadMap() {
        SortedMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(2, 2);
            put(1, 1);
        }};
        assertEquals("SortedMapTest.testHeadMap", expectedMap, map.headMap(3));
    }

    private static void testFirstKey() {
        assertEquals("SortedMapTest.testLastKey", 1, map.firstKey());
    }
}
