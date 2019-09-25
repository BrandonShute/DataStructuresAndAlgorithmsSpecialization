package personal.brandonshute.coursera.week2;


import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

/**
 * Stress tests for the {@link FibonacciSumLastDigit} class.
 */
public class FibonacciSumLastDigitStressTest {

    private static final int MAX_FIBONACCI_NUMBER_FOR_NAIVE_METHOD = 15;

    private NaiveFibonacciSumLastDigit naiveFibonacciSumLastDigit;

    @Before
    public void setup() {
        this.naiveFibonacciSumLastDigit = new NaiveFibonacciSumLastDigit();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < Fixture.DEFAULT_STRESS_TEST_RUN_TIME) {
            final int input = Fixture.getRandomInt(FibonacciSumLastDigit.MIN_FIBONACCI_NUMBER, MAX_FIBONACCI_NUMBER_FOR_NAIVE_METHOD);

            final long result = FibonacciSumLastDigit.calculate(input);
            final long naiveResult = this.naiveFibonacciSumLastDigit.calculate(input);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input %d", result, naiveResult, input)
                );
            }
        }
    }

    public class NaiveFibonacciSumLastDigit {

        public long calculate(final int n) {
            if (n <= 1) {
                return n;
            }

            long previous = 0;
            long current = 1;
            long sum = 1;

            for (long i = 0; i < n - 1; ++i) {
                long tmp_previous = previous;
                previous = current;
                current = tmp_previous + current;
                sum += current;
            }

            return sum % 10;
        }
    }
}
