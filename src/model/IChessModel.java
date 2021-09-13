package model;

import model.chessboard.IChessSquare;
import model.chesspiece.IChessPiece;

/**
 * Todo
 */
public interface IChessModel {
  void initBoard();

  void move(IChessPiece pieceToMove, IChessSquare destinationSquare);
}