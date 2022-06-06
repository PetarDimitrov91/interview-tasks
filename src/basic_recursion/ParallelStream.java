package basic_recursion;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStream {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        Arrays.stream(new int[10000000])
                .parallel()
                .map(e -> i.getAndIncrement())
                .forEach(System.out::println);

        new Thread(() -> {
            AtomicInteger a = new AtomicInteger(0);
            Arrays.stream(new int[10000000])
                    .map(e -> a.getAndIncrement())
                    .forEach(System.out::println);
        }).start();

        System.out.println("Main tread");
    }
}
