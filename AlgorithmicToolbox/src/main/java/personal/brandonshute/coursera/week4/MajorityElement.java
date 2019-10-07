package personal.brandonshute.coursera.week4;

import java.util.*;
import java.io.*;

/**
 * A program used to find the majority element in a given array. Although this is the divide and conquer unit, it was
 * mentioned that there is a faster algorithm for this problem than O(n*log(n)) and I wanted to solve it.
 */
public class MajorityElement {

    /**
     * Finds an element in the array which is a majority (appears strictly more than n/2 times). Note that this assumes
     * all of the elements are positive {@code int} objects or -1 may also be in the list.
     *
     * @param array The array to examine.
     * @return The element if a majority exists and -1 otherwise.
     */
    public static int getMajorityElement(final int[] array) {
        if (array.length == 0) {
            return -1;
        }

        final Map<Integer, Integer> elementMap = getElementToOccurrence(array);

        final Integer largestElement = elementMap.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue()))
                .get()
                .getKey();

        if (elementMap.get(largestElement) > (array.length / 2 )) {
            return largestElement.intValue();
        }

        // Could not find a majority element
        return -1;
    }

    private static Map<Integer, Integer> getElementToOccurrence(final int[] array) {
        Map<Integer, Integer> elementMap = new HashMap();
        for (int i = 0; i < array.length; i++) {
            final Integer element = array[i];
            final Integer occurrence = elementMap.getOrDefault(element, 0) + 1;
            elementMap.put(element, occurrence);
        }
        return elementMap;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

