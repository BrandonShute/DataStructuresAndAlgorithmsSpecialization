package personal.brandonshute.coursera.week5;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Edit Distance problem under the week 5 assignment.
 */
class EditDistance {

	public static int calculate(final String string1, final String string2) {
		int[][] editDistanceMatrix = getInitialMatrix(string1, string2);
		for (int i = 1; i <= string1.length(); i++) {
			for (int j = 1; j <= string2.length(); j++) {
				// Copy to final variable to use in lambda functions
				final int index1 = i;
				final int index2 = j;
				// This is one less because the matrix starts with no letter case
				final int indexOfString1 = index1 - 1;
				final int indexOfString2 = index2 - 1;

				 editDistanceMatrix[i][j] = getAllowableOperations(string1.charAt(indexOfString1), string2.charAt(indexOfString2))
						 .map(opt -> getValue(opt, index1, index2, editDistanceMatrix))
						 .min(Comparator.comparingInt(Integer::intValue))
						 .orElseThrow(() -> new IllegalStateException(String.format(
						 		"Stream is empty, no operation must have been found for index %d and %d for input string %s and %s",
								 indexOfString1,
								 indexOfString2,
								 string1,
								 string2
						 )));
			}
		}

		return editDistanceMatrix[string1.length()][string2.length()];
	}

	private static int[][] getInitialMatrix(final String string1, final String string2) {
		int[][] editDistanceMatrix = new int[string1.length() + 1][string2.length() + 1];
		for (int i = 0; i <= string1.length(); i++) {
			editDistanceMatrix[i][0] = i;
		}
		for (int j = 0; j <= string2.length(); j++) {
			editDistanceMatrix[0][j] = j;
		}
		return editDistanceMatrix;
	}

	private static Stream<EditOperation> getAllowableOperations(final char string1Char, final char string2Char) {
		if (string1Char == string2Char) {
			return Stream.of(EditOperation.MATCH, EditOperation.DELETION, EditOperation.INSERTION);
		} else {
			return Stream.of(EditOperation.SUBSTITUTION, EditOperation.DELETION, EditOperation.INSERTION);
		}
	}

	private static int getValue(final EditOperation operation, final int currentRow, final int currentColumn, final int[][] editDistanceMatrix) {
		switch (operation) {
			case MATCH:
			case SUBSTITUTION:
				return editDistanceMatrix[currentRow - 1][currentColumn - 1] + operation.getCost();
			case INSERTION:
				return editDistanceMatrix[currentRow - 1][currentColumn] + operation.getCost();
			case DELETION:
				return editDistanceMatrix[currentRow][currentColumn - 1] + operation.getCost();
			default:
				throw new IllegalArgumentException(String.format("Unknown edit operation type: %s", operation.toString()));
		}
	}

	public static void main(String args[]) {
		final Scanner scan = new Scanner(System.in);

		final String string1 = scan.next();
		final String string2 = scan.next();

		System.out.println(calculate(string1, string2));
	}

	private enum EditOperation {
		MATCH(0),
		DELETION(1),
		INSERTION(1),
		SUBSTITUTION(1);

		private final int cost;

		EditOperation(final int cost) {
			this.cost = cost;
		}

		private int getCost() {
			return this.cost;
		}
	}

}
