package trees.binary_tree;

public class Main {
    public static void main(String[] args) {
// Create the binary tree from the sample.
        BinaryTree<Integer> binaryTree =
                new BinaryTree<Integer>(14,
                        new BinaryTree<Integer>(19,
                                new BinaryTree<Integer>(23),
                                new BinaryTree<Integer>(6,
                                        new BinaryTree<Integer>(10),
                                        new BinaryTree<Integer>(21))),
                        new BinaryTree<Integer>(15,
                                new BinaryTree<Integer>(3),
                                null));
// Traverse and print the tree in pre-order manner.
        binaryTree.printPreOrder();
// Console output:
// 23 19 10 6 21 14 3 15
    }
}
