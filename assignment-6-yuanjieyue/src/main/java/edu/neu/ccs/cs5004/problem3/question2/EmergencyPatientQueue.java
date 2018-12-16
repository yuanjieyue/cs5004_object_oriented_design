package edu.neu.ccs.cs5004.problem3.question2;

/**
 * Represents an emergency patient queue.
 */
public interface EmergencyPatientQueue {

  /**
   * Create a new empty EmergencyPatientQueue.
   *
   * @return a new empty EmergencyPatientQueue.
   */
  static EmergencyPatientQueue createEmptyPatientQueue() {
    return new ConcretePatientQueue();
  }

  /**
   * Check the next patient.
   * Type: observer.
   *
   * @return the next patient (based on the arrival order), without changing the queue.
   * @throws EmptyPatientQueueException if the queue is empty.
   */
  Patient nextPatient();

  /**
   * Removes the next patient (based on the arrival order).
   * Type: mutator.
   * Time complexity: O(n).
   *
   * @throws EmptyPatientQueueException if the queue is empty.
   */
  void removeNext();

  /**
   * Check the most urgent patient in the queue.
   * Type: observer.
   *
   * @return the patient with the highest urgency in the queue, without changing the queue.
   * @throws EmptyPatientQueueException if the queue is empty.
   */
  Patient nextMostUrgent();

  /**
   * Removes the most urgent patient from the queue.
   * Type: mutator.
   * Time complexity: O(1).
   *
   * @throws EmptyPatientQueueException if the queue is empty.
   */
  void removeMostUrgent();

  /**
   * Adds a patient to the queue, based on the patient's urgency value.
   * Type: mutator.
   *
   * @param patient the patient to be added to the queue.
   */
  void add(Patient patient);

  /**
   * Check if the queue is empty.
   * Type: observer.
   *
   * @return true if the queue is empty and false otherwise;
   */
  boolean isEmpty();

  /**
   * Get the number of patients in the queue.
   * Type: observer.
   *
   * @return the number of patients in the queue
   */
  int size();
}
