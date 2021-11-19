package model.chessboard.chesspath;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils.EChessColor;

/**
 * A Class representing a path a pawn can take on a chessboard. Includes captures, 2 square moves,
 * and en passant.
 */
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

    if (invalidPath()) {
      return path;
    }
    if (fileDelta == 0 && rankDelta > 0) { // white pawn moving up any squares
      for (int move = 0; move < rankDelta; move++) {
        try {
          IChessSquare squareOnPath = chessBoard.getSquare(startingSquare.getFile(),
              startingSquare.getRank() + move);
          path.add(squareOnPath);
        } catch (IndexOutOfBoundsException e) {
          break;
        }
      }
    } else if (fileDelta == 0 && rankDelta < 0) { // black pawn moving down any squares
      for (int move = 0; move < Math.abs(rankDelta); move++) {
        try {
          IChessSquare squareOnPath = chessBoard.getSquare(startingSquare.getFile(),
              startingSquare.getRank() - move);
          path.add(squareOnPath);
        } catch (IndexOutOfBoundsException e) {
          break;
        }
      }
    } else if (Math.abs(fileDelta) == 1 && Math.abs(rankDelta) == 1) {
      try {
        IChessSquare destSquare = chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
            this.startingSquare.getRank() + rankDelta);
        path.add(destSquare);
      } catch (IndexOutOfBoundsException ignored) {
        // Don't add square to path
      }
    }

    return path;
  }

  @Override
  public boolean invalidPath() {
    IChessPiece piece = this.startingSquare.getPiece();
    IChessSquare destSquare = chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
        this.startingSquare.getRank() + rankDelta);
    // If it's a one or two square move up and starting white pawn
    if (fileDelta == 0 && (rankDelta == 1 || rankDelta == 2)
        && piece.getColor() == EChessColor.WHITE
        && startingSquare.getRank() == 1) {
      if (rankDelta == 1) {
        return destSquare.hasPiece();
      } else {
        return chessBoard.getSquare(this.startingSquare.getFile(),
            this.startingSquare.getRank() + (rankDelta - 1)).hasPiece() && destSquare.hasPiece();
      }
    }
    // If it's a one or two square move down and starting black pawn
    if (fileDelta == 0 && (rankDelta == -1 || rankDelta == -2)
        && piece.getColor() == EChessColor.BLACK
        && startingSquare.getRank() == 6) {
      if (rankDelta == -1) {
        return destSquare.hasPiece();
      } else {
        return chessBoard.getSquare(this.startingSquare.getFile(),
            this.startingSquare.getRank() + (rankDelta + 1)).hasPiece() && destSquare.hasPiece();
      }
    }
    if (destSquare.hasPiece()) {
      if (destSquare.getPiece().getColor() != piece.getColor()) {
        if (piece.getColor() == EChessColor.WHITE) {
          return !((fileDelta == 1 && rankDelta == 1)
              || (fileDelta == -1 && rankDelta == 1));
        } else if (piece.getColor() == EChessColor.BLACK) {
          return !((fileDelta == 1 && rankDelta == -1)
              || (fileDelta == -1 && rankDelta == -1));
        }
      }
    }
    // final check for validity
    return destSquare != chessBoard.enPassantSquare();
  }
}