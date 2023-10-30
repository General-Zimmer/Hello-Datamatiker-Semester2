package opgaver.opg3;

import opgaver.List23Y;

import java.util.Iterator;

/** A double-linked nodes based implementation of the List ADT. */
public class DoubleLinkedList23Y<E> implements List23Y<E> {
    private final Node<E> header = new Node<>(null);
    private final Node<E> trailer = new Node<>(null);
    private int size = 0;

    public DoubleLinkedList23Y() {
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * Add the element to the end of this list.
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        // insert newNode between trailer.prev and trailer
        newNode.prev = trailer.prev;
        newNode.next = trailer;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    @Override
    public boolean remove(E e) {
        Node<E> node = header.next;
        while (node != trailer && !node.element.equals(e)) {
            node = node.next;
        }
        if (node != trailer) {
            // remove node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Return true, if this list contains the element.
     */
    @Override
    public boolean contains(E e) {
        Node<E> node = header.next;
        while (node != null) {
            if (node.element.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Remove all elements from this list.
     */
    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    /**
     * Return the size of this list.
     */
    public int size() {
        return size;
    }

    /**
     * Return true, if this list is empty.
     */
    @Override
    public boolean isEmpty() {
        return header.next == trailer;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = header.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<>(e);
        Node<E> node = header;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        // insert newNode after node
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
        size++;
    }

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = header.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        // remove node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.element;
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    @Override
    public int indexOf(E e) {
        Node<E> node = header.next;
        int index = 0;
        while (node != trailer && !node.element.equals(e)) {
            node = node.next;
            index++;
        }
        if (node != trailer) {
            return index;
        }
        return -1;
    }

    /**
     * Return an iterator over this list.
     * Note: While the list is traversed by this iterator,
     * adding or removing an element is not allowed.
     */
    @Override
    public Iterator<E> iterator() {
        return new doubleLinkedIterator();
    }

    //-------------------------------------------

    private class doubleLinkedIterator implements Iterator<E>{
        private Node<E> node = header.next;

        @Override
        public boolean hasNext() {
            return node != trailer;
        }

        @Override
        public E next() {
            E element = node.element;
            node = node.next;
            return element;
        }
    }

    private static class Node<T> {
        private final T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T t) {
            this.element = t;
            this.next = null;
            this.prev = null;
        }
    }

    //-------------------------------------------

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = header.next;
        while (node != trailer) {
            sb.append(node.element);
            if (node.next != trailer) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
