package edu.neu.ccs.cs5004.argumentparser;

/**
 * Thrown when current argument has appeared before.
 */
public class DuplicateArgumentException extends RuntimeException {
  public DuplicateArgumentException(String message) {
    super(message);
  }
}
