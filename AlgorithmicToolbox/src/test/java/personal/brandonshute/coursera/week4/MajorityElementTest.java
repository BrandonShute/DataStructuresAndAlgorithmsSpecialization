package personal.brandonshute.coursera.week4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Unit tests for the {@link MajorityElement} class.
 */
public class MajorityElementTest {

    @Test
    public void when_provided_with_empty_list_then_return_negative_one() {
        assertThat(MajorityElement.getMajorityElement(new int[]{}), is(-1));
    }

    @Test
    public void when_provided_with_list_of_size_one_then_return_the_element() {
        assertThat(MajorityElement.getMajorityElement(new int[]{5}), is(5));
    }

    @Test
    public void when_provided_with_odd_sized_list_with_majority_element_then_return_it() {
        assertThat(MajorityElement.getMajorityElement(new int[]{2, 3, 9, 2, 2}), is(2));
    }

    @Test
    public void when_provided_with_odd_sized_list_without_majority_element_then_return_negative_one() {
        assertThat(MajorityElement.getMajorityElement(new int[]{2, 3, 9, 2, 5}), is(-1));
    }

    @Test
    public void when_provided_with_even_sized_list_with_majority_element_then_return_it() {
        assertThat(MajorityElement.getMajorityElement(new int[]{2, 5, 2, 7, 2, 2}), is(2));
    }

    @Test
    public void when_provided_with_even_sized_list_without_majority_element_then_return_negative_one() {
        assertThat(MajorityElement.getMajorityElement(new int[]{1, 2, 3, 4}), is(-1));
    }

    @Test
    public void when_provided_with_even_sized_list_with_exactly_half_then_return_negative_one() {
        assertThat(MajorityElement.getMajorityElement(new int[]{1, 2, 5, 2}), is(-1));
    }
}
