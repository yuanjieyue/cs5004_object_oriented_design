package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.IncorrcetIndexException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.AbstractShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

/**
 * Represents a map for a battleship game.
 */
public class Map implements IMap {

  public static final int ROW = 10;
  public static final int COLUMN = 10;

  private List<Ship> observers;
  private Cell[][] field;

  /**
   * Create a new map.
   */
  public Map() {
    field = new Cell[ROW][COLUMN];
    OpenSeaCell initial = new OpenSeaCell(false);
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        field[i][j] = initial;
      }
    }
  }

  public Cell[][] getField() {
    return field;
  }

  public List<Ship> getObservers() {
    return observers;
  }

  @Override
  public List<Ship> observers() {
    return getObservers();
  }

  @Override
  public Cell getCell(Posn posn) {
    int coordX = posn.getX();
    int coordY = posn.getY();
    if (coordX < 1 || coordX > 10) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordY < 1 || coordY > 10) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    return field[coordX - 1][coordY - 1];
  }

  @Override
  public void setCell(Posn posn, Cell substitue) {
    int coordX = posn.getX();
    int coordinateY = posn.getY();
    if (coordX < 1 || coordX > 10) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordinateY < 1 || coordinateY > 10) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    field[coordX - 1][coordinateY - 1] = substitue;
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public void registerObserver(Ship observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Ship observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Ship ship : observers) {
      ship.update(this);
    }
  }

  public void flipToSpecifiedCells(Ship ship, Posn posn, Integer direction) {
    SpecifiedCell specifiedCell = new SpecifiedCell(false, false);
    if (direction == AbstractShip.HORIZONTAL) {
      int i = 0;
      while (i < ship.size()) {
        Posn tmp = posn.moveX(i);
        setCell(tmp, specifiedCell);
      }
    } else {
      int i = 0;
      while (i < ship.size()) {
        Posn tmp = posn.moveY(i);
        setCell(tmp, specifiedCell);
      }
    }
  }


  public List<Posn> checkCellsToFlipToGapCells(Ship ship, Posn posn, Integer direction) {
    List<Posn> res = new ArrayList<>();
    if (direction == AbstractShip.HORIZONTAL) {
      Posn[][] posns = new Posn[3][ship.size() + 2];
      int i = 1;
      for (int j = 0; j < posns[0].length; j++) {
        posns[i][j] = posn.moveX(j - 2);
      }
      i = 0;
      for (int j = 0; j < posns[0].length; j++) {
        posns[i][j] = posns[i + 1][j].moveY(-1);
      }
      i = 2;
      for (int j = 0; j < posns[0].length; j++) {
        posns[i][j] = posns[i - 1][j].moveY(1);
      }
      for (int k = 0; k < posns.length; k++) {
        for (int j = 0; j < posns[0].length; j++) {
          if (posns[k][j].getX() >= 1 && posns[k][j].getX() <= Map.COLUMN
              && posns[k][j].getY() >= 1 && posns[k][j].getY() <= Map.ROW) {
            res.add(posns[k][j]);
          }
        }
      }
    }
    return res;
  }

  public void flipToGapCells(List<Posn> posns) {
    GapCell gapCell = new GapCell(false);
    for (Posn posn : posns) {
      setCell(posn, gapCell);
    }
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Map map = (Map) obj;

    for (int i = 1; i <= ROW; i++) {
      for (int j = 1; j <= COLUMN; j++) {
        if (! (field[i - 1][j - 1].equals(map.getCell(new Posn(i, j))))) {
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
    StringBuilder res = new StringBuilder("Map{row=" + ROW + ", column=" + COLUMN + ", fields:\n");
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
