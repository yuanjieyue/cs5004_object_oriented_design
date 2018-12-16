package edu.neu.ccs.cs5004.assignment5.battleship.model.printer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.*;

public class ConsolePrinter implements IConsolePrinter {

  @Override
  public void toConsole(IMap map) {
    System.out.println();
    for (int i = 0; i <= Map.ROW; i++) {
      StringBuilder tmp = new StringBuilder();
      if (i > 0) {
        if (i <= Map.ROW - 1) {
          tmp.append(" ");
        }
        tmp.append(String.valueOf(i));
      } else {
        tmp.append("  ");
      }
      System.out.print(tmp.toString());
      for (int j = 1; j <= Map.COLUMN; j++) {
        System.out.print(" ");
        if (i == 0) {
          System.out.print((char) ('A' + (j - 1)));
        } else {
          if (map.getCell(new Posn(i, j)) instanceof SpecifiedCell) {
            toConsole((SpecifiedCell) map.getCell(new Posn(i, j)));
          } else if (map.getCell(new Posn(i, j)) instanceof EnemyCell) {
            toConsole((EnemyCell) map.getCell(new Posn(i, j)));
          } else {
            toConsole((WaterCell) map.getCell(new Posn(i, j)));
          }
        }
      }
      System.out.println();
    }
  }

  @Override
  public void toConsole(WaterCell cell) {
    StringBuilder res = new StringBuilder();
    if (cell instanceof OpenSeaCell) {
      res.append("-");
    } else {
      res.append("+");
    }
    System.out.print(res.toString());
  }

  @Override
  public void toConsole(SpecifiedCell cell) {
    StringBuilder res = new StringBuilder();
    if (cell.getIsSunk()) {
      res.append("x");
    } else {
      if (cell.getIsHit()) {
        res.append("*");
      } else if (!cell.getIsHit()) {
        res.append("o");
      }
    }
    System.out.print(res.toString());
  }

  @Override
  public void toConsole(EnemyCell cell) {
    StringBuilder res = new StringBuilder();
    if (cell.getIsSunk()) {
      res.append("x");
    } else {
      if (cell.getIsHit()) {
        res.append("*");
      } else if (!cell.getIsHit()) {
        res.append("o");
      }
    }
    System.out.print(res.toString());
  }

  @Override
  public int hashCode() {
    int res = 43;
    res = 43 * res + 43;
    return res;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ConsolePrinter={}";
  }

  public static void main(String args[]) {
    WaterCell waterCell = new OpenSeaCell(false);
    WaterCell waterCell2 = new GapCell(false);
    SpecifiedCell specifiedCell = new SpecifiedCell(false, false);
    SpecifiedCell specifiedCell1 = new SpecifiedCell(true, false);
    SpecifiedCell specifiedCell2 = new SpecifiedCell(true, true);
    SpecifiedCell specifiedCell3 = new SpecifiedCell(false, true);
    EnemyCell enemyCell = new EnemyCell(false, false);
    Map map = new Map();
    ConsolePrinter printer = new ConsolePrinter();
    printer.toConsole(waterCell);
    printer.toConsole(waterCell2);
    printer.toConsole(specifiedCell);
    printer.toConsole(specifiedCell1);
    printer.toConsole(specifiedCell2);
    printer.toConsole(specifiedCell3);
    printer.toConsole(enemyCell);
    printer.toConsole(map);
  }
}