package model.chessboard;

import java.util.List;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils.EChessColor;

/**
 * Representation of a ChessBoard class. Wrapper class for a 2D ArrayList representing the chess
 * board. Offers functionality to determine move legality and obtaining FEN notation.
 */
public interface IChessBoard {

  /**
   * Obtains the FEN notation of the board. FEN string can be used for printing or can be handed to
   * an external engine such as stockfish for chess AI implementation.
   *
   * @return a String representing the FEN notation for the board.
   */
  String getFENString();

  /**
   * Gets the ChessBoard. Returns the private member within the implemented class. Doesn't generate
   * the board but simply retrieves it. Generation is implemented within the model.
   *
   * @return a 2D List of ChessSquare.
   */
  List<List<IChessSquare>> getBoardArray();

  /**
   * Gets the <code>IChessSquare</code> at a given file (column) and rank(row). Treats file and rank
   * as positions on chessboard. For <i>a4</i>, the parameters (file: 0, rank: 3) should be used.
   *
   * @param file the file or column as an int, starting from01. Matches the letter of the file, (ex:
   *             a -> 0, c -> 2, h -> 7, etc.) Range [0,7]
   * @param rank the rank or row as an int, starting from 0. Range [0,7]
   * @return a <code>IChessSquare</code> at the given location
   * @throws IndexOutOfBoundsException if either index is out of bounds
   */
  IChessSquare getSquare(int file, int rank) throws IndexOutOfBoundsException;

  /**
   * Determines if a piece can be moved from its current square to the given square. Take into
   * account <b>ALL</b> factors in a legal move including:
   * <ul>
   *   <li>Moving through another piece</li>
   *   <li>Illegal piece movement</li>
   *   <li>Illegal move under check</li>
   *   <li>Move into check</li>
   * </ul>
   *
   * @param pieceToMove the piece to move to the destination.
   * @param destSquare  the destination square
   * @return a boolean determining if the move is legal
   */
  boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare);

  /**
   * Determines if the given move is legal and a capture, meaning the destination square has a piece
   * on it. If the given move is illegal, then <code>false</code> is returned.
   *
   * @param pieceToMove the piece to move.
   * @param destSquare  the destination square.
   * @return a boolean determining if the move is legal and a capture or not.
   */
  boolean isMoveLegalAndCapture(IChessPiece pieceToMove, IChessSquare destSquare);

  /**
   * Gets the En Passant square for the current board. A private member with the square is updated
   * after every move.
   *
   * @return a <code>IChessSquare</code> representing the En Passant square or null if there is no
   * En Passant square.
   */
  IChessSquare enPassantSquare();

  /**
   * Sets the board array to the given one and ensures the array is a valid one.
   *
   * @param squares the new board array
   * @throws IllegalArgumentException if the given array is null or invalid
   */
  void setChessBoardArray(List<List<IChessSquare>> squares) throws IllegalArgumentException;

  /**
   * Gets a list of squares that the given colored pieces are attacking.
   *
   * @param attackingColor the color of the attacking pieces
   * @return a list of IChessSquare that all of the given color pieces can move to.
   */
  List<IChessSquare> attackedBy(EChessColor attackingColor);

  // TODO: Docs
  boolean WhiteCastleKingSide();

  boolean WhiteCastleQueenSide();

  boolean BlackCastleKingSide();

  boolean BlackCastleQueenSide();
  // TODO: Docs
}