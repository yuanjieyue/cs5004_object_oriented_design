package edu.neu.ccs.cs5004.assignment5.battleship.model.userInteractor;

import java.io.BufferedReader;
import java.io.IOException;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.ColumnIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.FleetPlacementOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.RowIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.StrategyOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.RandomStrategy;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.SmartStrategy;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.Strategy;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.UserStrategy;

public interface IUserInteractor {

  static final int DEFAULT = -1;
  /**
   * Asking for the user to input the row index of the ship.
   *
   * @param reader the reader that reading the input of user from the console
   * @throws IOException
   */
  static int askForRowIndex(BufferedReader reader) throws IOException {
    System.out.println("Please input the RowIndex, type a number in [1, 10]: ");
    String rowIndex = reader.readLine();
    while (Integer.parseInt(rowIndex) < 1 || Integer.parseInt(rowIndex) > 10) {
      System.out.println("Index out of bound!");
      System.out.println("Please input again, type a number in [1, 10]: ");
      rowIndex = reader.readLine();
    }
    switch (rowIndex){
      case "1":
        return RowIndex.ONE.ordinal() + 1;
      case "2":
        return RowIndex.TWO.ordinal() + 1;
      case "3":
        return RowIndex.THREE.ordinal() + 1;
      case "4":
        return RowIndex.FOUR.ordinal() + 1;
      case "5":
        return RowIndex.FIVE.ordinal() + 1;
      case "6":
        return RowIndex.SIX.ordinal() + 1;
      case "7":
        return RowIndex.SEVEN.ordinal() + 1;
      case "8":
        return RowIndex.EIGHT.ordinal() + 1;
      case "9":
        return RowIndex.NINE.ordinal() + 1;
      case "10":
        return RowIndex.TEN.ordinal() + 1;
      default:
        System.out.println("Invalid Index!");
        break;
    }
    return DEFAULT;
  }

  /**
   * Asking for the user to input the column index of the ship.
   *
   * @param reader the reader that reading the input of user from the console
   * @throws IOException
   */
  static int askForColumnIndex(BufferedReader reader) throws IOException {
    System.out.println("Please input the RowIndex, type a character between A and J: ");
    String columnIndex = reader.readLine();
    while (columnIndex.length() == 0 || columnIndex.length() > 1 || columnIndex.charAt(0) < 'A'
        || columnIndex.charAt(0) > 'J') {
      System.out.println("Index out of bound!");
      System.out.println("Please input again, type a character between A and J: ");
      columnIndex = reader.readLine();
    }
    switch (columnIndex){
      case "A":
        return ColumnIndex.A.ordinal() + 1;
      case "B":
        return ColumnIndex.B.ordinal() + 1;
      case "C":
        return ColumnIndex.C.ordinal() + 1;
      case "D":
        return ColumnIndex.D.ordinal() + 1;
      case "E":
        return ColumnIndex.E.ordinal() + 1;
      case "F":
        return ColumnIndex.F.ordinal() + 1;
      case "G":
        return ColumnIndex.G.ordinal() + 1;
      case "H":
        return ColumnIndex.H.ordinal() + 1;
      case "I":
        return ColumnIndex.I.ordinal() + 1;
      case "J":
        return ColumnIndex.J.ordinal() + 1;
      default:
        System.out.println("Invalid Index!");
        break;
    }
    return DEFAULT;
  }


  /**
   * Asking for the user to input the orientation of the ship.
   *
   * @param reader the reader that reading the user's input
   * @return the orientation of the ship that placed on the map
   * @throws IOException
   */
  static Orientation askForOrientation(BufferedReader reader) throws IOException {
    System.out.println("Please input the Orientation, type character \"H\" for 'Vertical' or "
        + "\"V\" for 'Horizontal': ");
    String ori = reader.readLine();
    while (ori.length() == 0 || ori.length() > 1 || ori.charAt(0) != 'A'
        || ori.charAt(0) != 'V') {
      System.out.println("Invalid Input!");
      System.out.println("Please input again, type a character 'H' or 'V': ");
      ori = reader.readLine();
    }
    switch (ori) {
      case "H":
        return Orientation.HORIZONTAL;
      case "V":
        return Orientation.VERTICAL;
      default:
        System.out.println("Invalid Orientation!");
    }
    return null;
  }

  static FleetPlacementOptions askForFleetPlacementMode(BufferedReader reader) throws IOException {
    System.out.println("Please input the mode of FleetPlacement: ");
    System.out.println("'0' for 'RANDOM MODE'");
    System.out.println("'1' for 'USER MODE'");
    String fleetPlaceOpt = reader.readLine();
    while (Integer.parseInt(fleetPlaceOpt) < 0 || Integer.parseInt(fleetPlaceOpt) > 1) {
      System.out.println("Invalid input!");
      System.out.println("Please input again!");
      fleetPlaceOpt = reader.readLine();
    }
    switch (fleetPlaceOpt) {
      case "0":


    }
  }

  static Strategy askForStrategy(BufferedReader reader) throws IOException {
    System.out.println("Choose the stratey you want to attack: ");
    System.out.println("'0' for 'RANDOM STRATEGY'");
    System.out.println("'1' for 'USER STRATEGY'");
    System.out.println("'2' for 'SMART STRATEGY'");
    String strategy = reader.readLine();
    while (Integer.parseInt(strategy) < 0 || Integer.parseInt(strategy) > 2) {
      System.out.println("Invalid input!");
      System.out.println("Please input again!");
      strategy = reader.readLine();
    }
    Strategy res = null;
    switch (strategy) {
      case "0":
        res = new RandomStrategy();
        break;
      case "1":
        res = new UserStrategy();
        break;
      case "3":
        res = new SmartStrategy();
        break;
      default:
        System.out.println("Invalid Strategy Option!");
        break;
    }
    return res;
  }
}
