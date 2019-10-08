package personal.brandonshute.coursera.week4;

import java.io.*;
import java.util.*;

/**
 * A simple binary search algorithm where the input array is already sorted in non-descending order and a_i != a_j for
 * all i and j in 0, 1, ..., n (Problem constraint).
 */
public class BinarySearch {

    /***
     * Given a non-descending array of positive {@code int} object, find the index of a value in the array.
     *
     * @param array The array to search for the element in.
     * @param valueToFind The value that needs to be found in the array.
     * @return The index of the value in the array or -1 if it does not exist.
     */
    public static int search(final int[] array, final int valueToFind) {
        if (array.length == 0) {
            return -1;
        }
        return search(array, valueToFind, 0, array.length - 1);
    }

    private static int search(final int[] array, final int valueToFind, final int startIndex, final int endIndex) {
        if (endIndex < startIndex) {
            return -1;
        }

        final int mid = (endIndex - startIndex) / 2 + startIndex;

        if (array[mid] < valueToFind) {
            return search(array, valueToFind, mid + 1, endIndex);
        } else if (array[mid] > valueToFind) {
            return search(array, valueToFind, startIndex, mid - 1);
        }

        return mid;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
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
        for (int i = 0; i < m; i++) {
            System.out.print(search(a, b[i]) + " ");
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
