package model.chessplayer;

import java.util.List;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * Representation of a Chess player.
 * TODO: Method JavaDocs
 */
public interface IChessPlayer {

  /**
   * @return
   */
  EChessColor getColor();

  /**
   * @return
   */
  boolean isTurn();

  /**
   * Sets the turn boolean to the given value
   *
   * @param turn the value to set turn to.
   */
  void setTurn(boolean turn);
}