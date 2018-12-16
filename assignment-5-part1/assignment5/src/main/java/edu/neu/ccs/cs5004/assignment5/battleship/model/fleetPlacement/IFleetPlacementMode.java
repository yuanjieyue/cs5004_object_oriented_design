package edu.neu.ccs.cs5004.assignment5.battleship.model.fleetPlacement;

import java.io.BufferedReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

/**
 * Interface for fleet placement mode.
 */
public interface IFleetPlacementMode {

  /**
   * The player places the fleet on his map according his input fleet placement mode.
   *
   * @param reader the reader that reads the player's option
   * @param player the player of battleship game
   */
  void placeFleet(BufferedReader reader, Player player);
}
