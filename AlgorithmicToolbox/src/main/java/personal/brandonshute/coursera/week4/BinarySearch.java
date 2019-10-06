package personal.brandonshute.coursera.week4;

import java.io.*;
import java.util.*;

/**
 * A simple binary search algorithm where the input array is already sorted in increasing order and a_i != a_j for all
 * i and j in 0, 1, ..., n (Problem constraint).
 */
public class BinarySearch {

    // Problem constrains
    final static int MAX_ARRAY_SIZE = 10_000;

    public static int binarySearch(final int[] array, final int valueToFind) {
        if (array.length == 0) {
            return -1;
        }
        return binarySearch(array, valueToFind, 0, array.length - 1);
    }

    private static int binarySearch(final int[] array, final int valueToFind, final int startIndex, final int endIndex) {
        if (endIndex < startIndex) {
            return -1;
        }

        final int mid = (endIndex - startIndex) / 2 + startIndex;

        if (array[mid] < valueToFind) {
            return binarySearch(array, valueToFind, mid + 1, endIndex);
        } else if (array[mid] > valueToFind) {
            return binarySearch(array, valueToFind, startIndex, mid - 1);
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
            System.out.print(binarySearch(a, b[i]) + " ");
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
