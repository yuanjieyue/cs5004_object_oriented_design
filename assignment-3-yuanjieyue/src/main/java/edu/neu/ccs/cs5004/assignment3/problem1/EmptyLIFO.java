package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an empty LIFO deque.
 */
class EmptyLIFO extends Empty {

  /**
   * Add an element to the first place on an empty LIFO deque.
   *
   * @param item the element to be added to the deque
   * @return the new LIFO deque with one element added to the first place
   */
  @Override
  public Deque addFirst(Integer item) {
    return new LIFODeque(item, new EmptyLIFO());
  }

  @Override
  public Deque addLast(Integer item) {
    throw new UnsupportedOperationException("The addLast() is not supported on EmptyLIFO!");
  }

  @Override
  public String toString() {
    return "EmptyLIFO{}";
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = result + 41;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    return super.equals(obj);
  }
}
