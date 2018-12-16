package edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet.FleetBuildUp;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class RandomPlaceFleetManagerTest {
  private BufferedReader reader;

  private String playerName;
  private Player player;

  private GameModeOptions gameModeOptions;
  private FleetBuildUp fleetBuildUp;

  private ArrayList<ShipSubject> fleet;

  private PlaceFleetManager randomPlaceFleetManager;

  @Before
  public void setUp() throws Exception {
    reader = new BufferedReader(new InputStreamReader(System.in));

    gameModeOptions = GameModeOptions.GAME;
    fleetBuildUp = FleetBuildUp.createFleetBuilder(gameModeOptions);

    playerName = "AIPlayer";
    player = Player.initiatePlayer(playerName);

    fleet = fleetBuildUp.fleetBuild(reader, player);
    player.setFleet(fleet);
    randomPlaceFleetManager = PlaceFleetManager.createRandomPlacement();
  }

  @Test
  public void placeFleet() {
    randomPlaceFleetManager.placeFleet(reader, player);
  }

  @Test
  public void testToString() {
    String str = ("RandomPlaceFleetManager{}");
    Assert.assertEquals(randomPlaceFleetManager.toString(), str);
  }
}