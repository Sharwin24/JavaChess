package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * TODO
 */
public class Pawn extends AChessPiece {

  private int moveCounter;

  protected Pawn(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♟", "♙", startingSquare);
    this.moveCounter = 0;
  }

  public int getMoveCounter() {
    return this.moveCounter;
  }

  public void incrementMoveCounter() {
    this.moveCounter++;
  }

  @Override
  public List<IChessSquare> possibleMoves() {
    return null;
  }
}