package model.chesspiece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.utility.Utils.Pair;

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

  /**
   * Determines if castling with this piece on the given board is legal or not
   * @param chessBoard the board to determine the move legality
   * @return a boolean if the castle is legal
   * @throws IllegalStateException if the given board does not contain this piece
   */
  private boolean canCastle(IChessBoard chessBoard) throws IllegalStateException{
    return false;
  }

  /**
   * Determines if a move regarding this piece, on the given board, to the destination
   * square, is a castling move or not.
   * @param board the board to determine the move on
   * @param destinationSquare the square for the move to
   * @return a boolean whether the move with this piece is a castle or not
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

  private final Map<ERookPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> rookPathSearcherMap =
      initRookPathSearcherMap();

  private final Map<ERookPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> initRookPathSearcherMap() {
    Map<ERookPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> rookPathSearcherMap = new HashMap<>();
    rookPathSearcherMap.putIfAbsent()
  }

  private enum ERookPathMode implements ChessPiecePathModes {
    RIGHT, UP, LEFT, DOWN;
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