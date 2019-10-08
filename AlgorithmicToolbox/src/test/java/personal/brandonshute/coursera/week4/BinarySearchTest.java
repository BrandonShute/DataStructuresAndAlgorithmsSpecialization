package personal.brandonshute.coursera.week4;

import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link BinarySearch class}.
 */
public class BinarySearchTest {

    // Problem constrains
    final static int MAX_ARRAY_SIZE = 10_000;

    private static final int[] SIMPLE_ODD_LENGTH_ARRAY = new int[]{1, 5, 8, 12, 13};
    private static final int[] SIMPLE_EVEN_LENGTH_ARRAY = new int[]{1, 5, 8, 12};

    private int[] LARGE_ARRAY = new int[MAX_ARRAY_SIZE];

    @Before
    public void setup() {
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            LARGE_ARRAY[i] = i + 1;
        }
    }

    @Test
    public void when_provided_list_of_size_zero_then_return_negative_one() {
        assertThat(BinarySearch.search(new int[]{}, 1), is(-1));
    }

    @Test
    public void when_provided_odd_list_including_element_then_return_correct_index() {
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 1), is(0));
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 5), is(1));
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 8), is(2));
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 12), is(3));
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 13), is(4));
    }

    @Test
    public void when_provided_even_list_including_element_then_return_correct_index() {
        assertThat(BinarySearch.search(SIMPLE_EVEN_LENGTH_ARRAY, 1), is(0));
        assertThat(BinarySearch.search(SIMPLE_EVEN_LENGTH_ARRAY, 5), is(1));
        assertThat(BinarySearch.search(SIMPLE_EVEN_LENGTH_ARRAY, 8), is(2));
        assertThat(BinarySearch.search(SIMPLE_EVEN_LENGTH_ARRAY, 12), is(3));
    }

    @Test
    public void when_provided_odd_list_without_element_then_return_negative_one() {
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 9), is(-1));
    }

    @Test
    public void when_provided_even_list_without_element_then_return_negative_one() {
        assertThat(BinarySearch.search(SIMPLE_EVEN_LENGTH_ARRAY, 9), is(-1));
    }

    @Test
    public void when_provided_list_with_element_below_all_values_then_return_negative_one() {
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 0), is(-1));
    }

    @Test
    public void when_provided_list_with_element_above_all_values_then_return_negative_one() {
        assertThat(BinarySearch.search(SIMPLE_ODD_LENGTH_ARRAY, 16), is(-1));
    }

    @Test
    public void when_provided_large_list_with_element_then_return_correct_index_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(BinarySearch.search(LARGE_ARRAY, MAX_ARRAY_SIZE), is(MAX_ARRAY_SIZE - 1));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }

    @Test
    public void when_provided_large_list_without_element_then_return_negative_one_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(BinarySearch.search(LARGE_ARRAY, MAX_ARRAY_SIZE + 1), is(-1));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
