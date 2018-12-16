package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;

public abstract class AbstractCell implements Cell{

  private Boolean isHit;
  private Posn position;
  
  
  /**
   * Create an abstract cell.
   * @param isHit if the cell is hit
   * @param posn the position
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
  @Override
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
  public void setIsHit(Boolean hit) {
    this.isHit = hit;
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
    return this.getPosition().equals(cell.getPosition());
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
