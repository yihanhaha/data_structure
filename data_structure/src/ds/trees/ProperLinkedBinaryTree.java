package ds.trees;

import ds.common.Position;

public class ProperLinkedBinaryTree<T> extends AbstractLinkedBinaryTree<T> {
    public ProperLinkedBinaryTree() {
        root = new Node(null, null, null, null);
        size = 1;
    }

    public void expandExternal(Position<T> p) {
        if (!isExternal(p)) throw new InvalidPositionException("Attempt to expand Internal node");
        Node<T> node = toNode(p);
        node.left = new Node(null, node, null, null);
        node.right = new Node(null, node, null, null);
        size += 2;
    }

    public void collapseInternal(Position<T> p) {
        if (isExternal(p)) throw new InvalidPositionException("Attempt to collapse external node");
        Node<T> node = toNode(p);

        if (isInternal(node.left))
            throw new InvalidPositionException("Attempt to collapse internal node with internal left child");

        if (isInternal(node.right))
            throw new InvalidPositionException("Attempt to collapse internal node with internal right child");

        node.left.parent = null;
        node.left = null;
        node.right.parent = null;
        node.right = null;
        size -= 2;
    }
}
