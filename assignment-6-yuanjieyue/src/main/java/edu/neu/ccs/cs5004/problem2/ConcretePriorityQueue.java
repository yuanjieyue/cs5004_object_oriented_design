package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.List;

public class ConcretePriorityQueue<E extends Comparable> implements PriorityQueue<E> {

  private List<E> queue;

  public ConcretePriorityQueue() {
    this.queue = List.createEmptyList();
  }

  List<E> getQueue() {
    return this.queue;
  }

  @Override
  public void insert(E element) {
    // if empty, then the new node will be the only node in the queue.
    if (isEmpty()) {
      getQueue().add(element);
    } else if (higherPriorityThan(element, front())) {
      // if new node is bigger than the biggest node, add to head.
      getQueue().add(element);
    } else if (!higherPriorityThan(element, getQueue().get(size() - 1))) {
      // if new node is even lower than the tail...add to last.
      getQueue().add(size(), element);
    } else {
      // if not, perform linear search to its right position and insert.
      int queueSize = size();
      for (int i = 1; i < queueSize; i++) {
        if (higherPriorityThan(element, getQueue().get(i))) {
          getQueue().add(i, element);
          break;
        }
      }
    }

  }

  @Override
  public void remove() {
    if (isEmpty()) {
      throw new EmptyQueueException("ConcretePriorityQueue remove(): queue is empty.");
    }
    getQueue().remove(0);
  }

  @Override
  public E front() {
    if (isEmpty()) {
      throw new EmptyQueueException("ConcretePriorityQueue front(): queue is empty.");
    }
    return getQueue().get(0);
  }

  @Override
  public boolean isEmpty() {
    return getQueue().isEmpty();
  }

  @Override
  public int size() {
    return getQueue().size();
  }

  /**
   * Check the given element has a higher priority than another element.
   *
   * @param element        given element.
   * @param anotherElement another element.
   * @return true if given element has a higher priority than another element, false otherwise.
   */
  private boolean higherPriorityThan(E element, E anotherElement) {
    return element.compareTo(anotherElement) >= 1;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    ConcretePriorityQueue<?> that = (ConcretePriorityQueue<?>) other;

    return queue != null ? queue.equals(that.queue) : that.queue == null;
  }

  @Override
  public int hashCode() {
    return queue != null ? queue.hashCode() : 0;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    for (int i = 0; i < size(); i++) {
      stringBuilder.append(getQueue().get(i)).append(" ");
    }
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}
