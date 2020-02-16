package personal.brandonshute.coursera.week6;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link Knapsack} class.
 */
public class KnapsackTest {

	private static final int MAX_NUM_ELEMENTS = 300;
	private static final int MIN_ELEMENT_SIZE = 0;

	@Test
	public void when_provided_with_empty_list_then_return_zero() {
		assertThat(Knapsack.getOptimalWeight(10, new int[1]), is(0));
	}

	@Test
	public void when_provided_list_with_elements_greater_than_weight_limit_then_return_zero() {
		assertThat(Knapsack.getOptimalWeight(10, new int[]{11, 12}), is(0));
	}

	@Test
	public void when_provided_list_with_single_element_less_than_weight_limit_then_return_single_element_weight() {
		assertThat(Knapsack.getOptimalWeight(10, new int[]{8}), is(8));
	}

	@Test
	public void when_provided_list_with_many_elements_less_than_weight_limit_then_return_sum_of_elements() {
		assertThat(Knapsack.getOptimalWeight(15, new int[]{1, 2, 3, 4, 5}), is(15));
	}

	@Test
	public void when_provided_list_with_many_elements_and_one_that_equals_weight_limit_then_return_weight_limit() {
		assertThat(Knapsack.getOptimalWeight(8, new int[]{1, 4, 6, 3, 8}), is(8));
	}

	@Test
	public void when_provided_list_with_many_elements_then_return_correct_value() {
		assertThat(Knapsack.getOptimalWeight(10, new int[]{1, 4, 8}), is(9));
		assertThat(Knapsack.getOptimalWeight(8, new int[]{1, 4, 6, 3}), is(8));
	}

	@Test
	public void when_provided_maximum_size_list_with_all_elements_that_can_be_added_then_return_sum_in_allowable_amount_of_time() {
		// Keep max value low so that the basket total weight is low (problem limit is 100,000)
		final int[] elements = Fixture.initializeRandomList(MAX_NUM_ELEMENTS, MIN_ELEMENT_SIZE, 5);
		final int elementSum = IntStream.of(elements).sum();
		final long startTime = System.currentTimeMillis();

		final int result = Knapsack.getOptimalWeight(elementSum, elements);

		assertThat(result, is(elementSum));
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
