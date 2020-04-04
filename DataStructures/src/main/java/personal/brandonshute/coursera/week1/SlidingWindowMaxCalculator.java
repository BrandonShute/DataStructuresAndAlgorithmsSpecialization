package personal.brandonshute.coursera.week1;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Question 5 from assignment 1. Calculate the maximum in a sliding window on a list of values.
 */
public class SlidingWindowMaxCalculator {

	/**
	 * Given a list of values and the window size, calculate the maximum in each window of the list. (eg. If values
	 * were [5, 6, 2, 4, 3] and window size was 3, then the output would be [6, 6, 4] since max(5, 6, 2) = 6,
	 * max(6, 2, 4) = 6, and max(2, 4, 3) = 4.
	 *
	 * @param values     The values used to calculate the max
	 * @param windowSize The size of the sliding window
	 * @return A list of maxes for each window in the values
	 */
	public static int[] getMaxes(final int[] values, final int windowSize) {
		final int[] results = new int[values.length - windowSize + 1];
		final int[] firstWindow = new int[windowSize];
		for (int i = 0; i < windowSize; i++) {
			firstWindow[i] = values[i];
		}
		final SlidingWindow slidingWindow = new SlidingWindow(firstWindow);
		results[0] = slidingWindow.getCurrentMax();
		for (int i = windowSize; i < values.length; i++) {
			slidingWindow.add(values[i]);
			results[i - windowSize + 1] = slidingWindow.getCurrentMax();
		}

		return results;
	}

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int numValues = scanner.nextInt();
		int[] values = new int[numValues];
		for (int i = 0; i < numValues; i++) {
			values[i] = scanner.nextInt();
		}
		final int windowSize = scanner.nextInt();
		final int[] maxes = getMaxes(values, windowSize);
		System.out.println(IntStream.of(maxes).mapToObj(Objects::toString).collect(Collectors.joining(" ")));
	}

	public static class SlidingWindow {

		/**
		 * The values in the current window
		 */
		private ArrayDeque<Integer> windowValues;
		/**
		 * The queue of maximum values (When a new value is added, always remove all smaller values to the left)
		 */
		private ArrayDeque<Integer> maxes;


		/**
		 * Default constructor
		 *
		 * @param initialValues The first sliding window of values
		 */
		public SlidingWindow(final int[] initialValues) {
			this.windowValues = new ArrayDeque<>();
			this.maxes = new ArrayDeque<>();
			for (int i = 0; i < initialValues.length; i++) {
				final int value = initialValues[i];
				this.windowValues.addLast(value);
				addToMax(value);
			}
		}

		/**
		 * Adds the new value to the sliding window and removes the
		 *
		 * @param value
		 */
		public void add(final int value) {
			this.windowValues.addLast(value);

			final int removedValue = this.windowValues.removeFirst();
			if (removedValue == getCurrentMax()) {
				this.maxes.removeFirst();
			}
			addToMax(value);
		}

		/**
		 * Get the current maximum value in the window
		 *
		 * @return The maximum value
		 */
		public int getCurrentMax() {
			return this.maxes.peekFirst();
		}

		private void addToMax(final int value) {
			while (!this.maxes.isEmpty() && this.maxes.peekLast() < value) {
				this.maxes.removeLast();
			}
			this.maxes.add(value);
		}
	}
}
