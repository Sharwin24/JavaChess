package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

public class Queen extends AChessPiece {

  protected Queen(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♛", "♕", startingSquare);
  }
  
  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    return null;
  }
}