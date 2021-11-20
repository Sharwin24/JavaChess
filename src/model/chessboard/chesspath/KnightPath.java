package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

/**
 * Class to represent the Path a Knight would take to perform a move.
 */
public class KnightPath extends AChessPath {

  /**
   * Constructs a KnightPath using a board to execute the path on, the starting square, and the
   * deviation of the file and rank from the start.
   *
   * @param board          the board the path exists on
   * @param startingSquare the square the knight starts
   * @param fileDelta      the deviation in file
   * @param rankDelta      the deviation in rank
   */
  public KnightPath(IChessBoard board, IChessSquare startingSquare, int fileDelta,
      int rankDelta) {
    super(board, startingSquare, fileDelta, rankDelta);
  }

  @Override
  public List<IChessSquare> getPathOrder() {
    List<IChessSquare> path = new ArrayList<>();
    // Path is only destination square from start square
    try {
      IChessSquare destSquare =
          chessBoard.getSquare(this.startingSquare.getFile() + this.fileDelta,
              this.startingSquare.getRank() + this.rankDelta);
      path.add(destSquare);
    } catch (IndexOutOfBoundsException ignored) {
      // Should only catch IndexException, any other exceptions imply a bug
    }
    return path;
  }

  @Override
  public boolean invalidPath() { // Specific to Knight
    return this.getPathOrder().isEmpty();
  }
}