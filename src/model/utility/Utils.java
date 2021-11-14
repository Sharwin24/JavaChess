package model.utility;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import model.chessboard.IChessSquare;

/**
 * Utility class for general utility functions
 */
public final class Utils {

  public static boolean inBounds(double toCheck, double lowerBound, double upperBound) {
    return toCheck >= lowerBound && toCheck <= upperBound;
  }


}