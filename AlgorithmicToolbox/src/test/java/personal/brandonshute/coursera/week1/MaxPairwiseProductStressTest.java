package personal.brandonshute.coursera.week1;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * This implements a stress tests for the {@code MaxPairwiseProduct} class. It will run for a specified amount of time
 * validating the algorithm against the naive implementation and throw an exception any time the two differ. Note: if 
 * any issues are found, a proper unit test should be created.
 */
// TODO:brandonshute:2019-09-22: This can be moved out of unit tests in the future to its own module (too slow)
public class MaxPairwiseProductStressTest {

    private static final int SECOND = 1000;
    private static final int TEST_RUN_TIME = 20 * SECOND;
    private static final int MAX_ARRAY_LENGTH = 20_000;
    private static final int MAX_VALUE = 20_000;


    private NaiveMaxPairwiseProduct naiveMaxPairwiseProduct;

    @Before
    public void setup() {
        naiveMaxPairwiseProduct = new NaiveMaxPairwiseProduct();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < TEST_RUN_TIME) {
            final int[] input = initializeRandomArray(MAX_ARRAY_LENGTH, MAX_VALUE);

            final long result = MaxPairwiseProduct.getMaxPairwiseProduct(input);
            final long naiveResult = naiveMaxPairwiseProduct.getMaxPairwiseProduct(input);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input %s", result, naiveResult, Arrays.toString(input))
                );
            }
        }
    }

    private int[] initializeRandomArray(final int maxLength, final int maxValue) {
        final int length = getRandomInt(2, maxLength);
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = getRandomInt(0, maxValue);
        }
        return numbers;
    }

    private int getRandomInt(final int minValue, final int maxValue) {
        Random r = new Random();
        return r.nextInt((maxValue - minValue) + 1) + minValue;
    }

    private class NaiveMaxPairwiseProduct {

        public long getMaxPairwiseProduct(int[] numbers) {
            final int length = numbers.length;

            long maxValue = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (numbers[i] * numbers[j] > maxValue) {
                        maxValue = numbers[i] * numbers[j];
                    }
                }
            }

            return maxValue;
        }
    }
}
