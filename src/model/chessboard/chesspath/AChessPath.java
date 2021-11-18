package model.chessboard.chesspath;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

/**
 * Representation of an abstract ChessPath. Sub-classes will define their own methods for getting
 * their path order and determining the validity of their path.
 */
public abstract class AChessPath implements IChessPath {

  protected final IChessBoard chessBoard;
  protected final IChessSquare startingSquare;
  protected final int rankDelta;
  protected final int fileDelta;

  /**
   * Constructs an abstract ChessPath using a given board, starting square, and deltas for file and
   * rank.
   *
   * @param board          the board the path will be executed on.
   * @param startingSquare the starting square for the path.
   * @param fileDelta      the deviation in file from the starting square
   * @param rankDelta      the deviation in rank from the starting square
   */
  protected AChessPath(IChessBoard board, IChessSquare startingSquare, int fileDelta,
      int rankDelta) {
    this.chessBoard = board;
    this.startingSquare = startingSquare;
    this.fileDelta = fileDelta;
    this.rankDelta = rankDelta;
  }

  @Override
  public IChessSquare getStartingSquare() {
    return this.startingSquare;
  }

  @Override
  public IChessSquare getDestinationSquare() {
    int lastIndex = this.getPathOrder().size() - 1;
    return lastIndex >= 0 ? this.getPathOrder().get(lastIndex) : null;
  }

  @Override
  public abstract List<IChessSquare> getPathOrder();

  @Override
  public abstract boolean invalidPath();

  @Override
  public int getFileDelta() {
    return this.fileDelta;
  }

  @Override
  public int getRankDelta() {
    return this.rankDelta;
  }

}