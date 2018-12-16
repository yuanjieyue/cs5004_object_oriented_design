package edu.neu.ccs.cs5004.problem_2;

public class NotBelongToSunk implements Sunkable {

  /**
   * @return the state of a ship cell that if it belongs to a sunk ship or not.
   */
  @Override
  public String belongToSunk() {
    return "Not belong to Sunk";
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return 31;
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
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  /**
   * Print the instance and its fields in string
   * @return the string
   */
  @Override
  public String toString() {
    return belongToSunk();
  }
}
