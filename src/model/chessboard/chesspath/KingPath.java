package model.chessboard.chesspath;

import static model.utility.ChessUtils.EChessColor.BLACK;
import static model.utility.ChessUtils.EChessColor.WHITE;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils;
import model.utility.ChessUtils.EChessColor;

public class KingPath extends AChessPath {

  /**
   * Constructs an abstract ChessPath using a given board, starting square, and deltas for file and
   * rank.
   *
   * @param board          the board the path will be executed on.
   * @param startingSquare the starting square for the path.
   * @param fileDelta      the deviation in file from the starting square
   * @param rankDelta      the deviation in rank from the starting square
   */
  protected KingPath(IChessBoard board,
      IChessSquare startingSquare, int fileDelta, int rankDelta) {
    super(board, startingSquare, fileDelta, rankDelta);
  }

  @Override
  public List<IChessSquare> getPathOrder() {
    List<IChessSquare> path = new ArrayList<>();
    if (!invalidPath() && Math.abs(fileDelta) == 1) {
      try {
        path.add(chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
            this.startingSquare.getRank() + rankDelta));
      } catch (IndexOutOfBoundsException e) {
        path.clear(); // empty the path because it's invalid
      }
    } else if (!invalidPath() && Math.abs(fileDelta) == 2) {
      for (int i = 0; i < Math.abs(fileDelta); i++) {
        try {
          if (fileDelta > 0) {
            path.add(chessBoard.getSquare(this.startingSquare.getFile() + i,
                this.startingSquare.getRank() + rankDelta));
          } else {
            path.add(chessBoard.getSquare(this.startingSquare.getFile() - i,
                this.startingSquare.getRank() + rankDelta));
          }
        } catch (IndexOutOfBoundsException e) {
          path.clear();
          break;
        }
      }
    }
    return path;
  }

  @Override
  public boolean invalidPath() {
    // Moves to any adjacent square
    // Cannot move to a square with a piece of the same color
    // Cannot capture a piece that is 'protected' (Create definition?)
    // Cannot move to a square that is 'protected'
    IChessSquare destSquare;
    try {
      destSquare = chessBoard.getSquare(this.startingSquare.getFile() + fileDelta,
          this.startingSquare.getRank() + rankDelta);
    } catch (IndexOutOfBoundsException e) {
      return true;
    }
    if (!destSquare.hasPiece() && Math.abs(fileDelta) == 2) {
      // Validity for castling should be a function of the chessboard
      // OR these statements together
      // fileDelta == 2 && thisPieceColor == WHITE && chessboard.WhiteCastleKingSide
      // fileDelta == 2 && thisPieceColor == BLACK && chessboard.BlackCastleQueenSide
      // fileDelta == -2 && thisPieceColor == WHITE && chessboard.WhiteCastleQueenSide
      // fileDelta == -2 && thisPieceColor == BLACK && chessboard.BlackCastleKingSide
      EChessColor thisPieceColor = this.startingSquare.getPiece().getColor();
      return (fileDelta == 2 && thisPieceColor == WHITE && this.chessBoard.WhiteCastleKingSide())
          || (fileDelta == 2 && thisPieceColor == BLACK && this.chessBoard.BlackCastleQueenSide())
          || (fileDelta == -2 && thisPieceColor == WHITE && this.chessBoard.WhiteCastleQueenSide())
          || (fileDelta == -2 && thisPieceColor == BLACK && this.chessBoard.BlackCastleKingSide());
    }
    if (destSquare.hasPiece()) {
      if (destSquare.getPiece().getColor() == this.startingSquare.getPiece().getColor()) {
        return true;
      } else { // If opposite color
        return chessBoard.squaresAttackedBy(destSquare.getPiece().getColor()).contains(destSquare);
      }
    } else {
      return chessBoard.squaresAttackedBy(
          ChessUtils.switchColor(this.startingSquare.getPiece().getColor())).contains(destSquare);
    }
  }
}