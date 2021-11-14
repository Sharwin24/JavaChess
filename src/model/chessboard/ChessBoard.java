package model.chessboard;

import java.util.ArrayList;
import java.util.List;
import model.chesspiece.IChessPiece;

/**
 * Class representing the ChessBoard and its attributes.
 */
public class ChessBoard implements IChessBoard {

  private final List<List<IChessSquare>> chessBoard;
  private List<IChessSquare> enPassantSquares;

  public ChessBoard(List<List<IChessSquare>> chessBoard) {
    this.chessBoard = chessBoard;
    this.enPassantSquares = new ArrayList<>();
  }

  public ChessBoard() {
    this.chessBoard = this.getResetChessBoardArr();
    this.enPassantSquares = new ArrayList<>();
  }

  /**
   * Returns a 2D Array of <code>IChessSquare</code> of a reset
   * chess board.
   * @return a list of list of <code>IChessSquare</code>
   */
  private List<List<IChessSquare>> getResetChessBoardArr() {
    // TODO
    return null;
  }

  @Override
  public void initBoard() {
    // Sets up the chess board
  }

  @Override
  public boolean isValidBoardArray(List<List<IChessSquare>> boardToValidate) {
    // TODO: Size 64, Correct colors, ...
    return false;
  }

  @Override
  public String getFENString() {
    return null;
  }

  @Override
  public List<List<IChessSquare>> getBoardArray() {
    return this.chessBoard;
  }

  @Override
  public IChessSquare getSquare(int file, int rank) throws IndexOutOfBoundsException {
    if (file <= 0 || file > 8 || rank <= 0 || rank > 8) { //TODO: Enforce indexing
      throw new IndexOutOfBoundsException("Square position out of bounds!");
    }
    return this.chessBoard.get(8 - rank).get(file);
  }

  @Override
  public boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare) {
    return false;
  }

  @Override
  public boolean isLegalMoveCapture(IChessPiece pieceToMove, IChessSquare destSquare) {
    return canMovePieceToSquare(pieceToMove, destSquare) && destSquare.hasPiece();
  }

  @Override
  public List<IChessSquare> enPassantSquares() {
    return this.enPassantSquares;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o instanceof ChessBoard) {
      ChessBoard otherBoard = (ChessBoard) o;
      
    }
  }
}