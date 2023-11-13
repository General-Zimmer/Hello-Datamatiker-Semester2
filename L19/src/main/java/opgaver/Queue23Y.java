package opgaver;

public interface Queue23Y<E> {
    /**
     * Add the element at the back of the queue.
     */
    public void add(E element);

    /**
     * Remove and return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    public E remove();

    /**
     * Return the element at the front of the queue.
     * Throw a NoSuchElementException(), if the queue is empty.
     */
    public E element();

    /**
     * Return true, if the queue is empty.
     */
    public boolean isEmpty();

    /**
     * Remove all elements from the queue.
     */
    public void clear();

    /**
     * Return the number of elements in the queue.
     */
    public int size();
}
