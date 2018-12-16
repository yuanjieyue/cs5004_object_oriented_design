package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;


import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.BoardMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;
import java.util.Random;

public class RandomStrategy extends AStrategy {
  
  public RandomStrategy(BufferedReader reader, Player player) {
    super(reader, player);
  }
  
  @Override
  public Posn generateAttackPosn() {
    Random rand = new Random();
    int coordX = rand.nextInt(BoardMap.COLUMN) + 1;
    int coordY = rand.nextInt(BoardMap.ROW) + 1;
    Posn res = new Posn(coordX, coordY);
    while (getPlayer().getGuessMap().getCell(res).getIsHit()) {
      coordX = rand.nextInt(BoardMap.COLUMN) + 1;
      coordY = rand.nextInt(BoardMap.ROW) + 1;
      res = new Posn(coordX, coordY);
    }
    return res;
  }
}
