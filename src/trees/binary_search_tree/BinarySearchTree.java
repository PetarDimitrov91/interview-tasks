package trees.binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private static class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
        T value;
        BinaryTreeNode<T> parent;
        BinaryTreeNode<T> leftChild;
        BinaryTreeNode<T> rightChild;

        public BinaryTreeNode(T value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }

        @Override
        public int hashCode() {
            return this.value.hashCode();
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            BinaryTreeNode<T> other = (BinaryTreeNode<T>) obj;
            return this.compareTo(other) == 0;
        }

        @Override
        public int compareTo(BinaryTreeNode<T> other) {
            return this.value.compareTo(other.value);
        }
    }

    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        this.root = insert(value, null, root);
    }

    /**
     * Inserts node in the binary search tree by given value.
     *
     * @param value      - the new value.
     * @param parentNode - the parent of the new node.
     * @param node       - current node.
     * @return the inserted node
     */
    private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node) {
        if (node == null) {
            node = new BinaryTreeNode<>(value);
            node.parent = parentNode;
        } else {
            int compareTo = value.compareTo(node.value);

            if (compareTo < 0) {
                node.leftChild = insert(value, node, node.leftChild);
            } else if (compareTo > 0) {
                node.rightChild = insert(value, node, node.rightChild);
            }
        }

        return node;
    }

    /**
     * Finds a given value in the tree and returns the node
     * which contains it if such exsists.
     *
     * @param value - the value to be found.
     * @return the found node or null if not found.
     */
    private BinaryTreeNode<T> find(T value) {
        BinaryTreeNode<T> node = this.root;

        while (node != null) {
            int compareTo = value.compareTo(node.value);

            if (compareTo < 0) {
                node = node.leftChild;
            } else if (compareTo > 0) {
                node = node.rightChild;
            } else {
                break;
            }
        }

        return node;
    }

    public void remove(T value) {
        BinaryTreeNode<T> nodeToDelete = find(value);
        if (nodeToDelete == null) {
            return;
        }
        remove(nodeToDelete);
    }

    public void remove(BinaryTreeNode<T> node) {
// Case 3: If the node has two children.
// Note that if we get here at the end
// the node will be with at most one child.
        if (node.leftChild != null && node.rightChild != null) {
            BinaryTreeNode<T> replacement = node.rightChild;
            while (replacement.leftChild != null) {
                replacement = replacement.leftChild;
            }
            node.value = replacement.value;
            node = replacement;
        }
// Case 1 and 2: If the node has at most one child.
        BinaryTreeNode<T> theChild = node.leftChild != null ?
                node.leftChild : node.rightChild;
// If the element to be deleted has one child.
        if (theChild != null) {
            theChild.parent = node.parent;
// Handle the case when the element is the root.
            if (node.parent == null) {
                root = theChild;
            } else {
// Replace the element with its child subtree.
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = theChild;
                } else {
                    node.parent.rightChild = theChild;
                }
            }
        } else {
// Handle the case when the element is the root.
            if (node.parent == null) {
                root = null;
            } else {
// Remove the element. It is a leaf.
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = null;
                } else {
                    node.parent.rightChild = null;
                }
            }
        }
    }
}

