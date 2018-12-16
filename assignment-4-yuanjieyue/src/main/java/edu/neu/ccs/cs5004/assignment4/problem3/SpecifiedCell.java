package edu.neu.ccs.cs5004.assignment4.problem3;

public class SpecifiedCell extends AbstractShipCell {

  /**
   * Create a specified cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public SpecifiedCell(Boolean ishit, Boolean isSunk) {
    super(ishit, isSunk);
  }

  @Override
  protected AbstractShipCell shipCellCopyFactory() {
    return new SpecifiedCell(this.getIsHit(), true);
  }

  @Override
  public AbstractShipCell attackCell() {
    return new SpecifiedCell(true, this.getIsSunk());
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult attackResult() {
    if (this.getIsSunk()) {
      return new Sunk();
    }
    return new Hit();
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
    res = 19 * res + 19;
    return res;
  }

  @Override
  public String toString() {
    return "SpecifiedCell" + super.toString();
  }

}
