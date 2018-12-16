package edu.neu.ccs.cs5004.problem2;

/**
 * Thrown when the priority queue is empty.
 */
public class EmptyQueueException extends RuntimeException {
  public EmptyQueueException(String message) {
    super(message);
  }
}
