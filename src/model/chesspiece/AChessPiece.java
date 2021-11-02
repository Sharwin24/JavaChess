package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Abstract class representing methods and attributes all <code>IChessPiece</code>
 * objects have.
 */
public abstract class AChessPiece implements IChessPiece {

  private final EChessColor pieceColor;
  private final String blackText;
  private final String whiteText;
  protected IChessSquare currentSquare;

  /**
   * Constructs a <code>AChessPiece</code> with a starting square and it's
   * toString values.
   * @param color The <code>EChessColor</code> representing the piece's color
   * @param black The toString for a black version of this piece
   * @param white The toString for a white version of this piece
   * @param startingSquare The <code>IChessSquare</code> this piece starts on
   */
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
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard)
      throws IllegalStateException {
    if (chessBoard.)
  }

  protected abstract List<IChessSquare> possibleMovesLegalBoard(IChessBoard board);
}