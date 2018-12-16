package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.BoardMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

import java.util.ArrayList;


/**
 * Represents an interface for the player.
 */
public interface Player {

  static GamePlayer initiatePlayer(String playerName) {
    return new GamePlayer(playerName, null);
  }
  /**
   * Get the name of the player.
   *
   * @return the name of the player
   */
  String getPlayerName();

  /**
   * Get the fleetmap of the player.
   *
   * @return the fleet map of the player
   */
  BoardMap getFleetBoardMap();

  /**
   * Get the additionmap of the player.
   *
   * @return the addition map of the player
   */
  BoardMap getGuessMap();

  /**
   * Get the fleet of the player.
   *
   * @return the fleet of the player
   */
  ArrayList<ShipSubject> getFleet();

  /**
   * Set the fleet of the player.
   *
   * @param fleet the fleet of the player to be setted
   */
  void setFleet(ArrayList<ShipSubject> fleet);

  /**
   * Check if the player is fail in the game.
   *
   * @return true if the player lose, false otherwise
   */
  Boolean isFleetSunk();
  
  /**
   * Return a cell to the enemy's addition BoardMap.
   *
   * @param posn the posn that the player's enemy attacks on the player's fleetmap
   * @return the cell to the enemy's addition BoardMap
   */
  Cell returnAttackResultToOpponent(Posn posn);

  /**
   * Update the player's additionMap based on the attack result and the cell from the enemy.
   * @param posn the posn that the player attacks his enemy last round
   * @param resultCell the result cell that the enemy return to the player
   */
  void updateGuessMapBasedOnAttackResultFromOpponent(Posn posn, Cell resultCell);
  
  /**
   * Update the fleet after attack.
   * @param posn the posn of attack
   */
  void updateFleetAfterAttack(Posn posn);
}
