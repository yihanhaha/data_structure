package ds.queues;

public class LinkedQueue<T> implements Queue<T> {
    public static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T element) {
        Node<T> node = new Node<T>(element, null);
        if (front == null)
            front = node;
        else
            rear.next=node;
        rear = node;
        size++;
    }

    public T dequeue() {
        if (front == null) throw new QueueEmptyException();
        Node<T> temp = front;
        front = front.next;
        temp.next=null;
        size--;
        return temp.element;
    }

    public T front() {
        if (front == null) throw new QueueEmptyException();
        return front.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
