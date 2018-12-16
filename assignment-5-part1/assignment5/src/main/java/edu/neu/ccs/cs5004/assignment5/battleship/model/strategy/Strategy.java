package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import java.io.IOException;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;

public interface Strategy {

  /**
   * Generate a new posn for the player to attack.
   *
   * @return the posn to attack
   */
  Posn generatePosn() throws IOException;
}
