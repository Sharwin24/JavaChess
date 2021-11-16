package model;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * Representation of a ChessModel. Offers functionality to play the game of Chess.
 * Supports <code>IChessPiece</code>, <code>IChessSquare</code>, and <code>IChessBoard</code>
 * representations of Chess elements.
 */
public interface IChessModel {

  /**
   *  Initializes a reset chessBoard for the model and starts the game with
   *  WHITE moving first.
   */
  void playGame();


  /**
   * Performs a Chess move using the given piece to the destination square. If the move
   * is illegal, then the method throws an exception.
   * @param pieceToMove the piece to move
   * @param destinationSquare the square to move the piece to
   * @throws IllegalArgumentException if the given move is illegal for any reason
   */
  void move(IChessPiece pieceToMove, IChessSquare destinationSquare) throws IllegalArgumentException;

  /**
   * Gets the captured black pieces.
   * @return a list of chess pieces that are captured by White
   */
  List<IChessPiece> getCapturedBlackPieces();

  /**
   * Gets the captured white pieces.
   * @return a list of chess pieces that are captured by Black
   */
  List<IChessPiece> getCapturedWhitePieces();

}