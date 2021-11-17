package model.chessplayer;

import model.chesscolor.EChessColor;

/**
 * TODO:
 */
public abstract class AChessPlayer implements IChessPlayer {

  private final EChessColor playerColor;
  private boolean isTurn;

  /**
   * Constructs a Chess player with the given color
   * TODO: null checks
   * @param playerColor
   */
  protected AChessPlayer(EChessColor playerColor) {
    this.playerColor = playerColor;
    this.isTurn = false;
  }

  @Override
  public EChessColor getColor() {
    return this.playerColor;
  }

  @Override
  public boolean isTurn() {
    return this.isTurn;
  }

  @Override
  public void setTurn(boolean turn) {
    this.isTurn = turn;
  }
}