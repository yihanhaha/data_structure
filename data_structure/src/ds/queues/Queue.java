package ds.queues;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    T front();
    int size();
    boolean isEmpty();
}
