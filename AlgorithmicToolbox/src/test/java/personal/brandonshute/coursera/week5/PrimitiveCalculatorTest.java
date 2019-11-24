package personal.brandonshute.coursera.week5;

import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PrimitiveCalculatorTest {

	// Problem constrains
	final static int MAX_VALUE = 1_000_000;

	@Test
	public void when_provided_with_one_then_return_sequence_containing_one() {
		final List<Integer> result = PrimitiveCalculator.getOptimalSequence(1);

		assertThat(result.size(), is(1));
		assertThat(result.get(0), is(1));
	}

	@Test
	public void when_provided_with_simple_input_then_return_correct_sequence() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(4);
		expectedList.add(5);

		final List<Integer> result = PrimitiveCalculator.getOptimalSequence(5);

		assertThat(result, is(expectedList));
	}

	@Test
	public void when_provided_unsafe_move_of_ten_then_should_complete_in_three_moves() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(9);
		expectedList.add(10);

		final List<Integer> result = PrimitiveCalculator.getOptimalSequence(10);

		assertThat(result, is(expectedList));
	}

	@Test
	public void when_provided_large_value_where_greedy_algorithm_will_not_work_then_return_correct_output() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(9);
		expectedList.add(10);
		expectedList.add(11);
		expectedList.add(33);
		expectedList.add(99);
		expectedList.add(297);
		expectedList.add(891);
		expectedList.add(2673);
		expectedList.add(8019);
		expectedList.add(16038);
		expectedList.add(16039);
		expectedList.add(48117);
		expectedList.add(96234);

		final List<Integer> result = PrimitiveCalculator.getOptimalSequence(96234);

		assertThat(result, is(expectedList));
	}

	@Test
	public void when_provided_largest_value_then_return_sequence_in_allowable_time() {
		long startTime = System.currentTimeMillis();
		assertThat(PrimitiveCalculator.getOptimalSequence(MAX_VALUE).size(), greaterThan(0));
		assertThat(System.currentTimeMillis() - startTime < Fixture.MAX_ALLOWABLE_CALCULATION_TIME, is(true));
	}
}
