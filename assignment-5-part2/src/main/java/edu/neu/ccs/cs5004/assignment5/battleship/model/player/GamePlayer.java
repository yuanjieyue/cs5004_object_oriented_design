package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

import java.util.ArrayList;

/**
 * Represent a player in the game.
 */
public class GamePlayer extends APlayer {

  public GamePlayer(String name, ArrayList<ShipSubject> fleet) {
    super(name, fleet);
  }
}
