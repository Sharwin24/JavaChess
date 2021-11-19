package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chessboard.chesspath.IChessPath;
import model.chessboard.chesspath.PawnPath;
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
    // Possible moves:
    // If (firstMove and white) -> (0,+2)
    // If (firstMove and black) -> (0,-2)
    // If (!firstMove and white) -> (0,+1)
    // If (!firstMove and black) -> (0,-1)
    // If (white and captureRight) -> (+1,+1)
    // If (white and captureLeft) -> (-1,+1)
    // If (black and captureRight) -> (+1,-1)
    // If (black and captureLeft) -> (-1,-1)
    // If destSquare is an enpassant square, then it's a valid move
    // and the above moves still apply
    IChessPath p = new PawnPath(chessBoard,this.getSquare(),-2,4);
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