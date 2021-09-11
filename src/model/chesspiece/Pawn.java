package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * TODO
 */
public class Pawn extends AChessPiece {

  protected Pawn(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♟", "♙", startingSquare);
  }

  @Override
  public boolean canMoveToSquare(IChessSquare destSquare) {
    return false;
  }

  @Override
  public List<IChessSquare> possibleMoves() {
    return null;
  }
}