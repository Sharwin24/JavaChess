package model.chessboard.chesspath;

import java.util.List;
import model.chessboard.IChessSquare;

/**
 * TODO
 */
public interface IChessPath {

  IChessSquare getStartingSquare();

  List<IChessSquare> pathOrder();

  int getFileDelta();

  int getRankDelta();
}