package com.A.training.B.sinitsynv.lesson04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static com.A.training.B.util.Assert.assertEquals;

public class CollectionTest {
    public static void main(String[] args) {
        testSize();
        testIsEmpty();
        testContains();
        testIterator();
        testToArrayObject();
        testToArrayGeneric();
        testAdd();
        testRemove();
        testContainsAll();
        testAddAll();
        testRemoveAll();
        testRetainAll();
        testClear();
        testEquals();
        testHashCode();
    }

    private static void testToArrayGeneric() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        arrayListFirst.add(5);
        Integer[] arrayInteger = new Integer[arrayListFirst.size()];
        arrayListFirst.toArray(arrayInteger);
        assertEquals("CollectionTest.testToArrayGeneric", 5, arrayInteger[0]);
    }

    private static void testHashCode() {
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        assertEquals("CollectionTest.testHashCode", 36, arrayList.hashCode());
    }

    private static void testEquals() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        Collection<Integer> arrayListSecond = new ArrayList<>();
        arrayListFirst.add(5);
        arrayListSecond.add(5);
        assertEquals("CollectionTest.testEqualsTest1", true, arrayListFirst.equals(arrayListSecond));
        arrayListFirst.add(5);
        assertEquals("CollectionTest.testEqualsTest2", false, arrayListFirst.equals(arrayListSecond));
    }

    private static void testClear() {
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.clear();
        assertEquals("CollectionTest.testClear", 0, arrayList.size());
    }

    private static void testRetainAll() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        Collection<Integer> arrayListSecond = new ArrayList<>();
        arrayListFirst.add(5);
        arrayListFirst.add(6);
        arrayListSecond.add(5);
        assertEquals("CollectionTest.testRetainAllTest1", true, arrayListFirst.retainAll(arrayListSecond));
        assertEquals("CollectionTest.testRetainAllTest2", false, arrayListFirst.retainAll(arrayListSecond));
    }

    private static void testRemoveAll() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        Collection<Integer> arrayListSecond = new ArrayList<>();
        arrayListFirst.add(5);
        arrayListSecond.add(5);
        assertEquals("CollectionTest.testRemoveAllTest1", true, arrayListFirst.removeAll(arrayListSecond));
        assertEquals("CollectionTest.testRemoveAllTest2", false, arrayListFirst.removeAll(arrayListSecond));
    }

    private static void testAddAll() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        arrayListFirst.add(4);
        Collection<Integer> arrayListSecond = new ArrayList<>();
        arrayListSecond.add(5);
        assertEquals("CollectionTest.testAddAll", true, arrayListFirst.addAll(arrayListSecond));
    }

    private static void testContainsAll() {
        Collection<Integer> arrayListFirst = new ArrayList<>();
        Collection<Integer> arrayListSecond = new ArrayList<>();
        arrayListFirst.add(5);
        arrayListFirst.add(6);
        assertEquals("CollectionTest.testContainsAllTest1", false, arrayListSecond.containsAll(arrayListFirst));
        arrayListSecond.add(5);
        assertEquals("CollectionTest.testContainsAllTest2", true, arrayListFirst.containsAll(arrayListSecond));

    }

    private static void testRemove() {
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        assertEquals("CollectionTest.testRemoveTest1", true, arrayList.remove(5));
        assertEquals("CollectionTest.testRemoveTest2", false, arrayList.remove(5));
    }

    private static void testAdd() {
        Collection<Integer> arrayList = new ArrayList<>();
        assertEquals("CollectionTest.testAdd", true, arrayList.add(5));

    }

    private static void testToArrayObject() {
        Collection<Integer> arrayList = new ArrayList<>();
        Object[] arrayObjects = {1, 2};
        arrayList.add(1);
        arrayList.add(2);
        assertEquals("CollectionTest.testToArrayObject", arrayObjects, arrayList.toArray());
    }

    private static void testIterator() {
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        Iterator iterator = arrayList.iterator();
        assertEquals("CollectionTest.testIterator", 1, (int) iterator.next());
    }

    private static void testContains() {
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        assertEquals("CollectionTest.testContainsTest1", true, arrayList.contains(1));
        assertEquals("CollectionTest.testContainsTest2", false, arrayList.contains(0));
    }

    private static void testIsEmpty() {
        Collection<Integer> arrayList = new ArrayList<>();
        assertEquals("CollectionTest.testIsEmptyTest1", true, arrayList.isEmpty());
        arrayList.add(1);
        assertEquals("CollectionTest.testIsEmptyTest2", false, arrayList.isEmpty());
    }

    private static void testSize() {
        Collection<Integer> arrayList = new ArrayList<>();
        assertEquals("CollectionTest.testSize", 0, arrayList.size());
    }
}

