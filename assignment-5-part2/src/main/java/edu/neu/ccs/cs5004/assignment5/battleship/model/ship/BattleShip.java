package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public class BattleShip extends AbstractShip {
  private static final Integer SIZE = 4;

  /**
   * Create a new battleship with its size and number of hit cells given as integer.
   *
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 4
   */
  public BattleShip(Integer numberOfHitCells) {
    super(SIZE, numberOfHitCells);
  }

  @Override
  public String toString() {
    return "BattleShip" + super.toString();
  }
  

  @Override
  public Ship afterAttack() {
    if (this.isSunk()) {
      return this;
    }
    return new BattleShip(this.getNumOfHitCells() + 1);
  }
}
