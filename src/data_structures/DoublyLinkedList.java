package data_structures;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<T> implements Iterable<T> {

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

    public DoublyLinkedList() {
        this.size = 0;
    }

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
        Node<T> currNode = this.head;
        while (currNode != null) {
            action.accept(currNode.el);
            currNode = currNode.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T curr = current.el;
                this.current = current.next;
                return curr;
            }
        };
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<? extends T> a) {
        T[] arr = (T[]) Array.newInstance(a, this.size);
        if (this.size == 0) {
            return arr;
        }

        Node<T> current = head;

        for (int i = 0; i < this.size; i++) {
            arr[i] = current.el;
            current = current.next;
        }

        return arr;
    }
}
/*
  @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                return Arrays.copyOf(this.a, size,
                                     (Class<? extends T[]>) a.getClass());
            System.arraycopy(this.a, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }
 */
