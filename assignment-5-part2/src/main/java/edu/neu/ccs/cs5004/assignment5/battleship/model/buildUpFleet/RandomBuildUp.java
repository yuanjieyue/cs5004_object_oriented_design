package edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Submarine;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Represents a rondom fleet builder of the game.
 */
public class RandomBuildUp extends AFleetBuildUp {
  private static final int NUM_OF_SHIPS = 10;
  private static final int NUM_OF_BATTLESHIPS = 1;
  private static final int NUM_OF_CRUISER = 2;
  private static final int NUM_OF_SUBMARINE = 3;

  @Override
  public ArrayList<ShipSubject> fleetBuild(BufferedReader reader, Player player) {
    ArrayList<ShipSubject> fleet = new ArrayList<>();

    Ship shipToAdd = null;
    ShipSubject subjectToAdd = null;
    int idx = 0;
    while (idx < NUM_OF_SHIPS) {
      if (idx < NUM_OF_BATTLESHIPS) {
        shipToAdd = new BattleShip(INITIAL_NUM_OF_HITCELLS);
      } else if (idx < NUM_OF_CRUISER + NUM_OF_BATTLESHIPS) {
        shipToAdd = new Cruiser(INITIAL_NUM_OF_HITCELLS);
      } else if (idx < NUM_OF_SUBMARINE + NUM_OF_CRUISER + NUM_OF_BATTLESHIPS) {
        shipToAdd = new Submarine(INITIAL_NUM_OF_HITCELLS);
      } else {
        shipToAdd = new Destroyer(INITIAL_NUM_OF_HITCELLS);
      }
      subjectToAdd = new ShipSubject(shipToAdd, new ArrayList<>());
      fleet.add(subjectToAdd);
      idx++;
    }
    return fleet;
  }
}
