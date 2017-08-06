package com.A.training.B.sinitsynv.lesson04;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedList<E> {
    private Node<E> head;

    public void add(E e) {
        Node<E> newNode = new Node<>();
        newNode.val = e;
        if (head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public E get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        int size = size() - 1;
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            if (i == size) {
                throw new IndexOutOfBoundsException();
            }
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int size = 1;
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }

    public void reverse() {
        Node<E> reversedPart = null;
        Node<E> currentNode = head;
        while (currentNode != null) {
            Node<E> nextNode = currentNode.next;
            currentNode.next = reversedPart;
            reversedPart = currentNode;
            currentNode = nextNode;
        }
        head = reversedPart;
    }

    public List<E> asList() {
        List<E> list = new LinkedList<>();
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        list.add(currentNode.val);
        return list;
    }

    private static class Node<E> {
        Node<E> next;
        E val;
    }
}
