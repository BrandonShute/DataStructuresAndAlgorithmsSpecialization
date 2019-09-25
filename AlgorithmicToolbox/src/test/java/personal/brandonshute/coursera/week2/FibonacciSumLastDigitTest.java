package personal.brandonshute.coursera.week2;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@link FibonacciSumLastDigit} class.
 */
public class FibonacciSumLastDigitTest {

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_input_less_than_min_constraint_then_throw_exception() {
        FibonacciSumLastDigit.calculate(FibonacciSumLastDigit.MIN_FIBONACCI_NUMBER - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_input_greater_than_max_constraint_then_throw_exception() {
        FibonacciSumLastDigit.calculate(FibonacciSumLastDigit.MAX_FIBONACCI_NUMBER + 1);
    }

    @Test
    public void when_provided_with_zero_then_return_zero() {
        assertThat(FibonacciSumLastDigit.calculate(0), is(0L));
    }

    @Test
    public void when_provided_with_one_then_return_one() {
        assertThat(FibonacciSumLastDigit.calculate(1), is(1L));
    }

    @Test
    public void when_provided_with_value_that_is_multiple_of_pisano_then_then_return_zero() {
        assertThat(FibonacciSumLastDigit.calculate(240), is(0L));
    }

    @Test
    public void when_provided_with_valid_input_then_return_correct_fibonacci_sum_last_digit_number() {
        assertThat(FibonacciSumLastDigit.calculate(2), is(2L));
        assertThat(FibonacciSumLastDigit.calculate(5), is(2L));
        assertThat(FibonacciSumLastDigit.calculate(8), is(4L));
        assertThat(FibonacciSumLastDigit.calculate(10), is(3L));
    }

    @Test
    public void when_provided_with_maximum_value_of_n_then_return_correct_fibonacci_sum_last_digit_number_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(FibonacciSumLastDigit.calculate(100_000_000_000_000L), is(5L));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}


