package personal.brandonshute.coursera.week2;


import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

/**
 * Stress tests for the {@code Fibonacci} class.
 */
public class FibonacciStressTest {

    private static final int MAX_FIBONACCI_NUMBER_FOR_NAIVE_METHOD = 15;

    private NaiveFibonacci naiveFibonacci;

    @Before
    public void setup() {
        this.naiveFibonacci = new NaiveFibonacci();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < Fixture.DEFAULT_STRESS_TEST_RUN_TIME) {
            final int input = Fixture.getRandomInt(Fibonacci.MIN_FIBONACCI_NUMBER, MAX_FIBONACCI_NUMBER_FOR_NAIVE_METHOD);

            final long result = Fibonacci.calculateFibonacci(input);
            final long naiveResult = this.naiveFibonacci.calculateFibonacci(input);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input %d", result, naiveResult, input)
                );
            }
        }
    }

    public class NaiveFibonacci {

        public long calculateFibonacci(final int n) {
            if (n <= 1) {
                return n;
            }
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}
