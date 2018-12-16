package edu.neu.ccs.cs5004.problem_2;

public class Submarine extends AbstractShip {

  /**
   * Create a new submarine with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, default size is 2
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 2
   */
  public Submarine(Integer size, Integer numberOfHitCells) {
    super(size, numberOfHitCells);
  }

  /**
   * @return return a copy of the submarine.
   */
  @Override
  protected AbstractShip shipCopyFactory() {
    return new Submarine(this.getSize(), this.getNumberOfHitCells() + 1);
  }

  @Override
  public String toString() {
    return "Submarine" + super.toString();
  }
}
