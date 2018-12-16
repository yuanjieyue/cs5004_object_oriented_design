package edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer;


import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.GapCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.WaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.BoardMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;

public class ConsolePrinter implements IConsolePrinter {

  @Override
  public void toConsole(Map map) {
    //System.out.println();
    for (int i = 0; i <= BoardMap.ROW; i++) {
      StringBuilder tmp = new StringBuilder();
      if (i > 0) {
        if (i <= BoardMap.ROW - 1) {
          tmp.append(" ");
        }
        tmp.append(String.valueOf(i));
      } else {
        tmp.append("  ");
      }
      System.out.print(tmp.toString());
      for (int j = 1; j <= BoardMap.COLUMN; j++) {
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
    System.out.println("-----------------------");
  }

  @Override
  public void toConsole(WaterCell cell) {
    StringBuilder res = new StringBuilder();
    if (cell instanceof OpenSeaCell) {
      if (cell.getIsHit()) {
        res.append("-");
      } else {
        res.append("~");
      }
    } else if (cell instanceof GapCell) {
      res.append("+");
    }
    
    System.out.print(res.toString());
  }

  @Override
  public void toConsole(SpecifiedCell cell) {
    StringBuilder res = new StringBuilder();
    res.append("o");
    System.out.print(res.toString());
  }

  @Override
  public void toConsole(EnemyCell cell) {
    StringBuilder res = new StringBuilder();
    if (cell.isSunk()) {
      res.append("x");
    } else {
      if (cell.getIsHit()) {
        res.append("*");
      } else {
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
}