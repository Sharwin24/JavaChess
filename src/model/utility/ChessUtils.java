package model.utility;

import java.util.HashMap;

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

}