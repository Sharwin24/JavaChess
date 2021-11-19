package model.chessboard;

import model.chesspiece.IChessPiece;
import model.utility.ChessUtils;

/**
 * Representation of a ChessSquare. Acts as a container that has the ability to contain an
 * <code>IChessPiece</code>
 */
public interface IChessSquare {

  /**
   * Gets the Square's color.
   * @return an <code>EChessColor</code> representing the color of the square.
   */
  ChessUtils.EChessColor getSquareColor();

  /**
   * Determines if the square has a piece on it or not.
   * @return a boolean whether the square has a piece on it.
   */
  boolean hasPiece();

  /**
   * Gets the piece on this square, returns <code>null</code> if square is empty.
   * @return an <code>IChessPiece</code>, or <code>null</code>.
   */
  IChessPiece getPiece();

  /**
   * Places the given <code>IChessPiece</code> on the square.
   * @throws IllegalArgumentException if there is already a piece on the square.
   * @param pieceToPlace the piece to place on the square.
   */
  void placePiece(IChessPiece pieceToPlace) throws IllegalArgumentException;

  /**
   * Removes the piece on the square, either a capture or move.
   * @throws IllegalStateException if the square is empty.
   */
  void removePiece() throws IllegalStateException;

  /**
   * Gets the file, or column, of the square. Indexing starts at 0.
   * @return an integer representing the column.
   */
  int getFile();

  /**
   * Gets the rank, or row, of the square. Indexing starts at 0.
   * @return an integer representing the row.
   */
  int getRank();

  EChessSquareStartingPiece determineStartPiece();
}