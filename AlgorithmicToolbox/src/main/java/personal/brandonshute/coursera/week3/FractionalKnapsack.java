package personal.brandonshute.coursera.week3;

import java.util.*;

/**
 * This class is used to determine the most optimal value of items that can be added to a bag where a bag can support a
 * maximum fixed weight W and each item has an associated weight, w_x, and value, v_x. Any fraction of an item can be
 * added to the bag where the fractional value of the item would be (fraction / w_x) * v_x.
 *
 * Therefore, the goal is to find the items such that v_1, v_2, ..., v_n is maximized and w_1 + w_2 + ... w_n <= W.
 */
public class FractionalKnapsack {

	// Problem constraints
	protected static final int MIN_ITEMS = 0;
	protected static final int MAX_ITEMS = 1000;

	protected static final int MIN_BAG_WEIGHT = 0;
	protected static final int MAX_BAG_WEIGHT = 2_000_000;

	protected static final int MIN_ITEM_WEIGHT = 0;
	protected static final int MAX_ITEM_WEIGHT = 2_000_000;

	protected static final int MIN_ITEM_VALUE = 0;
	protected static final int MAX_ITEM_VALUE = 2_000_000;


    public static double getOptimalValue(final int capacity, final int[] values, final int[] weights) {
		isBagValueBounded(values, weights);
        if (capacity <= MIN_BAG_WEIGHT) {
        	return 0.0;
		}

        ArrayList<Item> orderedItems = getOrderedItems(values, weights);

        double value = 0;
        int remainingCapacity = capacity;
        while (remainingCapacity > 0 && orderedItems.size() > 0) {
        	final Item nextItem = orderedItems.remove(0);
        	if (nextItem.weight <= remainingCapacity) {
        		value += nextItem.value;
				remainingCapacity -= nextItem.weight;
			} else {
        		value += remainingCapacity * nextItem.getPerUnitValue();
        		remainingCapacity = 0;
			}
		}

        return value;
    }

    // Technically problem constrains allow items to have zero weight and positive value but this would obviously cause
	// an infinite value for the bag so I will throw an exception for this for now to avoid infinite loop
	// (This shouldn't be a valid case)
    private static void isBagValueBounded(final int[] values, final int[] weights) {
		for (int i = 0; i < values.length; i++) {
			if (weights[i] == 0 && values[i] > 0) {
				throw new IllegalArgumentException(
						String.format("Item %d has 0 weight but positive value so the solution is unbounded", i)
				);
			}
		}
	}

	private static ArrayList<Item> getOrderedItems(final int[] values, final int[] weights) {
    	ArrayList<Item> items = new ArrayList();
    	for (int i = 0; i < values.length; i++) {
    		items.add(new Item(values[i], weights[i]));
		}
    	Collections.sort(items);
    	Collections.reverse(items);
    	return items;
	}

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

	private static class Item implements Comparable<Item> {

    	private int value;
		private int weight;

    	private Item(final int value, final int weight) {
    		this.value = value;
    		this.weight = weight;
		}

		private double getPerUnitValue() {
    		return ((double) this.value) / this.weight;
		}

		public int compareTo(Item objectToCompare) {
    		// Ignore null and type checking for now since this class is private
    		if (this.getPerUnitValue() > objectToCompare.getPerUnitValue()) {
    			return 1;
			} else if (this.getPerUnitValue() < objectToCompare.getPerUnitValue()) {
    			return -1;
			} else {
    			return 0;
			}
		}
	}
} 
