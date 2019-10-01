package personal.brandonshute.coursera.week3;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link FractionalKnapsack} class.
 */
public class FractionalKnapsackTest {

	@Test(expected = IllegalArgumentException.class)
	public void when_provided_with_unbounded_solution_then_throw_exception() {
		FractionalKnapsack.getOptimalValue(10, new int[]{1}, new int[]{0});
	}

	@Test
	public void when_provided_with_zero_available_room_in_bag_then_return_zero() {
		assertThat(FractionalKnapsack.getOptimalValue(0, new int[]{5}, new int[]{1}), is(0.0));
	}

	@Test
	public void when_provided_with_less_objects_than_can_fit_in_knapsack_then_return_sum_or_values() {
		final int[] values = new int[]{15, 60, 10, 5};
		final int[] weights = new int[]{1, 1, 1, 1};
		assertThat(FractionalKnapsack.getOptimalValue(5, values, weights), is(90.0));
	}

	@Test
	public void when_provided_with_wieghts_that_match_exactly_then_return_correct_value() {
		final int[] values = new int[]{1, 3, 5};
		final int[] weights = new int[]{5, 2, 3};
		assertThat(FractionalKnapsack.getOptimalValue(10, values, weights), is(9.0));
	}

	@Test
	public void when_provided_with_amount_then_return_correct_value() {
		final int[] values = new int[]{1, 3, 5};
		final int[] weights = new int[]{5, 2, 3};
		assertThat(FractionalKnapsack.getOptimalValue(7, values, weights), is(5 + 3 + (((double)2 / 5) * 1)));
	}

	@Test
	public void when_provided_with_amount_then_return_correct_value_2() {
		final int[] values = new int[]{60, 100, 120};
		final int[] weights = new int[]{20, 50, 30};
		assertThat(FractionalKnapsack.getOptimalValue(50, values, weights), is(180.0));
	}

	@Test
	public void when_provided_with_amount_then_return_correct_value_3() {
		final int[] values = new int[]{500};
		final int[] weights = new int[]{30};
		assertThat(FractionalKnapsack.getOptimalValue(10, values, weights), is(((double) 500 / 30) * 10));
	}

	@Test
	public void when_provided_with_maximum_weight_and_amount_of_items_then_return_value_in_allowable_amount_of_time() {
		final int[] values = Fixture.initializeRandomList(
				FractionalKnapsack.MAX_ITEMS, FractionalKnapsack.MIN_ITEM_VALUE, FractionalKnapsack.MAX_ITEM_VALUE
		);
		final int[] weights = Fixture.initializeRandomList(
				FractionalKnapsack.MAX_ITEMS, FractionalKnapsack.MIN_ITEM_WEIGHT, FractionalKnapsack.MAX_ITEM_WEIGHT
		);
		long startTime = System.currentTimeMillis();
		FractionalKnapsack.getOptimalValue(FractionalKnapsack.MAX_BAG_WEIGHT, values, weights);
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
