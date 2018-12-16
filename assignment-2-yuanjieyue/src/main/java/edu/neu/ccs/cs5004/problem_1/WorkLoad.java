package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents a work load.
 */
public class WorkLoad {
  private Integer workLoad;

  /**
   * Create a new workLoad with its work load given as integer.
   */
  public WorkLoad(Integer workLoad) {
    this.workLoad = workLoad;
  }

  /**
   * Getter for property 'workLoad'.
   *
   * @return the workLoad
   */
  public Integer getWorkLoad() {
    return this.workLoad;
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
    WorkLoad workLoad1 = (WorkLoad) obj;
    return Objects.equals(getWorkLoad(), workLoad1.getWorkLoad());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWorkLoad());
  }


  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "WorkLoad{" + "workLoad=" + workLoad + '}';
  }

}
