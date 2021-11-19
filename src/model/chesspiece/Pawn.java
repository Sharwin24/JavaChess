package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils;

/**
 * Class to represent a Pawn chess piece.
 */
public class Pawn extends ADiscreteChessPiece {

  // Mechanic for the pawn's ability to move forward 2 spaces
  public boolean hasMoved;

  public Pawn(ChessUtils.EChessColor color,
              IChessSquare startingSquare) {
    super(color, "♟", "♙", startingSquare);
    this.hasMoved = false;
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
  public int getValue() {
    return 1;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}