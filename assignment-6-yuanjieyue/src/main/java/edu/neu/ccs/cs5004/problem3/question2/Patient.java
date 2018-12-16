package edu.neu.ccs.cs5004.problem3.question2;

/**
 * Represents a patient with respective urgency value and name to be stored within an Emergency
 * Queue.
 */
public class Patient implements Comparable<Patient> {
  private Urgency urgency;
  private Name name;
  private int arrivalOrder;

  /**
   * Create a new patient with the urgency value and the patient's name.
   *
   * @param urgency      given urgency value of the patient.
   * @param name         of the patient.
   * @param arrivalOrder the order of the patient.
   */
  public Patient(Urgency urgency, Name name, int arrivalOrder) {
    this.urgency = urgency;
    this.name = name;
    this.arrivalOrder = arrivalOrder;
  }

  /**
   * Getter for property ’urgency’.
   *
   * @return Value for property ’urgency’.
   */
  public Urgency getUrgency() {
    return this.urgency;
  }

  /**
   * Getter for property ’name’.
   *
   * @return Value for property ’name’.
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Getter for property 'arrivalOrder'.
   *
   * @return value for property 'arrivalOrder'.
   */
  public int getArrivalOrder() {
    return arrivalOrder;
  }

  @Override
  public int compareTo(Patient otherPatient) {
    return Integer.compare(getUrgency().getValue(), otherPatient.getUrgency().getValue());
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Patient patient = (Patient) obj;

    if (arrivalOrder != patient.arrivalOrder) {
      return false;
    }
    if (urgency != null ? !urgency.equals(patient.urgency) : patient.urgency != null) {
      return false;
    }
    return name != null ? name.equals(patient.name) : patient.name == null;
  }

  @Override
  public int hashCode() {
    int result = urgency != null ? urgency.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + arrivalOrder;
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("Patient{");
    stringBuilder.append("urgency=").append(urgency);
    stringBuilder.append(", name=").append(name);
    stringBuilder.append(", arrivalOrder=").append(arrivalOrder);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}
