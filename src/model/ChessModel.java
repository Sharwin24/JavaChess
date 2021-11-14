package model;

import model.chessboard.ChessBoard;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * An implementation of <code>IChessModel</code> to run a Chess game. The model
 * provides utility for an <code>IChessController</code>
 */
public class ChessModel implements IChessModel {

  private final IChessBoard chessBoard;
  private EChessColor currentPlayerTurn;

  /**
   * Constructs a <code>ChessModel</code> with a given starting board and
   * player turn. The starting board is <i>not</i> necessarily a reset board.
   * @param chessBoard An <code>IChessBoard</code> for the starting board
   * @param playerTurn A <code>EChessColor</code> representing the player's turn
   *                   for the given starting board.
   */
  public ChessModel(IChessBoard chessBoard, EChessColor playerTurn) {
    this.chessBoard = chessBoard;
    this.currentPlayerTurn = playerTurn;
  }

  /**
   * Constructs a <code>ChessModel</code> with a reset starting board, and
   * white as the starting color.
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

  @Override
  public void move(IChessPiece pieceToMove, IChessSquare destinationSquare) {
    chessBoard.getBoardArray().get(pieceToMove.getSquare().getFile())
  }
}