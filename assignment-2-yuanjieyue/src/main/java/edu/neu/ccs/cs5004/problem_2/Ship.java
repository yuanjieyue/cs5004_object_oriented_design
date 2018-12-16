package edu.neu.ccs.cs5004.problem_2;

public interface Ship {

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
}
