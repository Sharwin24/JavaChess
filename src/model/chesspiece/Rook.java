package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * TODO
 */
public class Rook extends AChessPiece {

  protected Rook(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♜", "♖", startingSquare);
  }

  @Override
  public List<IChessSquare> possibleMoves() {
    return null;
  }
}