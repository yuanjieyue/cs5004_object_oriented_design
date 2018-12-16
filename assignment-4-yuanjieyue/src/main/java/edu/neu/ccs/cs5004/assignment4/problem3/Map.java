package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a map for a battleship game.
 */
public class Map implements IMap {

  static final int ROW = 10;
  static final int COLUMN = 10;

  private Cell[][] field;

  /**
   * Create a new map.
   */
  protected Map() {
    field = new Cell[ROW][COLUMN];
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COLUMN; j++) {
        field[i][j] = new OpenSeaCell(false);
      }
    }
  }

  @Override
  public Cell getCell(Posn posn) {
    int coordinateX = posn.getCoordinateX();
    int coordinateY = posn.getCoordinateY();
    if (coordinateX < 1 || coordinateX > 10) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordinateY < 1 || coordinateY > 10) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    return field[coordinateX - 1][coordinateY - 1];
  }

  @Override
  public void setCell(Posn posn, Cell substitue) {
    int coordinateX = posn.getCoordinateX();
    int coordinateY = posn.getCoordinateY();
    if (coordinateX < 1 || coordinateX > 10) {
      throw new IncorrcetIndexException("Coordinate X Is Out Of Bound!");
    }
    if (coordinateY < 1 || coordinateY > 10) {
      throw new IncorrcetIndexException("Coordinate Y Is Out Of Bound!");
    }
    field[coordinateX - 1][coordinateY - 1] = substitue;
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
