package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents a ship with its size and number of hit cells.
 */
public abstract class AbstractShip implements Ship {

  private Integer size;
  private Integer numberOfHitCells;

  /**
   * Create a new ship with its size and number of hit cells given as integer.
   *
   * @param size             the size of the ship, ranging from 1 to 4 inclusive
   * @param numberOfHitCells the number of hit cells of the ship, ranging from 0 to 4
   */
  public AbstractShip(Integer size, Integer numberOfHitCells) {
    this.size = size;
    this.numberOfHitCells = numberOfHitCells;
  }

  @Override
  public Integer getSize() {
    return size;
  }

  @Override
  public Integer getNumOfHitCells() {
    return numberOfHitCells;
  }

  @Override
  public Boolean isSunk() {
    return this.numberOfHitCells >= this.size;
  }


  /**
   * Test if the given object equals to the instance.
   *
   * @param obj the object to be compared with
   * @return true if the have got the same class and got the same fields value, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractShip ship = (AbstractShip) obj;
    return this.numberOfHitCells != null ? this.numberOfHitCells.equals(ship
        .numberOfHitCells) : ship.numberOfHitCells == null;
  }
  
  /**
   * Return a unique hashcode.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return numberOfHitCells.hashCode() + size * 43;
  }

  /**
   * Print the instance with its fields.
   *
   * @return the instance with its fields in string
   */
  @Override
  public String toString() {
    return "{" + "size=" + size + ", numberOfHitCells=" + numberOfHitCells + '}';
  }
}
