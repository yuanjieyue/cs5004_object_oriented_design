package edu.neu.ccs.cs5004.problem_2;

public class Cruiser extends AbstractShip {

  /**
   * Create a new cruiser with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, default size 3
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 3
   */
  public Cruiser(Integer size, Integer numberOfHitCells) {
    super(size, numberOfHitCells);
  }

  /**
   * @return return a copy of the cruiser.
   */
  @Override
  protected AbstractShip shipCopyFactory() {
    return new Cruiser(this.getSize(), this.getNumberOfHitCells() + 1);
  }

  @Override
  public String toString() {
    return "Cruiser" + super.toString();
  }
}
