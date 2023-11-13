package opgaver;

public interface SortedList23Y<E> {
/**
* Add the element to the list.
* The list is still sorted after the element is added.
*/
public void add(E element);
/**
* Remove the first element in the list.
* The list is still sorted after the element is removed.
* Return true, if the element was removed.
*/
public boolean removeFirst();
/**
* Remove the last element in the list.
* The list is still sorted after the element is removed.
* Return true, if the element was removed.
*/
public boolean removeLast();
/**
* Remove the first instance of the element from the list.
* The list is still sorted after the element is removed.
* Return true, if the element was removed.
*/
public boolean remove(E element);
/**
* Return the number of elements in the list.
*/
public int size();
}