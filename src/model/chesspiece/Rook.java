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

  /**
   * Constructs a Rook chess piece given a color and starting square.
   * @param color The color for this piece
   * @param startingSquare The starting square for this piece
   */
  protected Rook(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♜", "♖", startingSquare);
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