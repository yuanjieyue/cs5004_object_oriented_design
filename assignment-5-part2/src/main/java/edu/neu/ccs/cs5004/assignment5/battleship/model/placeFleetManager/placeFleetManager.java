package edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;

/**
 * Interface for fleet placement mode.
 */
public interface PlaceFleetManager {
  
  static PlaceFleetManager createRandomPlacement() {
    return new RandomPlaceFleetManager();
  }
  
  static PlaceFleetManager createUserPlacement() {
    return new UserPlaceFleetManager();
  }

  /**
   * The gamePlayer places the fleet on his map according his input fleet placement mode.
   *
   * @param reader the reader that reads the gamePlayer's option
   * @param player the gamePlayer of battleship game
   */
  void placeFleet(BufferedReader reader, Player player);
}
