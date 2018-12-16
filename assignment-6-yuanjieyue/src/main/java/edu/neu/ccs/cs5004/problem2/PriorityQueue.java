package edu.neu.ccs.cs5004.problem2;

public interface PriorityQueue<E extends Comparable> {

  /**
   * Create a new empty PriorityQueue.
   *
   * @return a new empty PriorityQueue.
   */
  static PriorityQueue createEmptyPriorityQueue() {
    return new ConcretePriorityQueue<>();
  }

  /**
   * Insert the element in the queue.
   * Time complexity: O(n).
   *
   * @param element the element to be inserted.
   */
  void insert(E element);

  /**
   * Removes the object from the front.
   * Time complexity: O(1).
   *
   * @throws EmptyQueueException when the priority queue is empty.
   */
  void remove();

  /**
   * Check the front object with the highest priority of the queue.
   * Time complexity: O(1).
   *
   * @return the object at the front without changing the Priority Queue.
   * @throws EmptyQueueException if the Priority Queue is empty.
   */
  E front();

  /**
   * Check if the priority queue is empty.
   * Time complexity: O(1).
   *
   * @return true if the queue is empty and false otherwise.
   */
  boolean isEmpty();

  /**
   * Get the size of the priority queue.
   * Time complexity: O(1).
   *
   * @return the size of the queue.
   */
  int size();
}
