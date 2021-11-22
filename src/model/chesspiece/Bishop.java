package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils;
import model.utility.ChessUtils.EChessPieceType;

/**
 * Class to represent a Bishop. Bishops can move diagonally.
 */
public class Bishop extends AChessPiece {

  /**
   * Constructs a Bishop, given it's color and starting square.
   * @param color The <code>EChessColor</code> representing this piece's color
   * @param startingSquare The <code>IChessSquare</code> representing the starting
   *                       square for the piece.
   */
  public Bishop(ChessUtils.EChessColor color,
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

  @Override
  public EChessPieceType getPieceType() {
    return EChessPieceType.BISHOP;
  }

  @Override
  public int getValue() {
    return 3;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}