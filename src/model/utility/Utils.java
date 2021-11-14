package model.utility;

/**
 * Utility class for general utility functions
 */
public final class Utils {

  public static boolean inBounds(double toCheck, double lowerBound, double upperBound) {
    return toCheck >= lowerBound && toCheck <= upperBound;
  }
}