package edu.neu.ccs.cs5004.assignment5.battleship.model.placefleetmanager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet.FleetBuildUp;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class UserPlaceFleetManagerTest {
  private String input;
  private InputStream mockInputStream;
  private BufferedReader reader;

  private String playerName;
  private Player player;

  private GameModeOptions gameModeOptions;
  private FleetBuildUp fleetBuildUp;

  private ArrayList<ShipSubject> fleet;

  private ShipSubject ship1;
  private ShipSubject ship2;
  private ShipSubject ship3;
  private ShipSubject ship4;

  private PlaceFleetManager userPlaceFleetManager;

  @Before
  public void setUp() throws Exception {
    input = "H\nA\n2\nV\nE\n4\nH\nB\n8\nV\nG\n5";
    mockInputStream = new ByteArrayInputStream(
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    reader = new BufferedReader(new InputStreamReader(mockInputStream));

    gameModeOptions = GameModeOptions.DEBUG;
    fleetBuildUp = FleetBuildUp.createFleetBuilder(gameModeOptions);

    playerName = "AIPlayer";
    player = Player.initiatePlayer(playerName);

    fleet = new ArrayList<ShipSubject>();
    ship1 = new ShipSubject(Ship.createBattleShip(), new ArrayList<>());
    ship2 = new ShipSubject(Ship.createCruiser(), new ArrayList<>());
    ship3 = new ShipSubject(Ship.createSubmarine(), new ArrayList<>());
    ship4 = new ShipSubject(Ship.createDestroyer(), new ArrayList<>());

    fleet.add(ship1);
    fleet.add(ship2);
    fleet.add(ship3);
    fleet.add(ship4);

    player.setFleet(fleet);
    userPlaceFleetManager = PlaceFleetManager.createUserPlacement();
  }

  @Test
  public void placeFleet() {
    userPlaceFleetManager.placeFleet(reader, player);
  }

  @Test
  public void testToString() {
    String str = ("UserPlaceFleetManager{}");
    Assert.assertEquals(userPlaceFleetManager.toString(), str);
  }
}