package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

/**
 * Representation of a ChessPiece.
 */
public interface IChessPiece {

  /**
   * Gets the <code>IChessSquare</code> the piece is on.
   * @return a <code>IChessSquare</code> object
   */
  IChessSquare getSquare();

  /**
   * Gets a list of the possible moves the piece can make given the
   * chess board the piece is on. Ensures that the given board contains this
   * piece on this piece's square.
   * @param chessBoard the board to find all the possible moves.
   * @return A list of <code>IChessSquare</code> representing the list of possible moves.
   * @throws IllegalStateException if given board doesn't contain this piece on its square.
   */
  List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException;

}