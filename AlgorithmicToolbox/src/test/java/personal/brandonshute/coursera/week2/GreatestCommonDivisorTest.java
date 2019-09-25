package personal.brandonshute.coursera.week2;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link GreatestCommonDivisor} class.
 */
public class GreatestCommonDivisorTest {

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_first_input_less_than_min_constraint_then_throw_exception() {
        GreatestCommonDivisor.calculate(GreatestCommonDivisor.MIN_ALLOWABLE_VALUE - 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_second_input_less_than_min_constraint_then_throw_exception() {
        GreatestCommonDivisor.calculate(1, GreatestCommonDivisor.MIN_ALLOWABLE_VALUE - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_first_input_greater_than_max_constraint_then_throw_exception() {
        GreatestCommonDivisor.calculate(GreatestCommonDivisor.MAX_ALLOWABLE_VALUE + 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_second_input_greater_than_max_constraint_then_throw_exception() {
        GreatestCommonDivisor.calculate(GreatestCommonDivisor.MAX_ALLOWABLE_VALUE + 1, 1);
    }

    @Test
    public void when_provided_with_first_value_as_multiple_of_second_value_then_return_first_value() {
        assertThat(GreatestCommonDivisor.calculate(3, 6), is(3L));
    }

    @Test
    public void when_provided_with_second_value_as_multiple_of_first_value_then_return_second_value() {
        assertThat(GreatestCommonDivisor.calculate(6, 3), is(3L));
    }

    @Test
    public void when_provided_with_same_values_then_return_the_value() {
        assertThat(GreatestCommonDivisor.calculate(5, 5), is(5L));
    }

    @Test
    public void when_provided_with_valid_input_then_return_correct_result() {
        assertThat(GreatestCommonDivisor.calculate(6, 20), is(2L));
        assertThat(GreatestCommonDivisor.calculate(15, 20), is(5L));
        assertThat(GreatestCommonDivisor.calculate(3718, 42828), is(2L));
    }

    @Test
    public void when_provided_with_two_of_the_maximum_values_then_calculate_correct_result_in_max_allowable_time() {
        final int value = GreatestCommonDivisor.MAX_ALLOWABLE_VALUE;
        long startTime = System.currentTimeMillis();
        assertThat(GreatestCommonDivisor.calculate(value, value), is((long) value));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
