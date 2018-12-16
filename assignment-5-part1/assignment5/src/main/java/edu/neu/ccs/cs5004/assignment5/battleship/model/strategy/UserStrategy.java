package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;

public class UserStrategy implements Strategy {

  @Override
  public Posn generatePosn() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please type in the X coordinate of the posn: (which should be in the " +
        "range of [1, " + Map.COLUMN + "])");
    int coordX = Integer.parseInt(reader.readLine());
    while (coordX < 1 || coordX > Map.COLUMN) {
      System.out.println("Wrong Input, X coordinate should be in the range of [1, " + Map.COLUMN
          + "])");
      coordX = Integer.parseInt(reader.readLine());
    }
    System.out.println("Please type in the Y coordinate of the posn: (which should be in the " +
        "range of [1, " + Map.ROW + "])");
    int coordY = Integer.parseInt(reader.readLine());
    while (coordY < 1 || coordY > Map.ROW) {
      System.out.println("Wrong Input, Y coordinate should be in the range of [1, " + Map.ROW
          + "])");
      coordY = Integer.parseInt(reader.readLine());
    }
    return new Posn(coordX, coordY);
  }
}
