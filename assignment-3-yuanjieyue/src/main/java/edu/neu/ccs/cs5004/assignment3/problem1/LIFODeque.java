package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a last in first out deque.
 */
public class LIFODeque extends NonEmpty {

  /**
   * Create a new LIFO deque with its current item and its rest part.
   *
   * @param item the current first item of the deque
   * @param rest the rest part of the deque
   */
  protected LIFODeque(Integer item, Deque rest) {
    super(item, rest);
  }

  @Override
  public Deque addFirst(Integer item) {
    return new LIFODeque(item, this);
  }

  @Override
  public Deque addLast(Integer item) {
    throw new UnsupportedOperationException("addLast() is not supported on LIFODeque!");
  }

  @Override
  public Integer peek() {
    return this.getItem();
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
    LIFODeque lifoDeque = (LIFODeque) obj;
    return Objects.equals(getItem(), lifoDeque.getItem())
        && Objects.equals(getRest(), lifoDeque.getRest());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = result + 23;
    return result;
  }

  /**
   * Print out the LIFO deque with its items and rest.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "LIFODeque{" + "item=" + getItem() + ", rest=" + getRest() + '}';
  }
}
