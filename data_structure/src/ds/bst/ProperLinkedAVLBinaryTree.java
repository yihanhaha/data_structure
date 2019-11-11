package ds.bst;

import ds.common.Position;

public class ProperLinkedAVLBinaryTree<T> extends ProperLinkedBSTBinaryTree<T> {
    public Position<T> singleLeft(Position<T> _a, Position<T> _b, Position<T> _c) {
        Node<T> b = toNode(_b);
        Node<T> c = toNode(_c);
        Node<T> b_right = b.right;
        updateParent(c, b);
        b.right = c;
        c.parent = b;
        c.left = b_right;
        b_right.parent = c;
        return b;
    }

    public Position<T> singleRight(Position<T> _a, Position<T> _b, Position<T> _c) {
        Node<T> a = toNode(_a);
        Node<T> b = toNode(_b);
        Node<T> b_left = b.left;
        updateParent(a, b);
        b.left = a;
        a.parent = b;
        a.right = b_left;
        b_left.parent = a;
        return b;
    }

    public Position<T> doubleLeftRight(Position<T> a, Position<T> b, Position<T> c) {
        return doubleRotation(toNode(a), toNode(b), toNode(c), toNode(a));
    }

    public Position<T> doubleRightLeft(Position<T> a, Position<T> b, Position<T> c) {
        return doubleRotation(toNode(a), toNode(b), toNode(c), toNode(c));
    }

    private Position<T> doubleRotation(Node<T> a, Node<T> b, Node<T> c, Node<T> root) {
        Node<T> b_left = b.left;
        Node<T> b_right = b.right;

        updateParent(root, b);

        b.left = a;
        a.parent = b;
        a.right = b_left;
        b_left.parent = a;
        b.right = c;
        c.parent = b;
        c.left = b_right;
        b_right.parent = c;
        return b;
    }

    private void updateParent(Node<T> c, Node<T> b) {
        if (!isRoot(c)) {
            Node<T> parent = toNode(parent(c));
            b.parent = parent;
            if (left(parent) == c) parent.left = b;
            else parent.right = b;
        } else {
            b.parent = null;
            root = b;
        }
    }
}
