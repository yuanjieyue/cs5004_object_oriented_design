package edu.neu.ccs.cs5004.assignment3.problem1;

public interface Deque {

  /**
   * Create an empty FIFO deque.
   *
   * @return a new empty FIFO deque
   */
  static Empty emptyFIFODeque() {
    return new EmptyFIFO();
  }

  /**
   * Create an empty LIFO deque.
   *
   * @return a new empty LIFO deque
   */
  static Empty emptyLIFODeque() {
    return new EmptyLIFO();
  }

  /**
   * Check if a deque is empty or not.
   *
   * @return true if the deque is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * Get the number of elements in the deque.
   *
   * @return the size of the deque
   */
  Integer size();

  /**
   * Add the given item {@code item} to the first place of the deque.
   *
   * @param item the item to be added to the deque
   * @return the updated deque with the item added to at the first place
   */
  Deque addFirst(Integer item);

  /**
   * Add the given element {@code item} to the last place of the deque.
   *
   * @param item the element to be added to the deque
   * @return the updated deque with the element added to at the last place
   */
  Deque addLast(Integer item);

  /**
   * Remove the first element of the deque.
   *
   * @return the updated deque with the first element removed
   */
  Deque removeFirst();

  /**
   * Peek the first element of the deque.
   *
   * @return the first element of the deque
   */
  Integer peek();
}
