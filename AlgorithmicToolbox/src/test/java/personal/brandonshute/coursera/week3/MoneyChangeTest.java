package personal.brandonshute.coursera.week3;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link MoneyChange} class.
 */
public class MoneyChangeTest {

	@Test
	public void when_provided_with_zero_then_return_zero() {
		assertThat(MoneyChange.getChange(0), is(0));
	}

	@Test
	public void when_provided_with_exact_value_for_single_coin_then_return_one() {
		assertThat(MoneyChange.getChange(1), is(1));
		assertThat(MoneyChange.getChange(5), is(1));
		assertThat(MoneyChange.getChange(10), is(1));
	}

	@Test
	public void when_provided_with_amount_then_return_correct_value() {
		assertThat(MoneyChange.getChange(12), is(3));
		assertThat(MoneyChange.getChange(27), is(5));
		assertThat(MoneyChange.getChange(74), is(11));
	}

	@Test
	public void when_provided_with_maximum_then_return_correct_value_in_allowable_amount_of_time() {
		long startTime = System.currentTimeMillis();
		assertThat(MoneyChange.getChange(MoneyChange.MAX_CHANGE), is(100));
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
