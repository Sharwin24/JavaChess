package model.chessboard;

import java.util.List;
import model.chesspiece.IChessPiece;

/**
 * TODO
 */
public interface IChessBoard {
  String getFENSring();

  List<List<IChessSquare>> getBoard();

  boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare);

  boolean isMoveCapture(IChessPiece pieceToMove, IChessSquare destSquare);

  boolean canEnPassant();
}