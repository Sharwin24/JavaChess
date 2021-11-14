package model.utility;

import java.util.HashMap;

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

  public static String fileLetter(int file) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file, 0, 7)) {
      throw new IndexOutOfBoundsException("File out of bounds. Range: [0,7]");
    }
    return fileMap.get(file);
  }

}