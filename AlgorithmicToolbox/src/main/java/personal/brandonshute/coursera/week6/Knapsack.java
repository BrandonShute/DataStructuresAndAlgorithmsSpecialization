package personal.brandonshute.coursera.week6;

import java.util.*;

/**
 * This class is used to determine the maximum weight of items that can be added to a bag where a bag can support a
 * maximum fixed weight W and each item has an associated weight, w_x.
 *
 * Therefore, the goal is to find the items such that w_1 + w_2 + ... + w_m is maximized and w_1 + w_2 + ... w_m <= W.
 */
public class Knapsack {

    public static int getOptimalWeight(final int weightLimit, final int[] elementWeights) {
    	final int numElements = elementWeights.length;

		// Results matrix with the weight limit of the sub problem as the rows and the number of elements used as the columns
        final int[][] results = new int[weightLimit + 1][numElements + 1];

        for (int currentElementIndex = 0; currentElementIndex < numElements; currentElementIndex++) {
        	final int resultsElementIndex = currentElementIndex + 1;
        	final int elementWeight = elementWeights[currentElementIndex];
        	for (int currentWeightLimit = 1; currentWeightLimit <= weightLimit; currentWeightLimit++) {
				final int weightWithoutElement = results[currentWeightLimit][resultsElementIndex - 1];
				results[currentWeightLimit][resultsElementIndex] = weightWithoutElement;
        		if (elementWeight <= currentWeightLimit) {
					final int weightWithElement = results[currentWeightLimit - elementWeight][resultsElementIndex - 1] + elementWeight;
					if (weightWithElement > weightWithoutElement) {
						results[currentWeightLimit][resultsElementIndex] = weightWithElement;
					}
				}
			}
		}
        return results[weightLimit][numElements];
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int weightLimit = scanner.nextInt();
        final int numElements = scanner.nextInt();
        final int[] elementWeights = new int[numElements];
        for (int i = 0; i < numElements; i++) {
			elementWeights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalWeight(weightLimit, elementWeights));
    }
}

