package stack23ystudent;

// OPGAVE 1 med single-linked liste.
public class LinkedStack23Y<E> implements Stack23Y<E> {
    // top of stack is at head of list
    private Node<E> head = null;
    // the number of element in the stack
    int size = 0;

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        if (head == null) {
            head = new Node<>(entry);
        } else {
            Node<E> newNode = new Node<>(entry);
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {

        return null;
    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {

        return null;
    }

    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {

        return false;
    }

    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        // TODO
    }

    /**
     * Return the number of elements in the stack.
     */
    @Override
    public int size() {

        return 0;
    }

    //-------------------------------------------------------------------------

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
