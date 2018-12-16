package edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class UserBuildUpTest {
  private BufferedReader reader;
  private BufferedReader reader2;
  private String input;
  private String input2;
  private InputStream mockInputStream;
  private InputStream mockInputStream2;

  private String playerName;
  private Player player;

  private GameModeOptions gameModeOptions;
  private FleetBuildUp fleetBuildUp;

  private ArrayList<ShipSubject> fleet;

  private ShipSubject ship1;
  private ShipSubject ship2;
  private ShipSubject ship3;
  private ShipSubject ship4;

  @Before
  public void setUp() throws Exception {
    input = ("1\n2\n3\n4\na\n-1");
    input2 = ("1\n2\n3\n4\na\n1");
    mockInputStream = new ByteArrayInputStream(

        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    mockInputStream2 = new ByteArrayInputStream(
    
        // 'UTF-8' is the encoding using which the bytes should be read
        input2.getBytes("UTF-8")
    );
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
    reader2 = new BufferedReader(new InputStreamReader(mockInputStream2));

    gameModeOptions = GameModeOptions.DEBUG;
    fleetBuildUp = FleetBuildUp.createFleetBuilder(gameModeOptions);

    playerName = "HumanPlayer";
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
  }

  @Test
  public void fleetBuild() {
    
    Assert.assertEquals(fleetBuildUp.fleetBuild(reader, player), fleet);
    FleetBuildUp.createFleetBuilder(gameModeOptions).fleetBuild(reader2, player);
  }
}