package model.chessboard;

import java.util.ArrayList;
import java.util.List;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils;
import model.utility.Utils;

/**
 * Class representing the ChessBoard and its attributes.
 */
public class ChessBoard implements IChessBoard {

  private List<List<IChessSquare>> chessBoard;
  private IChessSquare enPassantSquare;

  public ChessBoard(List<List<IChessSquare>> chessBoard) {
    this.chessBoard = chessBoard;
    this.enPassantSquare = null;
  }

  public ChessBoard() {
    this.chessBoard = this.getResetChessBoardArr();
    this.enPassantSquare = null;
  }

  /**
   * Returns a 2D Array of <code>IChessSquare</code> of a reset chess board.
   *
   * @return a list of list of <code>IChessSquare</code>
   */
  private List<List<IChessSquare>> getResetChessBoardArr() {
    List<List<IChessSquare>> boardArray = new ArrayList<>();
    for (int row = 0; row < 8; row++) {
      boardArray.add(new ArrayList<>());
      EChessColor colorAcc = (row + 1) % 2 == 0 ? EChessColor.WHITE : EChessColor.BLACK;
      for (int col = 0; col < 8; col++) {
        IChessSquare square = new ChessSquare(colorAcc, col, (8 - 1) - row);
        IChessPiece pieceToPlace = ChessUtils.getStartPieceForSquare(square);
        if (pieceToPlace != null) { // Empty square
          square.placePiece(pieceToPlace);
        }
        boardArray.get(row).add(square);
        colorAcc = ChessUtils.switchColor(colorAcc);
      }
    }
    return boardArray;
  }

  /**
   * Determines if the given board is a legal chess board or not
   * @param boardToValidate A 2D board array to validate.
   * @return a boolean whether the given board is valid or not.
   */
  private boolean isValidBoardArray(List<List<IChessSquare>> boardToValidate) {
    // TODO: Size 64, Correct colors, ...
    return false;
  }

  @Override
  public String getFENString() {
    // TODO: Parse board and build FEN notation
    // [https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation]
    // EMPTY BOARD: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
    return "";
  }


  @Override
  public List<List<IChessSquare>> getBoardArray() {
    return this.chessBoard;
  }

  @Override
  public IChessSquare getSquare(int file, int rank) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file,0,8) || !Utils.inBounds(rank,0,8)) {
      throw new IndexOutOfBoundsException("Square position out of bounds!");
    }
    return this.chessBoard.get(8 - rank).get(file);
  }

  @Override
  public boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare) {
    return pieceToMove.possibleMoves(this).contains(destSquare); // TODO: test?
  }

  @Override
  public boolean isLegalMoveCapture(IChessPiece pieceToMove, IChessSquare destSquare) {
    return canMovePieceToSquare(pieceToMove, destSquare) && destSquare.hasPiece();
  }

  @Override
  public IChessSquare enPassantSquare() {
    return this.enPassantSquare;
  }

  @Override
  public void setChessBoardArray(List<List<IChessSquare>> squares) throws IllegalArgumentException {
    if (squares == null || !isValidBoardArray(squares)) {
      throw new IllegalArgumentException("Invalid board array given");
    }
    this.chessBoard = squares;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ChessBoard otherBoard = (ChessBoard) o;
    for (int r = 0; r < 7; r++) {
      for (int c = 0; c < 7; c++) {
        IChessSquare square = otherBoard.getSquare(c, r);
        if (this.getSquare(c, r) != square) {
          return false;
        }
      }
    }
    return true;
  }
}