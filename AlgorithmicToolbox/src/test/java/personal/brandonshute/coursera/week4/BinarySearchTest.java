package personal.brandonshute.coursera.week4;

import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static personal.brandonshute.coursera.week4.BinarySearch.binarySearch;

/**
 * Unit tests for the {@link BinarySearch class}.
 */
public class BinarySearchTest {

    private static final int[] SIMPLE_ODD_LENGTH_ARRAY = new int[]{1, 5, 8, 12, 13};
    private static final int[] SIMPLE_EVEN_LENGTH_ARRAY = new int[]{1, 5, 8, 12};

    private int[] LARGE_ARRAY = new int[BinarySearch.MAX_ARRAY_SIZE];

    @Before
    public void setup() {
        for (int i = 0; i < BinarySearch.MAX_ARRAY_SIZE; i++) {
            LARGE_ARRAY[i] = i + 1;
        }
    }

    @Test
    public void when_provided_list_of_size_zero_then_return_negative_one() {
        assertThat(binarySearch(new int[]{}, 1), is(-1));
    }

    @Test
    public void when_provided_odd_list_including_element_then_return_correct_index() {
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 1), is(0));
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 5), is(1));
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 8), is(2));
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 12), is(3));
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 13), is(4));
    }

    @Test
    public void when_provided_even_list_including_element_then_return_correct_index() {
        assertThat(binarySearch(SIMPLE_EVEN_LENGTH_ARRAY, 1), is(0));
        assertThat(binarySearch(SIMPLE_EVEN_LENGTH_ARRAY, 5), is(1));
        assertThat(binarySearch(SIMPLE_EVEN_LENGTH_ARRAY, 8), is(2));
        assertThat(binarySearch(SIMPLE_EVEN_LENGTH_ARRAY, 12), is(3));
    }

    @Test
    public void when_provided_odd_list_without_element_then_return_negative_one() {
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 9), is(-1));
    }

    @Test
    public void when_provided_even_list_without_element_then_return_negative_one() {
        assertThat(binarySearch(SIMPLE_EVEN_LENGTH_ARRAY, 9), is(-1));
    }

    @Test
    public void when_provided_list_with_element_below_all_values_then_return_negative_one() {
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 0), is(-1));
    }

    @Test
    public void when_provided_list_with_element_above_all_values_then_return_negative_one() {
        assertThat(binarySearch(SIMPLE_ODD_LENGTH_ARRAY, 16), is(-1));
    }

    @Test
    public void when_provided_large_list_with_element_then_return_correct_index_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(binarySearch(LARGE_ARRAY, BinarySearch.MAX_ARRAY_SIZE), is(BinarySearch.MAX_ARRAY_SIZE - 1));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }

    @Test
    public void when_provided_large_list_without_element_then_return_negative_one_in_allowable_time() {
        long startTime = System.currentTimeMillis();
        assertThat(binarySearch(LARGE_ARRAY, BinarySearch.MAX_ARRAY_SIZE + 1), is(-1));
        assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
    }
}
