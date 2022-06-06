package basic_recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(recursiveFib(45));
        System.out.println(dynamicFib(45));
        System.out.println(dynamicFibOptimized(45));
    }

    private static long recursiveFib(long i) {
        if (i <= 1) {
            return i;
        }

        return recursiveFib(i - 1) + recursiveFib(i - 2);
    }

    private static long dynamicFib(int n) {
        long[] f = new long[n + 2];
        int i;

        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
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

/**
 * fib(5)
 * /                \
 * fib(4)                fib(3)
 * /        \              /       \
 * fib(3)      fib(2)         fib(2)   fib(1)
 * /    \       /    \        /      \
 * fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
 * /     \
 * fib(1) fib(0)
 **/