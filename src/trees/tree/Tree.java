package trees.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tree data structure.
 *
 * @param <T> the type of the values in the tree.
 * @author Petar Dimitrov
 */
public class Tree<T> {
    /**
     * Represents a tree node.
     *
     * @param <T> the type of the values in nodes.
     * @author Petar Dimitrov
     */

    private static class TreeNode<T> {
        private T value;
        private boolean hasParent;
        private final List<TreeNode<T>> children;

        /**
         * Constructs a tree node.
         *
         * @param value the value of the node.
         */
        public TreeNode(T value) throws IllegalAccessException {
            if (value == null) {
                throw new IllegalAccessException("Cannot insert null element");
            }

            this.value = value;
            this.children = new ArrayList<>();
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void addChild(TreeNode<T> child) throws IllegalAccessException {
            if (child == null) {
                throw new IllegalAccessException("Cannot insert null node");
            }

            if (child.hasParent) {
                throw new IllegalArgumentException("The node already has a parent!");
            }

            child.hasParent = true;
            this.children.add(child);
        }

        /**
         * Gets the child of the node at given index.
         *
         * @param index the index of the desired child.
         * @return the child on the given position.
         */
        public TreeNode<T> getChild(int index) {
            return this.children.get(index);
        }

        /**
         * @return the number of node's children.
         */
        public int getChildrenCount() {
            return this.children.size();
        }
    }

    private TreeNode<T> root;

    /**
     * Constructs the tree.
     *
     * @param value the value of the node.
     */
    public Tree(T value) throws IllegalAccessException {
        if (value == null) {
            throw new IllegalArgumentException("Cannot insert null value!");
        }

        this.root = new TreeNode<>(value);
    }

    /**
     * Constructs the tree.
     *
     * @param value    - the value of the root node.
     * @param children - the children of the root node.
     */
    @SafeVarargs
    public Tree(T value, Tree<T>... children) throws IllegalAccessException {
        this(value);

        for (Tree<T> child : children) {
            this.root.addChild(child.root);
        }
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public List<TreeNode<T>> getChildNodes() {
        if (this.root != null) {
            return this.root.children;
        }

        return new ArrayList<TreeNode<T>>();
    }

    /**
     * Traverses and prints tree in
     * Depth First Search (DFS) manner.
     *
     * @param root the root of the tree to be traversed.
     * @param spaces the spaces used for representation of the parent-child relation.
     */

    private void printDFS(TreeNode<T> root, String spaces) {
        if (this.root == null) {
            return;
        }

        System.out.println(spaces + root.getValue());
        TreeNode<T> child = null;

        for (int i = 0; i < root.getChildrenCount(); i++) {
            child = root.getChild(i);
            printDFS(child,spaces + "    ");
        }
    }

    /**
     * Traverses and prints the tree in
     * Depth First Search (DFS) manner.
     */

    public void printDFS(){
        this.printDFS(this.root, "");
    }
}