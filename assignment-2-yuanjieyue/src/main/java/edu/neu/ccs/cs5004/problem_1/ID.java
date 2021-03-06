package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents a id with its id as string.
 */
public class ID {
  private String id;

  /**
   * Create a new id with it id given a string.
   *
   * @param id the id
   */
  public ID(String id) {
    this.id = id;
  }

  /**
   * Getter for the property id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Check if the given object equals to the instance.
   *
   * @param obj the object to be compared
   * @return true if they are of the same class and have exactly the same fields.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ID id1 = (ID) obj;
    return Objects.equals(getId(), id1.getId());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "ID{" + "id='" + id + '\'' + '}';
  }
}
