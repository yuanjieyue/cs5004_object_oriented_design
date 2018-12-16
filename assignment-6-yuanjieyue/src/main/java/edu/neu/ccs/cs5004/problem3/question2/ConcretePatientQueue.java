package edu.neu.ccs.cs5004.problem3.question2;

import edu.neu.ccs.cs5004.problem2.PriorityQueue;

public class ConcretePatientQueue implements EmergencyPatientQueue {

  private PriorityQueue<Patient> patientQueue;
  private PriorityQueue<Patient> tmpQueue;
  private int nextIndex;

  /**
   * Construct the patient queue with the patient queue (based on urgency value), tmp queue (for
   * looking for the patient with the next index), and the index for the next patient.
   */
  ConcretePatientQueue() {
    this.patientQueue = PriorityQueue.createEmptyPriorityQueue();
    this.tmpQueue = PriorityQueue.createEmptyPriorityQueue();
    this.nextIndex = 1;
  }

  /**
   * Getter for property 'patientQueue'.
   *
   * @return the patient queue.
   */
  public PriorityQueue<Patient> getPatientQueue() {
    return patientQueue;
  }

  /**
   * Getter for property 'tmpQueue'.
   *
   * @return the tmp queue for finding next patient arrival order.
   */
  public PriorityQueue<Patient> getTmpQueue() {
    return tmpQueue;
  }

  /**
   * Set the next arrival index as the given number.
   *
   * @param nextIndex the given new next index of next patient number.
   */
  public void setNextIndex(int nextIndex) {
    this.nextIndex = nextIndex;
  }

  /**
   * Getter for property 'nextIndex'.
   *
   * @return the value of next index.
   */
  public int getNextIndex() {
    return nextIndex;
  }

  @Override
  public Patient nextPatient() {
    checkIfEmpty();
    Patient curPatient = null;
    while (!getPatientQueue().isEmpty()) {
      curPatient = getPatientQueue().front();
      if (curPatient.getArrivalOrder() != nextIndex) {
        getPatientQueue().remove();
        tmpQueue.insert(curPatient);
      } else {
        break;
      }
    }

    while (!getTmpQueue().isEmpty()) {
      Patient curTmpPatient = getTmpQueue().front();
      getTmpQueue().remove();
      getPatientQueue().insert(curTmpPatient);
    }
    return curPatient;
  }

  @Override
  public void removeNext() {
    checkIfEmpty();

    while (!getPatientQueue().isEmpty()) {
      Patient curPatient = getPatientQueue().front();
      if (curPatient.getArrivalOrder() != nextIndex) {
        getPatientQueue().remove();
        tmpQueue.insert(curPatient);
      } else {
        getPatientQueue().remove();
        break;
      }
    }

    while (!getTmpQueue().isEmpty()) {
      Patient curTmpPatient = getTmpQueue().front();
      getTmpQueue().remove();
      getPatientQueue().insert(curTmpPatient);
    }
    setNextIndex(getNextIndex() + 1);
  }

  @Override
  public Patient nextMostUrgent() {
    checkIfEmpty();
    return getPatientQueue().front();
  }

  @Override
  public void removeMostUrgent() {
    checkIfEmpty();
    getPatientQueue().remove();
  }

  @Override
  public void add(Patient patient) {
    getPatientQueue().insert(patient);
  }

  @Override
  public boolean isEmpty() {
    return getPatientQueue().isEmpty();
  }

  @Override
  public int size() {
    return getPatientQueue().size();
  }

  /**
   * Check if this patientQueue is empty.
   *
   * @throws EmptyPatientQueueException if the patientQueue is empty.
   */
  private void checkIfEmpty() {
    if (isEmpty()) {
      throw new EmptyPatientQueueException("the patient queue is empty.");
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    ConcretePatientQueue that = (ConcretePatientQueue) obj;

    return patientQueue != null
        ? patientQueue.equals(that.patientQueue) : that.patientQueue == null;
  }

  @Override
  public int hashCode() {
    return patientQueue != null ? patientQueue.hashCode() : 0;
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("ConcretePatientQueue{");
    stringBuilder.append("patientQueue=").append(patientQueue);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}
