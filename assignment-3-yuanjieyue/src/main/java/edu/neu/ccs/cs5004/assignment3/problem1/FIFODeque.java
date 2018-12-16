package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a first in first out deque.
 */
public class FIFODeque extends NonEmpty {

  /**
   * Create a new FIFO deque with its current item and its rest part.
   *
   * @param item the current first item of the deque
   * @param rest the rest part of the deque
   */
  protected FIFODeque(Integer item, Deque rest) {
    super(item, rest);
  }

  @Override
  public Deque addFirst(Integer item) {
    throw new UnsupportedOperationException("addFirst() is not supported on FIFODeque!");
  }

  @Override
  public Deque addLast(Integer item) {
    if (this.getRest().equals(new EmptyFIFO())) {
      return new FIFODeque(this.getItem(), new FIFODeque(item, new EmptyFIFO()));
    }
    return this.getRest().addLast(item);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    FIFODeque fifoDeque = (FIFODeque) obj;
    return Objects.equals(getItem(), fifoDeque.getItem())
        && Objects.equals(getRest(), fifoDeque.getRest());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = result + 17;
    return result;
  }

  /**
   * Print out the FIFO deque with its items and rest.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "FIFODeque{" + "item=" + getItem() + ", rest=" + getRest() + '}';
  }
}
