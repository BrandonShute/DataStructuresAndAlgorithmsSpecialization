package personal.brandonshute.coursera.week6;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link Partition3} class.
 */
public class Partition3Test {

	private static final int MAX_NUM_ELEMENTS = 20;
	private static final int MIN_ELEMENT_SIZE = 0;
	private static final int MAX_ELEMENT_SIZE = 30;

	@Test
	public void when_provided_with_list_of_size_less_than_three_then_return_false() {
		assertThat(Partition3.canPartition(new int[0]), is(false));
		assertThat(Partition3.canPartition(new int[]{1}), is(false));
		assertThat(Partition3.canPartition(new int[]{1, 1}), is(false));
	}

	@Test
	public void when_provided_with_list_of_size_three_that_match_then_return_true() {
		assertThat(Partition3.canPartition(new int[]{1, 1, 1}), is(true));
		assertThat(Partition3.canPartition(new int[]{5, 5, 5}), is(true));
	}

	@Test
	public void when_provided_with_list_of_size_three_that_do_not_match_then_return_false() {
		assertThat(Partition3.canPartition(new int[]{1, 1, 2}), is(false));
		assertThat(Partition3.canPartition(new int[]{3, 14, 2}), is(false));
		assertThat(Partition3.canPartition(new int[]{2, 12, 2}), is(false));
	}

	@Test
	public void when_provided_with_all_matching_elements_but_size_is_not_divisible_by_three_then_return_false() {
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3}), is(false));
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3, 3}), is(false));
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3, 3, 3, 3}), is(false));
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3, 3, 3, 3, 3}), is(false));
	}

	@Test
	public void when_provided_with_all_matching_elements_and_size_is_divisible_by_three_then_return_true() {
		assertThat(Partition3.canPartition(new int[]{3, 3, 3}), is(true));
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3, 3, 3}), is(true));
		assertThat(Partition3.canPartition(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3}), is(true));
	}

	@Test
	public void when_provided_list_with_elements_whose_sum_is_not_divisible_by_three_then_return_false() {
		assertThat(Partition3.canPartition(new int[]{4, 5, 6, 7, 8, 10}), is(false));
		assertThat(Partition3.canPartition(new int[]{2, 4, 5, 6, 7, 8, 10, 35}), is(false));
		assertThat(Partition3.canPartition(new int[]{1, 2, 3, 4}), is(false));
	}

	@Test
	public void when_provided_list_with_elements_whose_sum_is_divisible_by_three_that_cannot_be_partitioned_then_return_false() {
		assertThat(Partition3.canPartition(new int[]{3, 3, 6}), is(false));
		assertThat(Partition3.canPartition(new int[]{6, 12, 9, 15, 6}), is(false));
	}

	@Test
	public void when_provided_list_with_elements_that_can_be_partitioned_then_return_true() {
		assertThat(Partition3.canPartition(new int[]{17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59}), is(true));
		assertThat(Partition3.canPartition(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25}), is(true));
	}

	@Test
	public void when_provided_maximum_size_list_who_sum_is_divisible_by_three_then_return_solution_in_allowable_amount_of_time() {
		int[] elements = Fixture.initializeRandomList(MAX_NUM_ELEMENTS, MIN_ELEMENT_SIZE, MAX_ELEMENT_SIZE - 1);
		final int sum = IntStream.of(elements).sum();
		elements = Arrays.copyOf(elements, MAX_NUM_ELEMENTS);
		elements[MAX_NUM_ELEMENTS - 1] = sum % 3;

		final long startTime = System.currentTimeMillis();

		Partition3.canPartition(elements);

		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
