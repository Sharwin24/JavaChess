package model;

import java.util.HashMap;

public class Utility {

  private static final HashMap<Integer, String> fileMap = new HashMap<>();

  public Utility() {
    fileMap.put(1,"a");
    fileMap.put(2,"b");
    fileMap.put(3,"c");
    fileMap.put(4,"d");
    fileMap.put(5,"e");
    fileMap.put(6,"f");
    fileMap.put(7,"g");
    fileMap.put(8,"h");
  }

  public static String fileLetter(int file) throws IndexOutOfBoundsException{
    if (!inBounds(file,1,8)) {
      throw new IndexOutOfBoundsException("File out of bounds. Range: [1,8]");
    }
    return fileMap.get(file);
  }

  public static boolean inBounds(double toCheck, double lowerBound, double upperBound) {
    return toCheck >= lowerBound && toCheck <= upperBound;
  }

}