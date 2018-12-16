package edu.neu.ccs.cs5004.assignment4.problem3;

public class EnemyCell extends AbstractShipCell {

  /**
   * Create an enemy cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public EnemyCell(Boolean ishit, Boolean isSunk) {
    super(ishit, isSunk);
  }

  @Override
  protected AbstractShipCell shipCellCopyFactory() {
    return new EnemyCell(this.getIsHit(), true);
  }


  @Override
  public Cell attackCell() {
    return new EnemyCell(true, this.getIsSunk());
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult attackResult() {
    return new Miss();
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
    res = 13 * res + 13;
    return res;
  }

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "EnemyCell" + super.toString();
  }

}
