package ds.queues;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int rear;
    private int front;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
    }

    @Override
    public void enqueue(T element) {
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    @Override
    public T dequeue() {
        T e = array[front];
        array[front] = null;
        front = (front+1) % array.length;
        return e;
    }

    @Override
    public T front() {
        return array[front];
    }

    @Override
    public int size() {
        return (array.length + rear - front) % array.length;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }
}
