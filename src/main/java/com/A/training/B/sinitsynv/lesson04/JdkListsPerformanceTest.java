package com.A.training.B.sinitsynv.lesson04;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.A.training.B.util.StopWatch.getElapsedTime;
import static com.A.training.B.util.StopWatch.start;
import static java.lang.System.out;

public class JdkListsPerformanceTest {
    public static void main(String[] args) {
        out.println("-------- Addition to the begin --------");
        out.println("ArrayList.add(index, e): " + testAddToBeginArrayList() + " ms");
        out.println("LinkedList.add(index, e): " + testAddToBeginLinkedList() + " ms");
        out.println();
        out.println("-------- Addition to the middle --------");
        out.println("ArrayList.add(index, e): " + testAddToMiddleArrayList() + " ms");
        out.println("LinkedList.add(index, e): " + testAddToMiddleLinkedList() + " ms");
        out.println();
        out.println("-------- Addition to the end --------");
        out.println("ArrayList.add(e): " + testAddToEndArrayList() + " ms");
        out.println("LinkedList.add(e): " + testAddToEndLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the begin --------");
        out.println("ArrayList.remove(index): " + testRemoveInBeginArrayList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInBeginLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the middle --------");
        out.println("ArrayList.remove(index): " + testRemoveInMiddleArrayList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInMiddleLinkedList() + " ms");
        out.println();
        out.println("-------- Removing in the end --------");
        out.println("ArrayList.remove(index): " + testRemoveInEndArrayList() + " ms");
        out.println("LinkedList.remove(index): " + testRemoveInEndLinkedList() + " ms");
    }

    private static long testRemoveInEndLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        return getElapsedTime();
    }

    private static long testRemoveInEndArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 1_000; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        return getElapsedTime();
    }

    private static long testRemoveInMiddleArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 1_000; i++) {
            arrayList.remove(arrayList.size() / 2);
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

    private static long testRemoveInBeginLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            linkedList.remove(0);
        }
        return getElapsedTime();
    }

    private static long testRemoveInBeginArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 1_000; i++) {
            arrayList.remove(0);
        }
        return getElapsedTime();
    }

    private static long testAddToEndLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 10_000_000; i++) {
            linkedList.add(i);
        }
        return getElapsedTime();
    }

    private static long testAddToEndArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 10_000_000; i++) {
            arrayList.add(i);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            linkedList.add(linkedList.size() / 2, 1);
        }
        return getElapsedTime();
    }

    private static long testAddToMiddleArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 1_000; i++) {
            arrayList.add(arrayList.size() / 2, 1);
        }
        return getElapsedTime();
    }

    private static long testAddToBeginLinkedList() {
        LinkedList linkedList = getLinkedList();
        start();
        for (int i = 0; i < 1_000; i++) {
            linkedList.add(0, i);
        }
        return getElapsedTime();
    }

    private static long testAddToBeginArrayList() {
        ArrayList arrayList = getArrayList();
        start();
        for (int i = 0; i < 1_000; i++) {
            arrayList.add(0, i);
        }
        return getElapsedTime();
    }

    private static ArrayList<Integer> getArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5_000_000; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private static LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5_000_000; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }
}
