package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Class to represent a Bishop. Bishops can move diagonally.
 */
public class Bishop extends AChessPiece {

  protected Bishop(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♝", "♗", startingSquare);
  }

  @Override
  public List<IChessSquare> possibleMoves() {
    return null;
  }
}