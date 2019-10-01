package personal.brandonshute.coursera.week3;

import java.util.*;

/**
 * This class determine the maximum number of positive integers, x_i, of a positive integer N such that the following
 * conditions hold:
 *
 * 1) x_1 + x_2 + .... + x_m = N
 * 2) x_i < x_(i+1) for all i from 1 to m
 */
public class DifferentSummands {

	// Problem constraints
	protected static final int MIN_NUM = 1;
	protected static final int MAX_NUM = 1_000_000_000;

    public static List<Integer> getOptimalSummands(final int n) {
        List<Integer> summands = new ArrayList<Integer>();

        int currentValue = 1;
        int remainingValue = n;
        while (remainingValue > 0) {
        	final int nextValue = currentValue + 1;
        	if (currentValue + nextValue <= remainingValue) {
				remainingValue -= currentValue;
				summands.add(currentValue);
				currentValue = nextValue;
			} else {
        		summands.add(remainingValue);
				remainingValue = 0;
			}
		}
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = getOptimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

