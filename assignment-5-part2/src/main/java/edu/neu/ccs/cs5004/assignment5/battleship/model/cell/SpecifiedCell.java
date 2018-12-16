package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

import java.util.Objects;

public class SpecifiedCell extends AbstractShipCell {

  private ShipSubject shipSubject;

  /**
   * Create a specified cell.
   *
   * @param ishit the state of being hit or not of the cell
   * @param position the posn of the cell
   * @param isSunk if the ship on the cell is sunk
   * @param shipSubject the ship observable subject
   */
  public SpecifiedCell(Boolean ishit, Posn position, Boolean isSunk, ShipSubject shipSubject) {
    super(ishit, position, isSunk);
    this.shipSubject = shipSubject;
  }

  /**
   * Getter for property 'shipsubject'.
   *
   * @return the ship subject of the cell
   */
  public ShipSubject getShipSubject() {
    return shipSubject;
  }

  @Override
  public void markShipCellSunk() {
    setSunk(true);
  }

  @Override
  public void attackCell() {
    setIsHit(true);
    Ship oldShip = shipSubject.getShip();
    Ship newShip = oldShip.afterAttack();
    shipSubject.updateShip(newShip);
    setSunk(newShip.isSunk());
  }

  /**
   * Get the result of the hit on the cell, if it miss the ship, hit the ship or the ship sunk.
   *
   * @return the result of the attack
   */
  @Override
  public AttackResult attackResult() {
    Ship ship = shipSubject.getShip();
    if (ship.isSunk()) {
      return AttackResult.SUNK;
    }
    return AttackResult.HIT;
  }

  @Override
  public Cell returnCellWhenAttacked() {
    Cell enemyCell = new EnemyCell(true, this.getPosition(), this.isSunk());
    getShipSubject().registerObserver(enemyCell);
    return enemyCell;
  }

  @Override
  public void update(Ship ship) {
    if (ship.isSunk()) {
      markShipCellSunk();
    }
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    SpecifiedCell that = (SpecifiedCell) obj;
    return Objects.equals(getShipSubject(), that.getShipSubject());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getShipSubject());
  }

  @Override
  public String toString() {
    return "SpecifiedCell" + super.toString();
  }

}
