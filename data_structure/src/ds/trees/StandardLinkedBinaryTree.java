package ds.trees;

import ds.common.Position;

public class StandardLinkedBinaryTree<T> extends AbstractLinkedBinaryTree<T> {
    public Position<T> addRoot(T element) {
        if (root != null) throw new InvalidPositionException("A root node already exists for this tree");
        return this.root = new Node<T>(element, null, null, null);
    }

    public Position<T> insertLeft(Position<T> p, T element) {
        Node<T> node = toNode(p);
        if (node.left != null) throw new InvalidPositionException("A left node already exists");
        node.left = new Node<T>(element, node, null, null);
        size++;
        return node.left;
    }

    public Position<T> insertRight(Position<T> p, T element) {
        Node<T> node = toNode(p);
        if (node.right != null) throw new InvalidPositionException("A right node already exists");
        node.right = new Node<T>(element, node, null, null);
        size++;
        return node.right;
    }

    /**
     * For this implementation, the remove method will initially only allow you to remove
     * external nodes.
     *
     * @param p
     * @return
     */
    public T remove(Position<T> p) {
        if (isInternal(p)) throw new InvalidPositionException("You can only remove external nodes!");

        Node<T> node = toNode(p);
        // Need to work out:
        // - is it the root node (special case)
        // - is it a left child of the parent?
        // - is it a right child of the parent?
        if (isRoot(p)) {
            root = null;
        } else if (node.parent.left == node) {
            node.parent.left = null;
            node.parent = null;
        } else { // node.parent.right == node
            node.parent.right = null;
            node.parent = null;
        }
        size--;
        return node.element;
    }
}
