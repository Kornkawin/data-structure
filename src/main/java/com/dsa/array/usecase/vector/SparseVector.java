package com.dsa.array.usecase.vector;

public class SparseVector {

    // size for non-zero elements
    private int size;
    // length for the vector
    private int length;
    // array for non-zero elements
    private Element[] elementData;

    private static class Element {
        private int index;
        private double value;

        public Element(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public SparseVector(int length) {
        this.elementData = new Element[0];
        this.size = 0;
        this.length = length;
    }

    public int length() {
        return length;
    }

    // Time: O(n), n=size
    public double get(int index) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].index == index) return elementData[i].value;
            else if(elementData[i].index > index) break;
        }
        return 0.0;
    }

    // Time: O(n) + O(n) = O(n), n=size
    public void set(int index, double value) {
        int i = 0;
        for(; i < size; i++)
            if(elementData[i].index >= index) break;

        // replace new element
        if(elementData[i].index == index) elementData[i].value = value;
        // insert or append new element
        else add(i, index, value);
    }

    // Time: O(n) + O(n) = O(n), n=size
    private void add(int i, int index, double value) {
        if(value != 0) {
            ensureCapacity(size+1);
            for(int k = size; k > i; k--) {
                // move left to right index
                elementData[k] = elementData[k-1];
            }
            elementData[i] = new Element(index, value);
            ++size;
        }
    }

    // Time: O(n), n=size
    private void ensureCapacity(int newSize) {
        int capacity = elementData.length;
        if (newSize > capacity) {
            System.out.println("old capacity = "+capacity);
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            elementData = java.util.Arrays.copyOf(elementData, capacity);
            System.out.println("new capacity = "+capacity);
        }
    }

//    // Time: O(nm) + O(nm) = O(nm), m=length,n=size
//    public double dot(SparseVector v2) {
//        SparseVector v1 = this;
//        double result = 0.0;
//        for(int i = 0; i < v1.length(); i++) {
//            result += v1.get(i) * v2.get(i);
//        }
//        return result;
//    }
//
//    // Time: O(nm) + O(nm) = O(nm), m=length,n=size
//    public SparseVector add(SparseVector v2) {
//        SparseVector v1 = this;
//        SparseVector v3 = new SparseVector(v1.length());
//        for (int i = 0; i < v1.length(); i++) {
//            v3.set(i, v1.get(i) + v2.get(i));
//        }
//        return v3;
//    }

    // Time: O(n)
    // Algorithm: 2 pointers
    public double dot(SparseVector v2) {
        SparseVector v1 = this;
        double result = 0;
        int i1 = 0, i2 = 0;
        while(i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1];
            Element e2 = v2.elementData[i2];
            if(e1.index < e2.index) ++i1;
            else if(e1.index > e2.index) ++i2;
            else {
                result += e1.value * e2.value;
                ++i1; ++i2;
            }
        }
        return result;
    }

    // Time: O(n*1) = O(n), n=size
    // Algorithm: 3 pointers
    public SparseVector add(SparseVector v2) {
        SparseVector v1 = this;
        SparseVector v3 = new SparseVector(v1.length());
        int i1 = 0, i2 = 0, i3 = 0;
        while(i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1];
            Element e2 = v2.elementData[i2];
            if(e1.index < e2.index) {
                // append: O(1)
                v3.add(i3++, e1.index, e1.value);
                ++i1;
            }
            else if(e1.index > e2.index) {
                v3.add(i3++, e2.index, e2.value);
                ++i2;
            }
            else {
                v3.add(i3++, e1.index, e1.value + e2.value);
                ++i1; ++i2;
            }
        }
        while(i1 < v1.size) {
            Element e1 = v1.elementData[i1++];
            v3.add(i3++, e1.index, e1.value);
        }
        while(i2 < v2.size) {
            Element e2 = v2.elementData[i2++];
            v3.add(i3++, e2.index, e2.value);
        }
        return v3;
    }
}
