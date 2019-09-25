package personal.brandonshute.coursera.week2;

import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

/**
 * Stress tests for the {@link LeastCommonMultiple} class.
 */
public class LeastCommonMultipleStressTest {

    private static final int MAX_LCD_NUMBER_FOR_NAIVE_METHOD = 30;

    private NaiveLowestCommonMultiple naiveLcm;

    @Before
    public void setup() {
        this.naiveLcm = new NaiveLowestCommonMultiple();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < Fixture.DEFAULT_STRESS_TEST_RUN_TIME) {
            final int a = Fixture.getRandomInt(LeastCommonMultiple.MIN_ALLOWABLE_VALUE, MAX_LCD_NUMBER_FOR_NAIVE_METHOD);
            final int b = Fixture.getRandomInt(LeastCommonMultiple.MIN_ALLOWABLE_VALUE, MAX_LCD_NUMBER_FOR_NAIVE_METHOD);

            final long result = LeastCommonMultiple.calculate(a, b);
            final long naiveResult = this.naiveLcm.calculate(a, b);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input (%d, %d)", result, naiveResult, a, b)
                );
            }
        }
    }

    public class NaiveLowestCommonMultiple {

        private long calculate(int a, int b) {
            for (long l = 1; l <= (long) a * b; ++l) {
                if (l % a == 0 && l % b == 0) {
                    return l;
                }
            }

            return (long) a * b;
        }
    }
}
