package edu.neu.ccs.cs5004.assignment4.problem3;

public interface IMap {

  /**
   * Create a new map.
   * @return the new map
   */
  static Map createMap() {
    return new Map();
  }

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
}

