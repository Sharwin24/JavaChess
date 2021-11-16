package model.chessplayer;

import java.util.List;
import model.chesscolor.EChessColor;
import model.chesspiece.IChessPiece;

/**
 * Representation of a Chess player.
 * TODO: Method JavaDocs
 */
public interface IChessPlayer {

  EChessColor getColor();

  boolean isTurn();

}