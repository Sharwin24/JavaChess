package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

public abstract class AChessPath implements IChessPath {

  protected final IChessBoard chessBoard;
  protected final IChessSquare startingSquare;
  protected final int rankDelta;
  protected final int fileDelta;

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
  public abstract boolean outOfBoundsPath();

  @Override
  public int getFileDelta() {
    return this.fileDelta;
  }

  @Override
  public int getRankDelta() {
    return this.rankDelta;
  }

}