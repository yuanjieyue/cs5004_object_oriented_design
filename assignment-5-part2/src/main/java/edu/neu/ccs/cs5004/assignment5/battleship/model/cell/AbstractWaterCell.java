package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  /**
   * Create a water cell.
   *
   * @param isHit the state of being hit or not of the cell
   * @param position the position of the cell
   */
  public AbstractWaterCell(Boolean isHit, Posn position) {
    super(isHit, position);
  }

  /**
   * Change the state of a cell after it is hit by enemy.
   *
   */
  @Override
  public void attackCell() {
    setIsHit(true);
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult attackResult() {
    return AttackResult.MISS;
  }

  @Override
  public Cell returnCellWhenAttacked() {
    return new OpenSeaCell(true, getPosition());
  }

  @Override
  public void update(Ship ship) {
    return;
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
