package com.A.training.B.sinitsynv.lesson04;

import static com.A.training.B.util.Assert.assertEquals;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        testBooleanAdd();
        testAdd();
        testBooleanRemove();
        testRemove();
        testGet();
        testListIterator();
        testSize();
    }

    private static DoublyLinkedList<Integer> getNewDoublyLinkedListSizeThree() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(0);
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        return doublyLinkedList;
    }

    private static void testSize() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        assertEquals("DoublyLinkedListTest.testSize", 3, doublyLinkedList.size());
    }

    private static void testListIterator() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        DoublyLinkedList.ListIteratorImpl iterator = doublyLinkedList.listIterator();
        iterator.next();
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testPreviousIndex", 0, iterator.previousIndex());
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testNextIndex", 1, iterator.nextIndex());
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testPrevious", 0, (int) iterator.previous());
        iterator.next();
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testHasNext", true, iterator.hasNext());
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testNext", 1, (int) iterator.next());
        iterator.remove();
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testRemove", 2, doublyLinkedList.get(1));
        iterator.next();
        iterator.set(4);
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testSet", 4, doublyLinkedList.get(1));
        iterator.add(3);
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testAdd", 3, doublyLinkedList.get(2));
        assertEquals("DoublyLinkedListTest.ListIteratorImpl.testHasPrevious", true, iterator.hasPrevious());
    }

    private static void testGet() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        assertEquals("DoublyLinkedListTest.testGet", 2, doublyLinkedList.get(2));
    }

    private static void testRemove() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        doublyLinkedList.remove(1);
        assertEquals("DoublyLinkedListTest.testRemove", 2, doublyLinkedList.get(1));
    }

    private static void testBooleanRemove() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        assertEquals("DoublyLinkedListTest.testBooleanRemoveTest1", true, doublyLinkedList.remove((Integer) 1));
        assertEquals("DoublyLinkedListTest.testBooleanRemoveTest2", false, doublyLinkedList.remove((Integer) 1));
    }

    private static void testAdd() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        doublyLinkedList.add(0, 1);
        assertEquals("DoublyLinkedListTest.testAdd", 1, doublyLinkedList.get(0));
    }

    private static void testBooleanAdd() {
        DoublyLinkedList<Integer> doublyLinkedList = getNewDoublyLinkedListSizeThree();
        doublyLinkedList.add(3);
        assertEquals("DoublyLinkedListTest.testBooleanAdd", 3, doublyLinkedList.get(3));
    }
}
