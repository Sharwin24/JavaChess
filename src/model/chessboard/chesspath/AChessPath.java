package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessSquare;

public abstract class AChessPath implements IChessPath {

  protected final IChessSquare startingSquare;
  protected final int rankDelta;
  protected final int fileDelta;
  protected final List<IChessSquare> pathOrder;

  protected AChessPath(IChessSquare startingSquare, int rankDelta, int fileDelta) {
    this.startingSquare = startingSquare;
    this.rankDelta = rankDelta;
    this.fileDelta = fileDelta;
    this.pathOrder = new ArrayList<>();
  }

  @Override
  public IChessSquare getStartingSquare() {
    return this.startingSquare;
  }

  @Override
  public abstract List<IChessSquare> pathOrder();

  @Override
  public int getFileDelta() {
    return this.fileDelta;
  }

  @Override
  public int getRankDelta() {
    return this.rankDelta;
  }

}