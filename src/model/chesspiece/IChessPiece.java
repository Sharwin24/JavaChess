package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;

/**
 * Representation of a ChessPiece.
 */
public interface IChessPiece {

  /**
   * Gets the <code>IChessSquare</code> the piece is on.
   * @return
   */
  IChessSquare getSquare();

  /**
   * Gets a list of the possible moves the piece can make mechanically.
   * Does <b>NOT</b> regard legality, and only if the piece <i>could</i>
   * move there via it's mechanics will it be included within the list.
   * @return A list of <code>IChessSquare</code> representing the list of possible moves.
   */
  List<IChessSquare> possibleMoves();

}