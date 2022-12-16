package com.dsa.linkedlist;

/**
 * Implementation Without Header Node
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    private int size=0;
    // point to the first node
    private Node<T> head = null;
    // point to the last node
    private Node<T> tail = null;


    // Inner Static Class for DoublyLinkedList
    // To make sure that Node class must be used only in DoublyLinkedList class
    // NOT for instance of DoublyLinkedList class and NOT for other classes
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Time: O(n)
    public void clear() {
        Node<T> trav = head;
        // clear memory
        while (trav != null) {
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            // move
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Time: O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // Time: O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            // first node
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Time: O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            // first node
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // index start at index 0
    public void addAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size) {
            addLast(data);
            return;
        }
        Node<T> temp = head;
        // Move to prev of new node
        // at i=0, idx=1
        // at i=1; idx=2
        // at i=index-2, idx=index-1
        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list -> cannot peek first node");
        return head.data;
    }

    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty list -> cannot peek last node");
        return tail.data;
    }

    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list -> cannot remove first node");

        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty list -> cannot remove last node");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    // Remove an arbitrary node from the linked list
    // Time: O(1)
    public T remove(Node<T> node) {
        // the node at first or last position
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        // make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // extract data
        T data = node.data;

        // Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    // Time: O(n)
    public T removeAt(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> trav;
        // remove from the front
        if(index < size/2) {
            for(i=0, trav=head; i != index; i++) {
                trav = trav.next;
            }
            // remove from the back
        } else {
            for(i=0, trav=tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    // Time: O(n)
    public boolean remove(Object obj) {
        Node<T> trav;

        // Support searching for null
        if(obj == null) {
            for(trav = head; trav != null; trav = trav.next) {
                if(trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // For non-null object
        } else {
            for(trav = head; trav != null; trav = trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Time: O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        if(obj == null) {
            for(trav = head; trav != null; trav = trav.next, index++) {
                if(trav.data == null) {
                    return index;
                }
            }
        } else {
            for(trav = head; trav != null; trav = trav.next, index++) {
                if(obj.equals(trav.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if(trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
