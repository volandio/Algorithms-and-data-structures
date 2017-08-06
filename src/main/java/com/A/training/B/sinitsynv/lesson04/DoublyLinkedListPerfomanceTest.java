package com.A.training.B.sinitsynv.lesson04;

import java.util.LinkedList;

import static com.A.training.B.util.StopWatch.getElapsedTime;
import static com.A.training.B.util.StopWatch.start;
import static java.lang.System.out;

public class DoublyLinkedListPerfomanceTest {
    public static void main(String[] args) {
        out.println("-------- Addition to the begin --------");
        out.println("LinkedList.add(index, e): " + testAddToBeginLinkedList() + " ms");
        out.println("DoublyLinkedList.add(index, e): " + testAddToBeginDoublyLinkedList() + " ms");
        out.println();
        out.println("-------- Addition to the middle --------");
        out.println("DoublyLinkedList.add(index, e): " + testAddToMiddleDoublyLinkedList() + " ms");
        out.println("LinkedList.add(index, e): " + testAddToMiddleLinkedList() + " ms");
        out.println();
        out.println("-------- Addition to the end --------");
        out.println("DoublyLinkedList.add(e): " + testAddToEndDoublyLinkedList() + " ms");
        out.println("LinkedList.add(e): " + testAddToEndLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the begin --------");
        out.println("DoublyLinkedList.remove(index): " + testRemoveInBeginDoublyLinkedList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInBeginLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the middle --------");
        out.println("DoublyLinkedList.remove(index): " + testRemoveInMiddleDoublyLinkedList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInMiddleLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the end --------");
        out.println("DoublyLinkedList.remove(index): " + testRemoveInEndDoublyLinkedList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInEndLinkedList() + " ms");
    }

    private static long testAddToBeginLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            doublyLinkedList.add(0, i);
        }
        return getElapsedTime();
    }

    private static long testAddToBeginDoublyLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            linkedList.add(0, i);
        }
        return getElapsedTime();
    }

    private static long testRemoveInEndLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        return getElapsedTime();
    }

    private static long testRemoveInEndDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            doublyLinkedList.remove(doublyLinkedList.size() - 1);
        }
        return getElapsedTime();
    }

    private static long testRemoveInMiddleLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        return getElapsedTime();
    }

    private static long testRemoveInMiddleDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            doublyLinkedList.remove(doublyLinkedList.size() / 2);
        }
        return getElapsedTime();
    }

    private static long testRemoveInBeginLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            linkedList.remove(0);
        }
        return getElapsedTime();
    }

    private static long testRemoveInBeginDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 5_000_000; i++) {
            doublyLinkedList.remove(0);
        }
        return getElapsedTime();
    }

    private static long testAddToEndLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 15_000_000; i++) {
            linkedList.add(i);
        }
        return getElapsedTime();
    }

    private static long testAddToEndDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 15_000_000; i++) {
            doublyLinkedList.add(i);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 200; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = getDoublyLinkedList();
        start();
        for (int i = 0; i < 200; i++) {
            doublyLinkedList.add(doublyLinkedList.size() / 2, i);
        }
        return getElapsedTime();
    }

    private static DoublyLinkedList<Integer> getDoublyLinkedList() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 5_000_000; i++) {
            doublyLinkedList.add(i);
        }
        return doublyLinkedList;
    }

    private static LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5_000_000; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }
}
