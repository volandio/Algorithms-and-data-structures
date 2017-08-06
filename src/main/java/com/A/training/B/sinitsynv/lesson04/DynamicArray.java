package com.A.training.B.sinitsynv.lesson04;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static java.lang.System.arraycopy;

public class DynamicArray<V> extends AbstractList<V> {
    private V[] elements;
    private int size;
    private int modCount;

    DynamicArray(int i) {
        elements = (V[]) new Object[i];
    }

    DynamicArray() {
        this(10);
    }

    private void increaseSizeArray() {
        if (elements.length == size) {
            V[] array2 = (V[]) new Object[size * 3 / 2];
            System.arraycopy(elements, 0, array2, 0, size);
            elements = array2;
        }
    }

    public void checkThrowArrayIndexOutOfBoundsException(int i) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
        }
    }

    @Override
    public boolean add(V e) {
        increaseSizeArray();
        elements[size++] = e;
        modCount++;
        return true;
    }

    @Override
    public void add(int i, V e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        increaseSizeArray();
        arraycopy(elements, i, elements, i + 1, size - i);
        elements[i] = e;
        modCount++;
        size++;
    }

    @Override
    public V set(int i, V e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        V prev = elements[i];
        elements[i] = e;
        return prev;
    }

    @Override
    public V get(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        return elements[i];
    }

    @Override
    public V remove(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        V removedElement = elements[i];
        arraycopy(elements, i + 1, elements, i, size - 1 - i);
        elements[--size] = null;
        modCount++;
        return removedElement;
    }

    @Override
    public boolean remove(Object e) {
        int removedElement = indexOf(e);
        if (removedElement == -1) {
            return false;
        }
        remove(removedElement);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public ListIteratorImpl listIterator() {
        return new ListIteratorImpl(0);
    }

    public class ListIteratorImpl implements ListIterator<V> {
        private int cursor;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        public ListIteratorImpl(int index) {
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public V next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (V) elements[lastRet = i];
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public V previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            cursor = i;
            return elements[lastRet = i];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            checkForComodification();
            DynamicArray.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
        }

        @Override
        public void set(V e) {
            checkForComodification();
            DynamicArray.this.set(lastRet, e);
        }

        @Override
        public void add(V e) {
            checkForComodification();
            int i = cursor;
            DynamicArray.this.add(i, e);
            cursor = i + 1;
            lastRet = -1;
            expectedModCount = modCount;
        }

        private void checkForComodification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}




