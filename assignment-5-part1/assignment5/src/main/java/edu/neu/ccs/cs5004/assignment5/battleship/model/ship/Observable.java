package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Interface for observable subjects.
 */
public interface Observable {
  /**
   * Register an observer with the subject.
   *
   * @param observer an observer
   */
  void registerObserver(ShipObserver observer);

  /**
   * Remove an observer with the subject.
   *
   * @param observer an observer
   */
  void removeObserver(ShipObserver observer);

  /**
   * Notify the observer.
   */
  void notifyObserver();
}
