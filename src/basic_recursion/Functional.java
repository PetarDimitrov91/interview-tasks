package basic_recursion;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional {
    public static void main(String[] args) {
        Function<String, Integer> a = String::length;

        Consumer<String> b = x -> System.out.println(x);

        Supplier<Throwable> c = () -> new RuntimeException();

        Predicate<String> d = f -> f.equals("s");
    }
}
