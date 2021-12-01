package model.chessboard;

import static model.utility.ChessUtils.EChessColor.BLACK;
import static model.utility.ChessUtils.EChessColor.WHITE;
import static model.utility.ChessUtils.EChessPieceType.*;

import java.util.ArrayList;
import java.util.List;

import model.chesspiece.ADiscreteChessPiece;
import model.chesspiece.IChessPiece;
import model.chesspiece.King;
import model.chesspiece.Pawn;
import model.utility.ChessUtils;
import model.utility.ChessUtils.EChessColor;
import model.utility.ChessUtils.EChessPieceType;
import model.utility.Utils;

/**
 * Class representing the ChessBoard and its attributes.
 */
public class ChessBoard implements IChessBoard {

  private List<List<IChessSquare>> chessBoard;
  private IChessSquare enPassantSquare;

  // For FEN Notation
  private int halfMoveCounter;
  private int fullMoveCounter;

  public ChessBoard(List<List<IChessSquare>> chessBoard) {
    this.chessBoard = chessBoard;
    this.enPassantSquare = null;
    this.halfMoveCounter = 0;
    this.fullMoveCounter = 0; // Not neccessarily correct
  }

  public ChessBoard() {
    this.chessBoard = this.getResetChessBoardArr();
    this.enPassantSquare = null;
    this.halfMoveCounter = 0;
    this.fullMoveCounter = 0;
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
      ChessUtils.EChessColor colorAcc = (row + 1) % 2 == 0 ? BLACK : WHITE;
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
   *
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
    // Starting position: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
    // After move e4:     rnbqkbnr/pppppppp/8/8/8/4P3/PPPP1PPP/RNBQKBNR B KQkq e3 0 1
    // 1. Board: Starts with rank 8, each rank is delineated by a '/'
    //           lowercase letters are black pieces, uppercase is white
    // 2. Player's move: 'w' or 'b'
    // 3. Castling: 'K' and 'Q' represents white can castle kingside or queenside
    //              'k' and 'q' are for black.
    //              If no one can castle this is '-'
    // 4. En Passant Target Square: '-' if there is none, otherwise if a pawn
    //                              has just made a 2 square move, it's the square
    //                              behind them. (ex: P -> e4, en passant sq === e3)
    // 5. Half-move Counter: Number of half moves since the last capture or pawn advance,
    //                      for the fifty-move rule.
    // 6. Full-move Counter: The number of the full move. Starting at 1,
    //                       incrementing after black's move
    return "";
  }

  @Override
  public List<List<IChessSquare>> getBoardArray() {
    return this.chessBoard;
  }

  @Override
  public IChessSquare getSquare(int file, int rank) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file, 0, 7) || !Utils.inBounds(rank, 0, 7)) {
      throw new IndexOutOfBoundsException("Square position out of bounds!");
    }
    return this.chessBoard.get((8 - 1) - rank).get(file);
  }

  @Override
  public boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare) {
    return pieceToMove.possibleMoves(this).contains(destSquare); // TODO: test?
  }

  @Override
  public boolean isMoveLegalAndCapture(IChessPiece pieceToMove, IChessSquare destSquare) {
    return this.canMovePieceToSquare(pieceToMove, destSquare) && destSquare.hasPiece();
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
  public List<IChessSquare> squaresAttackedBy(EChessColor attackingColor) {
    List<IChessSquare> squares = new ArrayList<>();
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (this.chessBoard.get(row).get(col).hasPiece()) {
          IChessPiece attackingPiece = this.chessBoard.get(row).get(col).getPiece();
          if (attackingPiece.getColor() == attackingColor) {
            if (attackingPiece.getPieceType() != PAWN) {
              squares.addAll(attackingPiece.possibleMoves(this));
            } else if (attackingPiece.getPieceType() == PAWN) {
              squares.addAll(((Pawn)attackingPiece).possibleCaptures(this));
            }
          }
        }
      }
    }
    return squares;
  }

  // TODO: Implement
  @Override
  public boolean WhiteCastleKingSide() {
    return false;
  }

  @Override
  public boolean WhiteCastleQueenSide() {
    return false;
  }

  @Override
  public boolean BlackCastleKingSide() {
    return false;
  }

  @Override
  public boolean BlackCastleQueenSide() {
    return false;
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
        if (this.getSquare(c,r).hasPiece() && !square.hasPiece()) {
          return false;
        }
        if (this.getSquare(c,r).hasPiece() && square.hasPiece()) {
          if(this.getSquare(c,r).getPiece() != square.getPiece()) {
            return false;
          }
        }
      } 
    }
    return true;
  }
}