package ds.vectors;

public class ArrayVectorTest {
    public static void main(String[] args) {
        testEmptyVector();
        testAltEmptyVector();
        testOneElementVector();
        testOneElementSizeVector();
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testEmptyVector() {
        Vector<String> vector = new ArrayVector<String>();

        try {
            if (!vector.isEmpty()) {
                System.out.println("testEmptyVector): FAILURE");
                System.out.println("Expected vector to be empty");
            } else {
                System.out.println("testEmptyVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testEmptyVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testAltEmptyVector() {
        Vector<String> vector = new ArrayVector<String>();

        try {
            if (vector.size()!=0) {
                System.out.println("testAltEmptyVector(): FAILURE");
                System.out.println("Expected vector to be empty");
            } else {
                System.out.println("testAltEmptyVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testAltEmptyVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementVector() {
        Vector<String> vector = new ArrayVector<String>();

        try {
            vector.insertAtRank(0, "A");
        } catch (RuntimeException e) {
            System.out.println("testOneElementVector(): FAILURE");
            System.out.println("insertAtRank(...) threw an exeception");
            e.printStackTrace();
            return;
        }

        try {
            if (vector.size()!=1) {
                System.out.println("testAltEmptyVector): FAILURE");
                System.out.println("Expected vector to be empty");
            } else {
                System.out.println("testAltEmptyVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testAltEmptyVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementSizeVector() {
        Vector<String> vector = new ArrayVector<String>();

        try {
            vector.insertAtRank(0, "A");

            if (vector.size()!=1) {
                System.out.println("testOneElementSizeVector(): FAILURE");
                System.out.println("Expected vector.size() to be 1");
            } else {
                System.out.println("testOneElementSizeVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testOneElementSizeVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }
}
