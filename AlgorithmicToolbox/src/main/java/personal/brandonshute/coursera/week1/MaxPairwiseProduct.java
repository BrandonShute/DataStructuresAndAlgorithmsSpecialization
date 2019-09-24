package personal.brandonshute.coursera.week1;

import java.util.*;
import java.io.*;

/**
 * Week 1 assignment 2. Design a program to provide the maximum pairwise product given a list of integers provided to
 * the standard input (Eg. given 1, 2, 4, 5, 3 then output 4 * 5 = 20)
 */
public class MaxPairwiseProduct {

    // Problem constraints
    protected static final int MIN_ARRAY_SIZE = 2;
    protected static final int MAX_ARRAY_SIZE = 200_000;
    protected static final int MIN_ALLOWABLE_VALUE = 0;
    protected static final int MAX_ALLOWABLE_VALUE = 200_000;

    public static long getMaxPairwiseProduct(int[] numbers) {
        if (numbers.length < MIN_ARRAY_SIZE || numbers.length > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException(
                    String.format("The array of numbers must be between %d and %d", MIN_ARRAY_SIZE, MAX_ARRAY_SIZE)
            );
        }
        // Pass in -1 so no indices are ignored
        final int largestIndex = getMaxIndex(numbers, -1);
        final int secondLargestIndex = getMaxIndex(numbers, largestIndex);

        // Cast to long to avoid integer overflow
        final long largest = numbers[largestIndex];
        final long secondLargest = numbers[secondLargestIndex];

        return largest * secondLargest;
    }


    private static int getMaxIndex(final int[] numbers, final int indexToIgnore) {
        int maxValue = -1;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < MIN_ALLOWABLE_VALUE || numbers[i] > MAX_ALLOWABLE_VALUE) {
                throw new IllegalArgumentException(String.format("Values must be non-negative but %d was received"));
            }
            if (i != indexToIgnore && numbers[i] > maxValue) {
                maxIndex = i;
                maxValue = numbers[i];
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
