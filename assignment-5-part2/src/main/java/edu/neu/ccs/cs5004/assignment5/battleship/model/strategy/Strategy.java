package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.StrategyOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.UnsupportedOperationException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor.UserInteraction;

import java.io.BufferedReader;

public interface Strategy {
  
  /**
   * Create a strategy instance.
   * @param reader a buffer reader to get stream
   * @param player a game player
   * @return a strategy for the given player
   */
  static Strategy initiateStrategy(BufferedReader reader, Player player) {
    StrategyOptions res = null;
    res = UserInteraction.enquireStrategy(reader, player);
    switch (res) {
      case USER:
        return new UserStrategy(reader, player);
      case RANDOM:
        return new RandomStrategy(reader, player);
      case SMART:
        return new SmartStrategy(reader, player);
      default:
        throw new UnsupportedOperationException("Strategy not defined!");
    }
  }
  /**
   * Generate a new posn for the gamePlayer to attack.
   *
   * @return the posn to attack
   */
  Posn generateAttackPosn();
  
  Player getPlayer();
}
