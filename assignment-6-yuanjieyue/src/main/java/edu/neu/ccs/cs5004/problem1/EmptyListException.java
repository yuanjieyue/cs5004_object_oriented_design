package edu.neu.ccs.cs5004.problem1;

/**
 * Thrown when LinkedList is empty.
 */
public class EmptyListException extends RuntimeException {
  public EmptyListException(String message) {
    super(message);
  }
}
