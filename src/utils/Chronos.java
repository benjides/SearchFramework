package utils;

/**
 * Basic Class to count time
 */
public class Chronos {
    private static long startTime;

    /**
     * Initializes a timer
     */
    public static void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the timer and returns the result in milliseconds
     * @return long     Time taken
     */
    public static long stop() {
        return System.currentTimeMillis() - startTime;
    }

}
