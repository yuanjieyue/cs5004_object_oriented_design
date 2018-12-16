package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an exception thrown when an unsupported operation on the deque.
 */
public class UnsupportedOperationException extends RuntimeException {
  String str;

  /**
   * Create a new unsupported exception.
   *
   * @param message the message that describe the exception
   */
  public UnsupportedOperationException(String message) {
    str = message;
  }

  /**
   * Print out the message about the exception.
   * @return the message about the exception
   */
  @Override
  public String toString() {
    return ("Unsupported Operation Exception Occurred: " + str);
  }

}
