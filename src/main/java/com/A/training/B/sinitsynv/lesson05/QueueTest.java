package com.A.training.B.sinitsynv.lesson05;

import java.util.LinkedList;
import java.util.Queue;

import static com.A.training.B.util.Assert.assertEquals;

public class QueueTest {
    public static void main(String[] args) {
        testElement();
        testOffer();
        testPeek();
        testPoll();
        testRemove();
    }

    private static void testRemove() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.remove();
        assertEquals("DequeTest.testRemove", 1, queue.remove());
    }

    private static void testPoll() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.poll();
        assertEquals("DequeTest.testPoll", 1, queue.poll());
    }

    private static void testPeek() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.peek();
        assertEquals("DequeTest.testPeek", 0, queue.peek());
    }

    private static void testOffer() {
        Queue<Integer> queue = new LinkedList<>();
        assertEquals("DequeTest.testOffer", true, queue.offer(0));

    }

    private static void testElement() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.element();
        assertEquals("DequeTest.testRemove", 0, queue.element());
    }
}
