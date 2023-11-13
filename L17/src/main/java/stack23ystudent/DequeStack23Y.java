package stack23ystudent;

import java.util.Deque;
import java.util.LinkedList;

public class DequeStack23Y<E> implements Stack23Y<E> {
    // Implements a stack by adapting a deque (implemented with a LinkedList).
    // The top of the stack is at the beginning of the LinkedList.

    // deque contains the elements in the stack.
    private final Deque<E> deque = new LinkedList<>();

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        deque.addFirst(entry);
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {
        return deque.removeFirst();
    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {
        return deque.getFirst();
    }

    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /**
     * Remove all elements from this stack.
     */
    @Override
    public void clear() {
        deque.clear();
    }

    /**
     * Return the number of elements in this stack.
     */
    @Override
    public int size() {
        return deque.size();
    }
}
