package model.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import model.chessboard.IChessSquare;

/**
 * Utility class for Chess Utility functions
 */
public final class ChessUtils {

  private static final HashMap<Integer, String> fileMap
      = new HashMap<>(8);

  public ChessUtils() {
    fileMap.put(0, "a");
    fileMap.put(1, "b");
    fileMap.put(2, "c");
    fileMap.put(3, "d");
    fileMap.put(4, "e");
    fileMap.put(5, "f");
    fileMap.put(6, "g");
    fileMap.put(7, "h");
  }

  /**
   * Gets the file letter as a string given the index. Throws an exception if the index is out of
   * bounds
   *
   * @param file the index of the file
   * @return a string representing the letter of that file (examples: 0 -> "a", 1 -> "b", 7 -> "h")
   * @throws IndexOutOfBoundsException if the index is out of bounds (zero-indexed)
   */
  public static String fileLetter(int file) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file, 0, 7)) {
      throw new IndexOutOfBoundsException("File out of bounds. Range: [0,7]");
    }
    return fileMap.get(file);
  }

  /**
   * Maps a unary function <code>mapperFunc</code> on every square in a 2D list of squares
   * <code>toMapOn</code>.
   *
   * @param toMapOn    the list to map a function on, with signature mapperFunc :: IChessSquare ->
   *                   Y
   * @param mapperFunc a well-defined unary function to apply to all squares in the list
   * @param <Y>        the result of the mapperFunc call
   * @return a 2D array of the same size as <code>toMapOn</code> (64), of type Y.
   */
  public static <Y> List<List<Y>> boardMap(List<List<IChessSquare>> toMapOn,
      Function<IChessSquare, Y> mapperFunc) {
    List<List<Y>> mappedResult = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      List<Y> thisRow = new ArrayList<>();
      for (int j = 0; j < 8; j++) {
        thisRow.add(mapperFunc.apply(toMapOn.get(i).get(j)));
      }
      mappedResult.add(thisRow);
    }

    return mappedResult;
  }

}