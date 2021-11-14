package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

public class King extends AChessPiece {

  private boolean hasCastled;

  protected King(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♚", "♔", startingSquare);
    this.hasCastled = false;
  }

  private boolean canCastle(IChessBoard chessBoard) throws IllegalStateException{
    return false; // TODO (return !hascastled || castleLogic)
  }

  public boolean givenMoveIsCastle(IChessBoard board, IChessSquare destinationSquare) {
    return false;
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file,this.rank).hasPiece() ||
        chessBoard.getSquare(this.file,this.rank).getPiece() != this) {
      throw new IllegalStateException("Invalid board given");
    }
    return null;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}