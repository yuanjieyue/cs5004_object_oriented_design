package edu.neu.ccs.cs5004.assignment5.battleship.model.printer;


import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.*;

public interface IConsolePrinter {

  /**
   * Print a map to the console.
   *
   * @param map the map to be printed
   */
  void toConsole(IMap map);

  /**
   * Print a water cell to the console.
   *
   * @param cell the water cell to be printed.
   */
  void toConsole(WaterCell cell);

  /**
   * Print a specified ship cell to the console.
   *
   * @param cell the specified cell to be printed
   */
  void toConsole(SpecifiedCell cell);

  /**
   * Print an enemy cell to the console.
   *
   * @param cell the enemy cell to be printed
   */
  void toConsole(EnemyCell cell);
}
