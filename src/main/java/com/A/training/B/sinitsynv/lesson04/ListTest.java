package com.A.training.B.sinitsynv.lesson04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class ListTest {
    public static void main(String[] args) {
        testAdd();
        testAddAll();
        testGet();
        testIndexOf();
        testLastIndexOf();
        testListIterator();
        testListIteratorIndex();
        testRemove();
        testSet();
        testSublist();
    }

    private static void testSublist() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        List<Integer> list = arrayList.subList(0, 1);
        assertEquals("ListTest.testSublist", 1, list.get(0));
    }

    private static void testSet() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.set(0, 2);
        assertEquals("ListTest.testSet", 2, arrayList.get(0));
    }

    private static void testRemove() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        assertEquals("ListTest.testRemove", 1, arrayList.remove(0));
    }

    private static void testListIteratorIndex() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        Iterator iterator = arrayList.listIterator(0);
        assertEquals("ListTest.testListIteratorIndex", 1, (int) iterator.next());
    }

    private static void testListIterator() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        Iterator iterator = arrayList.listIterator();
        assertEquals("ListTest.testListIterator", 1, (int) iterator.next());
    }

    private static void testLastIndexOf() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        assertEquals("ListTest.testLastIndexOf", 2, arrayList.lastIndexOf(1));
    }

    private static void testIndexOf() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(1);
        assertEquals("ListTest.testIndexOf", 2, arrayList.indexOf(1));
    }

    private static void testGet() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        assertEquals("ListTest.testIndexOf", 0, arrayList.get(0));
    }

    private static void testAddAll() {
        List<Integer> arrayListFirst = new ArrayList<>();
        arrayListFirst.add(1);
        List<Integer> arrayListSecond = new ArrayList<>();
        arrayListSecond.add(0);
        arrayListSecond.addAll(0, arrayListFirst);
        assertEquals("ListTest.testAddAll", 0, arrayListSecond.get(1));
    }

    private static void testAdd() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(0, 1);
        assertEquals("ListTest.testAdd", 1, arrayList.get(1));
    }
}
