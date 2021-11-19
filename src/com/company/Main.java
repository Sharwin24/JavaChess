package com.company;

import model.chessboard.ChessBoard;
import model.chessboard.IChessBoard;

public class Main {

  public static void main(String[] args) {
    IChessBoard board = new ChessBoard();
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        System.out.print(board.getBoardArray().get(r).get(c) + "  ");
      }
      System.out.println();
    }
  }
}