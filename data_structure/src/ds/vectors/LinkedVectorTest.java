package ds.vectors;

public class LinkedVectorTest {
    public static void main(String[] args) {
        testEmptyVector();
        testAltEmptyVector();
        testOneElementVector();
        testOneElementSizeVector();

        testOneElementRetrieveVector();
        testOneElementReplaceVector();
        testOneElementRemoveVector();
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testEmptyVector() {
        Vector<String> vector = new LinkedVector<String>();

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
        Vector<String> vector = new LinkedVector<String>();

        try {
            if (vector.size()!=0) {
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
    public static void testOneElementVector() {
        Vector<String> vector = new LinkedVector<String>();

        try {
            vector.insertAtRank(0, "A");
        } catch (RuntimeException e) {
            System.out.println("testOneElementVector(): FAILURE");
            System.out.println("insertAtRank(...) threw an exeception");
            e.printStackTrace();
            return;
        }
        System.out.println("testAltEmptyVector(): SUCCESS");
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementSizeVector() {
        Vector<String> vector = new LinkedVector<String>();

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

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementRetrieveVector() {
        Vector<String> vector = new LinkedVector<String>();

        try {
            vector.insertAtRank(0, "A");

            if (!vector.elemAtRank(0).equals("A")) {
                System.out.println("testOneElementRetrieveVector(): FAILURE");
                System.out.println("Expected vector.elemAtRank(0) to return A");
            } else {
                System.out.println("testOneElementRetrieveVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testOneElementRetrieveVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementReplaceVector() {
        Vector<String> vector = new LinkedVector<String>();

        try {
            vector.insertAtRank(0, "A");

            if (!vector.replaceAtRank(0, "B").equals("A")) {
                System.out.println("testOneElementReplaceVector(): FAILURE");
                System.out.println("Expected vector.replaceAtRank(0,B) to return A");
            } else {
                System.out.println("testOneElementReplaceVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testOneElementReplaceVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }

    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testOneElementRemoveVector() {
        Vector<String> vector = new LinkedVector<String>();

        try {
            vector.insertAtRank(0, "A");

            if (!vector.removeAtRank(0).equals("A")) {
                System.out.println("testOneElementRemoveVector(): FAILURE");
                System.out.println("Expected vector.removeAtRank(0,B) to return A");
            } else {
                System.out.println("testOneElementRemoveVector(): SUCCESS");
            }
        } catch (RuntimeException e) {
            System.out.println("testOneElementRemoveVector(): MAJOR FAILURE");
            e.printStackTrace();
        }
    }
}
