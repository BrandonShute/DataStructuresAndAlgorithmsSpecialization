package personal.brandonshute.coursera.week5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Calculates the minimum number of coins/bills required for an amount of change. This overcomes issues in the original
 * version for denominations where a greedy algorithm will not suffice. The example scenario here is when coins/bills
 * have a value of 1, 3, 4. Then in the case of 6, the greedy algorithm would return 3 coins/bills (4, 1, 1) whereas the
 * correct solution is 2 (3, 3).
 */
public class MoneyChangeV2 {
    
    private static final List<Integer> coinValues = Stream.of(1, 3, 4).collect(Collectors.toList());

    protected static final int MIN_CHANGE = 0;

    // Problem constraints
    protected static final int MAX_CHANGE = 1000;

    // Deals with cases when the amount to be changed cannot be represented by a number of coins. For example, if 2 was
    // passed in and the coinValues didn't contain 1 or 2.
    public static final int UNABLE_TO_CHANGE = -1;

    public static int getChange(final int amountToChange) {
        if (amountToChange <= MIN_CHANGE) {
            return 0;
        }

        int[] values = new int[amountToChange];

        for (int i = 0; i < amountToChange; i++) {
            final int targetValue = i + 1;
            final List<Integer> validCoinsToAdd = getValidCoins(targetValue);
            final int numCoinsRequired = validCoinsToAdd.stream()
                    .map(coinVal -> getNumberOfCoins(targetValue, coinVal.intValue(), values))
                    .min(Integer::compareTo)
                    .orElseGet(() -> UNABLE_TO_CHANGE);

            values[i] = numCoinsRequired;
        }

        return values[amountToChange - 1];
    }
    
    private static List<Integer> getValidCoins(final int targetValue) {
        return coinValues.stream()
                .filter(coinValue -> coinValue.intValue() <= targetValue)
                .collect(Collectors.toList());
    }

    private static int getNumberOfCoins(final int targetValue, final int coinValue, final int[] previousValues) {
        return (coinValue == targetValue) ? 1 : previousValues[targetValue - coinValue - 1] + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

    /**
     * Money object to represent the a denomination of money.
     */
    private class Money {

        private final int value;

        private Money(final int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}

