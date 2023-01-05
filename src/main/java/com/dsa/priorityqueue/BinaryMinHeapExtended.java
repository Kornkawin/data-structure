package com.dsa.priorityqueue;

public class BinaryMinHeapExtended extends BinaryHeap {

    public BinaryMinHeapExtended(int cap) {
        super(cap);
    }

    @Override
    protected void fixUp(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            Comparable<Object> child = (Comparable) getElement(childIndex);
            Comparable<Object> parent = (Comparable) getElement(parentIndex);
            if ( !(child.compareTo(parent) < 0) )
                // child meet min-heap condition:
                // child >= parent
                break;
            // swap value then move childIndex
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
        }
    }

    @Override
    protected void fixDown(int parentIndex) {
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < size()) {
            // find the min child
            if (childIndex + 1 < size()) {
                Comparable<Object> leftChild = (Comparable) getElement(childIndex);
                Comparable<Object> rightChild = (Comparable) getElement(childIndex + 1);
                if (rightChild.compareTo(leftChild) < 0) childIndex++;
            }
            // compare min child with parent
            Comparable<Object> parent = (Comparable) getElement(parentIndex);
            Comparable<Object> child = (Comparable) getElement(childIndex);
            if ( !(child.compareTo(parent) < 0) )
                // child meet min-heap condition:
                // child >= parent
                break;
            // swap value then move parent and child index
            swap(childIndex, parentIndex);
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
    }
}
