package personal.brandonshute.coursera.week5;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link MoneyChangeV2 class}.
 */
public class MoneyChangeV2Test {


    @Test
    public void when_provided_with_zero_then_return_zero() {
        assertThat(MoneyChangeV2.getChange(0), is(0));
    }

    @Test
    public void when_provided_with_exact_value_for_single_coin_then_return_one() {
        assertThat(MoneyChangeV2.getChange(1), is(1));
        assertThat(MoneyChangeV2.getChange(3), is(1));
        assertThat(MoneyChangeV2.getChange(4), is(1));
    }

    @Test
    public void when_provided_with_amount_then_return_correct_value() {
        assertThat(MoneyChangeV2.getChange(2), is(2));
        assertThat(MoneyChangeV2.getChange(34), is(9));
    }

    @Test
    public void when_provided_with_maximum_then_return_correct_value_in_allowable_amount_of_time() {
        long startTime = System.currentTimeMillis();
        assertThat(MoneyChangeV2.getChange(MoneyChangeV2.MAX_CHANGE), is(250));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
