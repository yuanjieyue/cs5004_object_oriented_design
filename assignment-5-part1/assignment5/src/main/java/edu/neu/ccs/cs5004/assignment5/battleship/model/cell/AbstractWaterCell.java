package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult.*;

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  @Override
  public Boolean isSunk() {
    return false;
  }
  /**
   * Create a water cell.
   *
   * @param isHit the state of being hit or not of the cell
   */
  public AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Change the state of a cell after it is hit by enemy.
   *
   * @return the cell after hit
   */
  @Override
  public Cell attackCell() {
    return cellCopyFactory();
  }

  /**
   * Create a new abstract water cell.
   *
   * @return the newly created cell
   */
  protected abstract AbstractWaterCell cellCopyFactory();

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
    if (obj == null || this.getClass() != this.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int res = super.hashCode();
    res = 31 * res + 31;
    return res;
  }

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "{" + super.toString() + "}";
  }
}
