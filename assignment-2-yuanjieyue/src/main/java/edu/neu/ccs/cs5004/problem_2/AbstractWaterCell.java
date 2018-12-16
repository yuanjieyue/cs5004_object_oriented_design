package edu.neu.ccs.cs5004.problem_2;

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  /**
   * Create a water cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public AbstractWaterCell(Hitable ishit) {
    super(ishit);
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult resultOfAttack() {
    return new Miss();
  }

  /**
   * Print the instance and its fields in string
   * @return the string
   */
  @Override
  public String toString() {
    return "{" + super.toString() + "}";
  }
}
