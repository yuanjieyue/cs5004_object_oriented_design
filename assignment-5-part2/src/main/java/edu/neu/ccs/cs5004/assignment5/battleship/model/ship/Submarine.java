package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public class Submarine extends AbstractShip {

  private static final Integer SIZE = 2;
  /**
   * Create a new submarine with its size and number of hit cells given as integer.
   *
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 2
   */
  public Submarine(Integer numberOfHitCells) {
    super(SIZE, numberOfHitCells);
  }
  

  @Override
  public String toString() {
    return "Submarine" + super.toString();
  }

  @Override
  public Ship afterAttack() {
    if (this.isSunk()) {
      return this;
    }
    return new Submarine(this.getNumOfHitCells() + 1);
  }
}
