package edu.neu.ccs.cs5004.assignment5.battleship.model.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class AStrategyTest {
  private BufferedReader reader;
  private BufferedReader reader2;
  private BufferedReader reader3;
  private BufferedReader reader4;
  private String input;
  private String input2;
  private String input3;
  private String input4;
  private InputStream mockInputStream;
  private InputStream mockInputStream2;
  private InputStream mockInputStream3;
  private InputStream mockInputStream4;
  
  private Strategy strategy1;
  private Strategy strategy2;
  private Strategy strategy3;
  private Strategy strategy4;
  private Player player;
  
  @Before
  public void setUp() throws Exception {
    input = ("0");
    input2 = ("1");
    input3 = ("2");
    input4 = ("2");
    mockInputStream = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    mockInputStream2 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input2.getBytes("UTF-8")
    );
    mockInputStream3 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input3.getBytes("UTF-8")
    );
    mockInputStream4 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input4.getBytes("UTF-8")
    );
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
    reader2 = new BufferedReader(new InputStreamReader(mockInputStream2));
    reader3 = new BufferedReader(new InputStreamReader(mockInputStream3));
    reader4 = new BufferedReader(new InputStreamReader(mockInputStream4));
  
    player = Player.initiatePlayer("player");
    strategy1 = Strategy.initiateStrategy(reader, player);
    strategy2 = Strategy.initiateStrategy(reader2, player);
    strategy3 = Strategy.initiateStrategy(reader3, player);
    strategy4 = Strategy.initiateStrategy(reader4, player);
  }
  
  @Test
  public void getPlayer() {
    Assert.assertEquals(strategy1.getPlayer().getPlayerName(), player.getPlayerName());
  }
  
  @Test
  public void checkPosnInBound() {
    Assert.assertFalse(AStrategy.checkPosnInBound(new Posn(-1, -1)));
    Assert.assertFalse(AStrategy.checkPosnInBound(new Posn(11, 11)));
  }
}