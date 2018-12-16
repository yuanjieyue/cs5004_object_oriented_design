package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

public interface ShipCell extends Cell {

  /**
   * Return if the cell belongs to a sunk ship or not.
   *
   * @return true if the cell belongs to a sunk ship, false otherwise
   */
  Boolean isSunk();

  /**
   * Mark a ship cell sunk.
   *
   * @param sunk true or false as sunk status
   */
  void setSunk(Boolean sunk);

  /**
   * Mark a ship cell as belonging to sunk ship.
   */
  void markShipCellSunk();
}
