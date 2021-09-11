package model.chesspiece;

import java.util.List;
import model.chessboard.IChessSquare;

/**
 * TODO
 */
public interface IChessPiece {
  IChessSquare getSquare();

  boolean canMoveToSquare(IChessSquare destSquare);

  List<IChessSquare> possibleMoves();
}