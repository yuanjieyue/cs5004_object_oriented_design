package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represent the ship in the game.
 */
public interface Ship {
  int INITIAL_NUM_OF_HIT_CELLS = 0;
  
  /**
   * Create a new battleship.
   * @return a new battleship.
   */
  static Ship createBattleShip() {
    return new BattleShip(INITIAL_NUM_OF_HIT_CELLS);
  }
  
  /**
   * Create a new Cruiser.
   * @return a new Cruiser.
   */
  static Ship createCruiser() {
    return new Cruiser(INITIAL_NUM_OF_HIT_CELLS);
  }
  
  /**
   * Create a new Submarine.
   * @return a new Submarine.
   */
  static Ship createSubmarine() {
    return new Submarine(INITIAL_NUM_OF_HIT_CELLS);
  }
  
  /**
   * Create a new Destroyer.
   * @return a new Destroyer.
   */
  static Ship createDestroyer() {
    return new Destroyer(INITIAL_NUM_OF_HIT_CELLS);
  }

  /**
   * Return number of hit cells of the ship.
   *
   * @return the number of hit cells of the ship
   */
  Integer getNumOfHitCells();

  /**
   * Return the size of the ship.
   *
   * @return the size of the ship
   */
  Integer getSize();

  /**
   * Update the ship if it is hit by enemy.
   *
   * @return the new ship after update
   */
  Ship afterAttack();

  /**
   * Check if the ship is sunk or not.
   *
   * @return true if the ship is sunk, false otherwise
   */
  Boolean isSunk();
}
