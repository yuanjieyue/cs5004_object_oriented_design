package edu.neu.ccs.cs5004.assignment4.problem3;

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
    res = res * 31 + 17;
    return res;
  }

  @Override
  public String toString() {
    return "Submarine" + super.toString();
  }

  @Override
  public Ship beingHit() {
    return new Submarine(this.getSize(), this.getNumberOfHitCells() + 1);
  }
}
