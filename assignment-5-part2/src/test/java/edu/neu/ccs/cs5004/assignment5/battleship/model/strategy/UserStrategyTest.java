package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class UserStrategyTest {
  private BufferedReader reader;
  private BufferedReader reader2;
  private String input;
  private String input2;
  private InputStream mockInputStream;
  private InputStream mockInputStream2;
  
  private UserStrategy userStrategy;
  
  private String playerName;
  private Player player;
  
  @Before
  public void setUp() throws Exception {
    input = ("A\n1\nH\nA\n11\n3\nA\n5");
    input2 = ("1\n2\n3\n4\na\n1");
    mockInputStream = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    mockInputStream2 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input2.getBytes("UTF-8")
    );
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
    reader2 = new BufferedReader(new InputStreamReader(mockInputStream2));
    
    player = Player.initiatePlayer("human");
    player.getGuessMap().setCell(new Posn(1,1),
        new EnemyCell(true, new Posn(1,1), false));
    
    userStrategy = new UserStrategy(reader, player);
  }
  
  @Test
  public void generateAttackPosn() {
    userStrategy.generateAttackPosn();
  }
}