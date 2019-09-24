package personal.brandonshute.coursera.week2;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@code Fibonacci} class.
 */
public class FibonacciTest {

    private static final double MAX_CALCULATION_TIME = 1.5 * Fixture.SECOND;

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_input_less_than_min_constraint_then_throw_exception() {
        Fibonacci.calculateFibonacci(Fibonacci.MIN_FIBONACCI_NUMBER - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_input_greater_than_max_constraint_then_throw_exception() {
        Fibonacci.calculateFibonacci(Fibonacci.MAX_FIBONACCI_NUMBER + 1);
    }

    @Test
    public void when_provided_with_zero_then_return_zero() {
        assertThat(Fibonacci.calculateFibonacci(0), is(0L));
    }

    @Test
    public void when_provided_with_valid_input_then_return_correct_fibonacci_number() {
        assertThat(Fibonacci.calculateFibonacci(1), is(1L));
        assertThat(Fibonacci.calculateFibonacci(3), is(2L));
        assertThat(Fibonacci.calculateFibonacci(5), is(5L));
        assertThat(Fibonacci.calculateFibonacci(10), is(55L));
        assertThat(Fibonacci.calculateFibonacci(20), is(6765L));
        assertThat(Fibonacci.calculateFibonacci(30), is(832040L));
    }

    @Test
    public void when_provided_with_maximum_value_of_n_then_return_correct_fibonacci_number_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(Fibonacci.calculateFibonacci(45), is(1134903170L));
        assertThat(System.currentTimeMillis() - startTime < MAX_CALCULATION_TIME, is(true));
    }
}
