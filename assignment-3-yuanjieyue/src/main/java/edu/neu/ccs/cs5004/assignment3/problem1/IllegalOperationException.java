package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an exception thrown when an illegal operation is on empty.
 */
public class IllegalOperationException extends RuntimeException {

  String str;

  /**
   * Create a new illegal operation exception with a message.
   *
   * @param message the message describe the exception
   */
  public IllegalOperationException(String message) {
    str = message;
  }

  /**
   * Print out the message of the exception.
   *
   * @return the message of exception
   */
  @Override
  public String toString() {
    return ("IllegalOperationException Occurred "+str) ;

  }

}
