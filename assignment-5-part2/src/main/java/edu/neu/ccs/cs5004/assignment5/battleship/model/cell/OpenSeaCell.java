package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class OpenSeaCell extends AbstractWaterCell {

  /**
   * Create a open sea cell.
   *
   * @param isHit the state of being hit or not of the cell
   * @param position the position of the cell
   */
  public OpenSeaCell(Boolean isHit, Posn position) {
    super(isHit, position);
  }

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public Boolean placeShipOnCell() {
    return true;
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }
  


  @Override
  public String toString() {
    return "OpenSeaCell" + super.toString();
  }

}
