package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
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
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file,this.rank).hasPiece() ||
        chessBoard.getSquare(this.file,this.rank).getPiece() != this) {
      throw new IllegalStateException("Invalid board given");
    }
    return null;
  }
}