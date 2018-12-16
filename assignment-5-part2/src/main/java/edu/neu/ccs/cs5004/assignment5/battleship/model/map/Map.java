package edu.neu.ccs.cs5004.assignment5.battleship.model.map;


import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.ColumnIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.RowIndex;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public interface Map {
  
  int ROW = RowIndex.values().length;
  int COLUMN = ColumnIndex.values().length;
  
  /**
   * Create a new map.
   *
   * @return the new map
   */
  static BoardMap createMap() {
    return new BoardMap();
  }
  
  /**
   * Get the field of the map.
   *
   * @return the field of the map
   */
  Cell[][] getField();
  
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
   * @param posn      the position of the cell
   * @param substitue the cell to be place on the position
   */
  void setCell(Posn posn, Cell substitue);
  
  /**
   * Check if the posn that the ship is going to be placed is valid or not.
   *
   * @param ship the ship that is going to be placed on the map
   * @param posn the posn that the ship is going to be place on
   * @param ori  the orientation how the ship is going to be placed
   * @return true if the posn on the map is valid for the ship to place
   */
  boolean isPosnValid(Ship ship, Posn posn, Orientation ori);
  
  /**
   * Flip the cells at the given {@code posn} to Specified Ship Cell.
   *
   * @param shipSubject the ship been placed on the cell at the given posn of the map
   * @param posn        the posn where the ship been placed on the map
   * @param ori         the orientaion of ship been placed on the map
   */
  void flipToSpecifiedCells(ShipSubject shipSubject, Posn posn, Orientation ori);
  
  /**
   * Flip the cells at the next to the given {@code posn} to Gap Cell.
   *
   * @param ship the ship been placed on the cell at the given posn of the map
   * @param posn the posn where the ship been placed on the map
   * @param ori  the orientation of the ship been placed on the map
   */
  void flipToGapCells(Ship ship, Posn posn, Orientation ori);
  
  /**
   * Use the given printer to print out the map.
   *
   * @param printer the printer
   */
  void prettyPrint(ConsolePrinter printer);
}

