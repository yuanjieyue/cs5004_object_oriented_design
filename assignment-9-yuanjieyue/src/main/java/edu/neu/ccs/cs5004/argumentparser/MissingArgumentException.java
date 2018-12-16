package edu.neu.ccs.cs5004.argumentparser;

/**
 * Thrown when necessary argument is missing.
 */
public class MissingArgumentException extends RuntimeException {
  public MissingArgumentException(String message) {
    super(message);
  }
}
