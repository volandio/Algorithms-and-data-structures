package com.A.training.B.sinitsynv.lesson05;

import java.util.LinkedList;
import java.util.List;

public class LinkedListQueue<E> extends AbstractQueue<E> {
    private Node<E> head;
    private Node<E> tail;

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        return true;
    }

    @Override
    public E remove() {
        E val;
        if (head == null) {
            throw new NullPointerException();
        }
        if (head == tail) {
            val = head.val;
            head = null;
            tail = null;
            return val;
        }
        val = head.next.val;
        head = head.next;
        return val;
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

    static class Node<E> {
        public Node<E> next;
        private E val;

        public Node(E val) {
            this.val = val;
        }
    }
}
