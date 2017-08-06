package com.A.training.B.sinitsynv.lesson05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static com.A.training.B.util.Assert.assertEquals;

public class DequeTest {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testDescendingIterator();
        testGetFirst();
        testGetLast();
        testOfferFirst();
        testOfferLast();
        testPeekFirst();
        testPeekLast();
        testPollFirst();
        testPollLast();
        testPop();
        testPush();
        testRemoveFirst();
        testRemoveLast();
        testRemoveFirstOccurrence();
        testRemoveLastOccurrence();
    }

    private static void testRemoveLastOccurrence() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        assertEquals("DequeTest.testRemoveLastOccurrenceTest1", true, deque.removeLastOccurrence(1));
        assertEquals("DequeTest.testRemoveLastOccurrenceTest2", false, deque.removeLastOccurrence(1));
    }

    private static void testRemoveFirstOccurrence() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals("DequeTest.testRemoveFirstOccurrenceTest1", true, deque.removeFirstOccurrence(1));
        assertEquals("DequeTest.testRemoveFirstOccurrenceTest2", false, deque.removeFirstOccurrence(1));
    }

    private static void testRemoveLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(4);
        assertEquals("DequeTest.testRemoveLast", 3, deque.removeLast());
    }

    private static void testRemoveFirst() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(4);
        assertEquals("DequeTest.testRemoveFirst", 4, deque.removeFirst());
    }

    private static void testPush() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        assertEquals("DequeTest.testPush", 4, deque.pop());
    }

    private static void testPop() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        assertEquals("DequeTest.testPop", 3, deque.pop());
    }

    private static void testPollLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        assertEquals("DequeTest.testPollLast", 3, deque.pollLast());
    }

    private static void testPollFirst() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        assertEquals("DequeTest.testPollFirst", 4, deque.pollFirst());
    }

    private static void testPeekLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        deque.peekLast();
        assertEquals("DequeTest.testPeekLast", 3, deque.peekLast());
    }

    private static void testPeekFirst() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        deque.peekFirst();
        assertEquals("DequeTest.testPeekFirst", 4, deque.peekFirst());
    }

    private static void testOfferLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        assertEquals("DequeTest.testOfferLast", true, deque.offerLast(4));
    }

    private static void testOfferFirst() {
        Deque<Integer> deque = new ArrayDeque<>(8);
        assertEquals("DequeTest.testOfferFirst", true, deque.offerFirst(4));
    }

    private static void testGetLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        deque.getLast();
        assertEquals("DequeTest.testGetLast", 3, deque.getLast());
    }

    private static void testGetFirst() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        deque.getFirst();
        assertEquals("DequeTest.testGetFirst", 4, deque.getFirst());
    }

    private static void testDescendingIterator() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(3);
        deque.push(4);
        Iterator iterator = deque.descendingIterator();
        assertEquals("DequeTest.testDescendingIterator", 3, (int) iterator.next());
    }

    private static void testAddLast() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(3);
        deque.addLast(4);
        assertEquals("DequeTest.testAddLast", 4, deque.getLast());
    }

    private static void testAddFirst() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(4);
        assertEquals("DequeTest.testAddFirst", 4, deque.getFirst());
    }
}
