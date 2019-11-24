package personal.brandonshute.coursera.week5;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link EditDistance class}.
 */
public class EditDistanceTest {

	private static final int MAX_SIZE = 100;


    @Test
    public void when_provided_identical_sequence_of_size_one_return_zero() {
        assertThat(EditDistance.calculate("a", "a"), is(0));
    }

	@Test
	public void when_provided_different_sequence_of_size_one_return_one() {
		assertThat(EditDistance.calculate("a", "b"), is(1));
	}

	@Test
	public void when_provided_inputs_of_different_lengths_with_no_commonality_then_return_size_of_larger_list() {
		final String string1 = buildRepeatedString("a", 2);
		final String string2 = buildRepeatedString("b", 4);

		assertThat(EditDistance.calculate(string1, string2), is(string2.length()));
	}

	@Test
	public void when_provided_inputs_of_different_lengths_with_all_commonality_then_return_difference_in_size() {
		final String string1 = buildRepeatedString("a", 2);
		final String string2 = buildRepeatedString("a", 4);

		assertThat(EditDistance.calculate(string1, string2), is(string2.length() - string1.length()));
	}

    @Test
    public void when_provided_with_inputs_then_return_correct_value() {
    	// Assignment example conditions
		assertThat(EditDistance.calculate("ab", "ab"), is(0));
		assertThat(EditDistance.calculate("short", "ports"), is(3));
		assertThat(EditDistance.calculate("editing", "distance"), is(5));
    }

	@Test
	public void when_provided_identical_maximum_size_string_then_return_zero_in_allowable_amount_of_time() {
    	final String value = buildRepeatedString("a", MAX_SIZE);
		final long startTime = System.currentTimeMillis();

		final int result = EditDistance.calculate(value, value);

		assertThat(result, is(0));
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}

	@Test
	public void when_provided_no_common_maximum_size_string_then_return_size_of_input_in_allowable_amount_of_time() {
		final String string1 = buildRepeatedString("a", MAX_SIZE);
		final String string2 = buildRepeatedString("b", MAX_SIZE);
		final long startTime = System.currentTimeMillis();

		final int result = EditDistance.calculate(string1, string2);

		assertThat(result, is(MAX_SIZE));
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}

	private String buildRepeatedString(final String repeatedString, final int numReps) {
    	return IntStream.range(0, numReps)
				.mapToObj(i -> repeatedString)
				.collect(Collectors.joining());
	}
}
