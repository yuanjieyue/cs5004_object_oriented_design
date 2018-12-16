package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

public abstract class AbstractShipCell extends AbstractCell implements ShipCell {

  private Boolean isSunk;

  /**
   * Create a ship cell.
   *
   * @param isHit the state of being hit or not of the cell
   * @param isSunk the state of belonging to a sunk ship or not
   */
  public AbstractShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit);
    this.isSunk = isSunk;
  }

  public Boolean getIsSunk() {
    return isSunk;
  }

  public Boolean isSunk() {
    return getIsSunk();
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
  public abstract ShipCell markShipCellSunk();

  /**
   * Check if the given object equals to the instance.
   *
   * @param obj the object to be compared
   * @return true they have the same class and exactly the same fields value
   */
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
    AbstractShipCell shipCell = (AbstractShipCell) obj;
    if (this.getIsSunk() != null ? !shipCell.getIsSunk().equals(shipCell.getIsSunk()) : shipCell
        .getIsSunk() != null) {
      return false;
    }
    return super.equals(obj);
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    int res = super.hashCode();
    res = 41 * res + (getIsSunk() != null ? getIsSunk().hashCode() : 0);
    return res;
  }

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "{" + super.toString() + ", belongToSunk=" + isSunk + '}';
  }
}
