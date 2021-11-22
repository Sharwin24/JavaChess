package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils;
import model.utility.ChessUtils.EChessPieceType;

/**
 * Representation of a Chess Piece. Offers functionality to get the
 * square this piece is on and the list of possible moves this piece can go to
 */
public interface IChessPiece {

  /**
   * Gets this piece type as an enum
   * @return an <code>enum</code> representing the piece's type
   */
  EChessPieceType getPieceType();

  /**
   * Gets the <code>IChessSquare</code> the piece is on.
   * @return a <code>IChessSquare</code> object
   */
  IChessSquare getSquare();

  /**
   * Obtains this piece's material value.
   * @return value as an integer
   */
  int getValue();

  /**
   * Gets the piece's color;
   * @return an Enum representing the piece's color
   */
  ChessUtils.EChessColor getColor();

  /**
   * Gets a list of the possible moves the piece can make given the
   * chess board the piece is on. Ensures that the given board contains this
   * piece on this piece's square.
   * @param chessBoard the board to find all the possible moves.
   * @return A list of <code>IChessSquare</code> representing the list of possible moves.
   * @throws IllegalStateException if given board doesn't contain this piece on its square.
   */
  List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException;

  /** TODO: Can maybe remove
   * Determines if this chess piece can move to the given square on the given board.
   * If the given board does not contain this piece on its square, an exception is thrown.
   * @param chessBoard the board to determine if the given move is possible or not
   * @param destinationSquare the square to move to
   * @return a boolean whether the move is legal or not
   * @throws IllegalStateException if the given board does not contain this piece on its square
   */
  boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare) throws IllegalStateException;

}