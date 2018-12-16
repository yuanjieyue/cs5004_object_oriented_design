package edu.neu.ccs.cs5004.argumentparser;

/**
 * Thrown when the input file directory or output folder directory is not defined.
 */
public class UndefinedDirException extends RuntimeException {
  public UndefinedDirException(String message) {
    super(message);
  }
}
