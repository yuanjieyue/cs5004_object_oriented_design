package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an empty FIFO deque.
 */
class EmptyFIFO extends Empty{

  @Override
  public Deque addFirst(Integer item) {
    throw new UnsupportedOperationException("addFirst() is not supported on EmptyFIFO!");
  }

  /**
   * Add element to the empty FIFO deque.
   *
   * @param item the element to be added to the deque
   * @return the FIFO deque with one element
   */
  @Override
  public Deque addLast(Integer item) {
    return new FIFODeque(item, new EmptyFIFO());
  }

  @Override
  public String toString() {
    return "EmptyFIFO{}";
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = result + 29;
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
