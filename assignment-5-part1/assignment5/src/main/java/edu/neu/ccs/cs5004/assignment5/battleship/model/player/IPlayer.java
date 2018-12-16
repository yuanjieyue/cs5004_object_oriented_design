package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;

/**
 * Represents an interface for the player.
 */
public interface IPlayer {

  /**
   * Attack another player by attacking one of the posn on his map.
   *
   * @param player the player to be attacked
   * @param posn the posn on the map of the player to be attacked
   */
  void attack(Player player, Posn posn);

  /**
   * Response the attack result when the player is attacked at the given posn on his map.
   *
   * @param posn the posn that is attack on the player's map
   */
  AttackResult response(Posn posn);
}
