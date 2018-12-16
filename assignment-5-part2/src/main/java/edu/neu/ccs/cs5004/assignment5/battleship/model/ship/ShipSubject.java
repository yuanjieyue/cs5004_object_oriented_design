package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import java.util.List;
import java.util.Objects;

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
  public ShipSubject(Ship ship, List<ShipObserver> observers) {
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

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  @Override
  public void registerObserver(ShipObserver observer) {
    observers.add(observer);
    observer.update(this.ship);
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

  /**
   * Notify observers upon ship got updated.
   *
   * @param newShip a new ship that is to be updated to
   */
  public void updateShip(Ship newShip) {
    this.ship = newShip;
    notifyObserver();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ShipSubject that = (ShipSubject) obj;
    return Objects.equals(getShip(), that.getShip())
        && Objects.equals(observers, that.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getShip(), observers);
  }

  @Override
  public String toString() {
    return "ShipSubject{" + "ship=" + ship + ", observers=" + observers + '}';
  }
}
