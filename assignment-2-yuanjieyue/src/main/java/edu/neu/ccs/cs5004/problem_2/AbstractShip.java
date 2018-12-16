package edu.neu.ccs.cs5004.problem_2;

import java.util.Objects;

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

  /**
   * Getter for property 'size'.
   *
   * @return the size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Getter for property 'numberOfHitCells'.
   *
   * @return the number of hit cells
   */
  public Integer getNumberOfHitCells() {
    return numberOfHitCells;
  }

  /**
   * Change the ship to the new state after it is hit by enemy.
   *
   * @return the new ship after hit
   */
  @Override
  public Ship beingHit() {
    return shipCopyFactory();
  }

  /**
   * @return return a copy of the ship.
   */
  protected AbstractShip shipCopyFactory() {
    return null;
  }

  /**
   * Check if the ship is sunk or not.
   *
   * @return true if the ship is sunk, false otherwise
   */
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
    return Objects.equals(getSize(), ship.getSize())
        && Objects.equals(getNumberOfHitCells(), ship.getNumberOfHitCells());
  }

  /**
   * Return a unique hashcode.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {

    return Objects.hash(getSize(), getNumberOfHitCells());
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
