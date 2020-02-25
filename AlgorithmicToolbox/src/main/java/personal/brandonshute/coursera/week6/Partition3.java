package personal.brandonshute.coursera.week6;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Given a list of n integer values, v_1, v_2, ... v_n, determine if there is a way to find three partitions of equal
 * value. An attempt was made to make this generic for any amount of sub arrays.
 */
public class Partition3 {

	private static final int NUM_SUBSETS = 3;

	public static boolean canPartition(final int[] elementValues) {
		return canPartition(elementValues, NUM_SUBSETS);
	}


	public static boolean canPartition(final int[] elementValues, final int numSubsets) {
		if (elementValues.length < numSubsets) {
			return false;
		}

		final int sum = IntStream.of(elementValues).sum();
		if (sum % numSubsets != 0) {
			return false;
		}

		final int[] sumValues = new int[numSubsets];
		Arrays.fill(sumValues, sum / numSubsets);

		return canPartition(elementValues, 0, sumValues);
	}

	private static boolean canPartition(final int[] elementValues, final int currentElementIndex, final int[] sumValues) {
		if (IntStream.of(sumValues).allMatch(value -> value == 0)) {
			return true;
		}

		if (elementValues.length == 0) {
			return false;
		}

		final int currentElement = elementValues[currentElementIndex];

		boolean result = false;
		for (int i = 0; i < sumValues.length; i++) {
			final int sumValue = sumValues[i];
			if (!result && sumValue - currentElement >= 0) {
				sumValues[i] = sumValue - currentElement;
				result = canPartition(elementValues, currentElementIndex + 1, sumValues);
				// Back track to try the next combination
				sumValues[i] = sumValue;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final int numElements = scanner.nextInt();
		final int[] elementValues = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			elementValues[i] = scanner.nextInt();
		}

		System.out.println(canPartition(elementValues) ? 1 : 0);
	}
}

