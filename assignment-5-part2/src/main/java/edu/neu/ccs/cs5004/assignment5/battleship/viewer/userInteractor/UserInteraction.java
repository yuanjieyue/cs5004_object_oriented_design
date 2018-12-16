package edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.ColumnIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.FleetPlacementOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.RowIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.StrategyOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Represent the user-computer interaction viewer.
 */
public interface UserInteraction {

  int DEFAULT = -1;
  
  /**
   * Greetings to player.
   */
  static void greetingAndGameInstruction() {
    System.out.println("Welcome to Russian BattleShip board game!");
    System.out.println("Here's the brief instruction: ");
    System.out.println("There are four type of ships with different size: ");
    System.out.println("BattleShip 4  Cruiser 3  Submarine 2  Destroyer 1");
    System.out.println("Each player will have 10 ships in total.");
    System.out.println("In the game, you will smartly place your ships to avoid the attack and \n "
        + "accurately attack the enemy ships by make a guess of the position.");
    System.out.println("Let's start!");
    System.out.println();
  }
  /**
   * Asking for the user to input the row index of the ship to be placed on a map.
   *
   * @param reader the reader that reading the input of user from the console
   * @return the row index as an integer
   */
  static int enquireRowIndex(BufferedReader reader) {
    System.out.println("Please input the RowIndex, type a number between 1 and 10: ");
    String rowIndex = "";
    try {
      rowIndex = reader.readLine();
      if (rowIndex == null) {
        rowIndex = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    int res = DEFAULT;
    switch (rowIndex) {
      case "1":
        res = RowIndex.ONE.ordinal() + 1;
        break;
      case "2":
        res = RowIndex.TWO.ordinal() + 1;
        break;
      case "3":
        res = RowIndex.THREE.ordinal() + 1;
        break;
      case "4":
        res = RowIndex.FOUR.ordinal() + 1;
        break;
      case "5":
        res = RowIndex.FIVE.ordinal() + 1;
        break;
      case "6":
        res = RowIndex.SIX.ordinal() + 1;
        break;
      case "7":
        res = RowIndex.SEVEN.ordinal() + 1;
        break;
      case "8":
        res = RowIndex.EIGHT.ordinal() + 1;
        break;
      case "9":
        res = RowIndex.NINE.ordinal() + 1;
        break;
      case "10":
        res = RowIndex.TEN.ordinal() + 1;
        break;
      default:
        System.out.println("Invalid Row index!");
        res = enquireRowIndex(reader);
        break;
    }
    return res;
  }

  /**
   * Asking for the user to input the column index of the ship to be placed on a map.
   *
   * @param reader the reader that reading the input of user from the console
   * @return the row index as an integer
   */
  static int enquireColumnIndex(BufferedReader reader) {
    System.out.println("Please input the ColumnIndex, type a character between A and J: ");

    String columnIndex = "";
    try {
      columnIndex = reader.readLine();
      if (columnIndex == null) {
        columnIndex = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    int res = DEFAULT;
    switch (columnIndex) {
      case "A":
        res =  ColumnIndex.A.ordinal() + 1;
        break;
      case "B":
        res = ColumnIndex.B.ordinal() + 1;
        break;
      case "C":
        res = ColumnIndex.C.ordinal() + 1;
        break;
      case "D":
        res = ColumnIndex.D.ordinal() + 1;
        break;
      case "E":
        res = ColumnIndex.E.ordinal() + 1;
        break;
      case "F":
        res = ColumnIndex.F.ordinal() + 1;
        break;
      case "G":
        res = ColumnIndex.G.ordinal() + 1;
        break;
      case "H":
        res = ColumnIndex.H.ordinal() + 1;
        break;
      case "I":
        res =  ColumnIndex.I.ordinal() + 1;
        break;
      case "J":
        res = ColumnIndex.J.ordinal() + 1;
        break;
      default:
        System.out.println("Invalid Column Index!");
        res = enquireColumnIndex(reader);
        break;
    }
    return res;
  }


  /**
   * Asking the user for the orientation of the ship to be placed on a map.
   *
   * @param reader the reader that reading the user's input
   * @return one of the orientation options
   */
  static Orientation enquireOrientation(BufferedReader reader) {
    System.out.println("Please input the Orientation:");
    System.out.println("'H' for 'Horizontal'\n'V' for 'Vertical'");
    String ori = "";
    try {
      ori = reader.readLine();
      if (ori == null) {
        ori = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Orientation res = null;
    switch (ori) {
      case "H":
        res = Orientation.HORIZONTAL;
        break;
      case "V":
        res = Orientation.VERTICAL;
        break;
      default:
        System.out.println("Invalid Orientation!");
        res = enquireOrientation(reader);
        break;
    }
    return res;
  }

  /**
   * Ask the user for the mode to place the fleet.
   *
   * @param reader the reader that reads the user's input
   * @return one of the fleet placement options
   */
  static FleetPlacementOptions enquireFleetPlacementMode(BufferedReader reader) {
    System.out.println("There are two mode for the Fleet Placement: ");
    System.out.println("'0' for 'RANDOM MODE'");
    System.out.println("'1' for 'USER MODE'");
    System.out.println("Please choose the mode: ");
    String fleetPlaceOpt = "";
    try {
      fleetPlaceOpt = reader.readLine();
      if (fleetPlaceOpt == null) {
        fleetPlaceOpt = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    FleetPlacementOptions res = null;
    switch (fleetPlaceOpt) {
      case "0":
        res = FleetPlacementOptions.RANDOM;
        break;
      case "1":
        res = FleetPlacementOptions.USER;
        break;
      default:
        System.out.println("Invalid input!");
        res = enquireFleetPlacementMode(reader);
        break;
    }
    return res;
  }

  /**
   * Ask the user for the game mode to play.
   *
   * @param reader the reader that reads user's input
   * @return one of the game mode options
   */
  static GameModeOptions enquireGameMode(BufferedReader reader) {
    System.out.println("There are two play mode as follows: ");
    System.out.println("'0' for 'DEBUG MODE'");
    System.out.println("'1' for 'GAME MODE'");
    System.out.println("Please input the Game Mode: ");
    String gameModeOpt = "";
    try {
      gameModeOpt = reader.readLine();
      if (gameModeOpt == null) {
        gameModeOpt = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    GameModeOptions res = null;
    switch (gameModeOpt) {
      case "0":
        res = GameModeOptions.DEBUG;
        break;
      case "1":
        res = GameModeOptions.GAME;
        break;
      default:
        System.out.println("Invalid input!");
        res = enquireGameMode(reader);
        break;
    }
    return res;
  }
  
  /**
   * Ask the user for the strategy of the player.
   * @param reader the buffer reader
   * @param player the game player
   * @return the strategy option for the given player
   */
  static StrategyOptions enquireStrategy(BufferedReader reader, Player player) {
    System.out.println("Choose the strategy of " + player.getPlayerName() + " : ");
    System.out.println("'0' for 'RANDOM STRATEGY'");
    System.out.println("'1' for 'USER STRATEGY'");
    System.out.println("'2' for 'SMART STRATEGY'");
    String strategy = "";
    try {
      strategy = reader.readLine();
      if (strategy == null) {
        strategy = "";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    StrategyOptions res = null;
    switch (strategy) {
      case "0":
        res = StrategyOptions.RANDOM;
        break;
      case "1":
        res = StrategyOptions.USER;
        break;
      case "2":
        res = StrategyOptions.SMART;
        break;
      default:
        System.out.println("Invalid Strategy Option!");
        res = enquireStrategy(reader, player);
        break;
    }
    return res;
  }
  
  /**
   * Announce the winner and finish the game.
   *
   * @param player the winner of the game
   */
  static void announceWinner(Player player) {
    System.out.println("Congratulations ! " + player.getPlayerName() + " win !");
    System.out.println("Game over!");
  }
}
