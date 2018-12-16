package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public class GapCell extends AbstractWaterCell {

  /**
   * Create a gap cell.
   *
   * @param isHit the state of being hit or not of the cell
   */
  public GapCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public Boolean placeShipOnCell() {
    return false;
  }


  @Override
  protected AbstractWaterCell cellCopyFactory() {
    if (!getIsHit()) {
      return new GapCell(true);
    }
    return this;
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int res = super.hashCode();
    res = 23 * res + 23;
    return res;
  }

  @Override
  public String toString() {
    return "GapCell" + super.toString();
  }
}
