package edu.neu.ccs.cs5004.assignment5.battleship.model.playmode;

import java.io.IOException;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

public interface IPlayMode {

  /**
   * Initialize a player.
   *
   * @param player the player to be initialized
   */
  void initialize(Player player) throws IOException;

  /**
   * Register new observers to the map.
   *
   * @param observer the new observer of the map
   */
  void registerObserver(Player observer);

  /**
   * remove observe from a list of observers.
   *
   * @param observer the observer to be removed
   */
  void removeObserver(Player observer);

  /**
   * View the map of the observers
   */
  void viewMaps();
}
