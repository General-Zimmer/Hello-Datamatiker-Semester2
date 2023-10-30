package opgaver.opg2;

import opgaver.List23Y;

import java.util.Iterator;

/** A single-linked nodes based implementation of the List ADT. */
public class SingleLinkedList23Y<E> implements List23Y<E> {
    private Node<E> head = null;
    private int size = 0;

    /**
     * Add the element to the end of this list.
     */
    @Override
    public void add(E e) {
        if (head == null) {
            head = new Node<>(e);
            size++;
            return;
        }

        Node<E> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(e);
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    @Override
    public boolean remove(E e) {
        if (head == null){
            return false;
        }

        if (head.element.equals(e)){
            head = head.next;
            size--;
            return true;
        }

        Node<E> node = head;
        while (node.next != null && !node.next.element.equals(e)){
            node = node.next;
        }
        if (node.next != null){
            node.next = node.next.next;
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
        Node<E> node = head;
        while (node != null){
            if (node.element.equals(e)){
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
        head = null;
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
        return head == null;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        for (int i = 0; i < index; i++){
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            Node<E> node = new Node<>(e);
            node.next = head;
            head = node;
            size++;
            return;
        }

        Node<E> node = head;
        for (int i = 0; i < index - 1; i++){
            node = node.next;
        }
        Node<E> newNode = new Node<>(e);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            Node<E> node = head;
            head = head.next;
            size--;
            return node.element;
        }

        Node<E> node = head;
        for (int i = 0; i < index - 1; i++){
            node = node.next;
        }
        Node<E> removeNode = node.next;
        node.next = node.next.next;
        size--;
        return removeNode.element;
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    @Override
    public int indexOf(E e) {
        Node<E> node = head;
        for (int i = 0; i < size; i++){
            if (node.element.equals(e)){
                return i;
            }
            node = node.next;
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
        return new SingleLinkedListIterator();
    }

    //-------------------------------------------

    private class SingleLinkedListIterator implements Iterator<E> {
        private Node<E> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
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

        public Node(T t) {
            this.element = t;
            this.next = null;
        }
    }

    //-------------------------------------------

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = head;
        while (node != null){
            stringBuilder.append(node.element).append(" ");
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
