package personal.brandonshute.coursera.week2;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link LeastCommonMultiple} class.
 */
public class LeastCommonMultipleTest {

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_first_input_less_than_min_constraint_then_throw_exception() {
        LeastCommonMultiple.calculate(LeastCommonMultiple.MIN_ALLOWABLE_VALUE - 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_second_input_less_than_min_constraint_then_throw_exception() {
        LeastCommonMultiple.calculate(1, LeastCommonMultiple.MIN_ALLOWABLE_VALUE - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_first_input_greater_than_max_constraint_then_throw_exception() {
        LeastCommonMultiple.calculate(LeastCommonMultiple.MAX_ALLOWABLE_VALUE + 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_second_input_greater_than_max_constraint_then_throw_exception() {
        LeastCommonMultiple.calculate(LeastCommonMultiple.MAX_ALLOWABLE_VALUE + 1, 1);
    }

    @Test
    public void when_provided_with_same_values_then_return_the_number() {
        assertThat(LeastCommonMultiple.calculate(10, 10), is(10L));
    }

    @Test
    public void when_provided_with_first_value_as_multiple_of_second_value_then_return_second_value() {
        assertThat(LeastCommonMultiple.calculate(3, 6), is(6L));
    }

    @Test
    public void when_provided_with_second_value_as_multiple_of_first_value_then_return_first_value() {
        assertThat(LeastCommonMultiple.calculate(6, 3), is(6L));
    }

    @Test
    public void when_provided_with_valid_input_then_return_correct_result() {
        assertThat(LeastCommonMultiple.calculate(6, 8), is(24L));
        assertThat(LeastCommonMultiple.calculate(12, 32), is(96L));
        assertThat(LeastCommonMultiple.calculate(3, 70), is(210L));
        assertThat(LeastCommonMultiple.calculate(761457, 614573), is(467970912861L));
    }

    @Test
    public void when_provided_with_two_of_the_maximum_values_then_calculate_correct_result_in_max_allowable_time() {
        final int value = LeastCommonMultiple.MAX_ALLOWABLE_VALUE;
        long startTime = System.currentTimeMillis();
        assertThat(LeastCommonMultiple.calculate(value, value), is((long) value));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
