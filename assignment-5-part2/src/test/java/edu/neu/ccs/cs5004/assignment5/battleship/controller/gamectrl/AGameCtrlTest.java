package edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class AGameCtrlTest {
  private BufferedReader reader;
  
  private String input;
  
  private InputStream mockInputStream;
  
  private Player player;
  
  private GameCtrl gameCtrl1;
  private GameCtrl gameCtrl2;
  
  
  @Before
  public void setUp() throws Exception {
    input = ("0\n0\n1\n-1\n1\n-1\nH\nA\n1\n0\n0");
  
    mockInputStream = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
    
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
    gameCtrl1 = GameCtrl.createGameCtrl(GameModeOptions.DEBUG);
    gameCtrl2 = GameCtrl.createGameCtrl(GameModeOptions.GAME);
    
  }
  
  @Test
  public void playCameCtrl() {
    gameCtrl1.setUpPlayerFleet(reader);
    gameCtrl1.playCameCtrl(reader);
//    gameCtrl2.setUpPlayerFleet(reader);
//    gameCtrl2.playCameCtrl(reader);
  }
  
  @Test
  public void printMaps() {
  }
  
  @Test
  public void printMapsFactory() {
  }
}