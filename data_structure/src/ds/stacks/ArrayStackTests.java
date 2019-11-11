package ds.stacks;

public class ArrayStackTests {
    public static void main(String[] args) {
        testEmptyStack();
        testPushStack();
        testPopStack();
        testPopEmptyStack();
        testTopEmptyStack();
        testPushFullStack();
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testEmptyStack() {
        Stack<String> stack = new ArrayStack<String>();

        try {
            if (!stack.isEmpty()) {
                System.out.println("testEmptyStack(): FAILURE");
                System.out.println("Expected stack to be empty");
            } else {
                System.out.println("testEmptyStack(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testEmptyStack(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testPushStack() {
        Stack<String> stack = new ArrayStack<String>();
        stack.push("A");

        try {
            if (!stack.peek().equals("A")) {
                System.out.println("testPushStack(): FAILURE");
                System.out.println("Expected A to be on top of the stack");
            } else {
                System.out.println("testPushStack(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testPushStack(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the pop() method on a non-empty stack removes the top item from the stack
     */
    public static void testPopStack() {
        Stack<String> stack = new ArrayStack<String>();

        try {
            String element = "A";
            stack.push(element);
            if (element.equals(stack.pop())) {
                System.out.println("testPopStack(): SUCCESS");
            } else {
                System.out.println("testPopStack(): FAILURE");
                System.out.println("Expected A to be popped from the stack");
            }
        } catch (RuntimeException e) {
            System.out.println("testPopStack(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the pop() method on an empty stack causes an exception
     */
    public static void testPopEmptyStack() {
        Stack<String> stack = new ArrayStack<String>();
        try {
            stack.pop();
            System.out.println("testPopEmptyStack(): FAILURE");
            System.out.println("Expected Exception was not thrown when stack.pop() is called on an empty stack");
        } catch (StackEmptyException e) {
            System.out.println("testPopEmptyStack(): SUCCESS");
        }
    }

    /**
     * tests that calling the top() method on an empty stack causes an exception
     */
    public static void testTopEmptyStack() {
        Stack<String> stack = new ArrayStack<String>();
        try {
            stack.peek();
            System.out.println("testTopEmptyStack(): FAILURE");
            System.out.println("Expected Exception was not thrown when stack.top() is called on an empty stack");
        } catch (StackEmptyException e) {
            System.out.println("testTopEmptyStack(): SUCCESS");
        }
    }

    /**
     * tests that calling the top() method on an empty stack causes an exception
     */
    public static void testPushFullStack() {
        Stack<String> stack = new ArrayStack<String>(2);
        stack.push("A");
        stack.push("B");
        try {
            stack.push("C");
            System.out.println("testPushFullStack(): FAILURE");
            System.out.println("Expected Exception was not thrown when stack.push() is called on a full stack");
        } catch (StackFullException e) {
            System.out.println("testPushFullStack(): SUCCESS");
        }
    }

}
