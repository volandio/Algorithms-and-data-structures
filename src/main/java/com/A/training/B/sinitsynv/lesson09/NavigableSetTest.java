package com.A.training.B.sinitsynv.lesson09;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import static com.A.training.B.util.Assert.assertEquals;

public class NavigableSetTest {
    private static NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    public static void main(String[] args) {
        testCeiling();
        testDescendingIterator();
        testDescendingSet();
        testFloor();
        testHeadSet();
        testHigher();
        testLower();
        testPollFirst();
        testPollLast();
        testSubSet();
        testTailSet();
        testIterator();
    }

    private static void testIterator() {
        Iterator<Integer> iterator = set.iterator();
        assertEquals("NavigableSetTest.testIterator", 1, iterator.next());
    }

    private static void testTailSet() {
        NavigableSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(4, 5, 6));
        assertEquals("NavigableSetTest.testTailSetTest1", expectedSet, set.tailSet(3, false));
        assertEquals("NavigableSetTest.testTailSetTest2", expectedSet, set.tailSet(4, true));
    }

    private static void testSubSet() {
        NavigableSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(2, 3, 4, 5));
        assertEquals("NavigableSetTest.expectedSetTest1", expectedSet, set.subSet(1, false, 6, false));
        assertEquals("NavigableSetTest.expectedSetTest2", expectedSet, set.subSet(2, true, 5, true));
    }

    private static void testPollLast() {
        NavigableSet<Integer> actualSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        actualSet.pollLast();
        assertEquals("NavigableSetTest.testPollLast", set, actualSet);
    }

    private static void testPollFirst() {
        NavigableSet<Integer> actualSet = new TreeSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        actualSet.pollFirst();
        assertEquals("NavigableSetTest.testPollFirst", set, actualSet);
    }

    private static void testLower() {
        assertEquals("NavigableSetTest.testLower", 4, set.lower(5));
    }

    private static void testHigher() {
        assertEquals("NavigableSetTest.testHigher", 6, set.higher(5));
    }

    private static void testHeadSet() {
        NavigableSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(1, 2, 3));
        assertEquals("NavigableSetTest.testDescendingIteratorTest1", expectedSet, set.headSet(4, false));
        assertEquals("NavigableSetTest.testDescendingIteratorTest2", expectedSet, set.headSet(3, true));
    }

    private static void testFloor() {
        assertEquals("NavigableSetTest.testFloor", 6, set.floor(7));
    }

    private static void testDescendingSet() {
        assertEquals("NavigableSetTest.testDescendingIterator", "[6, 5, 4, 3, 2, 1]", set.descendingSet().toString());
    }

    private static void testDescendingIterator() {
        Iterator<Integer> iterator = set.descendingIterator();
        assertEquals("NavigableSetTest.testDescendingIterator", 6, iterator.next());
    }

    private static void testCeiling() {
        assertEquals("NavigableSetTest.testCeiling", 1, set.ceiling(0));
    }


}
