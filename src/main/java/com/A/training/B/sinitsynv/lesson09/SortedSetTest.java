package com.A.training.B.sinitsynv.lesson09;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.A.training.B.util.Assert.assertEquals;

public class SortedSetTest {
    private static SortedSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    public static void main(String[] args) {
        testSubSet();
        testHeadSet();
        testTailSet();
        testFirst();
        testLast();
    }

    private static void testLast() {
        assertEquals("SortedSetTest.testLast", 6, set.last());
    }

    private static void testFirst() {
        assertEquals("SortedSetTest.testFirst", 1, set.first());
    }

    private static void testTailSet() {
        SortedSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(4, 5, 6));
        assertEquals("SortedSetTest.testTailSet", expectedSet, set.tailSet(4));
    }

    private static void testHeadSet() {
        SortedSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(1, 2, 3));
        assertEquals("SortedSetTest.testHeadSet", expectedSet, set.headSet(4));
    }

    private static void testSubSet() {
        SortedSet<Integer> expectedSet = new TreeSet<>(Arrays.asList(2, 3, 4, 5));
        assertEquals("SortedSetTest.testSubSet", expectedSet, set.subSet(2, 6));
    }
}
