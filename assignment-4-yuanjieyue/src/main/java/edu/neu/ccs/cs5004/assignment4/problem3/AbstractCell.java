package edu.neu.ccs.cs5004.assignment4.problem3;

public abstract class AbstractCell implements Cell{
  private Boolean isHit;

  /**
   * Create a cell.
   *
   * @param isHit the state of being hit or not of the cell
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
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
    return true;
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    int res = (isHit != null ? isHit.hashCode() : 0);
    res = res * 31 + 31;
    return res;
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
