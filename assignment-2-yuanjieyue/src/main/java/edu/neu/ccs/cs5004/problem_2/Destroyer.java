package edu.neu.ccs.cs5004.problem_2;

public class Destroyer extends AbstractShip {

  /**
   * Create a destroyer with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, default size is 1
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 1
   */
  public Destroyer(Integer size, Integer numberOfHitCells) {
    super(size, numberOfHitCells);
  }

  /**
   * @return return a copy of the destroyer.
   */
  @Override
  protected AbstractShip shipCopyFactory() {
    return new Destroyer(this.getSize(), this.getNumberOfHitCells() + 1);
  }

  @Override
  public String toString() {
    return "Destroyer" + super.toString();
  }
}
