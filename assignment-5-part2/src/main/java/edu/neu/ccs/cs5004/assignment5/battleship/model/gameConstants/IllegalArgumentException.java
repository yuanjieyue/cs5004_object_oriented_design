package edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants;

/**
 * Represents an illegal argument exception.
 */
public class IllegalArgumentException extends RuntimeException {

  String str;

  /**
   * Create an illegal argument exception with an error message.
   *
   * @param message the error message
   */
  public IllegalArgumentException(String message) {
    str = message;
  }

  @Override
  public String toString() {
    return ("IllegalArgumentException Occurred" + str);
  }
}
