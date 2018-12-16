package edu.neu.ccs.cs5004.assignment4.problem3;

public interface ShipCell extends Cell {

  /**
   * Mark a ship cell as belonging to sunk ship.
   *
   * @return the updated ship after marking
   */
  ShipCell markShipCellSunk();
}
