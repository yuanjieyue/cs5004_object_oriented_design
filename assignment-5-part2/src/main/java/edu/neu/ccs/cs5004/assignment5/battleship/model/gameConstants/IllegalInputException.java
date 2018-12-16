package edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants;

/**
 * Represents an illegal input exception.
 */
public class IllegalInputException extends RuntimeException {
  private String str;

  /**
   * Create a new illegal input exception with a message.
   *
   * @param message the message about the exception
   */
  public IllegalInputException(String message) {
    str = message;
  }

  @Override
  public String toString() {
    return ("IllegalInputException Occurred: " + str);
  }
}
