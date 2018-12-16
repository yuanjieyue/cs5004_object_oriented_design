package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an empty deque.
 */
abstract class Empty extends ADeque {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Deque removeFirst() {
    throw new IllegalOperationException("Call removeFirst on Empty Deque()!");
  }

  @Override
  public Integer peek() {
    throw new java.lang.Error("this is very bad");
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = result + 31;
    return result;
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
}
