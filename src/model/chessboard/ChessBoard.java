package model.chessboard;

import java.util.ArrayList;
import java.util.List;
import model.chesspiece.IChessPiece;

/**
 * TODO
 */
public class ChessBoard implements IChessBoard {

  private final List<List<IChessSquare>> chessBoard;
  private List<IChessSquare> enPassantSquares;

  public ChessBoard(List<List<IChessSquare>> chessBoard) {
    this.chessBoard = chessBoard;
    this.enPassantSquares = new ArrayList<>();
  }

  @Override
  public String getFENSring() {
    return null;
  }

  @Override
  public List<List<IChessSquare>> getBoard() {
    return this.chessBoard;
  }

  @Override
  public boolean canMovePieceToSquare(IChessPiece pieceToMove, IChessSquare destSquare) {
    return false;
  }

  @Override
  public boolean isLegalMoveCapture(IChessPiece pieceToMove, IChessSquare destSquare) {
    return canMovePieceToSquare(pieceToMove, destSquare) && destSquare.hasPiece();
  }

  @Override
  public List<IChessSquare> enPassantSquares() {
    return this.enPassantSquares;
  }
}