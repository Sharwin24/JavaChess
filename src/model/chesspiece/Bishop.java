package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * TODO
 */
public class Bishop extends AChessPiece {

  protected Bishop(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♝", "♗", startingSquare);
  }
}