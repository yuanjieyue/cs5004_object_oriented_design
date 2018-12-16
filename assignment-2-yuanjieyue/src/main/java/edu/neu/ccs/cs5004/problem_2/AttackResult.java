package edu.neu.ccs.cs5004.problem_2;

public interface AttackResult {

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return
   */
  String result();
}
