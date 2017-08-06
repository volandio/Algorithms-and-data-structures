package com.A.training.B.sinitsynv.lesson04;

import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        testSize();
        testGet();
        testAsList();
        testAdd();
        testReverse();
    }

    private static void testReverse() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0);
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.reverse();
        assertEquals("SinglyLinkedListTest.testReverse", "[2, 1, 0]", singlyLinkedList.asList().toString());
    }

    private static void testAdd() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0);
        singlyLinkedList.add(1);
        assertEquals("SinglyLinkedListTest.testAdd", "[0, 1]", singlyLinkedList.asList().toString());
    }

    private static void testAsList() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0);
        singlyLinkedList.add(1);
        List<Integer> list = singlyLinkedList.asList();
        assertEquals("SinglyLinkedListTest.testAsList", "[0, 1]", list.toString());
    }

    private static void testGet() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(5);
        assertEquals("SinglyLinkedListTest.testGet", 5, singlyLinkedList.get(0));
    }

    private static void testSize() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(0);
        singlyLinkedList.add(1);
        assertEquals("SinglyLinkedListTest.testSize", 2, singlyLinkedList.size());
    }
}
