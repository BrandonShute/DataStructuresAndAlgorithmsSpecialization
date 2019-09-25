package personal.brandonshute.coursera.week2;

import java.util.Scanner;

/**
 * Calculates the nth Fibonacci number.
 */
public class Fibonacci {

    protected static final int MIN_FIBONACCI_NUMBER = 0;

    // Problem constraints
    protected static final int MAX_FIBONACCI_NUMBER = 45;


    public static long calculate(final int n) {
        if (n < MIN_FIBONACCI_NUMBER || n > MAX_FIBONACCI_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("n must be between %d and %d but received: %d", MIN_FIBONACCI_NUMBER, MAX_FIBONACCI_NUMBER, n)
            );
        }

        if (n == 0) {
            return 0L;
        } else if (n == 1) {
            return 1L;
        }

        long[] fibonacciSequence = new long[n + 1];
        fibonacciSequence[0] = 0L;
        fibonacciSequence[1] = 1L;

        for (int i = 2; i <= n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        return fibonacciSequence[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calculate(n));
    }
}
