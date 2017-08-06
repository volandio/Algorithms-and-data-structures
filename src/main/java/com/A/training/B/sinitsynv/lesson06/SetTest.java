package com.A.training.B.sinitsynv.lesson06;

import java.util.HashSet;
import java.util.Set;

import static com.A.training.B.util.Assert.assertEquals;

public class SetTest {
    public static void main(String[] args) {
        testAdd();
        testAddAll();
    }

    private static void testAddAll() {
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(1);
        Set<Integer> secondSet = new HashSet<>();
        secondSet.addAll(firstSet);
        secondSet.addAll(firstSet);
        assertEquals("SetTest.testAddAll", firstSet.toString(), secondSet.toString());
    }

    private static void testAdd() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        assertEquals("SetTest.testAdd", "[1]", set.toString());
    }
}
