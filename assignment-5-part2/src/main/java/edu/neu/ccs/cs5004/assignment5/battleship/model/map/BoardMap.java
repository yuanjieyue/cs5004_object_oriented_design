package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.IncorrcetIndexException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Orientation;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a map for a battleship game.
 */
public class BoardMap implements Map {
  
  private Cell[][] field;

  /**
   * Create a new map.
   */
  public BoardMap() {
    field = new Cell[ROW][COLUMN];
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        field[i][j] = new OpenSeaCell(false, new Posn(i + 1, j + 1));
      }
    }
  }

  @Override
  public Cell[][] getField() {
    Cell[][] res = new Cell[ROW][COLUMN];
    for (int idx = 0; idx < ROW; idx++) {
      for (int jdx = 0; jdx < COLUMN; jdx++) {
        res[idx][jdx] = this.field[idx][jdx];
      }
    }
    return res;
  }

  @Override
  public Cell getCell(Posn posn) {
    int coordX = posn.getX();
    int coordY = posn.getY();
    if (coordX < 1 || coordX > ROW) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordY < 1 || coordY > COLUMN) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    return field[coordX - 1][coordY - 1];
  }

  @Override
  public void setCell(Posn posn, Cell substitue) {
    int coordX = posn.getX();
    int coordY = posn.getY();
    if (coordX < 1 || coordX > ROW) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordY < 1 || coordY > COLUMN) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    field[coordX - 1][coordY - 1] = substitue;
  }

  @Override
  public boolean isPosnValid(Ship ship, Posn posn, Orientation ori) {
    boolean res = !(isAnyPartOfShipOutOfBound(ship, posn, ori))
        && !(isAnyPartOfShipOccupied(ship, posn, ori));
    return res;
  }

  /**
   * Check if any part of the ship is out of bound.
   *
   * @param ship the ship to be placed on the map
   * @param posn the posn where the ship is going to be placed
   * @param ori the orientation how the ship is going to be place
   * @return true if any part of the ship is out of bound, false otherwise
   */
  private boolean isAnyPartOfShipOutOfBound(Ship ship, Posn posn, Orientation ori) {
    boolean res = false;
    if (ori == Orientation.VERTICAL) {
      if (ship.getSize() + posn.getX() - 1 > BoardMap.ROW) {
        res = true;
      }
    } else {
      if (ship.getSize() + posn.getY() - 1 > BoardMap.COLUMN) {
        res = true;
      }
    }
    return res;
  }

  /**
   * Check if any part of the place that the ship want to place is already occupied.
   *
   * @param ship the ship to be placed on the map
   * @param posn the posn where the ship is going to be placed
   * @param ori the orientation how the ship is going to be place
   * @return true if any part of the to be placed area is already occupied, false otherwise
   */
  private boolean isAnyPartOfShipOccupied(Ship ship, Posn posn, Orientation ori) {
    boolean res = false;
    int coordX = posn.getX();
    int coordY = posn.getY();
    Cell[][] tmp = this.getField();
    for (int i = 0; i < ship.getSize(); i++) {
      if (ori == Orientation.VERTICAL) {
        if (!tmp[coordX + i - 1][coordY - 1].placeShipOnCell()) {
          res = true;
          break;
        }
      } else {
        if (!tmp[coordX - 1][coordY + i - 1].placeShipOnCell()) {
          res = true;
          break;
        }
      }
    }
    return res;
  }

  @Override
  public void flipToSpecifiedCells(ShipSubject shipSubject, Posn posn, Orientation ori) {
    int idx = 0;
    Posn posnToFlip = null;
    while (idx < shipSubject.getShip().getSize()) {
      if (ori == Orientation.VERTICAL) {
        posnToFlip = posn.moveX(idx);
      } else {
        posnToFlip = posn.moveY(idx);
      }
      setCell(posnToFlip, new SpecifiedCell(false, posnToFlip, false, shipSubject));
      idx++;
    }
  }

  /**
   * Check the cells that needed to be flipped to Gap Cell on the map.
   *
   * @param ship the ship that been placed on the given {@code posn} on the map
   * @param posn the posn where the ship is placed
   * @param ori the orientation of the ship on the map
   * @return the list of posns on which the cell needed to be flipped
   */
  private List<Posn> checkCellsToFlipToGapCells(Ship ship, Posn posn, Orientation ori) {
    List<Posn> res = new ArrayList<>();
    int xcoord = posn.getX();
    int ycoord = posn.getY();
    int size = ship.getSize();
    if (ori == Orientation.VERTICAL) {
      res.add(new Posn(xcoord - 1, ycoord));
      res.add(new Posn(xcoord + size, ycoord));
      for (int i = xcoord - 1; i <= xcoord + size; i++) {
        res.add(new Posn(i, ycoord - 1));
        res.add(new Posn(i, ycoord + 1));
      }
    } else {
      for (int j = posn.getY() - 1; j <= posn.getY() + ship.getSize(); j++) {
        res.add(new Posn(posn.getX() - 1, j)); // The cells left to the ship
        res.add(new Posn(posn.getX() + 1, j)); // The cells right the ship
        if (j == posn.getY() - 1 || j == posn.getY() + ship.getSize()) {
          res.add(new Posn(posn.getX(), j)); // The cell in next to two end of the ship
        }
      }
    }
    // Remove all posns that are out of bound
    for (int i = 0; i < res.size(); i++) {
      Posn posnToFlip = res.get(i);
      if (isPosnOutOfBound(posnToFlip) || !isPosnOpenSeaCell(posnToFlip)) {
        res.remove(posnToFlip);
        i--;
      }
    }
    return res;
  }
  
  
  private boolean isPosnOpenSeaCell(Posn posn) {
    if (this.getCell(posn) instanceof OpenSeaCell) {
      return true;
    }
    return false;
  }
  
  private boolean isPosnOutOfBound(Posn posn) {
    int coordX = posn.getX();
    int coordY = posn.getY();
    if (coordX < 1 || coordX > ROW || coordY < 1 || coordY > COLUMN) {
      return true;
    }
    return false;
  }
  
  

  @Override
  public void flipToGapCells(Ship ship, Posn posn, Orientation ori) {
    List<Posn> posns = checkCellsToFlipToGapCells(ship, posn, ori);
    for (Posn posnToFlip : posns) {
      setCell(posnToFlip, Cell.createGapCell(false, posnToFlip));
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
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    BoardMap boardMap = (BoardMap) obj;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        if (! (field[i][j].equals(boardMap.getCell(new Posn(i + 1, j + 1))))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int res = 31;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        res = 31 * res + (field[i][j] != null ? field[i][j].hashCode() : 0);
      }
    }
    return res;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder("BoardMap{row=" + ROW + ", column=" + COLUMN
        + ", fields:\n");
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        res.append("Posn{x=" + (i + 1) + ", y=" + (j + 1) + "}" + " -> ");
        res.append(field[i][j].toString());
        res.append("\n");
      }
    }
    res.append("}");
    return res.toString();
  }
}
