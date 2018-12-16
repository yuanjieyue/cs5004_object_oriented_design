package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public class Destroyer extends AbstractShip {

  private static final Integer SIZE = 1;
  /**
   * Create a destroyer with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, default size is 1
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 1
   */
  public Destroyer(Integer size, Integer numberOfHitCells) {
    super(SIZE, numberOfHitCells);
  }

  @Override
  public String toString() {
    return "Destroyer" + super.toString();
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
    res = res * 31 + SIZE.hashCode();
    return res;
  }

  @Override
  public Ship beingHit() {
    if (this.isSunk()) {
      return this;
    }
    return new Destroyer(this.size(), this.numOfHitCells() + 1);
  }
}
