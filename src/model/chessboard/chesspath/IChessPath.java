package model.chessboard.chesspath;

import java.util.List;
import model.chessboard.IChessSquare;

/**
 * TODO
 */
public interface IChessPath {

  IChessSquare getStartingSquare();

  IChessSquare getDestinationSquare();

  List<IChessSquare> getPathOrder();

  boolean outOfBoundsPath();

  int getFileDelta();

  int getRankDelta();

}