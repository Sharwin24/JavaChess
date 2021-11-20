package model.chesspiece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.utility.ChessUtils;

/**
 * Abstract class representing methods and attributes all <code>IChessPiece</code> objects have.
 */
public abstract class AChessPiece implements IChessPiece {

<<<<<<< HEAD
  protected static final Map<String, Integer> INITIAL_PIECE_FILE_MAP = initInitialFileMap();

  private static final Map<String, Integer> initInitialFileMap() {
    HashMap<String, Integer> initialFileMap = new HashMap<>();
    initialFileMap.putIfAbsent("rook", 0);
    initialFileMap.putIfAbsent("knight", 1);
    initialFileMap.putIfAbsent("bishop", 2);
    initialFileMap.putIfAbsent("queen", 3);
    initialFileMap.putIfAbsent("king", 4);

    return initialFileMap;
  }


  private final EChessColor pieceColor;
=======
  private final ChessUtils.EChessColor pieceColor;
>>>>>>> origin/sharwin
  private final String blackText;
  private final String whiteText;
  private IChessSquare currentSquare; // Square may be mutated for move()
  protected final int file;
  protected final int rank;

  protected interface ChessPiecePathModes {

  }

  /**
   * Constructs a <code>AChessPiece</code> with a starting square and it's toString values.
   *
   * @param color          The <code>EChessColor</code> representing the piece's color
   * @param black          The toString for a black version of this piece
   * @param white          The toString for a white version of this piece
   * @param startingSquare The <code>IChessSquare</code> this piece starts on
   * @throws IllegalArgumentException if any arguments are null or invalid
   */ // TODO: Change order of white and black args for IDEs
  protected AChessPiece(ChessUtils.EChessColor color, String white, String black,
      IChessSquare startingSquare) throws IllegalArgumentException {
    if (color == null || startingSquare == null) {
      throw new IllegalArgumentException("Invalid ChessPiece Arguments");
    }
    this.pieceColor = color;
    this.blackText = black;
    this.whiteText = white;
    this.currentSquare = startingSquare;
    this.file = startingSquare.getFile();
    this.rank = startingSquare.getRank();
  }

  @Override
  public ChessUtils.EChessColor getColor() {
    return this.pieceColor;
  }

  @Override
  public String toString() {
    switch (this.pieceColor) {
      case BLACK:
        return this.blackText;
      case WHITE:
        return this.whiteText;
      default:
        throw new IllegalArgumentException("Invalid Piece color");
    }
  }

  @Override
  public IChessSquare getSquare() {
    return this.currentSquare;
  }

  @Override
  public abstract List<IChessSquare> possibleMoves(IChessBoard chessBoard)
      throws IllegalStateException;

  @Override
  public abstract int getValue();

  @Override
  public int hashCode() {
    return Objects.hash(this.file, this.rank, this.blackText, this.whiteText, this.pieceColor);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IChessPiece otherPiece = (IChessPiece) o;

    return this.getColor() == otherPiece.getColor()
        && this.file == otherPiece.getSquare().getFile()
        && this.rank == otherPiece.getSquare().getRank()
        && this.hashCode() == otherPiece.hashCode();
  }
}