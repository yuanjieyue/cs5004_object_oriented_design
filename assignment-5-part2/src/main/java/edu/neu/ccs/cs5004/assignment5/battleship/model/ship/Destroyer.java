package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public class Destroyer extends AbstractShip {

  private static final Integer SIZE = 1;
  /**
   * Create a destroyer with its size and number of hit cells given as integer.
   *
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 1
   */
  public Destroyer(Integer numberOfHitCells) {
    super(SIZE, numberOfHitCells);
  }

  @Override
  public String toString() {
    return "Destroyer" + super.toString();
  }
  

  @Override
  public Ship afterAttack() {
    if (this.isSunk()) {
      return this;
    }
    return new Destroyer(this.getNumOfHitCells() + 1);
  }
}
