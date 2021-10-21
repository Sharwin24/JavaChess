package model.chessboard;

import java.util.List;
import model.chesspiece.IChessPiece;

/**
 * Representation of a ChessBoard class. Wrapper class for a 2D ArrayList
 * representing the chess board. Offers functionality to determine move legality
 * and obtaining FEN notation.
 */
public interface IChessBoard {

  /**
   * Initializes the board with the pieces on their starting squares.
   */
  void initBoard();

  /**
   * Obtains the FEN notation of the board. FEN string can be used for printing or
   * can be handed to an external engine such as stockfish for chess AI implementation.
   * @return a String representing the FEN notation for the board.
   */
  String getFENSring();

  /**
   * Gets the ChessBoard. Returns the private member within the implemented
   * class. Doesn't generate the board but simply retrieves it. Generation is
   * implemented within the model.
   * @return a 2D List of ChessSquare.
   */
  List<List<IChessSquare>> getBoardArray();

  /**
   * Determines if a piece can be moved from its current square to the given square.
   * Take into account <b>ALL</b> factors in a legal move including:
   * <ul>
   *   <li>Moving through another piece</li>
   *   <li>Illegal piece movement</li>
   *   <li>Illegal move under check</li>
   *   <li>Move into check</li>
   * </ul>
   * @param pieceToMove the piece to move to the destination.
   * @param destSquare the destination square
   * @return a boolean determining if the move is legal
   */
  boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare);

  /**
   * Determines if the given legal move is a capture, meaning the destination square
   * has a piece on it. If the given move is illegal, then <code>false</code> is returned.
   * @param pieceToMove the piece to move.
   * @param destSquare the destination square.
   * @return a boolean determining if the legal move is a capture or not.
   */
  boolean isLegalMoveCapture(IChessPiece pieceToMove, IChessSquare destSquare);

  /**
   * Gets a list of the En Passant squares for the current board.
   * A private member with the squares is updated after every move.
   * @return a List of <code>IChessSquare</code> representing the En Passant squares.
   */
  List<IChessSquare> enPassantSquares();
}