package personal.brandonshute.coursera.week5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Primitive calculator problem under the week 5 assignment.
 */
public class PrimitiveCalculator {

    public static List<Integer> getOptimalSequence(final int value) {
    	if (value == 1) {
    		return Stream.of(1).collect(Collectors.toList());
		}

    	// Setup initial values
    	Map<Integer, Integer> valueToNumOperations = new HashMap<>();
    	valueToNumOperations.put(1, 0);
    	valueToNumOperations.put(2, 1);

    	Map<Integer, Integer> valueToPreviousValue = new HashMap<>();
		valueToPreviousValue.put(1, -1);
		valueToPreviousValue.put(2, 1);

    	for (Integer i = 3; i <= value; i++) {
    		final Integer currentValue = i;
    		final Calculation calcToApply = getValidCalculations(i).stream()
					.map((calc) -> new AbstractMap.SimpleImmutableEntry<>(
							calc, valueToNumOperations.get(calc.applyInverse(currentValue))
					))
					.min(Comparator.comparing(Map.Entry::getValue))
					.get()
					.getKey();

			final Integer previousValue = calcToApply.applyInverse(currentValue);
			final Integer previousNumOperations = valueToNumOperations.get(previousValue);

    		valueToNumOperations.put(i, previousNumOperations + 1);
    		valueToPreviousValue.put(i, previousValue);
		}

		return getFullSequenceFromMap(valueToPreviousValue);
    }

    private static List<Calculation> getValidCalculations(final Integer value) {
    	List<Calculation> validCalculations = new ArrayList<>();
    	validCalculations.add(Calculation.ADD_1);
    	if (value % 2 == 0) {
    		validCalculations.add(Calculation.MULTIPLY_2);
		}
		if (value % 3 == 0) {
			validCalculations.add(Calculation.MULTIPLY_3);
		}
		return validCalculations;
	}

	private static List<Integer> getFullSequenceFromMap(final Map<Integer, Integer> valueToPreviousValue) {
		Integer currentValue = valueToPreviousValue.size();
		List<Integer> optimalSequence = new ArrayList<>();
		while (currentValue >= 1) {
			optimalSequence.add(currentValue);
			currentValue = valueToPreviousValue.get(currentValue);
		}
		Collections.reverse(optimalSequence);
		return optimalSequence;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = getOptimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

    private enum Calculation {
		MULTIPLY_3((value) -> value / 3),
		MULTIPLY_2((value) -> value / 2),
		ADD_1((value) -> value - 1);

		private final Function<Integer, Integer> inverseFunction;

		Calculation(final Function<Integer, Integer> inverseFunction) {
			this.inverseFunction = inverseFunction;
		}

		private Integer applyInverse(final Integer input) {
			return this.inverseFunction.apply(input);
		}
	}
}

