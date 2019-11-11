package ds.trees;

import ds.common.Position;

public class Test2 {
    public static void main(String[] args) {
        ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<>();
        System.out.println(tree);
        tree.expandExternal(tree.root());
        tree.replace(tree.root(), "ron");
        System.out.println(tree);

    }
}
