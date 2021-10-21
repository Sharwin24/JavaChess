package model.chessboard;

import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * Implementation of <code>IChessSquare</code>. Represents a Chess Square that is a container for a
 * piece. Provides functionality to get the color of the square, the piece on the square, and remove
 * or place the piece.
 */
public class ChessSquare implements IChessSquare {

  private final EChessColor color;
  private final int file;
  private final int rank;
  private IChessPiece piece;

  /**
   * Constructs a <code>ChessSquare</code> given a color and a location by
   * file and rank. The Square is empty and does not contain a piece.
   * @param color An <code>EChessColor</code> representing the color of this square
   * @param file The file or 'column' of this square
   * @param rank The rank or 'row' of this square
   */
  public ChessSquare(EChessColor color, int file, int rank) {
    this.color = color;
    this.file = file;
    this.rank = rank;
    this.piece = null;
  }

  /**
   * Constructs a <code>ChessSquare</code> given a color, location, and piece to start with.
   * @param color An <code>EChessColor</code> representing the color of this square
   * @param file The file or 'column' of this square
   * @param rank The rank or 'row' of this square
   * @param piece A <code>IChessPiece</code> to start on this square.
   */
  public ChessSquare(EChessColor color, int file, int rank, IChessPiece piece) {
    this(color, file, rank);
    this.piece = piece;
  }

  @Override
  public EChessColor getSquareColor() {
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
}