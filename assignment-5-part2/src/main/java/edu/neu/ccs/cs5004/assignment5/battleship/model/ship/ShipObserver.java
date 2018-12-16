package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

public interface ShipObserver {

  /**
   * update the state of the observer according to the changes on the given {@code ship}.
   *
   * @param ship the ship after update
   */
  void update(Ship ship);
}
