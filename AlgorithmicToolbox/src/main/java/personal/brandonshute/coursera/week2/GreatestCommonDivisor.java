package personal.brandonshute.coursera.week2;

import java.util.*;

/**
 * Calculates the Greatest Common Divisor (GCD) of two integers.
 */
public class GreatestCommonDivisor {

    // Problem constraints
    protected static final int MIN_ALLOWABLE_VALUE = 1;
    protected static final int MAX_ALLOWABLE_VALUE = 2_000_000_000;


    public static long calculate(int a, int b) {
        validateInput(a);
        validateInput(b);

        // TODO:brandonshute:Implement
        return 0L;
    }

    private static void validateInput(final int value) {
        if (value < MIN_ALLOWABLE_VALUE || value > MAX_ALLOWABLE_VALUE) {
            throw new IllegalArgumentException(
                    String.format("value must be between %d and %d but received: %d", MIN_ALLOWABLE_VALUE, MAX_ALLOWABLE_VALUE, value)
            );
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(calculate(a, b));
    }
}
