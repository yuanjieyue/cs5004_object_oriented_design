package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents a deque.
 */
public abstract class ADeque implements Deque {

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    return this.getClass() == obj.getClass();
  }
}
