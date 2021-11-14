package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Class to represent the King chess piece. This piece has
 * unique mechanics since it is unable to be captured, and
 * its position on the board affects move legality.
 */
public class King extends AChessPiece {

  private boolean hasCastled;

  /**
   * Constructs a King object given a color and starting square.
   * @param color the piece's color
   * @param startingSquare the square to start on
   */
  protected King(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♚", "♔", startingSquare);
    this.hasCastled = false;
  }

  /**
   * Determines if the king can castle given the board the King exists on.
   * @param chessBoard the board to determine if castling is possible
   * @return a boolean if a castle is possible
   * @throws IllegalStateException if the given board does not contain this piece
   */
  private boolean canCastle(IChessBoard chessBoard) throws IllegalStateException{
    return false; // TODO (return !hascastled || castleLogic)
  }

  /**
   * Public facing method for determining if a move for this piece, on the given board
   * to the destination square is a castle or not.
   * @param board the board the move is happening on
   * @param destinationSquare the destination square of the move
   * @return a boolean if the given move for this piece on the given board to the given square is
   * a <i>castle</i> move
   */
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
    return 4; // Depends on current chess social norms
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}