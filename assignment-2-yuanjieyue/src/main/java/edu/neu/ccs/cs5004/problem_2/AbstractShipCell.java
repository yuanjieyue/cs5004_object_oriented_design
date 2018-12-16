package edu.neu.ccs.cs5004.problem_2;

import java.util.Objects;

public abstract class AbstractShipCell extends AbstractCell implements ShipCell {

  private Sunkable belongToSunk;

  /**
   * Create a ship cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public AbstractShipCell(Hitable ishit, Sunkable belongToSunk) {
    super(ishit);
    this.belongToSunk = belongToSunk;
  }

  public Sunkable getBelongToSunk() {
    return belongToSunk;
  }

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public Boolean isPlacable() {
    return false;
  }

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
    return Objects.equals(getBelongToSunk(), shipCell.getBelongToSunk());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBelongToSunk());
  }

  /**
   * Print the instance and its fields in string
   * @return the string
   */
  @Override
  public String toString() {
    return "{" + super.toString() + ", belongToSunk=" + belongToSunk + '}';
  }
}
