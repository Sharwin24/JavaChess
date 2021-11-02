package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
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

  /**
   * Gets the pawn's move.
   * @return
   */
  public int getMoveCounter() {
    return this.moveCounter;
  }

  public void incrementMoveCounter() {
    this.moveCounter++;
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    return null;
  }
}