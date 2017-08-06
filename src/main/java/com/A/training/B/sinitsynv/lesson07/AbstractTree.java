package com.A.training.B.sinitsynv.lesson07;

import java.util.Collection;
import java.util.Iterator;

/**
 * An abstract base class providing some functionality of the Tree interface
 *
 * @param <E> element
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Node<E> n) throws IllegalArgumentException {
        return childrenNumber(n) > 0;
    }

    @Override
    public boolean isExternal(Node<E> n) throws IllegalArgumentException {
        return childrenNumber(n) == 0;
    }

    @Override
    public boolean isRoot(Node<E> n) throws IllegalArgumentException {
        return root() == n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return an iterable collection of nodes of the tree in preorder
     */
    public Collection<Node<E>> preOrder() {
        return null;
    }

    /**
     * @return an iterable collection of nodes of the tree in postorder
     */
    public Collection<Node<E>> postOrder() {
        return null;
    }

    /**
     * @return an iterable collection of nodes of the tree in breadth-first order
     */
    public Collection<Node<E>> breadthFirst() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Adapts the iteration produced by {@link Tree#nodes()}
     */
    private class ElementIterator implements Iterator<E> {
        private Iterator<Node<E>> it = nodes().iterator();

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public E next() {
            return it.next().getElement();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
