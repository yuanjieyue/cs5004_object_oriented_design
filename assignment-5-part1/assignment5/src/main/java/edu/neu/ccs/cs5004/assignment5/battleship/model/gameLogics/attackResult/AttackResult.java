package edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult;

public interface AttackResult {

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of attack
   */
  String result();
}
