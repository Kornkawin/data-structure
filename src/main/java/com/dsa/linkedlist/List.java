package com.dsa.linkedlist;

import com.dsa.Collection;

public interface List extends Collection {
    public void add(int index, Object element);
    public void remove(int index);
    public Object get(int index);
    public void set(int index, Object element);
}
