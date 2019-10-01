package personal.brandonshute.coursera.week3;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link DifferentSummands} class.
 */
public class DifferentSummandsTest {

	@Test
	public void when_provided_with_minimum_available_number_then_return_one() {
		final List<Integer> result = DifferentSummands.getOptimalSummands(1);

		assertThat(result.size(), is(1));
		assertThat(result, contains(1));
	}

	@Test
	public void when_provided_with_two_then_return_just_two() {
		final List<Integer> result = DifferentSummands.getOptimalSummands(2);

		assertThat(result.size(), is(1));
		assertThat(result, contains(2));
	}

	@Test
	public void when_provided_with_number_that_can_be_perfectly_broken_down_then_return_correct_value() {
		final List<Integer> result = DifferentSummands.getOptimalSummands(6);

		assertThat(result.size(), is(3));
		assertThat(result, contains(1, 2, 3));
	}

	@Test
	public void when_provided_with_number_that_cannot_be_perfectly_broken_down_then_return_correct_value() {
		final List<Integer> result = DifferentSummands.getOptimalSummands(8);

		assertThat(result.size(), is(3));
		assertThat(result, contains(1, 2, 5));
	}

	@Test
	public void when_provided_with_maximum_weight_and_amount_of_items_then_return_value_in_allowable_amount_of_time() {
		long startTime = System.currentTimeMillis();
		final List<Integer> result = DifferentSummands.getOptimalSummands(DifferentSummands.MAX_NUM);
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
