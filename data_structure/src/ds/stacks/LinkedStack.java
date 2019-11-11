package ds.stacks;

public class LinkedStack<T> implements Stack<T> {
    private class Node<T> {
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Push method
     * Creates a new node and pushes it onto the stack. After the completion of this method
     * the newly created node will be the top of the stack.
     *
     * @param object
     */
    @Override
    public void push(T object) {
        top = new Node<T>(object, top);
        size++;
    }

    /**
     * Pop method:
     * removes the top item from the stack, and update top to be the next item.
     * if the stack is empty, throw a runtime StackEmptyEception
     *
     * @return
     */
    @Override
    public T pop() {
        if (top == null) throw new StackEmptyException();

        Node<T> temp = top;
        top = top.next;
        temp.next = null;
        size--;
        return temp.element;
    }

    @Override
    public T peek() {
        if (top == null) throw new StackEmptyException();
        return top.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public String toString() {
        String output = "";
        Node<T> cur = top;
        while (cur != null) {
            output = " " + cur.element + output;
            cur = cur.next;
        }
        return size + " :" + output;
    }
}
