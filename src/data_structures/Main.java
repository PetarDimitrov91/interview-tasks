package data_structures;

import java.nio.file.LinkOption;

public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();

        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);

        /*

        l.forEach(System.out::println);

        for (Integer integer : l) {
            System.out.println(integer);
        }
         */

        Integer[] integers = l.toArray(Integer.class);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
