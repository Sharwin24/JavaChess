package model.chessboard.chesspath;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

public class KingPath extends AChessPath{

  /**
   * Constructs an abstract ChessPath using a given board, starting square, and deltas for file and
   * rank.
   *
   * @param board          the board the path will be executed on.
   * @param startingSquare the starting square for the path.
   * @param fileDelta      the deviation in file from the starting square
   * @param rankDelta      the deviation in rank from the starting square
   */
  protected KingPath(IChessBoard board,
      IChessSquare startingSquare, int fileDelta, int rankDelta) {
    super(board, startingSquare, fileDelta, rankDelta);
  }

  @Override
  public List<IChessSquare> getPathOrder() {
    return null;
  }

  @Override
  public boolean invalidPath() {
    return false;
  }
}