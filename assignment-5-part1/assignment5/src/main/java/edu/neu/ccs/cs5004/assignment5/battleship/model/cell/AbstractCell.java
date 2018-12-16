package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

public abstract class AbstractCell implements Cell{

  private Boolean isHit;
  private Posn position;

  /**
   * Create a cell.
   *
   * @param isHit the state of being hit or not of the cell
   */
  public AbstractCell(Boolean isHit, Posn posn) {
    this.isHit = isHit;
    this.position = posn;
  }

  /**
   * Getter for property 'isHit.
   *
   * @return isHit
   */
  public Boolean getIsHit() {
    return isHit;
  }

  /**
   * Getter for property 'position'.
   *
   * @return the position of the cell
   */
  public Posn getPosition() {
    return position;
  }

  @Override
  public Boolean isHit() {
    return getIsHit();
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
    if (this.getIsHit() != null ? !this.getIsHit().equals(cell.getIsHit()) : cell.getIsHit()
        != null) {
      return false;
    }
    /*
    if (this.observers != null ? !listEquals(this.observers, cell.getObservers()) : cell
        .getObservers() != null) {
      return false;
    }
    */
    return this.getPosition() != null ? this.getPosition().equals(cell.getPosition()) : cell
        .getPosition() == null;
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    int res = (isHit != null ? isHit.hashCode() : 0);
    res = res * 31 + (position != null ? position.hashCode() : 0);
    return res;
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "isHit=" + isHit + ", position=" + position;
  }
}
