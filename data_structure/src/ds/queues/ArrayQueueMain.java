package ds.queues;

public class ArrayQueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<String>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
