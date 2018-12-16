package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

public interface ShipCell extends Cell {

  /**
   * Mark a ship cell as belonging to sunk ship.
   *
   * @return the updated ship after marking
   */
  ShipCell markShipCellSunk();
}
