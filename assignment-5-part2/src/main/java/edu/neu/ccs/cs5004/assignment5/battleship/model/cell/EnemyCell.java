package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.UnsupportedOperationException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;


public class EnemyCell extends AbstractShipCell {
  
  
  /**
   * Create an enemy cell.
   * @param ishit if the cell is it
   * @param position the posn of the cell
   * @param isSunk if the ship on the cell is sunk
   */
  public EnemyCell(Boolean ishit, Posn position, Boolean isSunk) {
    super(ishit, position, isSunk);
  }

  @Override
  public void markShipCellSunk() {
    setSunk(true);
  }

  @Override
  public void attackCell() {
    throw new UnsupportedOperationException("EnemyCell can not be attack!");
  }

  @Override
  public AttackResult attackResult() {
    throw new UnsupportedOperationException("EnemyCell can not be attack!");
  }

  @Override
  public Cell returnCellWhenAttacked() {
    throw new UnsupportedOperationException("EnemyCell can not be attack!");
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }
  

  

  /**
   * Print the instance and its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "EnemyCell" + super.toString();
  }

  @Override
  public void update(Ship ship) {
    if (ship.isSunk()) {
      markShipCellSunk();
    }
  }
}
