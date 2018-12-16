package edu.neu.ccs.cs5004.problem_2;

import java.util.Objects;

public abstract class AbstractCell implements Cell{
  private Hitable isHit;

  /**
   * Create a cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public AbstractCell(Hitable ishit) {
    this.isHit = ishit;
  }

  /**
   * Getter for property 'isHit.
   *
   * @return isHit
   */
  public Hitable getIshit() {
    return isHit;
  }

  /**
   * Check if a ship could be put on the cell.
   *
   * @return true if the ship could be put on the cell, false otherwise
   */
  @Override
  public abstract Boolean isPlacable();

  /**
   * Change the state of a cell after it is hit by enemy.
   *
   * @return the cell after hit
   */
  public Cell beingHit() {
    return cellCopyFactory();
  }

  /**
   * Create a new cell.
   *
   * @return the newly created cell
   */
  protected AbstractCell cellCopyFactory() {
    return null;
  }

  /**
   * Check if the given object equals to the instance.
   *
   * @param obj the object to be compared
   * @return true if they are of the same class and have exactly the same fields.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractCell cell = (AbstractCell) obj;
    return Objects.equals(isHit, cell.isHit);
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {

    return Objects.hash(isHit);
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "isHit=" + isHit;
  }
}
