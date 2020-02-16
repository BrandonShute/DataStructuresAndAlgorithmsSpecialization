package personal.brandonshute.coursera.week5;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link LongestCommonSubsequence class}.
 */
public class LongestCommonSubsequenceTest {

    private static final int MAX_SIZE = 100;
    private static final int MIN_ELEMENT_SIZE = -1_000_000_000;
    private static final int MAX_ELEMENT_SIZE = 1_000_000_000;

    @Test
    public void when_provided_two_do_different_sequences_of_size_one_return_zero() {
        assertThat(LongestCommonSubsequence.getLength(new int[]{0}, new int[]{1}), is(0));
    }

    @Test
    public void when_provided_two_identical_sequences_of_size_one_return_one() {
        assertThat(LongestCommonSubsequence.getLength(new int[]{1}, new int[]{1}), is(1));
    }

    @Test
    public void when_provided_inputs_then_return_correct_value() {
        assertThat(LongestCommonSubsequence.getLength(new int[]{2, 7, 5}, new int[]{2, 5}), is(2));
        assertThat(LongestCommonSubsequence.getLength(new int[]{7}, new int[]{1, 2, 3, 4}), is(0));
        assertThat(LongestCommonSubsequence.getLength(new int[]{2, 7, 8, 3}, new int[]{5, 2, 8, 7}), is(2));
        assertThat(LongestCommonSubsequence.getLength(new int[]{1, 2, 100, 8}, new int[]{8, 1, 7, 100}), is(2));
    }

    @Test
    public void when_provided_identical_maximum_size_list_then_return_size_of_list_in_allowable_amount_of_time() {
        final int[] list1 = Fixture.initializeRandomList(MAX_SIZE, MIN_ELEMENT_SIZE, MAX_ELEMENT_SIZE);
        final int[] list2 = list1.clone();
        final long startTime = System.currentTimeMillis();

        final int result = LongestCommonSubsequence.getLength(list1, list2);

        assertThat(result, is(list1.length));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
