package com.A.training.B.sinitsynv.lesson08;

import com.A.training.B.sinitsynv.lesson07.Node;
import com.A.training.B.sinitsynv.lesson07.binary.LinkedBinaryTree;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree<E> extends LinkedBinaryTree<E> {
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public E remove(Node<E> n) throws IllegalArgumentException {
        E element = n.getElement();
        NodeImpl<E> current = validate(n);
        NodeImpl<E> parent = current.getParent();
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root()) {
                setRoot(null);
            } else if (current == parent.getLeftChild()) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        boolean isLeftChild = true;
        if (parent != null && current == parent.getRightChild()) {
            isLeftChild = false;
        }
        if (current.getRightChild() == null) {
            if (current == root()) {
                setRoot(current.getLeftChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root()) {
                setRoot(current.getRightChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            NodeImpl<E> successor = getSuccessor(current);
            if (current == root()) {
                setRoot(successor);
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        reduceSize();
        return element;
    }

    private NodeImpl<E> getSuccessor(NodeImpl<E> delNode) {
        NodeImpl<E> successorParent = delNode;
        NodeImpl<E> successor = delNode;
        NodeImpl<E> current = delNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    @Override
    public Node<E> add(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> currentNode = n;
        Node<E> parentNode;
        while (true) {
            int cmp = compare(e, currentNode.getElement());
            parentNode = currentNode;
            if (cmp < 0) {
                currentNode = left(currentNode);
                if (currentNode == null) {
                    return super.addLeft(parentNode, e);
                }
            } else if (cmp > 0) {
                currentNode = right(currentNode);
                if (currentNode == null) {
                    return super.addRight(parentNode, e);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
        if (compare(n.getElement(), e) > 0) {
            return super.addLeft(n, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
        if (compare(n.getElement(), e) < 0) {
            return super.addRight(n, e);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method for comparing two values
     *
     * @param val1
     * @param val2
     * @return
     */
    public int compare(E val1, E val2) throws IllegalArgumentException {
        if (val1 != null && val2 != null) {
            if (comparator == null) {
                return ((Comparable<E>) val1).compareTo(val2);
            }
            return comparator.compare(val1, val2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the node in n's subtree by val
     *
     * @param n
     * @param val
     * @return
     */
    public Node<E> treeSearch(Node<E> n, E val) {
        if (n == null) {
            return null;
        }
        Node<E> current = validate(n);
        while (current.getElement() != val) {
            if (compare(val, current.getElement()) < 0) {
                current = left(current);
            } else {
                current = right(current);
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        NodeImpl<E> root = getRoot();
        return saveToString(root);
    }

    private String saveToString(NodeImpl<E> node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            result.append("(").append(node.getElement()).append(saveToString(node.getLeftChild()))
                .append(saveToString(node.getRightChild())).append(")");
        }
        return result.toString();
    }

    public void displayTree(Node<E> node) {
        Deque<NodeImpl<E>> arrayDeque = new LinkedList<>();
        arrayDeque.push(validate(node));
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Deque<NodeImpl<E>> localStack = new LinkedList<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (!arrayDeque.isEmpty()) {
                NodeImpl<E> temp = arrayDeque.pop();
                if (temp != null) {
                    System.out.print(temp.getElement());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                arrayDeque.push(localStack.pop());
            }
        }
        System.out.println("");
    }

    protected void afterElementRemoved(Node<E> n) {

    }

    protected void afterElementAdded(Node<E> n) {
    }

}
