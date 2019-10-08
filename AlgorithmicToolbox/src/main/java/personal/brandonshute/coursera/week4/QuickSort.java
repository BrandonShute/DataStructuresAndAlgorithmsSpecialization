package personal.brandonshute.coursera.week4;

import java.io.*;
import java.util.*;

/**
 * This class implements the Quick sort algorithm with a 3-way partition.
 */
public class QuickSort {

    private static Random random = new Random();


    /**
     * Sorts an array in non-descending order in place.
     *
     * @param array The array to be sorted.
     */
    public static void sort(int[] array) {
        randomizedQuickSort(array, 0, array.length - 1);
    }

    private static void randomizedQuickSort(int[] array, final int lowerIndex, final int upperIndex) {
        if (lowerIndex >= upperIndex) {
            return;
        }

        final int randomStartingIndex = random.nextInt(upperIndex - lowerIndex + 1) + lowerIndex;
        final int startingValue = array[randomStartingIndex];
        array[randomStartingIndex] = array[lowerIndex];
        array[lowerIndex] = startingValue;

        int[] partitionIndices = partition3(array, lowerIndex, upperIndex);
        randomizedQuickSort(array, lowerIndex, partitionIndices[0] - 1);
        randomizedQuickSort(array, partitionIndices[1] + 1, upperIndex);
    }

    private static int[] partition3(int[] array, final int lowerIndex, final int upperIndex) {
        final int value = array[lowerIndex];
        int lowerValuesEndIndex = lowerIndex;
        int higherValuesStartIndex = upperIndex;
        for (int i = lowerIndex + 1; i <= higherValuesStartIndex; i++) {
            if (value > array[i]) {
                switchElements(array, lowerValuesEndIndex, i);
                lowerValuesEndIndex++;
            } else if (value < array[i]) {
                switchElements(array, i, higherValuesStartIndex);
                higherValuesStartIndex--;
                // Do not increase i in this case because we just moved the last value back to i so it will need to be
                // compared again (However, we no longer have to compare the last value which is why we have
                // i <= higherValuesStartIndex)
                i--;
            }
        }

        return new int[]{lowerValuesEndIndex, higherValuesStartIndex};
    }

    private static void switchElements(int[] array, final int index1, final int index2) {
        final int index1TempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = index1TempValue;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        sort(a);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

