import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();
        int a = 1234;

        String[] b = Arrays.stream(Integer.toBinaryString(a).split(""))
                .filter(e -> !e.equals("0"))
                .map(Objects::toString)
                .toArray(String[]::new);

        //.count();

        System.out.println(Arrays.toString(b));
    }
}
