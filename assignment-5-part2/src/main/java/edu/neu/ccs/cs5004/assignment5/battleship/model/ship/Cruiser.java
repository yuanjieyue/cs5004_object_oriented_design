package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public class Cruiser extends AbstractShip {

  private static final Integer SIZE = 3;
  /**
   * Create a new cruiser with its size and number of hit cells given as integer.
   *
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 3
   */
  public Cruiser(Integer numberOfHitCells) {
    super(SIZE, numberOfHitCells);
  }

  @Override
  public String toString() {
    return "Cruiser" + super.toString();
  }
  

  @Override
  public Ship afterAttack() {
    if (this.isSunk()) {
      return this;
    }
    return new Cruiser(this.getNumOfHitCells() + 1);
  }
}
