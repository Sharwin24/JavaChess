package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Class to represent a Rook chess piece. Rooks can move in a cardinal direction,
 * with an infinite range, given they can't go off the board, or through pieces.
 * Rooks are also able to perform a 'Castle' with the {@link King} piece.
 */
public class Rook extends AChessPiece {

  private boolean hasCastled;

  /**
   * Constructs a Rook chess piece given a color and starting square.
   * @param color The color for this piece
   * @param startingSquare The starting square for this piece
   */
  protected Rook(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♜", "♖", startingSquare);
    this.hasCastled = false;
  }

  private boolean canCastle(IChessBoard chessBoard) {
    return false;
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
  public int getValue() {
    return 5;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}