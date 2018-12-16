package edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.BoardMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

import java.io.BufferedReader;
import java.util.Random;

/**
 * Represnet a random manager to place fleet.
 */
public class RandomPlaceFleetManager extends APlaceFleetManager {

  @Override
  public void placeFleet(BufferedReader reader, Player player) {
    Random rand = new Random();
    for (ShipSubject ship : player.getFleet()) {
      Integer input = rand.nextInt(2);
      Orientation ori = (input == 0 ? Orientation.VERTICAL : Orientation.HORIZONTAL);
      Posn posn = null;
      do {
        posn = new Posn(rand.nextInt(BoardMap.ROW) + 1, rand.nextInt(BoardMap.COLUMN) + 1);
      } while (!player.getFleetBoardMap().isPosnValid(ship.getShip(), posn, ori));
      player.getFleetBoardMap().flipToSpecifiedCells(ship, posn, ori);
      player.getFleetBoardMap().flipToGapCells(ship.getShip(), posn, ori);
      ship.registerObserver(player.getFleetBoardMap().getCell(posn));
    }
    System.out.println("Player " + player.getPlayerName() + "'s fleet has been placed!\n");
  }

  @Override
  public String toString() {
    return "RandomPlaceFleetManager{}";
  }
}
