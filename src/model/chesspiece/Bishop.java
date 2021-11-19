package model.chesspiece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.utility.Utils.Pair;

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
  protected Bishop(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♝", "♗", startingSquare);
  }


  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file,this.rank).hasPiece() ||
        !chessBoard.getSquare(this.file,this.rank).getPiece().equals(this)) { // changed this to equals method instead of !=
      throw new IllegalStateException("Invalid board given");
    }
    // loop through the diagonals of this piece, stopping when another piece is found
    // -if a piece of the same color is found, do not include that square as a possible move
    // -if a piece of the opposite color is found, include that square as a possible move
    List<IChessSquare> possibleMoves = new ArrayList<>();

    possibleMoves.addAll(searchForMovesAlongADiagonal(chessBoard, EBishopPathMode.UP_RIGHT));
    possibleMoves.addAll(searchForMovesAlongADiagonal(chessBoard, EBishopPathMode.UP_LEFT));
    possibleMoves.addAll(searchForMovesAlongADiagonal(chessBoard, EBishopPathMode.DOWN_LEFT));
    possibleMoves.addAll(searchForMovesAlongADiagonal(chessBoard, EBishopPathMode.DOWN_RIGHT));

    return possibleMoves;
  }

  /**
   * Generalized method to loop through indices on a chessboard and return the possible moves, given a
   * <code>EDiagonalPathMode</code> describing how the diagonal direction that the bishop can move.
   * @param boardToSearchIn
   * @param diagonalPathMode
   * @return
   */
  private final List<IChessSquare> searchForMovesAlongADiagonal(IChessBoard boardToSearchIn, EBishopPathMode diagonalPathMode) {
    List<IChessSquare> possibleMoves = new ArrayList<>();
    Pair<Integer, Integer> currentlySearching = new Pair<>(file, rank);
    boolean seenPieceAlongSearchedPath = false;
    IChessSquare currentSquare;

    while(!seenPieceAlongSearchedPath) {
      try {
        currentSquare = boardToSearchIn.getSquare(currentlySearching.first, currentlySearching.second);
        if (currentSquare.hasPiece()) {
          if (currentSquare.getPiece().getColor() != getColor()) {
            possibleMoves.add(currentSquare);
          }
          else {
            seenPieceAlongSearchedPath = true;
          }
        }
        possibleMoves.add(currentSquare);
        currentlySearching = bishopPathSearcherMap.get(diagonalPathMode).apply(currentlySearching);
      } catch (IndexOutOfBoundsException e) {
        seenPieceAlongSearchedPath = true;
      }
    }

    return possibleMoves;
  }



  private enum EBishopPathMode {
    UP_RIGHT, UP_LEFT, DOWN_LEFT, DOWN_RIGHT;
  }

  private final Map<EBishopPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> bishopPathSearcherMap =
      initBishopPathSearcherMap();

  private final Map<EBishopPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> initBishopPathSearcherMap() {
    Map<EBishopPathMode, Function<Pair<Integer, Integer>, Pair<Integer, Integer>>> bishopPathSearcherMap = new HashMap<>();
    bishopPathSearcherMap.putIfAbsent(
        EBishopPathMode.UP_RIGHT, pr -> new Pair<>(pr.first + 1, pr.second - 1));
    bishopPathSearcherMap.putIfAbsent(
        EBishopPathMode.UP_LEFT, pr -> new Pair<>(pr.first - 1, pr.second - 1));
    bishopPathSearcherMap.putIfAbsent(
        EBishopPathMode.DOWN_LEFT, pr -> new Pair<>(pr.first - 1, pr.second + 1));
    bishopPathSearcherMap.putIfAbsent(
        EBishopPathMode.DOWN_RIGHT, pr -> new Pair<>(pr.first + 1, pr.second + 1));

    return bishopPathSearcherMap;
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