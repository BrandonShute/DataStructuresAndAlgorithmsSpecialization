package personal.brandonshute.coursera.week1;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link SlidingWindowMaxCalculator} class
 */
public class SlidingWindowMaxCalculatorTest {

	@Test
	public void when_sliding_window_is_one_then_return_the_same_list() {
		final int[] values = new int[]{1, 3, 4, 5, 2};
		assertThat(SlidingWindowMaxCalculator.getMaxes(values, 1), is(values));
	}

	@Test
	public void when_sliding_window_is_size_of_list_then_return_single_max() {
		final int[] values = new int[]{1, 3, 4, 5, 2};
		assertThat(SlidingWindowMaxCalculator.getMaxes(values, values.length), is(new int[]{5}));
	}

	@Test
	public void when_sliding_window_is_in_between_one_and_list_size_then_return_correct_maxes() {
		final int[] values = new int[]{2, 7, 3, 1, 5, 2, 6, 2};
		final int windowSize = 4;

		final int[] expectedMaxes = new int[]{7, 7, 5, 6, 6};

		assertThat(SlidingWindowMaxCalculator.getMaxes(values, windowSize), is(expectedMaxes));
	}
}
