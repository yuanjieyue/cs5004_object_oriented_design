package edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Interface for fleet configurer.
 */
public interface FleetBuildUp {

  /**
   * Create new fleet builder as per user's selection.
   *
   * @param gameMode one of the game mode of the game
   * @return the fleet builder that the user choose
   */
  static FleetBuildUp createFleetBuilder(GameModeOptions gameMode) {
    if (gameMode == GameModeOptions.DEBUG) {
      return new UserBuildUp();
    } else {
      return new RandomBuildUp();
    }
  }

  /**
   * Building up the fleet as per user's input.
   *
   * @param reader the reader reads the user's input
   * @param player the player who owns the fleet
   * @return the list of ship subjects in the 'Fleet'
   */
  ArrayList<ShipSubject> fleetBuild(BufferedReader reader, Player player);
}
