package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils.EChessColor;

public class PawnPath extends AChessPath {

  /**
   * Constructs an abstract ChessPath using a given board, starting square, and deltas for file and
   * rank.
   *
   * @param board          the board the path will be executed on.
   * @param startingSquare the starting square for the path.
   * @param fileDelta      the deviation in file from the starting square
   * @param rankDelta      the deviation in rank from the starting square
   */
  public PawnPath(IChessBoard board,
      IChessSquare startingSquare, int fileDelta, int rankDelta) {
    super(board, startingSquare, fileDelta, rankDelta);
  }

  @Override
  public List<IChessSquare> getPathOrder() {
    List<IChessSquare> path = new ArrayList<>();
    IChessPiece piece = startingSquare.getPiece();
    // If first move
    if (startingSquare.getRank() == 1 || startingSquare.getRank() == 6) {
      // Only if fileDelta is zero
      if (fileDelta == 0) {
        if (piece.getColor() == EChessColor.WHITE && rankDelta > 0) {
          IChessSquare destSquare =
              chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
                  this.startingSquare.getRank() + rankDelta);
        } else if (piece.getColor() == EChessColor.BLACK && rankDelta < 0) {

        }
      }
    }

    return null;
  }

  @Override
  public boolean invalidPath() {
    IChessPiece piece = this.startingSquare.getPiece();
    IChessSquare destSquare = chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
        this.startingSquare.getRank() + rankDelta);
    // If it's a one or two square move up and starting white pawn
    if (fileDelta == 0 && (rankDelta == 1 || rankDelta == 2)
        && piece.getColor() == EChessColor.WHITE && startingSquare.getRank() == 1) {

      if (rankDelta == 1) {
        return destSquare.hasPiece();
      } else {
        return chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
            this.startingSquare.getRank() + (rankDelta - 1)).hasPiece() && destSquare.hasPiece();
      }
    }
    // If it's a one or two square move down and starting black pawn
    if (fileDelta == 0 && (rankDelta == -1 || rankDelta == -2)
        && piece.getColor() == EChessColor.BLACK && startingSquare.getRank() == 6) {

      if (rankDelta == -1) {
        return destSquare.hasPiece();
      } else {
        return chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
            this.startingSquare.getRank() + (rankDelta + 1)).hasPiece() && destSquare.hasPiece();
      }
    }
    if (destSquare.hasPiece()) {
      if (destSquare.getPiece().getColor() != piece.getColor()) {
        if (piece.getColor() == EChessColor.WHITE) {
          return !((fileDelta == 1 && rankDelta == 1)
              || (fileDelta == -1 && rankDelta == 1));
        }
        else if (piece.getColor() == EChessColor.BLACK) {
          return !((fileDelta == 1 && rankDelta == -1)
              || (fileDelta == -1 && rankDelta == -1));
        }
      }
    }
    // final check for validity
    return destSquare != chessBoard.enPassantSquare();
  }
}