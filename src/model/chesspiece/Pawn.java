package model.chesspiece;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chessboard.chesspath.AChessPath;
import model.chessboard.chesspath.IChessPath;
import model.chessboard.chesspath.PawnPath;
import model.utility.ChessUtils;
import model.utility.ChessUtils.EChessPieceType;

/**
 * Class to represent a Pawn chess piece.
 */
public class Pawn extends ADiscreteChessPiece {

  // Mechanic for the pawn's ability to move forward 2 spaces
  public boolean hasMoved;

  public Pawn(ChessUtils.EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♟", "♙", startingSquare);
    this.hasMoved = false;
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file, this.rank).hasPiece() ||
        chessBoard.getSquare(this.file, this.rank).getPiece() != this) {
      throw new IllegalStateException("Invalid board given");
    }
    List<IChessSquare> squares = new ArrayList<>();
    // Possible moves:
    // If (firstMove and white) -> (0,+2)
    // If (firstMove and black) -> (0,-2)
    // If (white) -> (0,+1)
    // If (black) -> (0,-1)
    // If (white and captureRight) -> (+1,+1)
    // If (white and captureLeft) -> (-1,+1)
    // If (black and captureRight) -> (+1,-1)
    // If (black and captureLeft) -> (-1,-1)
    // If destSquare is an enpassant square, then it's a valid move
    // and the above moves still apply
    List<IChessPath> pathsToValidate = new ArrayList<>();
    switch (this.getColor()) {
      case WHITE:
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 0, 2));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 0, 1));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 1, 1));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), -1, 1));
        break;
      case BLACK:
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 0, -2));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 0, -1));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), 1, -1));
        pathsToValidate.add(new PawnPath(chessBoard, this.getSquare(), -1, -1));
        break;
    }
    for (IChessPath path : pathsToValidate) {
      if (!path.invalidPath()) {
        squares.addAll(path.getPathOrder());
      }
    }
    return squares;
  }

  @Override
  public List<IChessSquare> possibleCaptures(IChessBoard chessBoard) {
    List<IChessPath> capturePaths = new ArrayList<>();
    switch (this.getColor()) {
      case WHITE:
        capturePaths.add(new PawnPath(chessBoard, this.getSquare(), 1, 1));
        capturePaths.add(new PawnPath(chessBoard, this.getSquare(), -1, 1));
        break;
      case BLACK:
        capturePaths.add(new PawnPath(chessBoard, this.getSquare(), 1, -1));
        capturePaths.add(new PawnPath(chessBoard, this.getSquare(), -1, -1));
        break;
    }
    List<IChessSquare> squares = new ArrayList<>();
    for (IChessPath path : capturePaths) {
      if (!path.invalidPath()) {
        squares.addAll(path.getPathOrder());
      }
    }
    return squares;
  }

  @Override
  public EChessPieceType getPieceType() {
    return EChessPieceType.PAWN;
  }

  @Override
  public int getValue() {
    return 1;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }


}