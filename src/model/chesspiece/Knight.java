package model.chesspiece;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;

/**
 * Class to represent a Knight chess piece. A Knight can move in an L shape,
 * and can jump over pieces. The range is 2 squares in a cardinal direction,
 * and then 1 square to the left or right.
 */
public class Knight extends AChessPiece {

  /**
   * Constructs a knight given the color and starting square.
   * @param color the color for this chess piece
   * @param startingSquare the starting square for this chess piece
   */
  public Knight(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♞", "♘", startingSquare);
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file,this.rank).hasPiece() ||
        chessBoard.getSquare(this.file,this.rank).getPiece() != this) {
      throw new IllegalStateException("Invalid board given");
    }
    List<IChessSquare> moves = new ArrayList<>();
    // Possible moves:
    // (-2,-1), (-2,+1), Left
    // (+2,+1), (+2,-1), Right
    // (-1,+2), (+1,+2), Up
    // (-1,-2), (+1,-2), Down

    return moves;
  }

  @Override
  public int getValue() {
    return 3;
  }

  @Override
  public boolean canMoveTo(IChessBoard chessBoard, IChessSquare destinationSquare)
      throws IllegalStateException {
    return false;
  }
}