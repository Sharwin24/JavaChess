package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

public class King extends AChessPiece {

  protected King(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♚", "♔", startingSquare);
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    return null;
  }
}