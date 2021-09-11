package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

public class Queen extends AChessPiece {

  protected Queen(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♛", "♕", startingSquare);
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