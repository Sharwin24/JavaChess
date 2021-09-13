package model.chessboard;

import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * TODO
 */
public class ChessSquare implements IChessSquare {

  private final EChessColor color;
  private final int file;
  private final int rank;

  private IChessPiece piece;

  public ChessSquare(EChessColor color, int file, int rank) {
    this.color = color;
    this.file = file;
    this.rank = rank;
    this.piece = null;
  }

  public ChessSquare(EChessColor color, int file, int rank, IChessPiece piece) {
    this(color,file,rank);
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
  public int getFile() {
    return 0;
  }

  @Override
  public int getRank() {
    return 0;
  }
}