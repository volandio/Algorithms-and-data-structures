package com.A.training.B.sinitsynv.lesson09.balanced;

import com.A.training.B.sinitsynv.lesson07.Node;
import com.A.training.B.sinitsynv.lesson08.balanced.BalanceableTree;

public class RedBlackTree<E> extends BalanceableTree<E> {
    @Override
    public Node<E> addLeft(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> added = super.addLeft(n, e);
        afterElementAdded(added);
        return added;
    }

    @Override
    public Node<E> addRight(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> added = super.addRight(n, e);
        afterElementAdded(added);
        return added;
    }

    private boolean isBlack(Node<E> n) {
        if (n == null) {
            return false;
        }
        return validate(n).getIsBlack();
    }

    private boolean isRed(Node<E> n) {
        if (n == null) {
            return false;
        }
        return !validate(n).getIsBlack();
    }

    private void makeBlack(Node<E> n) {
        validate(n).setIsBlack(true);
    }

    private void makeRed(Node<E> n) {
        validate(n).setIsBlack(false);
    }

    @Override
    public void setRoot(NodeImpl<E> root) throws IllegalStateException {
        super.setRoot(root);
        root.setIsBlack(true);
    }

    @Override
    public Node<E> addRoot(E e) throws IllegalStateException {
        super.addRoot(e);
        getRoot().setIsBlack(true);
        return getRoot();
    }

    @Override
    public Node<E> add(Node<E> n, E e) throws IllegalArgumentException {
        Node<E> added = super.add(n, e);
        afterElementAdded(added);
        return added;
    }

    @Override
    protected void afterElementAdded(Node<E> n) {
        NodeImpl<E> x = validate(n);
        x.setIsBlack(false);
        while (x != null && x != root() && isRed(x.getParent())) {
            if (x.getParent() == x.getParent().getParent().getLeftChild()) {
                NodeImpl<E> y = x.getParent().getParent().getRightChild();
                if (isRed(y)) {
                    makeBlack(x.getParent());
                    makeBlack(y);
                    makeRed(x.getParent().getParent());
                    x = x.getParent().getParent();
                } else {
                    if (x == x.getParent().getRightChild()) {
                        x = x.getParent();
                        rotateLeft(x);
                    }
                    makeBlack(x.getParent());
                    makeRed(x.getParent().getParent());
                    rotateRight(x.getParent().getParent());
                }
            } else {
                NodeImpl<E> y = x.getParent().getParent().getLeftChild();
                if (isRed(y)) {
                    makeBlack(x.getParent());
                    makeBlack(y);
                    makeRed(x.getParent().getParent());
                    x = x.getParent().getParent();
                } else {
                    if (x == x.getParent().getLeftChild()) {
                        x = x.getParent();
                        rotateRight(x);
                    }
                    makeBlack(x.getParent());
                    makeRed(x.getParent().getParent());
                    rotateLeft(x.getParent().getParent());
                }
            }
        }
        validate(root()).setIsBlack(true);
    }

    @Override
    public E remove(Node<E> n) throws IllegalArgumentException {
        E element = n.getElement();
        NodeImpl<E> p = validate(n);
        if (p.getLeftChild() != null && p.getRightChild() != null) {
            NodeImpl<E> s = successor(p);
            p.setElement(s.getElement());
            p = s;
        }
        NodeImpl<E> replacement = (p.getLeftChild() != null ? p.getLeftChild() : p.getRightChild());
        if (replacement != null) {
            replacement.setParent(p.getParent());
            if (p.getParent() == null) {
                setRoot(replacement);
            } else if (p == p.getParent().getLeftChild()) {
                p.getParent().setLeftChild(replacement);
            } else {
                p.getParent().setRightChild(replacement);
            }
            p.setLeftChild(null);
            p.setRightChild(null);
            p.setParent(null);
            if (isBlack(p)) {
                afterElementRemoved(replacement);
            }
        } else if (p.getParent() == null) {
            setRoot(null);
        } else {
            if (isBlack(p)) {
                afterElementRemoved(p);
            }
            if (p.getParent() != null) {
                if (p == p.getParent().getLeftChild()) {
                    p.getParent().setLeftChild(null);
                } else if (p == p.getParent().getRightChild()) {
                    p.getParent().setRightChild(null);
                }
                p.setParent(null);
            }
        }
        return element;
    }

    private NodeImpl<E> successor(NodeImpl<E> t) {
        if (t == null) {
            return null;
        } else if (t.getRightChild() != null) {
            NodeImpl<E> p = t.getRightChild();
            while (p.getLeftChild() != null) {
                p = p.getLeftChild();
            }
            return p;
        } else {
            NodeImpl<E> p = t.getParent();
            NodeImpl<E> ch = t;
            while (p != null && ch == p.getRightChild()) {
                ch = p;
                p = p.getParent();
            }
            return p;
        }
    }

    @Override
    protected void afterElementRemoved(Node<E> n) {
        NodeImpl<E> x = validate(n);
        while (x != root() && isBlack(x)) {
            if (x == x.getParent().getLeftChild()) {
                NodeImpl<E> sib = x.getParent().getRightChild();
                if (isRed(sib)) {
                    makeBlack(sib);
                    makeRed(x.getParent());
                    rotateLeft(x.getParent());
                    sib = x.getParent().getRightChild();
                }
                if (isBlack(sib.getLeftChild()) && isBlack(sib.getRightChild())) {
                    makeRed(sib);
                    x = x.getParent();
                } else {
                    if (isBlack(sib.getRightChild())) {
                        makeBlack(sib.getLeftChild());
                        makeRed(sib);
                        rotateRight(sib);
                        sib = x.getParent().getRightChild();
                    }
                    sib.setIsBlack(x.getParent().getIsBlack());
                    makeBlack(x.getParent());
                    makeBlack(sib.getRightChild());
                    rotateLeft(x.getParent());
                    x = validate(root());
                }
            } else {
                NodeImpl<E> sib = x.getParent().getLeftChild();
                if (isRed(sib)) {
                    makeBlack(sib);
                    makeRed(x.getParent());
                    rotateRight(x.getParent());
                    sib = x.getParent().getLeftChild();
                }
                if (isBlack(sib.getRightChild()) && isBlack(sib.getLeftChild())) {
                    makeRed(sib);
                    x = x.getParent();
                } else {
                    if (isBlack(sib.getLeftChild())) {
                        makeBlack(sib.getRightChild());
                        makeRed(sib);
                        rotateLeft(sib);
                        sib = x.getParent().getLeftChild();
                    }
                    sib.setIsBlack(x.getParent().getIsBlack());
                    makeBlack(x.getParent());
                    makeBlack(sib.getLeftChild());
                    rotateRight(x.getParent());
                    x = validate(root());
                }
            }
        }
        makeBlack(x);
    }
}
