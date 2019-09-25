package personal.brandonshute.coursera.week2;

import org.junit.Test;

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
    public void when_provided_with_valid_input_then_return_correct_result() {
        // TODO:brandonshute:2019-09-23 Test
    }

    @Test
    public void when_provided_with_same_values_then_return_the_value() {
        // TODO:brandonshute:2019-09-23 Test
    }
}
