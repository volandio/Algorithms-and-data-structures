package com.A.training.B.sinitsynv.lesson09;

import java.util.*;

import static com.A.training.B.util.Assert.assertEquals;

public class NavigableMapTest {
    private static NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 2);
        put(3, 3);
    }};

    public static void main(String[] args) {
        testCeilingEntry();
        testCeilingKey();
        testDescendingKeySet();
        testDescendingMap();
        testFirstEntry();
        testFloorEntry();
        testFloorKey();
        testHeadMap();
        testHigherEntry();
        testHigherKey();
        testLastEntry();
        testLowerEntry();
        testLowerKey();
        testNavigableKeySet();
        testPollFirstEntry();
        testPollLastEntry();
        testSubMap();
        testTailMap();
    }

    private static void testTailMap() {
        NavigableMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(2, 2);
            put(3, 3);
        }};
        assertEquals("NavigableMapTest.testTailMapTest1", expectedMap, map.tailMap(2, true));
        assertEquals("NavigableMapTest.testTailMapTest2", expectedMap, map.tailMap(1, false));
    }

    private static void testSubMap() {
        NavigableMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(2, 2);
            put(3, 3);
        }};
        assertEquals("NavigableMapTest.testSubMapTest1", expectedMap, map.subMap(1, false, 3, true));
        assertEquals("NavigableMapTest.testSubMapTest2", expectedMap, map.subMap(2, true, 4, false));
    }

    private static void testPollLastEntry() {
        NavigableMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
            put(3, 3);
            put(4, 4);
        }};
        expectedMap.pollLastEntry();
        assertEquals("NavigableMapTest.testPollLastEntry", expectedMap, map);
    }

    private static void testPollFirstEntry() {
        NavigableMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
        expectedMap.pollFirstEntry();
        assertEquals("NavigableMapTest.testPollFirstEntry", expectedMap, map);
    }

    private static void testNavigableKeySet() {
        NavigableSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(1, 2, 3));
        assertEquals("NavigableMapTest.testNavigableKeySet", expectedSet, map.navigableKeySet());
    }

    private static void testLowerKey() {
        assertEquals("NavigableMapTest.testLowerKey", 3, map.lowerKey(4));
    }

    private static void testLowerEntry() {
        assertEquals("NavigableMapTest.testLowerEntry", 3, map.lowerEntry(4).getValue());
    }

    private static void testLastEntry() {
        assertEquals("NavigableMapTest.testLastEntry", 3, map.lastEntry().getValue());
    }

    private static void testHigherKey() {
        assertEquals("NavigableMapTest.testHigherKey", 3, map.higherKey(2));
    }

    private static void testHigherEntry() {
        assertEquals("NavigableMapTest.testHigherEntry", 3, map.higherEntry(2).getValue());
    }

    private static void testHeadMap() {
        NavigableMap<Integer, Integer> expectedMap = new TreeMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 2);
        }};
        assertEquals("NavigableMapTest.testHeadMapTest1", expectedMap, map.headMap(3, false));
        assertEquals("NavigableMapTest.testHeadMapTest2", expectedMap, map.headMap(2, true));
    }

    private static void testFloorKey() {
        assertEquals("NavigableMapTest.testFloorKey", 3, map.floorKey(4));
    }

    private static void testFloorEntry() {
        assertEquals("NavigableMapTest.testFirstEntry", 3, map.floorEntry(4).getValue());
    }

    private static void testFirstEntry() {
        assertEquals("NavigableMapTest.testFirstEntry", 1, map.firstEntry().getValue());

    }

    private static void testDescendingMap() {
        assertEquals("NavigableMapTest.testDescendingMap", "{3=3, 2=2, 1=1}", map.descendingMap().toString());
    }

    private static void testDescendingKeySet() {
        NavigableSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(3, 2, 1));
        assertEquals("NavigableMapTest.testDescendingKeySet", expectedSet, map.descendingKeySet());
    }

    private static void testCeilingKey() {
        assertEquals("NavigableMapTest.testCeilingKey", 1, map.ceilingKey(0));
    }

    private static void testCeilingEntry() {
        assertEquals("NavigableMapTest.testCeilingEntry", 1, map.ceilingEntry(0).getValue());
    }
}
