package edu.neu.ccs.cs5004.assignment4.problem3;

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

  @Override
  public String toString() {
    return "BattleShip" + super.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int res = super.hashCode();
    res = res * 31 + 41;
    return res;
  }

  @Override
  public Ship beingHit() {
    return new BattleShip(this.getSize(), this.getNumberOfHitCells() + 1);
  }
}
