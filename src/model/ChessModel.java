package model;

import java.util.ArrayList;
import java.util.List;
import model.chessboard.ChessBoard;
import model.chessboard.ChessSquare;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesspiece.IChessPiece;
import model.utility.ChessUtils;

/**
 * An implementation of <code>IChessModel</code> to run a Chess game. The model provides utility for
 * an <code>IChessController</code>
 */
public class ChessModel implements IChessModel {

  private IChessBoard chessBoard;
  private ChessUtils.EChessColor currentPlayerTurn;
  private List<IChessPiece> capturedBlackPieces;
  private List<IChessPiece> capturedWhitePieces;

  /**
   * Constructs a <code>ChessModel</code> with a given starting board and player turn. The starting
   * board is <i>not</i> necessarily a reset board.
   *
   * @param chessBoard An <code>IChessBoard</code> for the starting board
   * @param playerTurn A <code>ChessUtils.EChessColor</code> representing the player's turn for the given
   *                   starting board.
   */
  public ChessModel(IChessBoard chessBoard, ChessUtils.EChessColor playerTurn) {
    this.chessBoard = chessBoard;
    this.currentPlayerTurn = playerTurn;
    this.capturedWhitePieces = new ArrayList<>();
    this.capturedBlackPieces = new ArrayList<>();
  }

  /**
   * Constructs a <code>ChessModel</code> with a reset starting board, and white as the starting
   * color.
   */
  public ChessModel() {
    this(new ChessBoard(), ChessUtils.EChessColor.WHITE);
  }

  @Override
  public void playGame() {

  }

  @Override
  public List<IChessPiece> getCapturedBlackPieces() {
    return this.capturedBlackPieces;
  }

  @Override
  public List<IChessPiece> getCapturedWhitePieces() {
    return this.capturedWhitePieces;
  }

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
   * @param pieceToMove the piece to move
   * @param destinationSquare the square to move the given piece to
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