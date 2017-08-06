package com.A.training.B.sinitsynv.lesson06;

import static com.A.training.B.util.Assert.assertEquals;

public class AssociativeArrayTest {
    public static void main(String[] args) {
        testAddGet();
        testRemove();
    }

    private static void testRemove() {
        AssociativeArray<Integer, Integer> associativeArray = new AssociativeArray<>();
        associativeArray.add(1, 2);
        assertEquals("AssociativeArrayTest.testRemove", 2, associativeArray.remove(1));
    }

    private static void testAddGet() {
        AssociativeArray<Integer, Integer> associativeArray = new AssociativeArray<>();
        associativeArray.add(1, 2);
        associativeArray.add(null, 3);
        assertEquals("AssociativeArrayTest.testAddGet.test1", 2, associativeArray.get(1));
        assertEquals("AssociativeArrayTest.testAddGet.test2", 3, associativeArray.get(null));
    }
}
