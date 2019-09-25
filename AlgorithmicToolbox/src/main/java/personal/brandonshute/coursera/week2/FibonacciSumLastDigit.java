package personal.brandonshute.coursera.week2;

import java.util.*;

/**
 * Calculates the last digit of a sum of Fibonacci sequence.
 */
public class FibonacciSumLastDigit {

    protected static final int MIN_FIBONACCI_NUMBER = 0;

    // Fibonacci sequence is a periodic function of a particular length for any given mod called the Pisano period
    private static final int MOD_10_PISANO = 60;

    // Problem constraints
    protected static final long MAX_FIBONACCI_NUMBER = 100_000_000_000_000L;

    public static long calculate(long n) {
        if (n < MIN_FIBONACCI_NUMBER || n > MAX_FIBONACCI_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("n must be between %d and %d but received: %d", MIN_FIBONACCI_NUMBER, MAX_FIBONACCI_NUMBER, n)
            );
        }

        if (n <= 1) {
            return n;
        }

        int lastValue = 0;
        int value = 1;
        for (int i = 2; i <= (n % MOD_10_PISANO); i++) {
            final int lastValueTemp = value;
            value = (lastValue + value + 1) % 10;
            lastValue = lastValueTemp;
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(calculate(n));
    }
}

