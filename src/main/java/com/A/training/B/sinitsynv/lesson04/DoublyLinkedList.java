package com.A.training.B.sinitsynv.lesson04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<V> extends AbstractList<V> {
    private int size;
    private Element<V> first;
    private Element<V> last;

    public DoublyLinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(V val) {
        Element<V> l = last;
        Element<V> newElement = new Element<>(last, null, val);
        last = newElement;
        if (l == null) {
            first = newElement;
        } else {
            l.next = newElement;
        }
        size++;
        return true;
    }

    private Element<V> findElement(int i) {
        if (i >= size || size < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i < size / 2) {
            Element<V> currentElement = first;
            for (int j = 0; j < i; j++) {
                currentElement = currentElement.next;
            }
            return currentElement;
        } else {
            Element<V> currentElement = last;
            for (int j = size - 1; j > i; j--) {
                currentElement = currentElement.prev;
            }
            return currentElement;
        }
    }

    @Override
    public void add(int index, V element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        }
        Element<V> currentElement = findElement(index);
        Element<V> previousElement = currentElement.prev;
        Element<V> addedElement = new Element<>(previousElement, currentElement, element);
        currentElement.prev = addedElement;
        if (previousElement == null) {
            first = addedElement;
        } else {
            previousElement.next = addedElement;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        for (Element<V> removed = first; removed != null; removed = removed.next) {
            if (o == null && removed.val == null || o.equals(removed.val)) {
                Element<V> previousElement = removed.prev;
                Element<V> next = removed.next;
                previousElement.next = next;
                next.prev = previousElement;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element<V> currentElement = findElement(index);
        V element = currentElement.val;
        Element<V> previousElement = currentElement.prev;
        Element<V> nextElement = currentElement.next;
        if (previousElement == null) {
            first = nextElement;
        } else {
            previousElement.next = nextElement;
            currentElement.prev = null;
        }
        if (nextElement == null) {
            last = previousElement;
        } else {
            nextElement.prev = previousElement;
            currentElement.next = null;
        }
        currentElement.val = null;
        size--;
        return element;
    }


    @Override
    public V get(int index) {
        Element<V> currentElement = findElement(index);
        return currentElement.val;
    }

    @Override
    public ListIteratorImpl listIterator() {
        return new ListIteratorImpl(0);
    }

    private static class Element<V> {
        Element<V> prev;
        Element<V> next;
        V val;

        Element(Element<V> prev, Element<V> next, V val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    class ListIteratorImpl implements ListIterator<V> {
        private Element<V> lastReturnedElement = null;
        private Element<V> nextElement;
        private int nextIndex;


        ListIteratorImpl(int i) {
            nextElement = (i == size) ? null : findElement(i);
            nextIndex = i;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            V element = nextElement.val;
            lastReturnedElement = nextElement;
            nextElement = nextElement.next;
            nextIndex++;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public V previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            nextElement = nextElement.prev;
            nextIndex--;
            lastReturnedElement = nextElement;
            return nextElement.val;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturnedElement == null) {
                throw new IllegalStateException();
            }
            Element<V> removedElement = lastReturnedElement.prev;
            Element<V> currentElement = lastReturnedElement.next;
            removedElement.next = currentElement;
            currentElement.prev = removedElement;
            size--;
            if (nextElement == lastReturnedElement) {
                nextElement = currentElement;
            } else {
                nextIndex--;
            }
            lastReturnedElement = null;
        }

        @Override
        public void set(V v) {
            if (lastReturnedElement == null) {
                throw new IllegalStateException();
            }
            lastReturnedElement.val = v;
        }

        @Override
        public void add(V v) {
            lastReturnedElement = null;
            if (nextElement == null) {
                DoublyLinkedList.this.add(v);
            } else {
                Element<V> pred = nextElement.prev;
                Element<V> newElement = new Element<>(pred, nextElement, v);
                nextElement.prev = newElement;
                if (pred == null) {
                    first = newElement;
                } else {
                    pred.next = newElement;
                }
                size++;
            }
            nextIndex++;
        }
    }
}
