package edu.neu.ccs.cs5004.assignment5.battleship.model.buildupfleet;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Submarine;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a user ship configurer of the game.
 */
public class UserBuildUp extends AFleetBuildUp {
  private static final int MAX_QUANTITY = 5;
  
  @Override
  public ArrayList<ShipSubject> fleetBuild(BufferedReader reader, Player player) {
    ArrayList<ShipSubject> fleet = new ArrayList<>();
    Ship shipToAdd = null;
    ShipSubject subjectToAdd = null;
    int idx = MAX_QUANTITY;
    System.out.println("Start building up " + player.getPlayerName() + "'s the fleet!");
    System.out.println("'-1' if you want to stop!");
    String choose = "";
    while (idx > 0) {
      System.out.println();
      System.out.println("There are four kinds of ships: ");
      System.out.println("'1' for 'Battleship'");
      System.out.println("'2' for 'Cruiser'");
      System.out.println("'3' for 'Submarine'");
      System.out.println("'4' for 'Destroyer'");
      System.out.println("you want to add to the fleet: ");
      try {
        choose = reader.readLine();
        if (choose == null) {
          choose = "";
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      switch (choose) {
        case "1":
          System.out.println("1 BattleShip added to the fleet!");
          shipToAdd = new BattleShip(INITIAL_NUM_OF_HITCELLS);
          break;
        case "2":
          System.out.println("1 Cruiser added to the fleet!");
          shipToAdd = new Cruiser(INITIAL_NUM_OF_HITCELLS);
          break;
        case "3":
          System.out.println("1 Submarine added to the fleet!");
          shipToAdd = new Submarine(INITIAL_NUM_OF_HITCELLS);
          break;
        case "4":
          System.out.println("1 Destroyer added to the fleet!");
          shipToAdd = new Destroyer(INITIAL_NUM_OF_HITCELLS);
          break;
        case "-1":
          System.out.println("Fleet building up complete!\n");
          System.out.println("There are " + fleet.size() + " ships in the fleet!\n");
          return fleet;
        default:
          System.out.println("Wrong choice, please choose again!");
          continue;
      }
      subjectToAdd = new ShipSubject(shipToAdd, new ArrayList<>());
      fleet.add(subjectToAdd);
      idx--;
    }
    System.out.println(player.getPlayerName() + "'s Fleet building up complete!");
    System.out.println("There are " + fleet.size() + " ships in the fleet!\n");
    return fleet;
  }
}
