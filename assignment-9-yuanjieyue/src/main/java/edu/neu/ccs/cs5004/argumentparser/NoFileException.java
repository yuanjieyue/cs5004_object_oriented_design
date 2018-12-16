package edu.neu.ccs.cs5004.argumentparser;

/**
 * Thrown when there is no file after switch.
 */
public class NoFileException extends RuntimeException {
  public NoFileException(String message) {
    super(message);
  }
}
