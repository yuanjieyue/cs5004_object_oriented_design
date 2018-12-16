package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ship subject with a ship and all its observers.
 */
public class ShipSubject implements Observable {
  private Ship ship;
  private List<ShipObserver> observers;

  /**
   * Creates a new ship subject.
   *
   * @param ship the ship of the subject
   * @param observers the list of observers of the given ship
   */
  public ShipSubject(Ship ship, ArrayList<ShipObserver> observers) {
    this.ship = ship;
    this.observers = observers;
  }

  /**
   * Getter for the property 'ship'.
   *
   * @return the 'ship'
   */
  public Ship getShip() {
    return ship;
  }

  @Override
  public void registerObserver(ShipObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ShipObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObserver() {
    for (ShipObserver observer : observers) {
      observer.update(this.ship);
    }
  }
}
