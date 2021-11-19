package model.chessboard;

import java.util.Objects;

import model.chesspiece.IChessPiece;
import model.utility.ChessUtils;

/**
 * Implementation of <code>IChessSquare</code>. Represents a Chess Square that is a container for a
 * piece. Provides functionality to get the color of the square, the piece on the square, and remove
 * or place the piece.
 */
public class ChessSquare implements IChessSquare {

  private final ChessUtils.EChessColor color;
  private final int file;
  private final int rank;
  private IChessPiece piece;

  /**
   * Constructs a <code>ChessSquare</code> given a color and a location by file and rank. The Square
   * is empty and does not contain a piece.
   *
   * @param color An <code>EChessColor</code> representing the color of this square
   * @param file  The file or 'column' of this square
   * @param rank  The rank or 'row' of this square
   */
  public ChessSquare(ChessUtils.EChessColor color, int file, int rank) {
    this.color = color;
    this.file = file;
    this.rank = rank;
    this.piece = null;
  }

  /**
   * copy ctor with ability to remove a piece
   */
  public ChessSquare(IChessSquare aSquare, boolean hasPiece) {
    color = aSquare.getSquareColor();
    file = aSquare.getFile();
    rank = aSquare.getRank();

    if (!aSquare.hasPiece()) { // can't add a piece to a square with no piece
      hasPiece = false;
    }

    piece = hasPiece ? aSquare.getPiece() : null;

  }

  /**
   * copy ctor that can place a piece
   */
  public ChessSquare(IChessSquare aSquare, IChessPiece aPiece) {
    this(aSquare.getSquareColor(), aSquare.getFile(), aSquare.getRank(), aPiece);
  }

  /**
   * Constructs a <code>ChessSquare</code> given a color, location, and piece to start with.
   *
   * @param color An <code>EChessColor</code> representing the color of this square
   * @param file  The file or 'column' of this square
   * @param rank  The rank or 'row' of this square
   * @param piece A <code>IChessPiece</code> to start on this square.
   */
  public ChessSquare(ChessUtils.EChessColor color, int file, int rank, IChessPiece piece) {
    this(color, file, rank);
    this.piece = piece;
  }

  @Override
  public ChessUtils.EChessColor getSquareColor() {
    return this.color;
  }

  @Override
  public boolean hasPiece() {
    return this.piece != null;
  }

  @Override
  public IChessPiece getPiece() {
    return this.piece;
  }

  @Override
  public void placePiece(IChessPiece pieceToPlace) throws IllegalArgumentException {
    if (this.hasPiece()) {
      throw new IllegalArgumentException("Cannot place piece on occupied square");
    }
    this.piece = pieceToPlace;
  }

  @Override
  public void removePiece() {
    if (!this.hasPiece()) {
      throw new IllegalStateException("No piece to remove!");
    }
    this.piece = null;
  }

  @Override
  public int getFile() {
    return this.file;
  }

  @Override
  public int getRank() {
    return this.rank;
  }

  @Override
  public EChessSquareStartingPiece determineStartPiece() {
    if (ChessUtils.isRookSquare(this)) {
      if (this.rank == 0) {
        return EChessSquareStartingPiece.WROOK;
      } else if (this.rank == 7) {
        return EChessSquareStartingPiece.BROOK;
      }
    } else if (ChessUtils.isKnightSquare(this)) {
      if (this.rank == 0) {
        return EChessSquareStartingPiece.WKNIGHT;
      } else if (this.rank == 7) {
        return EChessSquareStartingPiece.BKNIGHT;
      }
    } else if (ChessUtils.isBishopSquare(this)) {
      if (this.rank == 0) {
        return EChessSquareStartingPiece.WBISHOP;
      } else if (this.rank == 7) {
        return EChessSquareStartingPiece.BBISHOP;
      }
    } else if (ChessUtils.isQueenSquare(this)) {
      if (this.rank == 0) {
        return EChessSquareStartingPiece.WQUEEN;
      } else if (this.rank == 7) {
        return EChessSquareStartingPiece.BQUEEN;
      }
    } else if (ChessUtils.isKingSquare(this)) {
      if (this.rank == 0) {
        return EChessSquareStartingPiece.WKING;
      } else if (this.rank == 7) {
        return EChessSquareStartingPiece.BKING;
      }
    } else if (ChessUtils.isPawnSquare(this)) {
      if (this.rank == 1) {
        return EChessSquareStartingPiece.WPAWN;
      } else if (this.rank == 6) {
        return EChessSquareStartingPiece.BPAWN;
      }
    }
    // Empty starting square
    return EChessSquareStartingPiece.EMPTY;
  }

  @Override
  public String toString() {
    if (this.hasPiece()) {
      return this.piece.toString() + ChessUtils.fileLetter(this.file) + (this.rank + 1);
    } else {
      switch (this.color) { // TODO: Print square with piece on it?
        case BLACK:
          return "⬜" + ChessUtils.fileLetter(this.file) + (this.rank + 1); // Black box
        case WHITE:
          return "⬛" + ChessUtils.fileLetter(this.file) + (this.rank + 1); // White box
        default:
          throw new IllegalArgumentException("Invalid Square Color");
      }
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ChessSquare that = (ChessSquare) o;
    return this.file == that.file
        && this.rank == that.rank
        && this.color == that.color;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.color, this.file, this.rank);
  }
}