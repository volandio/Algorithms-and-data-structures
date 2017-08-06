package com.A.training.B.sinitsynv.lesson07.binary;

import com.A.training.B.sinitsynv.lesson07.Node;

import java.util.Collection;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure
 *
 * @param <E> element
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    private NodeImpl<E> root;
    private int size;

    public int getSize() {
        return size;
    }

    public void addSize() {
        size++;
    }

    public void reduceSize() {
        size--;
    }

    public NodeImpl<E> getRoot() {
        return root;
    }

    public void setRoot(NodeImpl<E> root) throws IllegalStateException {
        if (root == null) {
            throw new IllegalStateException();
        }
        this.root = root;
    }

    /**
     * Validates the node is an instance of supported {@link NodeImpl} type and casts to it
     *
     * @param n node
     * @return casted {@link NodeImpl} node
     * @throws IllegalArgumentException
     */
    public NodeImpl<E> validate(Node<E> n) throws IllegalArgumentException {
        if (n != null && n instanceof NodeImpl) {
            return (NodeImpl<E>) n;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Node<E> addRoot(E e) throws IllegalStateException {
        if (root != null) {
            throw new IllegalStateException();
        }
        root = new NodeImpl<>(e);
        size++;
        return root;
    }

    @Override
    public Node<E> add(Node<E> n, E e) throws IllegalArgumentException {
        NodeImpl<E> current = validate(n);
        NodeImpl<E> added = new NodeImpl<>(e);
        if (current.leftChild == null) {
            current.leftChild = added;
            added.parent = current;
            size++;
        } else if (current.rightChild == null) {
            current.rightChild = added;
            added.parent = current;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
        return added;
    }

    @Override
    public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
        NodeImpl<E> current = validate(n);
        if (current.leftChild != null) {
            throw new IllegalArgumentException();
        }
        NodeImpl<E> added = new NodeImpl<>(e);
        current.leftChild = added;
        added.parent = current;
        size++;
        return added;
    }

    @Override
    public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
        NodeImpl<E> current = validate(n);
        if (current.rightChild != null) {
            throw new IllegalArgumentException();
        }
        NodeImpl<E> added = new NodeImpl<>(e);
        current.rightChild = added;
        added.parent = current;
        size++;
        return added;
    }

    /**
     * Replaces the element at {@link Node} <i>n</i> with <i>e</i>
     *
     * @param n node
     * @param e element
     * @return replace element
     * @throws IllegalArgumentException
     */
    @Override
    public E set(Node<E> n, E e) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        NodeImpl<E> changeableNodeImpl = validate(n);
        E oldElement = changeableNodeImpl.element;
        changeableNodeImpl.element = e;
        return oldElement;
    }

    /**
     * Replaces the element at {@link Node} <i>n</i> with <i>e</i>
     *
     * @param n node
     * @return replace element
     * @throws IllegalArgumentException
     */
    @Override
    public E remove(Node<E> n) throws IllegalArgumentException {
        if (n == null || childrenNumber(n) == 2) {
            throw new IllegalArgumentException();
        }
        NodeImpl<E> currentNode = validate(n);
        NodeImpl<E> parentNode = currentNode.parent;
        if (currentNode.rightChild == null && currentNode.leftChild == null) {
            if (currentNode == root) {
                root = null;
            } else if (parentNode.leftChild == currentNode) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        }
        if (parentNode != null && parentNode.leftChild == currentNode) {
            parentNode.leftChild = null;
        } else if (parentNode != null && parentNode.rightChild == currentNode) {
            parentNode.rightChild = null;
        }
        size--;
        return currentNode.element;
    }

    @Override
    public Node<E> left(Node<E> p) throws IllegalArgumentException {
        NodeImpl<E> node = validate(p);
        if (node == null) {
            throw new IllegalArgumentException();
        }
        return node.leftChild;
    }

    @Override
    public Node<E> right(Node<E> p) throws IllegalArgumentException {
        NodeImpl<E> node = validate(p);
        if (node == null) {
            throw new IllegalArgumentException();
        }
        return node.rightChild;
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public Node<E> parent(Node<E> n) throws IllegalArgumentException {
        NodeImpl<E> node = validate(n);
        if (node.parent == null) {
            throw new IllegalArgumentException();
        }
        return node.parent;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<Node<E>> nodes() {
        return inOrder();
    }

    public static class NodeImpl<E> implements Node<E> {
        private boolean isBlack;
        private E element;
        private NodeImpl<E> leftChild;
        private NodeImpl<E> rightChild;
        private NodeImpl<E> parent;

        NodeImpl(E element) {
            this.element = element;
        }

        public boolean getIsBlack() {
            return isBlack;
        }

        public void setIsBlack(boolean black) {
            isBlack = black;
        }

        public NodeImpl<E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(NodeImpl<E> leftChild) {
            this.leftChild = leftChild;
        }

        public NodeImpl<E> getRightChild() {
            return rightChild;
        }

        public void setRightChild(NodeImpl<E> rightChild) {
            this.rightChild = rightChild;
        }

        public NodeImpl<E> getParent() {
            return parent;
        }

        public void setParent(NodeImpl<E> parent) {
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

}