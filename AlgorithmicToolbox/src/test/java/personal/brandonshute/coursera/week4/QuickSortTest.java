package personal.brandonshute.coursera.week4;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuickSortTest {

    // Problem constraint used for speed test (actual class should work for larger values)
    private static final int MAX_ARRAY_SIZE = 100_000;

    @Test
    public void when_provided_empty_array_then_return_empty_array() {
        int[] array = new int[0];

        QuickSort.sort(array);

        assertThat(array, is(array));
    }

    @Test
    public void when_provided_array_of_one_element_then_return_it() {
        int[] array = new int[]{1};

        QuickSort.sort(array);

        assertThat(array, is(array));
    }

    @Test
    public void when_provided_array_of_two_elements_then_return_correctly_sorted_array() {
        int[] array = new int[]{2, 1};

        QuickSort.sort(array);

        assertThat(array, is(new int[]{1, 2}));
    }

    @Test
    public void when_provided_unsorted_array_with_all_unique_values_then_return_correctly_sorted_array() {
        int[] array = new int[]{2, 5, 12, 57, 23, 43};

        QuickSort.sort(array);

        assertThat(array, is(new int[]{2, 5, 12, 23, 43, 57}));
    }

    @Test
    public void when_provided_unsorted_array_with_duplicate_values_then_return_correctly_sorted_array() {
        int[] array = new int[]{2, 1, 5, 1, 6, 7, 5};

        QuickSort.sort(array);

        assertThat(array, is(new int[]{1, 1, 2, 5, 5, 6, 7}));
    }

    // For a 2-part partition in the randomized QuickSort algorithm, an array of size N of identical values has a run
    // time of O(N^2). This test ensures we have implemented the 3-part partition correctly to adjust for this issue.
    @Test
    public void when_provided_large_array_of_the_same_value_then_return_correctly_sorted_array_in_allowable_time() {
        int[] array = Fixture.initializeRandomList(MAX_ARRAY_SIZE, 1, 1);

        long startTime = System.currentTimeMillis();

        QuickSort.sort(array);

        assertThat(array, is(array));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
