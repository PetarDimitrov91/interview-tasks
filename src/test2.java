import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        int[] arr = {2, -5};
        int i = methodArr(arr);

        String a = "dfasda";
        int f = a.indexOf('f');

        List<Integer> s = new ArrayList<>(List.of(1, 2, 3, 4));

        s.indexOf(1);

        System.out.println(i);
    }

    private static int methodArr(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int n = arr[0];

        for (int i = 0; i < arr.length; i++) {

            int num = Math.abs(arr[i]);

            if (num <= Math.abs(n)) {
                n = arr[i];
            }
        }

        return n;
    }
}
