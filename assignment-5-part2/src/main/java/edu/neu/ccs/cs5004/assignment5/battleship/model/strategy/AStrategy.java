package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;

public abstract class AStrategy implements Strategy {
  
  private BufferedReader reader;
  private Player player;
  
  public AStrategy(BufferedReader reader, Player player) {
    this.reader = reader;
    this.player = player;
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public BufferedReader getReader() {
    return reader;
  }
  
  /**
   * Check if the posn is in the board bound.
   * @param posn the position
   * @return true if the posn is in bound, false otherwise
   */
  public static boolean checkPosnInBound(Posn posn) {
    if (posn.getX() < 0 || posn.getX() >= Map.ROW
        || posn.getY() < 0 || posn.getY() >= Map.COLUMN) {
      return false;
    }
    return true;
  }
  
}
