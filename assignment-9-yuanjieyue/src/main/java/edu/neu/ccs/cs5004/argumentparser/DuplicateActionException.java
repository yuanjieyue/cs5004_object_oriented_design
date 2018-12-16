package edu.neu.ccs.cs5004.argumentparser;

/**
 * Thrown when duplicate actions appears.
 */
public class DuplicateActionException extends RuntimeException {
  public DuplicateActionException(String message) {
    super(message);
  }
}
