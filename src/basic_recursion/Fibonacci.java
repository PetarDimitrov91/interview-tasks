package basic_recursion;

public class Fibonacci {
    static int num = 100;
    static long[] memory = new long[num + 1];

    public static void main(String[] args) {
        memory[0] = 0;
        memory[1] = 1;
        // System.out.println(fibDynamic(num));
        // System.out.println(fibRecursiveOptimized(num));
        // System.out.println(fibDynamicOpt(num));

        int a = 5;
        int b = 10;

        a = a + b; //a5 + b10 = 15
        b = a - b; //a15 - b10 = 5
        a = a - b; //a15 - b5 = 10

        System.out.println(a);
        System.out.println(b);
    }

    private static long slowFib(int num) {
        if (num <= 1) {
            return num;
        }

        return slowFib(num - 1) + slowFib(num - 2);
    }

    private static long fibDynamic(int num) {
        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[num];
    }

    private static long fibDynamicOpt(int num) {
        long a = 0, b = 1, c = 0;

        for (int i = 2; i <= num; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    private static long fibRecursiveOptimized(int num) {
        if (num <= 1) {
            return num;
        }

        if (memory[num] == 0) {
            return memory[num] = fibRecursiveOptimized(num - 1) + fibRecursiveOptimized(num - 2);
        }

        return memory[num];
    }

}
