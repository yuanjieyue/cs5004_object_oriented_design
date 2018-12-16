package edu.neu.ccs.cs5004.problem_2;

public class SpecifiedCell extends AbstractShipCell {

  /**
   * Create a specified cell.
   *
   * @param ishit the state of being hit or not of the cell
   */
  public SpecifiedCell(Hitable ishit, Sunkable belongToSunk) {
    super(ishit, belongToSunk);
  }

  @Override
  protected AbstractCell cellCopyFactory() {
    return new SpecifiedCell(new BeingHit(), this.getBelongToSunk());
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult resultOfAttack() {
    if (this.getBelongToSunk().equals(new BelongToSunk())) {
      return new Sunk();
    }
    return new Hit();
  }

  @Override
  public String toString() {
    return "SpecifiedCell" + super.toString();
  }

}
