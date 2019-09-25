package personal.brandonshute.coursera.week2;

import java.util.*;

/**
 * Calculates the Least Common Multiple (LCM) of two integers.
 */
public class LeastCommonMultiple {

    // Problem constraints
    protected static final int MIN_ALLOWABLE_VALUE = 0;
    protected static final int MAX_ALLOWABLE_VALUE = 10_000_000;

    public static long calculate(int a, int b) {
        validateInput(a);
        validateInput(b);

        if (a == 0 || b == 0) {
            return 0;
        } else if (a == b || a % b == 0) {
            return a;
        } else if (b % a == 0) {
            return b;
        }

        final int maxLowerFactor = getMaxLowerFactor(a, b);
        final long upperFactorA = (a / maxLowerFactor);
        final long upperFactorB = (b / maxLowerFactor);
        return maxLowerFactor * upperFactorA * upperFactorB;
    }

    private static void validateInput(final int value) {
        if (value < MIN_ALLOWABLE_VALUE || value > MAX_ALLOWABLE_VALUE) {
            throw new IllegalArgumentException(
                    String.format("value must be between %d and %d but received: %d", MIN_ALLOWABLE_VALUE, MAX_ALLOWABLE_VALUE, value)
            );
        }
    }

    private static int getMaxLowerFactor(final int a, final int b) {
        final List<Integer> lowerFactorsA = getLowerFactors(a);
        final List<Integer> lowerFactorsB = getLowerFactors(b);

        int maxLowerFactor = 1;
        for (int i = 0; i < lowerFactorsA.size(); i++) {
            for (int j = 0; j < lowerFactorsB.size(); j++) {
                final int lowerFactorA = lowerFactorsA.get(i);
                if (lowerFactorA == lowerFactorsB.get(j) && lowerFactorA > maxLowerFactor) {
                    maxLowerFactor = lowerFactorA;
                }
            }
        }

        return maxLowerFactor;
    }

    private static List<Integer> getLowerFactors(final int value) {
        List<Integer> lowerFactors = new ArrayList<>();
        for (int i = 2; i < value / 2 + 1; i++) {
            if (value % i == 0) {
                lowerFactors.add(i);
            }
        }
        return lowerFactors;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(calculate(a, b));
    }
}
