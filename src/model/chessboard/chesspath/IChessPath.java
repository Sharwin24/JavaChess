package model.chessboard.chesspath;

import java.util.List;
import model.chessboard.IChessSquare;

/**
 * Representation of a path on a chess board. The interface offers functionality to get the start
 * and stop square of the path, as well as the squares on that path.
 */
public interface IChessPath {

  /**
   * Gets the starting square for the path.
   *
   * @return an {@link IChessSquare} for the starting square.
   */
  IChessSquare getStartingSquare();

  /**
   * Gets the final square for the path. Could return null if the path is invalid.
   *
   * @return an {@link IChessSquare} for the ending square.
   */
  IChessSquare getDestinationSquare();

  /**
   * Gets the path as a list of squares. The list contains in order every square after the start
   * square until the destination square. If the path is out of bounds or is obstructed by its own
   * piece or is after an able-to-be-captured piece, then the path will be empty.
   *
   * @return a list of Squares, in order of the path.
   */
  List<IChessSquare> getPathOrder();

  /**
   * Determines if this path is valid or not. If it's invalid, the pathOrder will be empty and the
   * destination square will be null. A valid path is one that:
   * <ul>
   *   <li>Does not go out of bounds</li>
   *   <li>Does not capture it's own piece</li>
   *   <li>Does not move through another piece</li>
   *   <li>Has the correct movement mechanic</li>
   * </ul>
   *
   * @return a boolean whether the path is valid or not.
   */
  boolean invalidPath();

  /**
   * Gets the deviation of the file from the starting square.
   *
   * @return an integer representing the change in file
   */
  int getFileDelta();

  /**
   * Gets the deviation of the rank from the starting square.
   *
   * @return an integer representing the change in rank
   */
  int getRankDelta();

}