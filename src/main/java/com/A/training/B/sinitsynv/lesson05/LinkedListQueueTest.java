package com.A.training.B.sinitsynv.lesson05;

import static com.A.training.B.util.Assert.assertEquals;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        testAdd();
        testRemove();
    }

    private static void testRemove() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.add(0);
        linkedListQueue.add(1);
        linkedListQueue.remove();
        assertEquals("LinkedListStackTest.testAdd", "[1]", linkedListQueue.asList().toString());
    }

    private static void testAdd() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.add(0);
        linkedListQueue.add(1);
        assertEquals("LinkedListStackTest.testAdd", "[0, 1]", linkedListQueue.asList().toString());
    }
}
