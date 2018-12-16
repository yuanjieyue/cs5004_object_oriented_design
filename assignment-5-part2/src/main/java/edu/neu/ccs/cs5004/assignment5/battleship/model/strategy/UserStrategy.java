package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor.UserInteraction;

import java.io.BufferedReader;

public class UserStrategy extends AStrategy {
  
  public UserStrategy(BufferedReader reader, Player player) {
    super(reader, player);
  }
  
  @Override
  public Posn generateAttackPosn() {
    int coordX;
    int coordY;
    Posn res = null;
    coordY = UserInteraction.enquireColumnIndex(getReader());
    coordX = UserInteraction.enquireRowIndex(getReader());
    res = new Posn(coordX, coordY);
    while (AStrategy.checkPosnInBound(res) && getPlayer().getGuessMap().getCell(res).getIsHit()) {
      System.out.println("Invalid posn, please choose another one!");
      coordY = UserInteraction.enquireColumnIndex(getReader());
      coordX = UserInteraction.enquireRowIndex(getReader());
      res = new Posn(coordX, coordY);
    }
    return res;
  }
}
