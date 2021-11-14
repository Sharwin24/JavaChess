package model.utility;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Utility class for general utility functions
 */
public final class Utils {

  /**
   * Determines if the given number is in between the given range (inclusive)
   * @param toCheck the number to check
   * @param lowerBound the lower bound of the range
   * @param upperBound the upper bound of the range
   * @return a boolean whether the number is in bounds or not
   */
  public static boolean inBounds(double toCheck, double lowerBound, double upperBound) {
    return toCheck >= lowerBound && toCheck <= upperBound;
  }

  /**
   * Filters the list <code>toFilter</code> to return a list consisting of only the elements that
   * return <code>true</code> for the <code>Predicate</code> function <code>filterWith</code>.
   * @param toFilter the list to filter
   * @param filterWith the predicate by which to filter the list
   * @param <X> the type of elements in the list to be filtered
   * @return a <code>List</code> of type <code>X</code> consisting of elements that return
   * <code>true</code> for the predicate function <code>filterWith</code>.
   */
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