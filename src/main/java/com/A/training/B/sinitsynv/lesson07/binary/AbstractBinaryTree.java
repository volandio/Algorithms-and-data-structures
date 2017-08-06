package com.A.training.B.sinitsynv.lesson07.binary;

import com.A.training.B.sinitsynv.lesson07.AbstractTree;
import com.A.training.B.sinitsynv.lesson07.Node;

import java.util.*;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Node<E> sibling(Node<E> n) throws IllegalArgumentException {
        Node<E> parent = parent(n);
        if (childrenNumber(parent) == 1) {
            return null;
        } else if (left(parent) == n) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    @Override
    public Collection<Node<E>> children(Node<E> n) throws IllegalArgumentException {
        List<Node<E>> childrenList = new ArrayList<>();
        childrenList.add(left(n));
        childrenList.add(right(n));
        return childrenList;
    }

    @Override
    public int childrenNumber(Node<E> n) throws IllegalArgumentException {
        int childrenNumber = 0;
        if (left(n) != null) {
            childrenNumber++;
        }
        if (right(n) != null) {
            childrenNumber++;
        }
        return childrenNumber;
    }

    @Override
    public Collection<Node<E>> preOrder() {
        List<Node<E>> list = new ArrayList<>();
        if (root() == null) {
            return list;
        }
        Deque<Node<E>> nodes = new ArrayDeque<>();
        nodes.push(root());
        while (!nodes.isEmpty()) {
            Node<E> node = nodes.pop();
            list.add(node);
            Node<E> rightChildNode = right(node);
            if (rightChildNode != null) {
                nodes.push(rightChildNode);
            }
            Node<E> leftChildNode = left(node);
            if (leftChildNode != null) {
                nodes.push(leftChildNode);
            }
        }
        return list;
    }

    public Collection<Node<E>> inOrder() {
        List<Node<E>> list = new ArrayList<>();
        if (root() == null) {
            return list;
        }
        Deque<Node<E>> nodes = new ArrayDeque<>();
        Node<E> node = root();
        while (!nodes.isEmpty() || node != null) {
            if (node != null) {
                nodes.push(node);
                node = left(node);
            } else {
                node = nodes.pop();
                list.add(node);
                node = right(node);
            }
        }
        return list;
    }

    @Override
    public Collection<Node<E>> postOrder() {
        List<Node<E>> list = new ArrayList<>();
        if (root() == null) {
            return list;
        }
        Deque<Node<E>> nodes = new ArrayDeque<>();
        Node<E> current = root();
        Node<E> lastVisited = root();
        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = left(current);
            } else {
                Node<E> peekNode = nodes.peek();
                Node<E> rightChildNode = right(peekNode);
                if (rightChildNode != null && lastVisited != rightChildNode) {
                    current = rightChildNode;
                } else {
                    list.add(peekNode);
                    lastVisited = nodes.poll();
                }
            }
        }
        return list;
    }

    @Override
    public Collection<Node<E>> breadthFirst() {
        List<Node<E>> list = new ArrayList<>();
        if (root() == null) {
            return list;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root());
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            list.add(node);
            Node<E> leftChildNode = left(node);
            if (leftChildNode != null) {
                queue.add(leftChildNode);
            }
            Node<E> rightChildNode = right(node);
            if (rightChildNode != null) {
                queue.add(rightChildNode);
            }
        }
        return list;
    }
}
