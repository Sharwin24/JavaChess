package com.company;

import java.util.List;
import model.chessboard.ChessBoard;
import model.chessboard.IChessBoard;
import model.chessboard.IChessSquare;

public class Main {

  public static void main(String[] args) {
    // write your code here
    IChessBoard board = new ChessBoard();
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        System.out.print(board.getBoardArray().get(r).get(c) + "  ");
      }
      System.out.println();
    }
  }
}