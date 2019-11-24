package personal.brandonshute.coursera;

import java.util.Random;

public class Fixture {

    public static final int SECOND = 1000;
    public static final int DEFAULT_STRESS_TEST_RUN_TIME = 20 * SECOND;

    // Java program constraint
    public static final double MAX_ALLOWABLE_CALCULATION_TIME = 1.5 * SECOND;

    /**
     * Gets a random {@code int} between the {@code minValue} and {@code maxValue} inclusively.
     * @param minValue The minimum possible value of the int.
     * @param maxValue The maximum possible value of the int.
     * @return A random int between the passed values.
     */
    public static int getRandomInt(final int minValue, final int maxValue) {
        Random r = new Random();
        return r.nextInt((maxValue - minValue) + 1) + minValue;
    }

	/**
	 * Initialize a random list of {@code int} values between {@code minValue} and {@code maxValue} with a size between
	 * {@code minLength} and {@code maxLength}.
	 *
	 * @param minLength The minimum length of the list.
	 * @param maxLength The maximum length of the list.
	 * @param minValue The minimum value for any given  {@code int} in the array.
	 * @param maxValue The maximum value for any given  {@code int} in the array.
	 * @return A list of {@code int} with the passed specifications.
	 */
	public static int[] initializeRandomList(final int minLength, final int maxLength, final int minValue, final int maxValue) {
		final int length = getRandomInt(minLength, maxLength);
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = getRandomInt(minValue, maxValue);
		}
		return numbers;
	}

	/**
	 * Initialize a random list of {@code int} values between {@code minValue} and {@code maxValue} with a length {@code length}.
	 *
	 * @param length The length of the list.
	 * @param minValue The minimum value for any given  {@code int} in the array.
	 * @param maxValue The maximum value for any given  {@code int} in the array.
	 * @return A list of {@code int} with the passed specifications.
	 */
	public static int[] initializeRandomList(final int length, final int minValue, final int maxValue) {
		return initializeRandomList(length, length, minValue, maxValue);
	}

}
