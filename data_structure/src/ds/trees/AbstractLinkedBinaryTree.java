package ds.trees;

import ds.common.Position;
import ds.stacks.ArrayStack;
import ds.stacks.Stack;
import ds.vectors.ArrayVector;
import ds.vectors.Vector;

import java.util.Iterator;

public abstract class AbstractLinkedBinaryTree<T> implements BinaryTree<T> {
    protected static class Node<T> implements Position<T> {
        public T element;
        public Node<T> parent;
        public Node<T> left;
        public Node<T> right;

        public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public T element() {
            return element;
        }
    }

    protected Node<T> root;
    protected int size;

    /**
     * The constructor is declared protected so that it cannot be called from outside
     * the class (it can only be called in this class or in sub-classes of this class.
     *
     * This is an extra mechanism that ensures that we do not create instances of this
     * class, but only create instances of its subclasses.
     */
    protected AbstractLinkedBinaryTree() {
        root = null;
        size = 0;
    }

    protected Node<T> toNode(Position<T> p) {
        return (Node<T>) p;
    }

    @Override
    public Position<T> left(Position<T> p) {
        Node<T> node = toNode(p);
        if (node.left == null) throw new InvalidPositionException("There is no left child");
        return node.left;
    }

    @Override
    public Position<T> right(Position<T> p) {
        Node<T> node = toNode(p);
        if (node.right == null) throw new InvalidPositionException("There is no right child");
        return node.right;
    }

    @Override
    public boolean hasLeft(Position<T> p) {
        return toNode(p).left != null;
    }

    @Override
    public boolean hasRight(Position<T> p) {
        return toNode(p).right != null;
    }

    @Override
    public Position<T> root() {
        if (root == null) throw new InvalidPositionException("There is no root node");
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) {
        Node<T> node = toNode(p);
        if (node.parent == null) throw new InvalidPositionException("There is no parent");
        return node.parent;
    }

    @Override
    public Iterator<Position<T>> children(Position<T> p) {
        Node<T> node = toNode(p);
        Vector<Position<T>> vector = new ArrayVector<Position<T>>();
        if (node.left != null) vector.insertAtRank(0, node.left);
        if (node.right != null) vector.insertAtRank(0, node.right);
        return vector.iterator();
    }

    @Override
    public boolean isInternal(Position<T> p) {
        Node<T> node = toNode(p);
        return node.left != null || node.right != null;
    }

    @Override
    public boolean isExternal(Position<T> p) {
        Node<T> node = toNode(p);
        return node.left == null && node.right == null;
    }

    @Override
    public boolean isRoot(Position<T> p) {
        return p == root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T replace(Position<T> p, T t) {
        Node<T> node = toNode(p);
        T temp = node.element;
        node.element = t;
        return temp;
    }

    /**
     * Implements an in-order traversal of the tree using a stack to control the recursive
     * steps.
     *
     * GO-LEFT
     * PROCESS NODE
     * GO-RIGHT
     */
    @Override
    public Iterator<Position<T>> positions() {
        return new Iterator<Position<T>>() {
            Stack<Node<T>> stack;
            Node<T> current = root;

            // The code below is an initialisation block. It is something
            // like a constructor, but not the same. Initialisation blocks
            // cannot be parameterised, and are called no matter which
            // constructor you use. They are called BEFORE the constructor
            // is invoked.
            //
            // This means that they should be used to implement common pieces
            // of initialisation code.
            {
                // NOTE: I should use a LinkedStack here, but I am
                // using an array stack because the LinkedStack is
                // part of a practical, so releasing it would make
                // it impossible for me to allow late submissions
                // for practical 1.
                stack = new ArrayStack<Node<T>>(10000);

                // Start by traversing to the left most
                // node in the tree.
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Position<T> next() {
                Node<T> node = stack.pop();

                // Now find the next node:
                // - go right (if a right child exists), then
                // - keep going left until you cannot go further
                if (node.right != null) {
                    current = node.right;
                    while (current != null) {
                        stack.push(current);
                        current = current.left;
                    }
                }
                return node;
            }
        };
    }

    /**
     * The value iterator simply reuses the position iterator
     * but returns the element at the position instead of the
     * position...
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<Position<T>> iterator = positions();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next().element();
            }
        };
    }

    private void append(StringBuffer buf, Node<T> node, String tabs) {
        buf.append(tabs);
        buf.append(node.element);
        buf.append("\n");
        if (node.left != null) append(buf, node.left, tabs+"\t");
        if (node.right != null) append(buf, node.right, tabs+"\t");
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        if (root == null) buf.append("TREE IS EMPTY");
        else append(buf, root, "");
        return buf.toString();
    }
}
