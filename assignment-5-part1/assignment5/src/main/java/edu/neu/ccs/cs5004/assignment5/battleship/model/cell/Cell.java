package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public interface Cell extends ShipObserver {

  /**
   * Return if the cell is being hit or not.
   *
   * @return true if the cell is being hit, false otherwise
   */
  Boolean isHit();

  /**
   * Return the position of the cell on the map.
   *
   * @return the cell of the position
   */
  Posn getPosition();

  /**
   * Return if the cell belongs to a sunk ship or not.
   *
   * @return true if the cell belongs to a sunk ship, false otherwise
   */
  Boolean isSunk();

  /**
   * Update the states of cell if it is hit.
   *
   * @return the new cell after the hti
   */
  Cell attackCell();

  /**
   * Check if the cell is able to place a ship.
   *
   * @return true if it can be placed a ship, false otherwise
   */
  Boolean placeShipOnCell();

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  AttackResult attackResult();

  /**
   * Print the cell to the console.
   *
   * @param printer the printer will be adopted to print
   */
  void prettyPrint(ConsolePrinter printer);

}
