package trees.binary_tree;

/**
 * Represents a binary tree structure.
 *
 * @author Petar Dimitrov
 */
public class BinaryTree<T> {
    /**
     * Represents a binary tree node.
     *
     * @param <T> - the type of the values in nodes.
     */

    private static class BinaryTreeNode<T> {
        private T value;
        private boolean hasParent;
        private BinaryTreeNode<T> leftChild;
        private BinaryTreeNode<T> rightChild;

        /**
         * Constructs a binary tree node.
         *
         * @param value      - the value of the node.
         * @param leftChild  - the left child of the node.
         * @param rightChild - the right child of the node.
         */
        public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
            if (value == null) {
                throw new IllegalArgumentException("Cannot insert null value!");
            }

            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        /**
         * Constructs a binary tree node with no children.
         *
         * @param value - the value of the node.
         */
        public BinaryTreeNode(T value) {
            this(value, null, null);
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public BinaryTreeNode<T> getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(BinaryTreeNode<T> value) {
            if (value == null || value.hasParent) {
                throw new IllegalArgumentException();
            }
            value.hasParent = true;
            this.leftChild = value;
        }

        public BinaryTreeNode<T> getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(BinaryTreeNode<T> value) {
            if (value == null || value.hasParent) {
                throw new IllegalArgumentException();
            }
            value.hasParent = true;
            this.rightChild = value;
        }
    }

    private BinaryTreeNode<T> root;

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        if (value == null) {
            throw new IllegalArgumentException("cannot insert null value!");
        }

        BinaryTreeNode<T> leftChildNode = leftChild != null ? leftChild.root : null;
        BinaryTreeNode<T> rightChildNode = rightChild != null ? rightChild.root : null;

        this.root = new BinaryTreeNode<>(value, leftChildNode, rightChildNode);

    }

    public BinaryTree(T value) {
        this(value, null, null);
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    public BinaryTreeNode<T> getLeftChildNode() {
        if (this.root != null) {
            return this.root.getLeftChild();
        }

        return null;
    }

    public BinaryTreeNode<T> getRightChildNode() {
        if (this.root != null) {
            return this.root.getRightChild();
        }

        return null;
    }

    private void printPreOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }

        printPreOrder(root.getLeftChild());
        System.out.print(root.getValue() + " ");
        printPreOrder(root.getRightChild());

    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
        System.out.println();
    }
}


















