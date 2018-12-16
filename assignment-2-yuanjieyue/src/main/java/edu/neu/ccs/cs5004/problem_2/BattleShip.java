package edu.neu.ccs.cs5004.problem_2;

public class BattleShip extends AbstractShip {

  /**
   * Create a new battleship with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, default size is 4
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 4
   */
  public BattleShip(Integer size, Integer numberOfHitCells) {
    super(size, numberOfHitCells);
  }

  /**
   * @return return a copy of the battleship.
   */
  @Override
  protected AbstractShip shipCopyFactory() {
    return new BattleShip(this.getSize(), this.getNumberOfHitCells() + 1);
  }

  @Override
  public String toString() {
    return "BattleShip" + super.toString();
  }

}
