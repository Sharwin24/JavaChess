package model.chessplayer;

import model.chesscolor.EChessColor;

public abstract class AChessPlayer implements IChessPlayer {

  private final EChessColor playerColor;
  private boolean isTurn;

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

  /**
   * Sets the turn boolean to the given value
   * @param turn the value to set turn to.
   */
  public void setTurn(boolean turn) {
    this.isTurn = turn;
  }
}