package edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class RandomBuildUpTest {
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
  private ShipSubject ship5;
  private ShipSubject ship6;
  private ShipSubject ship7;
  private ShipSubject ship8;
  private ShipSubject ship9;
  private ShipSubject ship10;

  @Before
  public void setUp() throws Exception {
    reader = new BufferedReader(new InputStreamReader(System.in));

    gameModeOptions = GameModeOptions.GAME;
    fleetBuildUp = FleetBuildUp.createFleetBuilder(gameModeOptions);

    playerName = "AIPlayer";
    player = Player.initiatePlayer(playerName);

    fleet = new ArrayList<ShipSubject>();

    ship1 = new ShipSubject(Ship.createBattleShip(), new ArrayList<>());
    ship2 = new ShipSubject(Ship.createCruiser(), new ArrayList<>());
    ship3 = new ShipSubject(Ship.createCruiser(), new ArrayList<>());
    ship4 = new ShipSubject(Ship.createSubmarine(), new ArrayList<>());
    ship5 = new ShipSubject(Ship.createSubmarine(), new ArrayList<>());
    ship6 = new ShipSubject(Ship.createSubmarine(), new ArrayList<>());
    ship7 = new ShipSubject(Ship.createDestroyer(), new ArrayList<>());
    ship8 = new ShipSubject(Ship.createDestroyer(), new ArrayList<>());
    ship9 = new ShipSubject(Ship.createDestroyer(), new ArrayList<>());
    ship10 = new ShipSubject(Ship.createDestroyer(), new ArrayList<>());
    fleet.add(ship1);
    fleet.add(ship2);
    fleet.add(ship3);
    fleet.add(ship4);
    fleet.add(ship5);
    fleet.add(ship6);
    fleet.add(ship7);
    fleet.add(ship8);
    fleet.add(ship9);
    fleet.add(ship10);
  }

  @Test
  public void fleetBuild() {
    Assert.assertEquals(fleetBuildUp.fleetBuild(reader, player), fleet);
  }
}