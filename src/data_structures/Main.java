package data_structures;

public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();

        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);

        l.forEach(System.out::println);


        l.removeLast();

        l.forEach(System.out::println);
    }
}
