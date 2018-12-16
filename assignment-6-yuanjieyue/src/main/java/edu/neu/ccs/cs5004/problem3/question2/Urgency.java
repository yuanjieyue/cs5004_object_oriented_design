package edu.neu.ccs.cs5004.problem3.question2;

import java.util.Objects;

/**
 * Represents a patients urgency value in the EmergencyPatientQueue.
 */
public class Urgency {
  Integer value;

  /**
   * Constructs an Urgency with an urgency value.
   *
   * @param value the urgency value of the patient.
   */
  public Urgency(Integer value) {
    this.value = value;
  }

  /**
   * Getter of property emergency value.
   *
   * @return the value of emergency value.
   */
  public Integer getValue() {
    return this.value;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Urgency urgency = (Urgency) other;
    return Objects.equals(value, urgency.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override

  public String toString() {
    return "Urgency{" + "value=" + value + '}';
  }
}
