package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public interface Cell extends ShipObserver {

  /**
   * Create a new Open Sea Cell.
   *
   * @param isHit the state that the cell is hit or not.
   * @param posn the position of the cell
   * @return a new open sea cell
   */
  static Cell createOpenSeaCell(boolean isHit, Posn posn) {
    return new OpenSeaCell(isHit, posn);
  }

  /**
   * Greate a new Gap Cell.
   *
   * @param isHit the state that the cell is hit or not.
   * @param posn the position of the cell
   * @return a new gap cell
   */
  static Cell createGapCell(boolean isHit, Posn posn) {
    return new GapCell(isHit, posn);
  }

  /**
   * Create a new Specified Ship Cell.
   *
   * @param isHit the state that the cell is hit or not.
   * @param posn the position of the cell
   * @param isSunk the state that if the cell is sunk or not
   * @param shipSubject the ship subject that is bonded with the cell
   * @return a new specified ship cell
   */
  static Cell createSpecifiedCell(boolean isHit, Posn posn, boolean isSunk, ShipSubject
      shipSubject) {
    return new SpecifiedCell(isHit, posn, isSunk, shipSubject);
  }

  /**
   * Create a new Enemy Cell.
   *
   * @param isHit the state that the cell is hit or not.
   * @param posn the position of the cell
   * @param isSunk the state that if the cell is sunk or not
   * @return a new enemy cell
   */
  static Cell createEnemyCell(boolean isHit, Posn posn, boolean isSunk) {
    return new EnemyCell(isHit, posn, isSunk);
  }

  /**
   * Return if the cell is being hit or not.
   *
   * @return true if the cell is being hit, false otherwise
   */
  Boolean getIsHit();

  /**
   * Return the position of the cell on the map.
   *
   * @return the cell of the position
   */
  Posn getPosition();

  /**
   * Set the 'isHit' state of the cell to the given {@code hit}.
   *
   * @param hit the new 'isHit' state of the cell
   */
  void setIsHit(Boolean hit);

  /**
   * Update the states of cell if it is hit.
   */
  void attackCell();

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
   * Return a cell to be assigned to opponent's addition map.
   *
   * @return a cell to be assigned to opponent's addition map
   */
  Cell returnCellWhenAttacked();


  /**
   * Print the cell to the console.
   *
   * @param printer the printer will be adopted to print
   */
  void prettyPrint(ConsolePrinter printer);
}
