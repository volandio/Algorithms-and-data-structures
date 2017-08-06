package com.A.training.B.sinitsynv.lesson05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

interface CollectionFilter<E> {
    boolean check(E e);
}

interface CollectionTransformList<E, T> {
    List<T> change(List<E> l);
}

interface CollectionTransformElement<E, T> {
    T change(E e);
}

interface CollectionLogic<E> {
    E doLogic(E e);
}

class UnmodifiableCollection<E> implements Collection<E> {
    private Collection<E> collection;

    UnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return collection.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return collection.iterator().hasNext();
            }

            @Override
            public E next() {
                return collection.iterator().next();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return collection.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return collection.toArray(a);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}

class CollectionUtils<E> {
    static <E> UnmodifiableCollection<E> unmodifiableCollection(Collection<E> e) {
        return new UnmodifiableCollection<>(e);
    }

    static <E> List<E> filter(List<E> list, CollectionFilter<E> filter) {
        List<E> filterList = new ArrayList<>();
        for (E e : list) {
            if (filter.check(e)) {
                filterList.add(e);
            }
        }
        return filterList;
    }

    static <E, T> List<T> transform(List<E> list, CollectionTransformElement<E, T> transformer) {
        List<T> transformList = new ArrayList<>();
        for (E e : list) {
            transformList.add(transformer.change(e));
        }
        return transformList;
    }

    static <E, T> List<T> transform(List<E> list, CollectionTransformList<E, T> transformer) {
        return transformer.change(list);
    }

    static <E> List<E> forAllDo(List<E> list, CollectionLogic<E> logic) {
        for (E e : list) {
            logic.doLogic(e);
        }
        return list;
    }
}

