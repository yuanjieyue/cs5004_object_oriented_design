package edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer;


import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.WaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;

public interface IConsolePrinter {

  /**
   * Print a map to the console.
   *
   * @param map the map to be printed
   */
  void toConsole(Map map);

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
