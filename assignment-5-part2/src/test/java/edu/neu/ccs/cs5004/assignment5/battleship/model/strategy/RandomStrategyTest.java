package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class RandomStrategyTest {
  private RandomStrategy randomStrategy;
  
  private BufferedReader reader;
  
  private Player player;
  
  @Before
  public void setUp() throws Exception {
    player = Player.initiatePlayer("aiPlayer");
    player.getGuessMap().setCell(new Posn(1,1), new EnemyCell(true,
        new Posn(1, 1), true));
    player.getGuessMap().setCell(new Posn(5,5), new EnemyCell(true,
        new Posn(5,5), false));
  
    randomStrategy = new RandomStrategy(null, player);
  }
  
  @Test
  public void generateAttackPosn() {
    for (int i = 0; i < 500; i++) {
      randomStrategy.generateAttackPosn();
    }
    
  }
}