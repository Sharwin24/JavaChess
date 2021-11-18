package model.chesspiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chessboard.chesspath.IChessPath;
import model.chessboard.chesspath.KnightPath;
import model.chesscolor.EChessColor;

/**
 * Class to represent a Knight chess piece. A Knight can move in an L shape, and can jump over
 * pieces. The range is 2 squares in a cardinal direction, and then 1 square to the left or right.
 */
public class Knight extends AChessPiece {

  /**
   * Constructs a knight given the color and starting square.
   *
   * @param color          the color for this chess piece
   * @param startingSquare the starting square for this chess piece
   */
  public Knight(EChessColor color,
      IChessSquare startingSquare) {
    super(color, "♞", "♘", startingSquare);
  }

  @Override
  public List<IChessSquare> possibleMoves(IChessBoard chessBoard) throws IllegalStateException {
    if (!chessBoard.getSquare(this.file, this.rank).hasPiece() ||
        chessBoard.getSquare(this.file, this.rank).getPiece() != this) {
      throw new IllegalStateException("Invalid board given");
    }
    List<IChessSquare> moves = new ArrayList<>();
    // Possible moves:
    // (fileDelta,rankDelta)
    // (-2,-1), (-2,+1), Down L/R
    // (+2,-1), (+2,+1), Up L/R
    // (-1,-2), (+1,-2), Left D/U
    // (-1,+2), (+1,+2), Right D/U
    IChessPath downL = new KnightPath(chessBoard, this.getSquare(), -2, -1);
    IChessPath downR = new KnightPath(chessBoard, this.getSquare(), -2, 1);
    IChessPath upL = new KnightPath(chessBoard, this.getSquare(), 2, -1);
    IChessPath upR = new KnightPath(chessBoard, this.getSquare(), 2, -1);
    IChessPath leftD = new KnightPath(chessBoard, this.getSquare(), -1, -2);
    IChessPath leftR = new KnightPath(chessBoard, this.getSquare(), 1, -2);
    IChessPath rightD = new KnightPath(chessBoard, this.getSquare(), -1, 2);
    IChessPath rightU = new KnightPath(chessBoard, this.getSquare(), 1, 2);
    List<IChessPath> allPaths =
        new ArrayList<>(Arrays.asList(downL, downR, upL, upR, leftD, leftR, rightD, rightU));
    for (IChessPath path : allPaths) {
      if (!path.invalidPath()) {
        if (path.getDestinationSquare().hasPiece()
            && path.getDestinationSquare().getPiece().getColor() != this.getColor()) {
          moves.add(path.getDestinationSquare());
        }
      }
    }
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