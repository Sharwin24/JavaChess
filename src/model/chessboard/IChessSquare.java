package model.chessboard;

import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * TODO
 */
public interface IChessSquare {
  EChessColor getSquareColor();

  boolean hasPiece();

  IChessPiece getPiece();

  boolean canMovePieceHere(IChessPiece pieceToMove);

  int getFile();

  int getRank();
}