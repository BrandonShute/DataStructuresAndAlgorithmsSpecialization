package personal.brandonshute.coursera.week1;


import org.junit.Before;
import org.junit.Test;
import personal.brandonshute.coursera.Fixture;

import java.util.Arrays;


/**
 * This implements a stress tests for the {@link MaxPairwiseProduct} class. It will run for a specified amount of time
 * validating the algorithm against the naive implementation and throw an exception any time the two differ. Note: if 
 * any issues are found, a proper unit test should be created.
 */
public class MaxPairwiseProductStressTest {

    private NaiveMaxPairwiseProduct naiveMaxPairwiseProduct;

    @Before
    public void setup() {
        this.naiveMaxPairwiseProduct = new NaiveMaxPairwiseProduct();
    }


    @Test
    public void when_testing_against_naive_algorithm_with_random_values_then_solutions_always_match() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < Fixture.DEFAULT_STRESS_TEST_RUN_TIME) {
            final int[] input = initializeRandomArray(
                    MaxPairwiseProduct.MIN_ARRAY_SIZE, MaxPairwiseProduct.MAX_ARRAY_SIZE,
                    MaxPairwiseProduct.MIN_ALLOWABLE_VALUE, MaxPairwiseProduct.MAX_ALLOWABLE_VALUE
            );

            final long result = MaxPairwiseProduct.calculate(input);
            final long naiveResult = this.naiveMaxPairwiseProduct.getMaxPairwiseProduct(input);
            if (result != naiveResult) {
                throw new IllegalStateException(
                        String.format("Solutions differed %d versus %d for input %s", result, naiveResult, Arrays.toString(input))
                );
            }
        }
    }

    private int[] initializeRandomArray(final int minLength, final int maxLength, final int minValue, final int maxValue) {
        final int length = Fixture.getRandomInt(minLength, maxLength);
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Fixture.getRandomInt(minValue, maxValue);
        }
        return numbers;
    }

    private class NaiveMaxPairwiseProduct {

        public long getMaxPairwiseProduct(int[] numbers) {
            final int length = numbers.length;

            long maxValue = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    final long val1 = numbers[i];
                    final long val2 = numbers[j];
                    if (val1 * val2 > maxValue) {
                        maxValue = val1 * val2;
                    }
                }
            }

            return maxValue;
        }
    }
}
