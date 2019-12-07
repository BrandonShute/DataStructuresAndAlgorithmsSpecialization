package personal.brandonshute.coursera.week5;

import java.util.*;
import java.util.stream.Stream;

/**
 * Longest Common Subsequence problem under the week 5 assignment. This is very similar to Edit Distance but since I
 * think there is an issue with the grader and Primitive Calculator is not accepted, I will submit this as well. In an
 * ideal world, I would be able to re-use code but since I am submitting a single file to the grader, it is not possible.
 */
public class LongestCommonSubsequence {

    public static int getLength(final int[] list1, final int[] list2) {
        int[][] matchMatrix = getInitialMatrix(list1, list2);
        for (int i = 1; i <= list1.length; i++) {
            for (int j = 1; j <= list2.length; j++) {
                // Copy to final variable to use in lambda functions
                final int index1 = i;
                final int index2 = j;
                // This is one less because the matrix starts with no int case
                final int indexOfVal1 = index1 - 1;
                final int indexOfVal2 = index2 - 1;

                matchMatrix[i][j] = getAllowableOperations(list1[indexOfVal1], list2[indexOfVal2])
                        .map(opt -> getValue(opt, index1, index2, matchMatrix))
                        .max(Comparator.comparingInt(Integer::intValue))
                        .orElseThrow(() -> new IllegalStateException(String.format(
                                "Stream is empty, no operation must have been found for index %d and %d for input string %s and %s",
                                indexOfVal1,
                                indexOfVal2,
                                list1,
                                list2
                        )));
            }
        }
        return matchMatrix[list1.length][list2.length];
    }

    private static int[][] getInitialMatrix(final int[] list1, final int[] list2) {
        int[][] matchMatrix = new int[list1.length + 1][list2.length + 1];
        for (int i = 0; i <= list1.length; i++) {
            matchMatrix[i][0] = 0;
        }
        for (int j = 0; j <= list2.length; j++) {
            matchMatrix[0][j] = 0;
        }
        return matchMatrix;
    }

    private static Stream<Operation> getAllowableOperations(final int val1, final int val2) {
        if (val1 == val2) {
            return Stream.of(Operation.MATCH);
        } else {
            return Stream.of(Operation.DELETION, Operation.INSERTION);
        }
    }

    private static int getValue(final Operation operation, final int currentRow, final int currentColumn, final int[][] matchMatrix) {
        switch (operation) {
            case MATCH:
                return matchMatrix[currentRow - 1][currentColumn - 1] + operation.getValue();
            case INSERTION:
                return matchMatrix[currentRow - 1][currentColumn] + operation.getValue();
            case DELETION:
                return matchMatrix[currentRow][currentColumn - 1] + operation.getValue();
            default:
                throw new IllegalArgumentException(String.format("Unknown edit operation type: %s", operation.toString()));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(getLength(a, b));
    }

    private enum Operation {
        MATCH(1),
        DELETION(0),
        INSERTION(0);

        private final int value;

        Operation(final int value) {
            this.value = value;
        }

        private int getValue() {
            return this.value;
        }
    }
}

