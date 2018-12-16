package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.Hit;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.Miss;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.Sunk;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.*;

/**
 * Represents a player of the battleship game.
 */
public class Player implements IPlayer {
  private static final int NUM_OF_SHIPS = 10;
  private static final int NUM_OF_BATTLESHIPS = 1;
  private static final int NUM_OF_CRUISER = 2;
  private static final int NUM_OF_SUBMARINE = 3;
  private static final int NUM_OF_DESTROYER = 4;

  private static final int BATTLESHIP_INTITIAL_LENGTH = 4;
  private static final int CRUISER_INTITIAL_LENGTH = 3;
  private static final int SUBMARINE_INTITIAL_LENGTH = 2;
  private static final int DESTROYER_INTITIAL_LENGTH = 1;
  private static final int INITIAL_NUM_OF_HITCELLS = 0;

  private Ship[] ships;

  private Map fleetMap;
  private Map additionMap;

  /**
   * Create a new player for the battleship game.
   */
  public Player() {
    fleetMap = new Map();
    additionMap = new Map();
    ships = new Ship[NUM_OF_SHIPS];
    int i = 0;
    for (; i < ships.length; i++) {
      ships[i] = new BattleShip(BATTLESHIP_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
    }
    for (; i < NUM_OF_CRUISER + NUM_OF_BATTLESHIPS; i++) {
      ships[i] = new Cruiser(CRUISER_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
    }
    for (; i < NUM_OF_SUBMARINE + NUM_OF_CRUISER + NUM_OF_BATTLESHIPS; i++) {
      ships[i] = new Submarine(SUBMARINE_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
    }
    for (; i < NUM_OF_SHIPS; i++) {
      ships[i] = new Destroyer(DESTROYER_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
    }
  }

  public Player(Integer num) throws IOException {
    fleetMap = new Map();
    additionMap = new Map();
    ships = new Ship[num];
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;
    while (i < ships.length) {
      System.out.println("Please choose which kind of ship you want to place on the map: '1' for " +
          "'Battleship', '2' for 'Cruiser', '3' for Submarine and '4' for Destroyer");
      int choose = Integer.parseInt(reader.readLine());

      if (choose < 1 || choose > 4) {
        System.out.println("Wrong choose, please choose again!");
        continue;
      }
      switch (choose) {
        case 1:
          ships[i] = new BattleShip(BATTLESHIP_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
          break;
        case 2:
          ships[i] = new Cruiser(CRUISER_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
          break;
        case 3:
          ships[i] = new Submarine(SUBMARINE_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
          break;
        case 4:
          ships[i] = new Destroyer(DESTROYER_INTITIAL_LENGTH, INITIAL_NUM_OF_HITCELLS);
          break;
      }
      i++;
    }
  }

  public Integer getNumOfLiveShips() {
    int res = ships.length;
    for (int i = 0; i < ships.length; i++) {
      if (ships[i].isSunk()) {
        res--;
      }
    }
    return res;
  }

  public Integer getNumOfSunkShips() {
    return ships.length - getNumOfLiveShips();
  }

  /**
   * Getter for property 'fleetMap'.
   *
   * @return the fleet map of the player
   */
  public Map getFleetMap() {
    return fleetMap;
  }

  /**
   * Getter for property 'additionMap'.
   *
   * @return the addition map of the player
   */
  public Map getAdditionMap() {
    return additionMap;
  }

  public Boolean ifFail() {
    return getNumOfLiveShips() <= 0;
  }

  /**
   * Place the ships on the map randomly.
   */
  public void randomPlacement() {
    Random rand = new Random();
    int i = 0;
    while (i < ships.length) {
      Integer direction  = rand.nextInt(2); // will generate 0 and 1 uniformly.
      Posn posn = null;
      do {
        posn = new Posn(rand.nextInt(Map.ROW) + 1, rand.nextInt(Map.COLUMN) + 1);
      } while (!isPosnValid(ships[i], posn, direction));

      ships[i].setPosition(posn);
      ships[i].setDirection(direction);
      fleetMap.flipToSpecifiedCells(ships[i], posn, direction);
      fleetMap.flipToGapCells(fleetMap.checkCellsToFlipToGapCells(ships[i], posn, direction));
      i++;
    }
  }


  /**
   * User decides where and how to place the ships on the map.
   *
   * @throws IOException
   */
  public void userPlacement() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int i = 0;
    while (i < ships.length) {
      System.out.println("Please input the direction of the ship!('0' for Horizontal or '1' for " +
          "Vertical!): ");
      Integer direction = Integer.parseInt(reader.readLine());
      while (direction != 0 && direction != 1) {
        System.out.println("direction should be either '0' or '1'!");
        direction = Integer.parseInt(reader.readLine());
      }

      System.out.println("Please input the position of the ship: ");
      int coordX = Integer.parseInt(reader.readLine());
      int coordY = Integer.parseInt(reader.readLine());
      Posn posn = new Posn(coordX, coordY);
      while (coordX < 1 || coordX > 10 || coordY < 1 || coordY > 10 || !isPosnValid(ships[i],
          posn, direction)) {
        if (coordX < 1 || coordX > 10) {
          System.out.println("coordinate X is out of bound!");
        }
        if (coordY < 1 || coordY > 10) {
          System.out.println("coordinate Y is out of bound!");
        }
        if (!isPosnValid(ships[i], posn, direction)) {
          System.out.println("posn is not valid, some part of the ship is out of bound!");
        }
        coordX = Integer.parseInt(reader.readLine());
        coordY = Integer.parseInt(reader.readLine());
        posn = new Posn(coordX, coordY);
      }
      ships[i].setPosition(posn);
      ships[i].setDirection(direction);
      fleetMap.flipToSpecifiedCells(ships[i], posn, direction);
      fleetMap.flipToGapCells(fleetMap.checkCellsToFlipToGapCells(ships[i], posn, direction));
      i++;
    }
  }

  private boolean isPosnValid(Ship ship, Posn posn, Integer direction) {
    if (direction == AbstractShip.HORIZONTAL) {
      if (ship.size() + posn.getX() - 1 <= Map.COLUMN) {
        return true;
      } else {
        return false;
      }
    } else {
      if (ship.size() + posn.getY() - 1 <= Map.ROW) {
        return true;
      } else {
        return false;
      }
    }
  }

  @Override
  public void attack(Player player, Posn posn) {
    AttackResult res = player.response(posn);
    updateAdditionMap(res, posn);
  }

  public void updateAdditionMap(AttackResult res, Posn posn) {
    if (res.equals(new Miss())) {
      if (this.getAdditionMap().getCell(posn) instanceof OpenSeaCell) {
        this.getAdditionMap().setCell(posn, new OpenSeaCell(true));
      }
      else {
        return;
      }
    } else if (res.equals(new Hit())) {
      this.getAdditionMap().setCell(posn, new EnemyCell(true, false));
    } else { // res.equals(new Sunk()
      this.getAdditionMap().setCell(posn, new EnemyCell(true, true));
    }
  }
  @Override
  public AttackResult response(Posn posn) {
    AttackResult res = this.getFleetMap().getCell(posn).attackResult();
    res.toString();
    this.getFleetMap().setCell(posn, this.getFleetMap().getCell(posn).attackCell());
    if (!this.getFleetMap().observers().isEmpty()) {
      for (Ship ship : this.getFleetMap().observers()) {
        ship.update(fleetMap);
      }
    }
    if (this.getFleetMap().getCell(posn).isSunk()) {
      res = new Sunk();
    }
    return res;
  }

}
