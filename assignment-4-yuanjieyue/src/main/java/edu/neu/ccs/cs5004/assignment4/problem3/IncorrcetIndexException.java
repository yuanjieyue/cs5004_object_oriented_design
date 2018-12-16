package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents an incorrect index exception.
 */
public class IncorrcetIndexException extends RuntimeException {
  String str;

  /**
   * Create a new incorrect index exception.
   *
   * @param message the exception message
   */
  public IncorrcetIndexException(String message) {
    str = message;
  }

  @Override
  public String toString() {
    return ("IncorrectIndexException Occurred: " + str);
  }
}
