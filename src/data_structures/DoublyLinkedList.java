package data_structures;

import java.util.function.Consumer;

public class DoublyLinkedList<T> {

    private static class Node<T> {
        private final T el;
        private Node<T> next;
        private Node<T> prev;

        private Node(T el) {
            this.el = el;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T el) {
        Node<T> newNode = new Node<>(el);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;
    }

    public void addLast(T el) {
        Node<T> newNode = new Node<>(el);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size++;
    }

    public T removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0.");
        } else if (this.size == 1) {
            Node<T> firstElement = this.head;
            this.head = null;
            this.tail = null;
            this.size = 0;

            return firstElement.el;
        } else {
            Node<T> firstElement = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;

            return firstElement.el;
        }
    }

    public T removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0.");
        } else if (this.size == 1) {
            Node<T> removedElement = this.head;
            this.head = null;
            this.tail = null;
            this.size = 0;

            return removedElement.el;
        } else {
            Node<T> removedElement = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;

            return removedElement.el;
        }
    }

    public void forEach(Consumer<? super T> action) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            action.accept(currentNode.el);
            currentNode = currentNode.next;
        }
    }
}
