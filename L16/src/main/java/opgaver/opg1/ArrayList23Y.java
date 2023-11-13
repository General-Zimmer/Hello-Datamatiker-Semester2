package opgaver.opg1;

import opgaver.List23Y;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** An array based implementation of the List ADT. */
public class ArrayList23Y<E> implements List23Y<E> {
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[4];
    private int size = 0;
    // data contains elements at index 0..size-1 and null else

    /**
     * Add the element to the end of this list.
     */
    @Override
    public void add(E e) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = e;
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    @Override
    public boolean remove(E e) {
        int index = 0;
        while (index < size) {
            if (data[index].equals(e)) {
                for (int i = index; i < size - 1; i++) {
                    data[index] = data[index + 1];
                }
                size--;
                data[size] = null;
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Return true, if this list contains the element.
     */
    @Override
    public boolean contains(E e) {
        for (E e2 : data){
            if (e2.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove all elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Return the size of this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return true, if this list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E get(int index) {
        return data[index];
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
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        for (int i = index; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
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
        E saved = data[index];

        E temp = data[size-1];
        for (int i = size-2; i > index-1; i--) {
            E temp2 = data[i];
            data[i] = temp;
            temp = temp2;
        }
        size--;
        data[size] = null;
        return saved;
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)) {
                return i;
            }
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
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return data[index++];

        }
    }

    //-------------------------------------------

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E e : data) {
            if (e != null)
                stringBuilder.append(e).append(" ");
        }
        return stringBuilder.toString();
    }
}
