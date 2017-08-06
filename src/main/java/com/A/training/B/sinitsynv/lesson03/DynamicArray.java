package com.A.training.B.sinitsynv.lesson03;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import static java.lang.System.arraycopy;

public class DynamicArray {
    private Object[] elements;
    private int size;
    private int modCount;

    DynamicArray(int i) {
        elements = new Object[i];
        size = 0;
    }

    DynamicArray() {
        this(10);
    }

    private void increaseSizeArray() {
        if (elements.length == size) {
            Object[] array2 = new Object[size * 3 / 2];
            System.arraycopy(elements, 0, array2, 0, size);
            elements = array2;
        }
    }

    public void checkThrowArrayIndexOutOfBoundsException(int i) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
        }
    }

    public boolean add(Object e) {
        int halfMaxIntValue = (int) (Integer.MAX_VALUE / 1.5);
        if (elements.length >= halfMaxIntValue) {
            return false;
        }
        increaseSizeArray();
        elements[size++] = e;
        modCount++;
        return true;
    }

    public void add(int i, Object e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        increaseSizeArray();
        arraycopy(elements, i, elements, i + 1, size - i);
        elements[i] = e;
        modCount++;
        size++;
    }

    public Object set(int i, Object e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        Object prev = elements[i];
        elements[i] = e;
        return prev;
    }

    public Object get(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        return elements[i];
    }

    public Object remove(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        Object removedElement = elements[i];
        arraycopy(elements, i + 1, elements, i, size - 1 - i);
        elements[--size] = null;
        modCount++;
        return removedElement;
    }

    public boolean remove(Object e) {
        int removedElement = indexOf(e);
        if (removedElement == -1) {
            return false;
        }
        remove(removedElement);
        return true;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return elements;
    }

    public ListIterator listIterator() {
        return new ListIterator(0);
    }

    public class ListIterator {
        private int cursor;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        public ListIterator(int index) {
            cursor = index;
        }

        public boolean hasNext() {
            return cursor != size;
        }

        public Object next() {
            checkForComodification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return elements[lastRet = i];
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public Object previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            cursor = i;
            return elements[lastRet = i];
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void remove() {
            checkForComodification();
            DynamicArray.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
        }

        public void set(Object e) {
            checkForComodification();
            DynamicArray.this.set(lastRet, e);
        }

        public void add(Object e) {
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




