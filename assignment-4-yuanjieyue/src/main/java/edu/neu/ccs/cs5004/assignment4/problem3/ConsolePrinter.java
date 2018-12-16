package edu.neu.ccs.cs5004.assignment4.problem3;

public class ConsolePrinter implements IConsolePrinter {
  @Override
  public void toConsole(IMap map) {
    for (int i = 0; i <= Map.ROW; i++) {
      StringBuilder tmp = new StringBuilder();
      if (i > 0) {
        if (i < 10) {
          tmp.append(" ");
        }
        tmp.append(String.valueOf(i));
      } else {
        tmp.append("  ");
      }
      for (int j = 1; j <= Map.COLUMN; j++) {
        if (i == 0) {
          tmp.append(" ");
          tmp.append((char) ('A' + (j - 1)));
          tmp.append(" ");
        } else {
          tmp.append(" ");
          if (map.getCell(new Posn(i, j)) instanceof SpecifiedCell) {
            tmp.append("o");
          } else {
            tmp.append("-");
          }
          tmp.append(" ");
        }
      }
      System.out.println(tmp.toString());
    }
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
