package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;

import java.util.Objects;

public abstract class AbstractShipCell extends AbstractCell implements ShipCell {

  private Boolean isShipSunk;

  /**
   * Create a ship cell.
   *
   * @param isHit the state of being hit or not of the cell
   * @param position the posn of the cell
   * @param isShipSunk the state of belonging to a sunk ship or not
   */
  public AbstractShipCell(Boolean isHit, Posn position, Boolean isShipSunk) {
    super(isHit, position);
    this.isShipSunk = isShipSunk;
  }
  

  @Override
  public Boolean isSunk() {
    return isShipSunk;
  }

  @Override
  public void setSunk(Boolean sunk) {
    isShipSunk = sunk;
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
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    AbstractShipCell that = (AbstractShipCell) obj;
    return Objects.equals(isSunk(), that.isSunk());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isSunk());
  }

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "{" + super.toString() + ", belongToSunk=" + isShipSunk + '}';
  }
}
