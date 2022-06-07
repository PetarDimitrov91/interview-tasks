package basic_recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(recursiveFib(9));
        System.out.println(dynamicFib(9));
        System.out.println(dynamicFibOptimized(9));
    }

    private static long recursiveFib(long i) {
        if (i <= 1) {
            return i;
        }

        return recursiveFib(i - 1) + recursiveFib(i - 2);
    }

    private static long dynamicFib(int n) {
        long[] arr = new long[n + 2];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    private static long dynamicFibOptimized(int n) {
        int a = 0, b = 1, c;

        if (n == 0) {
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
