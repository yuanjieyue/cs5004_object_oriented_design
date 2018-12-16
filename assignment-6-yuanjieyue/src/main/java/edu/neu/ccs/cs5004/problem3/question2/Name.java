package edu.neu.ccs.cs5004.problem3.question2;

import java.util.Objects;

/**
 * Represents a patient's name.
 */
public class Name {
  String first;
  String last;

  /**
   * Construct a new name with first and last name.
   *
   * @param first the patient's first name.
   * @param last  the patient's last name.
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Name name = (Name) other;
    return Objects.equals(first, name.first) && Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{" + "first=" + first + ", last=" + last + '}';
  }
}
