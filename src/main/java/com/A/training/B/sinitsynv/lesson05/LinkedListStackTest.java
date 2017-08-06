package com.A.training.B.sinitsynv.lesson05;

import static com.A.training.B.util.Assert.assertEquals;

public class LinkedListStackTest {
    public static void main(String[] args) {
        testPop();
        testPush();
    }

    private static void testPush() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(0);
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.pop();
        assertEquals("LinkedListStackTest.testPush", 1, linkedListStack.pop());
    }

    private static void testPop() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(35);
        assertEquals("LinkedListStackTest.testPush", 35, linkedListStack.pop());
    }
}
