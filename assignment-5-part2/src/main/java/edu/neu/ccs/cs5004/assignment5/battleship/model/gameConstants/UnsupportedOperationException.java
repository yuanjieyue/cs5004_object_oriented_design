package edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants;

/**
 * Represents an unsupported operation exception.
 */
public class UnsupportedOperationException extends RuntimeException {

  String str;

  /**
   * Create a new unsupported operation exception.
   * @param message the message to show to notify the exception
   */
  public UnsupportedOperationException(String message) {
    str = message;
  }

  @Override
  public String toString() {
    return ("UnsupportedOperationException Occurred: " + str);
  }
}
