package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

public class KnightPath extends AChessPath {

  public KnightPath(IChessBoard board, IChessSquare startingSquare, int fileDelta,
      int rankDelta) {
    super(board, startingSquare, fileDelta, rankDelta);
  }

  @Override
  public List<IChessSquare> getPathOrder() {
    List<IChessSquare> squares = new ArrayList<>();
    // Path is only destination square from start square
    try {
      IChessSquare destSquare =
          chessBoard.getSquare(this.startingSquare.getFile() + this.fileDelta,
              this.startingSquare.getRank() + this.rankDelta);
      squares.add(destSquare);
    } catch (IndexOutOfBoundsException ignored) {
      // Do nothing
    }
    return squares;
  }

  @Override
  public boolean outOfBoundsPath() { // Specific to Knight
    return this.getPathOrder().isEmpty();
  }
}