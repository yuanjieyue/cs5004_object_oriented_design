package edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class GameModeTest {
  private BufferedReader reader;
  
  private String input;
  
  private InputStream mockInputStream;
  
  private Player player;
  
  
  @Before
  public void setUp() throws Exception {
    input = ("H\nC\n5\nH\nD\n6\nH\nF\n7\nH\nI\n6\nH\nJ\n9\nH\nA\n10\nH\nA\n1\nH\nA\n3\nH" +
        "\nA\n5\nH\nA\n7\nH\nC\n7\nH\nE\n1");
    
    mockInputStream = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
    
  }
  
  @Test
  public void setUpPlayerFleet() {
    new GameMode().setUpPlayerFleet(reader);
  }
}