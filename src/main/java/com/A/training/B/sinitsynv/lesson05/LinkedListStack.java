package com.A.training.B.sinitsynv.lesson05;

import java.util.EmptyStackException;

public class LinkedListStack<E> implements Stack<E> {
    private Node<E> head;

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public E pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        E tempElement = head.val;
        head = head.next;
        return tempElement;
    }

    private static class Node<E> {
        public Node<E> next;
        private E val;

        public Node(E val) {
            this.val = val;
        }
    }
}

