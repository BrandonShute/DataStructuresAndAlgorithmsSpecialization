package personal.brandonshute.coursera.week2;

import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

/**
 * Stress tests for the {@link GreatestCommonDivisor} class.
 */
public class GreatestCommonDivisorStressTest {

    private static final int MAX_GCD_NUMBER_FOR_NAIVE_METHOD = 100_000;

    private NaiveGreatestCommonDivisor naiveGcd;

    @Before
    public void setup() {
        this.naiveGcd = new NaiveGreatestCommonDivisor();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < Fixture.DEFAULT_STRESS_TEST_RUN_TIME) {
            final int a = Fixture.getRandomInt(GreatestCommonDivisor.MIN_ALLOWABLE_VALUE, MAX_GCD_NUMBER_FOR_NAIVE_METHOD);
            final int b = Fixture.getRandomInt(GreatestCommonDivisor.MIN_ALLOWABLE_VALUE, MAX_GCD_NUMBER_FOR_NAIVE_METHOD);


            final long result = GreatestCommonDivisor.calculate(a, b);
            final long naiveResult = this.naiveGcd.calculate(a, b);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input (%d, %d)", result, naiveResult, a, b)
                );
            }
        }
    }

    public class NaiveGreatestCommonDivisor {

        public long calculate(final int a, final int b) {
            int currentGcd = 1;
            for (int d = 2; d <= a && d <= b; ++d) {
                if (a % d == 0 && b % d == 0) {
                    if (d > currentGcd) {
                        currentGcd = d;
                    }
                }
            }

            return currentGcd;
        }
    }
}
