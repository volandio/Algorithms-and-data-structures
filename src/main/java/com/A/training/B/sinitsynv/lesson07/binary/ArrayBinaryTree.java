package com.A.training.B.sinitsynv.lesson07.binary;

import com.A.training.B.sinitsynv.lesson07.Node;

import java.util.Collection;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure
 *
 * @param <E> element
 */
public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {
    private NodeImpl<E>[] tree = new NodeImpl[1000];
    private int size;

    private void increaseSizeTree() {
        if (tree.length == size) {
            NodeImpl<E>[] array2 = new NodeImpl[size * 3 / 2];
            System.arraycopy(tree, 0, array2, 0, size);
            tree = array2;
        }
    }

    @Override
    public Node<E> left(Node<E> p) throws IllegalArgumentException {
        int indexLeftChildNode = 2 * ((NodeImpl<E>) p).index + 1;
        return tree[indexLeftChildNode];
    }

    @Override
    public Node<E> right(Node<E> p) throws IllegalArgumentException {
        int indexRightChildNode = 2 * ((NodeImpl<E>) p).index + 2;
        return tree[indexRightChildNode];
    }

    @Override
    public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
        int halfMaxIntValue = (int) (Integer.MAX_VALUE / 1.5);
        if (tree.length >= halfMaxIntValue) {
            throw new OutOfMemoryError();
        }
        increaseSizeTree();
        NodeImpl<E> node = (NodeImpl<E>) n;
        int indexLeftChildNode = 2 * node.index + 1;
        if (left(n) == null) {
            size++;
            return tree[indexLeftChildNode] = new NodeImpl<>(indexLeftChildNode, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
        int halfMaxIntValue = (int) (Integer.MAX_VALUE / 1.5);
        if (tree.length >= halfMaxIntValue) {
            throw new OutOfMemoryError();
        }
        increaseSizeTree();
        NodeImpl<E> node = (NodeImpl<E>) n;
        int indexRightChildNode = 2 * node.index + 2;
        if (right(n) == null) {
            size++;
            return tree[indexRightChildNode] = new NodeImpl<>(indexRightChildNode, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Node<E> root() {
        return tree[0];
    }

    @Override
    public Node<E> parent(Node<E> n) throws IllegalArgumentException {
        if (tree[0] == n) {
            throw new IllegalArgumentException();
        }
        int indexNode = ((NodeImpl<E>) n).index;
        if (indexNode % 2 == 0) {
            return tree[(indexNode - 2) / 2];
        } else {
            return tree[(indexNode - 1) / 2];
        }
    }

    @Override
    public Node<E> addRoot(E e) throws IllegalStateException {
        if (tree[0] != null) {
            throw new IllegalStateException();
        }
        tree[0] = new NodeImpl<>(0, e);
        size++;
        return tree[0];
    }

    @Override
    public Node<E> add(Node<E> n, E e) throws IllegalArgumentException {
        int halfMaxIntValue = (int) (Integer.MAX_VALUE / 1.5);
        if (tree.length >= halfMaxIntValue) {
            throw new OutOfMemoryError();
        }
        increaseSizeTree();
        if (left(n) == null) {
            return addLeft(n, e);
        } else if (right(n) == null) {
            return addRight(n, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public E set(Node<E> n, E e) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        NodeImpl<E> changeableNodeImpl = (NodeImpl<E>) n;
        E oldElement = changeableNodeImpl.element;
        changeableNodeImpl.element = e;
        return oldElement;
    }

    @Override
    public E remove(Node<E> n) throws IllegalArgumentException {
        int indexNode = ((NodeImpl<E>) n).index;
        E element = tree[indexNode].element;
        tree[indexNode] = null;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<Node<E>> nodes() {
        return inOrder();
    }

    protected static class NodeImpl<E> implements Node<E> {
        private E element;
        private int index;

        NodeImpl(int index, E element) {
            this.element = element;
            this.index = index;
        }

        @Override
        public E getElement() {
            return element;
        }
    }
}
