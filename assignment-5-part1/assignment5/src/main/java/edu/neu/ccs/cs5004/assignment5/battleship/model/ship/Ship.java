package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;

public interface Ship {


  /**
   * Return number of hit cells of the ship.
   *
   * @return the number of hit cells of the ship
   */
  Integer numOfHitCells();

  /**
   * Return the size of the ship.
   *
   * @return the size of the ship
   */
  Integer size();

  /**
   * Update the ship if it is hit by enemy.
   *
   * @return the new ship after update
   */
  Ship beingHit();

  /**
   * Check if the ship is sunk or not.
   *
   * @return true if the ship is sunk, false otherwise
   */
  Boolean isSunk();


  /**
   * Update the state of the ship according to the map.
   *
   * @param map the map that the ship is placed on
   */
  /*
  void update(Map map);
  */
}
