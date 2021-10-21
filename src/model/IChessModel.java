package model;

import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesspiece.IChessPiece;

/**
 * Representation of a ChessModel. Offers functionality to play the game of Chess.
 * Supports <code>IChessPiece</code>, <code>IChessSquare</code>, and <code>IChessBoard</code>
 * representations of Chess elements.
 */
public interface IChessModel {

  /**
   * Initializes and resets the ChessBoard for the model. The game starts when
   * the board is reset.
   */
  void resetBoard();

  /**
   * Performs a Chess move using the given piece to the destination square. If the move
   * is illegal, then the method throws an exception.
   * @param pieceToMove the piece to move
   * @param destinationSquare the square to move the piece to
   * @throws IllegalArgumentException if the given move is illegal for any reason
   */
  void move(IChessPiece pieceToMove, IChessSquare destinationSquare) throws IllegalArgumentException;
}