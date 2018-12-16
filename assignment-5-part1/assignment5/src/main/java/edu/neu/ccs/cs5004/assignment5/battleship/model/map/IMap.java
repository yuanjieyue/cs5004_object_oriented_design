package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public interface IMap {

  /**
   * Create a new map.
   * @return the new map
   */
  static Map createMap() {
    return new Map();
  }

  /**
   * Get the observers of the map.
   *
   * @return the observers of the map
   */
  List<Ship> observers();

  /**
   * Get the cell on the given position on the map.
   *
   * @param posn the position of the cell
   * @return the cell that on the position that is set by the row and column index on the field
   */
  Cell getCell(Posn posn);

  /**
   * Set the cell on the given position of the map as the given substitute cell.
   *
   * @param posn the position of the cell
   * @param substitue the cell to be place on the position
   */
  void setCell(Posn posn, Cell substitue);

  /**
   * Use the given printer to print out the map.
   *
   * @param printer the printer
   */
  void prettyPrint(ConsolePrinter printer);

  /**
   * Register new observers to the map.
   *
   * @param observer the new observer of the map
   */
  void registerObserver(Ship observer);

  /**
   * remove observe from a list of observers.
   *
   * @param observer the observer to be removed
   */
  void removeObserver(Ship observer);

  /**
   * notify observer if the map was changed.
   */
  void notifyObservers();
}

