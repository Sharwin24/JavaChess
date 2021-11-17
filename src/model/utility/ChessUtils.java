package model.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import model.chessboard.ChessSquare;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.chesspiece.Bishop;
import model.chesspiece.IChessPiece;
import model.chesspiece.King;
import model.chesspiece.Knight;
import model.chesspiece.Pawn;
import model.chesspiece.Queen;
import model.chesspiece.Rook;

/**
 * Utility class for Chess Utility functions
 */
public final class ChessUtils {

  private static final HashMap<Integer, String> fileMap = new HashMap<>(8) {{
    put(0, "a");
    put(1, "b");
    put(2, "c");
    put(3, "d");
    put(4, "e");
    put(5, "f");
    put(6, "g");
    put(7, "h");
  }};

  /**
   * Switches the given EChessColor. Black -> White, White -> Black
   *
   * @param color the color to switch
   * @return an EChessColor
   */
  public static EChessColor switchColor(EChessColor color) {
    return color == EChessColor.WHITE ? EChessColor.BLACK : EChessColor.WHITE;
  }

  /**
   * Gets the file letter as a string given the index. Throws an exception if the index is out of
   * bounds
   *
   * @param file the index of the file
   * @return a string representing the letter of that file (examples: 0 -> "a", 1 -> "b", 7 -> "h")
   * @throws IndexOutOfBoundsException if the index is out of bounds (zero-indexed)
   */
  public static String fileLetter(int file) throws IndexOutOfBoundsException {
    if (!Utils.inBounds(file, 0, 7)) {
      throw new IndexOutOfBoundsException("File out of bounds. Range: [0,7]");
    }
    return fileMap.get(file);
  }

  /**
   * Maps a unary function <code>mapperFunc</code> on every square in a 2D list of squares
   * <code>toMapOn</code>.
   *
   * @param toMapOn    the list to map a function on, with signature mapperFunc :: IChessSquare ->
   *                   Y
   * @param mapperFunc a well-defined unary function to apply to all squares in the list
   * @param <Y>        the result of the mapperFunc call
   * @return a 2D array of the same size as <code>toMapOn</code> (64), of type Y.
   */
  public static <Y> List<List<Y>> boardMap(List<List<IChessSquare>> toMapOn,
      Function<IChessSquare, Y> mapperFunc) {
    List<List<Y>> mappedResult = new ArrayList<>();

    for (int i = 0; i < 8; i++) {
      List<Y> thisRow = new ArrayList<>();
      for (int j = 0; j < 8; j++) {
        thisRow.add(mapperFunc.apply(toMapOn.get(i).get(j)));
      }
      mappedResult.add(thisRow);
    }

    return mappedResult;
  }

  /**
   * Returns the IChessPiece that starts on the given square on a reset chess board.
   *
   * @param square the square the piece should start on
   * @return the IChessPiece or <code>null</code> if the square starts empty
   * @throws IllegalStateException if the square has null or has an invalid start piece enum
   */
  public static IChessPiece getStartPieceForSquare(IChessSquare square)
      throws IllegalStateException {
    if (square == null) {
      throw new IllegalStateException("Square is null");
    }
    switch (square.determineStartPiece()) {
      case WROOK:
        return new Rook(EChessColor.WHITE, square);
      case WKNIGHT:
        return new Knight(EChessColor.WHITE, square);
      case WBISHOP:
        return new Bishop(EChessColor.WHITE, square);
      case WQUEEN:
        return new Queen(EChessColor.WHITE, square);
      case WKING:
        return new King(EChessColor.WHITE, square);
      case WPAWN:
        return new Pawn(EChessColor.WHITE, square);
      case BROOK:
        return new Rook(EChessColor.BLACK, square);
      case BKNIGHT:
        return new Knight(EChessColor.BLACK, square);
      case BBISHOP:
        return new Bishop(EChessColor.BLACK, square);
      case BQUEEN:
        return new Queen(EChessColor.BLACK, square);
      case BKING:
        return new King(EChessColor.BLACK, square);
      case BPAWN:
        return new Pawn(EChessColor.BLACK, square);
      case EMPTY:
        return null;
      default:
        throw new IllegalStateException("Square has invalid start piece enum");
    }
  }

  public static boolean isRookSquare(IChessSquare square) {
    // a && (1 or 8) OR h && (1 or 8)
    return (square.getFile() == 0 && (square.getRank() == 0 || square.getRank() == 7))
        || (square.getFile() == 7 && (square.getRank() == 0 || square.getRank() == 7));
  }
  
  public static boolean isKnightSquare(IChessSquare square) {
    // b && (1 or 8) OR g && (1 or 8)
    return (square.getFile() == 1 && (square.getRank() == 0 || square.getRank() == 7))
        || (square.getFile() == 6 && (square.getRank() == 0 || square.getRank() == 7));
  }

  public static boolean isBishopSquare(ChessSquare square) {
    // c && (1 or 8) OR f && (1 or 8)
    return (square.getFile() == 2 && (square.getRank() == 0 || square.getRank() == 7))
        || (square.getFile() == 5 && (square.getRank() == 0 || square.getRank() == 7));
  }

  public static boolean isQueenSquare(ChessSquare square) {
    // d && (1 or 8)
    return square.getFile() == 3 && (square.getRank() == 0 || square.getRank() == 7);
  }

  public static boolean isKingSquare(ChessSquare square) {
    // e && (1 or 8)
    return square.getFile() == 4 && (square.getRank() == 0 || square.getRank() == 7);
  }

  public static boolean isPawnSquare(ChessSquare square) {
    // (2 or 7)
    return square.getRank() == 1 || square.getRank() == 6;
  }
}