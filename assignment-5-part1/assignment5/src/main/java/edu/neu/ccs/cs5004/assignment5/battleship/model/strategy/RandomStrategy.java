package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import java.util.Random;

import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;

public class RandomStrategy implements Strategy {
  @Override
  public Posn generatePosn() {
    Random rand = new Random();
    int i = 0;
    int coordX = rand.nextInt(Map.COLUMN) + 1;
    int coordY = rand.nextInt(Map.ROW) + 1;

    return new Posn(coordX, coordY);
  }
}
