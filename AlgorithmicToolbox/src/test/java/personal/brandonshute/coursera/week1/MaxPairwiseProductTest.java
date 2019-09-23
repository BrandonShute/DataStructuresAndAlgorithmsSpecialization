package personal.brandonshute.coursera.week1;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@code MaxPairwiseProduct} class.
 */
public class MaxPairwiseProductTest {

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_less_than_two_numbers_then_throw_an_exception() {
        MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{0});
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_more_than_the_maximum_specified_numbers_then_throw_an_exception() {
        MaxPairwiseProduct.getMaxPairwiseProduct(new int[20_001]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_provided_with_an_array_with_a_negative_value_then_throw_an_exception() {
        MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{5, 4, -1});
    }

    @Test
    public void when_provided_with_two_numbers_then_output_the_product_of_those_numbers() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{3, 4}), is(12L));
    }

    @Test
    public void when_provided_with_a_list_of_numbers_then_should_return_max_pairwise_product() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{3, 4, 2}), is(12L));
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{1, 2, 12, 3, 9}), is(108L));
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{1, 2, 3, 4, 5, 6}), is(30L));
    }

    @Test
    public void when_provided_with_a_list_of_numbers_that_have_duplicates_for_largest_then_should_return_max_pairwise_product() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{3, 4, 4, 2}), is(16L));
    }

    @Test
    public void when_provided_with_a_list_of_two_large_integers_than_multiplication_does_not_cause_integer_overflow() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{100_000, 90_000}), is(9_000_000_000L));
    }

    @Test
    public void when_provided_with_largest_value_at_start_then_return_correct_result() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{6, 5, 4, 3, 2, 1}), is(30L));
    }

    @Test
    public void when_provided_with_zero_as_a_largest_number_than_return_zero() {
        assertThat(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{2, 0}), is(0L));
    }
}
