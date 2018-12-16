package edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.attackResult;

public class Sunk implements AttackResult {
  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   */
  @Override
  public String result() {
    return "The ship is sunk!";
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return 59;
  }

  /**
   * Check if the given object equals to the instance.
   *
   * @param obj the object to be compared
   * @return true they have the same class and exactly the same fields value
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return result();
  }
}
