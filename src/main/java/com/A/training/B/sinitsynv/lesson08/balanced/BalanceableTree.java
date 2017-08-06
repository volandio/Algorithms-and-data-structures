package com.A.training.B.sinitsynv.lesson08.balanced;

import com.A.training.B.sinitsynv.lesson07.Node;
import com.A.training.B.sinitsynv.lesson08.BinarySearchTree;

public class BalanceableTree<E> extends BinarySearchTree<E> {
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void displayTree(Node<E> node) {
        super.displayTree(node);
    }

    protected void rotateLeft(Node<E> k) {
        NodeImpl<E> p = validate(k);
        NodeImpl<E> r = validate(p).getRightChild();
        p.setRightChild(r.getLeftChild());
        if (r.getLeftChild() != null) {
            r.getLeftChild().setParent(p);
        }
        r.setParent(p.getParent());
        if (p.getParent() == null) {
            setRoot(r);
        } else if (p.getParent().getLeftChild() == p) {
            p.getParent().setLeftChild(r);
        } else {
            p.getParent().setRightChild(r);
        }
        r.setLeftChild(p);
        p.setParent(r);
    }

    protected void rotateRight(Node<E> k) {
        NodeImpl<E> p = validate(k);
        NodeImpl<E> l = validate(p).getLeftChild();
        p.setLeftChild(l.getRightChild());
        if (l.getRightChild() != null) {
            l.getRightChild().setParent(p);
        }
        l.setParent(p.getParent());
        if (p.getParent() == null) {
            setRoot(l);
        } else if (p.getParent().getRightChild() == p) {
            p.getParent().setRightChild(l);
        } else {
            p.getParent().setLeftChild(l);
        }
        l.setRightChild(p);
        p.setParent(l);
    }

    /**
     * Sets new relationship between parent and child. This method is used by
     * {@link #rotate(com.A.training.B.sinitsynv.lesson07.Node)} for node and its grandparent,
     * node and its parent, node's child and node's parent relinking.
     *
     * @param node          parent rotated node
     * @param makeLeftChild whether new child must be left or right
     */
    private void relink(NodeImpl<E> node, boolean makeLeftChild) {
        if (makeLeftChild) {
            rotateRight(node);
        } else {
            rotateLeft(node);
        }
    }

    /**
     * Rotates n with it's parent.
     *
     * @param n node to rotate above its parent
     */
    protected void rotate(Node<E> n) throws IllegalArgumentException {
        NodeImpl<E> node = validate(n);
        if (node.getParent() == null) {
            throw new IllegalArgumentException();
        }
        boolean isLeftChild = node.getParent().getLeftChild() == node;
        relink(node.getParent(), isLeftChild);
    }

    /**
     * Performs one rotation of <i>n</i>'s parent node or two rotations of <i>n</i> by the means of
     * {@link #rotate(Node)} to  the height
     * of subtree rooted at <i>n1</i>reduce
     * <p>
     * <pre>
     *     n1         n2           n1           n
     *    /          /  \         /            / \
     *   n2    ==>  n   n1  or  n2     ==>   n2   n1
     *  /                         \
     * n                           n
     * </pre>
     * <p>
     * Similarly for subtree with right side children.
     *
     * @param n grand child of subtree root node
     * @return new subtree root
     */
    protected Node<E> reduceSubtreeHeight(Node<E> n) throws IllegalArgumentException {
        NodeImpl<E> node = validate(n);
        NodeImpl<E> parentNode = node.getParent();
        NodeImpl<E> grandParentNode = parentNode.getParent();
        if (parentNode == grandParentNode.getLeftChild() && node == parentNode.getLeftChild() ||
            parentNode == grandParentNode.getRightChild() && node == parentNode.getRightChild()) {
            rotate(parentNode);
            return parentNode;
        } else if (parentNode == grandParentNode.getLeftChild() && node == parentNode.getRightChild() ||
            parentNode == grandParentNode.getRightChild() && node == parentNode.getLeftChild()) {
            rotate(node);
            rotate(node);
            return node;
        }
        return null;
    }
}
