package personal.brandonshute.coursera.week3;

import java.util.Scanner;

/**
 * Calculates the minimum number of coins required for an amount of change.
 */
public class MoneyChange {

	private static final Coin[] ORDERED_COINS = new Coin[] {
			Coin.PENNY, Coin.NICKLE, Coin.DIME
	};

	protected static final int MIN_CHANGE = 0;

	// Problem constraints
	protected static final int MAX_CHANGE = 1000;

    public static int getChange(final int amountToChange) {
        if (amountToChange <= MIN_CHANGE) {
        	return 0;
		}

        final Coin nextCoin = getNextCoin(amountToChange);
		return 1 + getChange(amountToChange - nextCoin.getValue());
    }

    private static Coin getNextCoin(final int amountToChange) {
    	for (int i = ORDERED_COINS.length - 1; i >= 0 ; i--) {
    		if (amountToChange >= ORDERED_COINS[i].getValue()) {
    			return ORDERED_COINS[i];
			}
		}
    	throw new IllegalArgumentException(String.format("Cannot find a small enough coin to change: %d", amountToChange));
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }


	/**
	 * Enum to represent a coin object with it's associated value.
	 */
	private enum Coin {
    	PENNY(1),
		NICKLE(5),
		DIME(10);

    	private final int value;

    	private Coin(final int value) {
    		this.value = value;
		}

		public int getValue() {
    		return this.value;
		}
	}
}

