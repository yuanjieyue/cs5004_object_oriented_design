package edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor.UserInteraction;

import java.io.BufferedReader;

/**
 * Represent the User console to place the fleet.
 */
public class UserPlaceFleetManager extends APlaceFleetManager {

  @Override
  public void placeFleet(BufferedReader reader, Player player) {
    ConsolePrinter printer = new ConsolePrinter();
    int count = 1;
    int coordX = 0;
    int coordY = 0;
    Posn posn = null;
    for (ShipSubject ship : player.getFleet()) {
      System.out.println("Now please deploy the " + count + " ship in the fleet!");
      Orientation ori = UserInteraction.enquireOrientation(reader);
      do {
        coordY = UserInteraction.enquireColumnIndex(reader);
        coordX = UserInteraction.enquireRowIndex(reader);
        posn = new Posn(coordX, coordY);
      } while (!(player.getFleetBoardMap().isPosnValid(ship.getShip(), posn, ori)));
      player.getFleetBoardMap().flipToSpecifiedCells(ship, posn, ori);
      player.getFleetBoardMap().flipToGapCells(ship.getShip(), posn, ori);
      ship.registerObserver(player.getFleetBoardMap().getCell(posn));
      count++;
      player.getFleetBoardMap().prettyPrint(printer);
    }
    System.out.println("Player " + player.getPlayerName() + "'s fleet has been placed!\n");
  }

  @Override
  public String toString() {
    return "UserPlaceFleetManager{}";
  }
}
