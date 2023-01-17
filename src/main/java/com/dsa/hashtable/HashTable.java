package com.dsa.hashtable;

import com.dsa.Set;

public class HashTable implements Set {
    private Object[] table;
    private int size;

    public HashTable(int m) {
        table = new Object[m];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(Object element) {
        if(table[hash(element)] != null && table[hash(element)].equals(element)) {
            table[hash(element)] = null;
            size--;
        }
    }

    @Override
    public boolean contains(Object element) {
        return table[hash(element)] != null && table[hash(element)].equals(element);
    }

    @Override
    public void add(Object element) {
        if(table[hash(element)] == null) {
            table[hash(element)] = element;
            size++;
        }
    }

    private int hash(Object x) {
        // depend on algorithm designs
        return x.hashCode() % table.length;
    }

    private int hash(int x) {
        // another hash function example
        x = ~x + (x << 15);
        x = x ^ (x >>> 11);
        x = x + (x << 3);
        x = x ^ (x >>> 5);
        x = x + (x << 10);
        x = x ^ (x >>> 16);
        return x;
    }
}
