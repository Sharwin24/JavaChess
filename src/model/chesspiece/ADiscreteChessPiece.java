package model.chesspiece;

import java.util.List;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils.EChessColor;

public abstract class ADiscreteChessPiece extends AChessPiece{

  /**
   * Constructs a <code>AChessPiece</code> with a starting square and it's toString values.
   *
   * @param color          The <code>EChessColor</code> representing the piece's color
   * @param black          The toString for a black version of this piece
   * @param white          The toString for a white version of this piece
   * @param startingSquare The <code>IChessSquare</code> this piece starts on
   * @throws IllegalArgumentException if any arguments are null or invalid
   */
  protected ADiscreteChessPiece(EChessColor color, String black,
      String white, IChessSquare startingSquare) throws IllegalArgumentException {
    super(color, black, white, startingSquare);
  }

  @Override
  public abstract List<IChessSquare> possibleCaptures(IChessBoard chessBoard);
}