package edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl;

import edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet.FleetBuildUp;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager.PlaceFleetManager;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

import java.io.BufferedReader;

public class DebugMode extends AGameCtrl {
  /**
   * Helper function to printMaps.
   *
   * @param player   current gamePlayer
   * @param opponent the opponent gamePlayer
   */
  @Override
  public void printMapsFactory(Player player, Player opponent) {
    ConsolePrinter printer = new ConsolePrinter();
    
    System.out.println("Now print " + player.getPlayerName() + "'s maps.");
    player.getFleetBoardMap().prettyPrint(printer);
    player.getGuessMap().prettyPrint(printer);
  
    System.out.println("Now print " + opponent.getPlayerName() + "'s maps.");
    opponent.getFleetBoardMap().prettyPrint(printer);
    opponent.getGuessMap().prettyPrint(printer);
  }
  
  @Override
  public void setUpPlayerFleet(BufferedReader reader) {
    //create the fleets for both players.
    FleetBuildUp fleetBuildUp = FleetBuildUp.createFleetBuilder(GameModeOptions.DEBUG);
    getHumanPlayer().setFleet(fleetBuildUp.fleetBuild(reader, getHumanPlayer()));
    getArtificialPlayer().setFleet(fleetBuildUp.fleetBuild(reader, getArtificialPlayer()));
  
    //place the ships for each player.
    PlaceFleetManager placeFleetManagerForAi = PlaceFleetManager.createRandomPlacement();
    placeFleetManagerForAi.placeFleet(reader, getArtificialPlayer());
    PlaceFleetManager placeFleetManagerForHuman = PlaceFleetManager.createUserPlacement();
    placeFleetManagerForHuman.placeFleet(reader, getHumanPlayer());
  
  }
}