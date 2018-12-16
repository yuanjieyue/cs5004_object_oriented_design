package edu.neu.ccs.cs5004.problem_2;

public interface Cell {

  /**
   * Update the states of cell if it is hit.
   *
   * @return the new cell after the hti
   */
  Cell beingHit();

  /**
   * Check if the cell is able to place a ship.
   *
   * @return true if it can be placed a ship, false otherwise
   */
  Boolean isPlacable();

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  AttackResult resultOfAttack();
}
