package model.utility;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import model.chessboard.IChessSquare;

/**
 * Utility class for general utility functions
 */
public final class Utils {

  public static boolean inBounds(double toCheck, double lowerBound, double upperBound) {
    return toCheck >= lowerBound && toCheck <= upperBound;
  }

  public static <X> List<X> filter(List<X> toFilter, Predicate<X> filterWith) {
    List<X> filtered = new ArrayList<>();

    for(X x : toFilter) {
      if (filterWith.test(x)) {
        filtered.add(x);
      }
    }

    return filtered;
  }
}