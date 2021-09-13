package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * TODO
 */
public abstract class AChessPiece implements IChessPiece {

  private final EChessColor pieceColor;
  private final String blackText;
  private final String whiteText;
  protected IChessSquare currentSquare;

  protected AChessPiece(EChessColor color, String black, String white,
      IChessSquare startingSquare) {
    this.pieceColor = color;
    this.blackText = black;
    this.whiteText = white;
    this.currentSquare = startingSquare;
  }

  @Override
  public String toString() {
    switch (this.pieceColor) {
      case BLACK:
        return this.blackText;
      case WHITE:
        return this.whiteText;
      default:
        throw new IllegalArgumentException("Invalid Piece color");
    }
  }

  @Override
  public IChessSquare getSquare() {
    return this.currentSquare;
  }

  @Override
  public abstract List<IChessSquare> possibleMoves();
}