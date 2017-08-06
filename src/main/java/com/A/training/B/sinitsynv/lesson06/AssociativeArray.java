package com.A.training.B.sinitsynv.lesson06;

import java.util.Objects;

import static java.lang.Math.abs;

public class AssociativeArray<K, V> {
    private final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private final int MAXIMUM_CAPACITY = 1 << 30;
    private final float LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * LOAD_FACTOR);

    private int indexFor(int hash, int length) {
        return abs(hash) % length;
    }

    private void resize(int newCapacity) {
        if (table.length == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * LOAD_FACTOR);
    }

    private void transfer(Entry<K, V>[] newTable) {
        int newCapacity = newTable.length;
        for (Entry<K, V> e : table) {
            while (e != null) {
                Entry<K, V> next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    V add(K key, V val) {
        if (key == null) {
            return putForNullKey(val);
        }
        int hash = key.hashCode();
        int i = indexFor(hash, table.length);
        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || key.equals(entry.key))) {
                return entry.setValue(val);
            }
        }
        addEntry(hash, key, val, i);
        return null;
    }

    private V putForNullKey(V val) {
        for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                return entry.setValue(val);
            }
        }
        addEntry(0, null, val, 0);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        if (size == threshold) {
            resize(2 * table.length);
            index = indexFor(hash, table.length);
        }
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(hash, key, value, e);
        size++;
    }

    V get(K key) {
        if (size == 0) {
            return null;
        }
        if (key == null) {
            for (Entry<K, V> entry = table[0]; entry != null; entry = entry.next) {
                if (entry.key == null) {
                    return entry.value;
                }
            }
        }
        int hash = key != null ? key.hashCode() : 0;
        int i = indexFor(hash, table.length);
        for (Entry<K, V> entry = table[i]; entry != null; entry = entry.next) {
            if (entry.hash == hash && (entry.key == key || Objects.equals(key, entry.key))) {
                return entry.value;
            }
        }
        return null;
    }

    V remove(K key) {
        int hash = key != null ? key.hashCode() : 0;
        int i = indexFor(hash, table.length);
        Entry<K, V> prevEntry = table[i];
        for (Entry<K, V> entry = prevEntry; entry != null; entry = entry.next) {
            if (entry.hash == hash) {
                K k = entry.key;
                if (entry.key == key || key != null && key.equals(k)) {
                    size--;
                    if (entry == prevEntry) {
                        table[i] = entry.next;
                    } else {
                        prevEntry.next = entry.next;
                    }
                    return entry.value;
                }
            }
            prevEntry = entry;
        }
        return null;
    }

    private class Entry<E, T> {
        private final int hash;
        private final E key;
        private Entry<E, T> next;
        private T value;

        Entry(int hash, E key, T value, Entry<E, T> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String toString() {
            return key + "=" + value;
        }

        private T setValue(T newValue) {
            T oldValue = value;
            value = newValue;
            return oldValue;
        }
    }
}

