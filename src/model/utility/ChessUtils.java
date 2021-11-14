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
    fileMap.put(1, "a");
    fileMap.put(2, "b");
    fileMap.put(3, "c");
    fileMap.put(4, "d");
    fileMap.put(5, "e");
    fileMap.put(6, "f");
    fileMap.put(7, "g");
    fileMap.put(8, "h");
  }

  public static String fileLetter(int file) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file, 1, 8)) {
      throw new IndexOutOfBoundsException("File out of bounds. Range: [1,8]");
    }
    return fileMap.get(file);
  }

  /**
   * Maps a unary function <code>mapperFunc</code> on every square in a 2D list of squares
   * <code>toMapOn</code>.
   * @param toMapOn the list to map a function on, with signature mapperFunc :: IChessSquare -> Y
   * @param mapperFunc a well-defined unary function to apply to all squares in the list
   * @param <Y> the result of the mapperFunc call
   * @return a 2D array of the same size as <code>toMapOn</code> (64), of type Y.
   */
  public static <Y> List<List<Y>> boardMap(List<List<IChessSquare>> toMapOn,
      Function<IChessSquare, Y> mapperFunc) {
    List<List<Y>> mappedResult = new ArrayList<>();

    for (int i = 0; i <  8; i++) {
      List<Y> thisRow = new ArrayList<>();
      for (int j = 0; j < 8; j++) {
        thisRow.add(mapperFunc.apply(toMapOn.get(i).get(j)));
      }
      mappedResult.add(thisRow);
    }

    return mappedResult;
  }
  
}