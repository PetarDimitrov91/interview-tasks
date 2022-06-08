import java.util.Arrays;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
        int a = 1234;

        "asdas".replace("a","");
        String[] b = Arrays.stream(Integer.toBinaryString(a).split(""))
                .filter(e -> !e.equals("0"))
                .map(Objects::toString)
                .toArray(String[]::new);

        //.count();

        System.out.println(Arrays.toString(b));
    }
}
