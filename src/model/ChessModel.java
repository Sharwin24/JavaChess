package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.chessboard.ChessBoard;
import model.chessboard.ChessSquare;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils;
import model.utility.Utils;

/**
 * An implementation of <code>IChessModel</code> to run a Chess game. The model provides utility for
 * an <code>IChessController</code>
 */
public class ChessModel implements IChessModel {

  private IChessBoard chessBoard;
  private EChessColor currentPlayerTurn;

  /**
   * Constructs a <code>ChessModel</code> with a given starting board and player turn. The starting
   * board is <i>not</i> necessarily a reset board.
   *
   * @param chessBoard An <code>IChessBoard</code> for the starting board
   * @param playerTurn A <code>EChessColor</code> representing the player's turn for the given
   *                   starting board.
   */
  public ChessModel(IChessBoard chessBoard, EChessColor playerTurn) {
    this.chessBoard = chessBoard;
    this.currentPlayerTurn = playerTurn;
  }

  /**
   * Constructs a <code>ChessModel</code> with a reset starting board, and white as the starting
   * color.
   */
  public ChessModel() {
    this.chessBoard = new ChessBoard();
    this.currentPlayerTurn = EChessColor.WHITE;
  }

  @Override
  public void resetBoard() {
    this.chessBoard.initBoard();
    this.currentPlayerTurn = EChessColor.WHITE;
    // Reset timer
  }

//  private static final Map<EChessColor, IChessMove> moveStylesMap = initMoveStylesMap;
//  private static Map<EChessColor, IChessMove> initMoveStylesMap() {
//    Map<EChessColor, ChessMove> moveStylesMap = new HashMap<>();
//    moveStylesMap.putIfAbsent(null, new MoveToEmptySquare());
//    moveStylesMap.putIfAbsent(EChessColor.WHITE, new MoveToSquareContainingWhitePiece());
//    moveStylesMap.putIfAbsent(EChessColor.BLACK, new MoveToSquareContainingBlackPiece());
//
//    return moveStylesMap;
//  }
//
//  /**
//   * A function object that consumes a chess piece to move and
//   * a square to move to, and returns a new
//   * board depending where the move has been executed one of three ways (implementations):
//   * <ol>
//   *   <li>a move to a square containing a white piece</li>
//   *   <li>a move to a square containing a black piece</li>
//   *   <li>a move to a square containing no piece</li>
//   * </ol>
//   */
//  private interface IChessMove {
//    IChessBoard executeMove(IChessPiece pieceToMove, IChessSquare destinationSquare);
//  }
//
//  /**
//   * Returns a [Maybe EChessColor], where a [Maybe X] is either an X or null.
//   * @param returnMyPieceColorOrNull the square whose piece color, or null, will be returned
//   * @return a [Maybe EChessColor] representing the color of the piece on the given square, or null
//   * if there is no piece on the given square.
//   */
//  private static EChessColor pieceColorSwitcher(IChessSquare returnMyPieceColorOrNull) {
//    if (!returnMyPieceColorOrNull.hasPiece()) {
//      return null;
//    }
//
//    return returnMyPieceColorOrNull.getPiece().getColor();
//  }

  @Override
  public void move(IChessPiece pieceToMove, IChessSquare destinationSquare) {

    // store the list of squares that pieceToMove can move to
    List<IChessSquare> legalMoves = pieceToMove.possibleMoves(this.chessBoard);

    // if the destinationSquare is not a possible move, then throw an exception
    if (!legalMoves.contains(destinationSquare)) {
      throw new IllegalStateException("Cannot move piece " + pieceToMove + " from " +
          pieceToMove.getSquare() + " to " + destinationSquare);
    }

    if (destinationSquare.hasPiece() &&
        destinationSquare.getPiece().getColor() != currentPlayerTurn) {
      this.chessBoard.setChessBoardArray(moveHelp(pieceToMove, destinationSquare));
      // TODO: add the piece that got taken to a graveyard/win pile for each player
    } else if (!destinationSquare.hasPiece()) {
      this.chessBoard.setChessBoardArray(moveHelp(pieceToMove, destinationSquare));
    } else {
      throw new IllegalStateException("Cannot move piece " + pieceToMove + " from " +
          pieceToMove.getSquare() + " to " + destinationSquare);
    }

  }

  /**
   * given a valid move, returns the new state of the board, with <strong><i>swag</i></strong>
   *
   * @param pieceToMove
   * @param destinationSquare
   * @return
   */
  private List<List<IChessSquare>> moveHelp(IChessPiece pieceToMove,
      IChessSquare destinationSquare) {
    return ChessUtils.boardMap(
        ChessUtils.boardMap(chessBoard.getBoardArray(),
            (sqr -> sqr.getPiece().equals(pieceToMove) ?
                new ChessSquare(sqr, false) : sqr)),
        (sqr -> sqr.getRank() == destinationSquare.getRank()
            && sqr.getFile() == destinationSquare.getFile() ?
            new ChessSquare(sqr, pieceToMove) : sqr));
  }
}