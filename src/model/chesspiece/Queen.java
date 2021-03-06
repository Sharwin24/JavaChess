package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Class to represent Queen chess piece.
 */
public class Queen extends AChessPiece {

  /**
   * Constructs a Queen chess piece given a color and starting square
   * @param color the chess color for this piece
   * @param startingSquare the square for this piece to start on
   */
  public Queen(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♛", "♕", startingSquare);
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
    return 9;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}