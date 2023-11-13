package opgaver.opg1;

import opgaver.SortedList23Y;

public class SortedList<E extends Comparable<E>> implements SortedList23Y<E> {
    private Node header = null;


    @Override
    public void add(E element) {
        Node newNode = new Node(element);

        if (header == null)
            header = newNode;
        else {
            Node current = header;

            if (header.element.compareTo(element) > 0) {
                newNode.next = header;
                header = newNode;
                return;
            }
            while (current.next != null) {
                if (current.next.element.compareTo(element) > 0) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
                current = current.next;
            }

            current.next = newNode;
        }
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return size(header);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = header;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unused")
    private class Node {
        public Node(E element) {
            this.element = element;
        }

        public E element;
        public Node next = null;
    }
}
