package personal.brandonshute.coursera;

import java.util.Random;

public class Fixture {

    public static final int SECOND = 1000;
    public static final int DEFAULT_STRESS_TEST_RUN_TIME = 20 * SECOND;

    // Java program constraint
    public static final double MAX_ALLOWABLE_CALCULATION_TIME = 1.5 * Fixture.SECOND;

    /**
     * Gets a random {@code int} between the {@code minValue} and {@code maxValue} inclusively.
     * @param minValue The minimum possible value of the int.
     * @param maxValue The maximum possible value of the int.
     * @return A random int between the passed values.
     */
    public static int getRandomInt(final int minValue, final int maxValue) {
        Random r = new Random();
        return r.nextInt((maxValue - minValue) + 1) + minValue;
    }

}
