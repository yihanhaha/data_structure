package ds.vectors;

import ds.common.Position;

import java.util.Iterator;

public class LinkedVector<T> implements Vector<T> {
    private static class Node<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedVector() {
        first = null;
        last = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> atRank(int rank) {
        int i=0;
        Node<T> current = first;
        while (i<rank) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T elemAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        return atRank(rank).element;
    }

    @Override
    public T replaceAtRank(int rank, T element) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        Node<T> node = atRank(rank);
        T temp = node.element;
        node.element = element;
        return temp;
    }

    @Override
    public void insertAtRank(int rank, T element) {
        if (rank < 0 || rank > size) throw new RankOutOfBoundsException();
        if (first == null) {
            // Special case - insert into empty linked list
            first = last = new Node<T>(element, null, null);
        } else {
            // Not empty list
            Node<T> current = atRank(rank);
            Node<T> node = new Node<T>(element, current.prev, current);
            if (current == first) {
                first = node;
            } else {
                current.prev.next = node;
            }
            current.prev = node;
        }
        size++;
    }

    @Override
    public T removeAtRank(int rank) {
        if (rank < 0 || rank > size-1) throw new RankOutOfBoundsException();
        Node<T> node = atRank(rank);

        if (node == first) {
            first = first.next;
        } else {
            node.prev.next = node.next;
        }
        if (node == last) {
            last = last.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;

        // remove references to other nodes.
        node.next = null;
        node.prev = null;
        return node.element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current;

            @Override
            public boolean hasNext() {
                if (isEmpty()) return false;
                if (current == null) return true;
                return !current.equals(last);
            }

            @Override
            public T next() {
                if (current == null) {
                    current = first;
                } else {
                    current = current.next;
                }
                return current.element;

            }
        };
    }
}
