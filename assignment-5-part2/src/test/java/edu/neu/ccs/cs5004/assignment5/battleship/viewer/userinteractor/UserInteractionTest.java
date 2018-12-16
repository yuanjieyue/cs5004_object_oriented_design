package edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public class UserInteractionTest {
  private BufferedReader reader1;
  private String input1;
  private InputStream mockInputStream1;
  
  private BufferedReader reader2;
  private String input2;
  private InputStream mockInputStream2;
  
  private BufferedReader reader3;
  private String input3;
  private InputStream mockInputStream3;
  
  private BufferedReader reader4;
  private String input4;
  private InputStream mockInputStream4;
  
  private BufferedReader reader5;
  private String input5;
  private InputStream mockInputStream5;
  
  private Player player;
  
  @Before
  public void setUp() throws Exception {
    input1 = ("J");
    mockInputStream1 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input1.getBytes("UTF-8")
    );
    reader1 = new BufferedReader(new InputStreamReader(mockInputStream1));
  
    input2 = ("F");
    mockInputStream2 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input2.getBytes("UTF-8")
    );
    reader2 = new BufferedReader(new InputStreamReader(mockInputStream2));
  
    input3 = ("0");
    mockInputStream3 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input3.getBytes("UTF-8")
    );
    reader3 = new BufferedReader(new InputStreamReader(mockInputStream3));
  
    input4 = ("1");
    mockInputStream4 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input4.getBytes("UTF-8")
    );
    reader4 = new BufferedReader(new InputStreamReader(mockInputStream4));
  
    input5 = ("*\n1\nA\nH");
    mockInputStream5 = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input5.getBytes("UTF-8")
    );
    reader5 = new BufferedReader(new InputStreamReader(mockInputStream5));
    
    player = Player.initiatePlayer("player");
    
  }
  
  @Test
  public void greetingAndGameInstruction() {
    UserInteraction.greetingAndGameInstruction();
  }
  
  
  @Test
  public void enquireColumnIndex() {
    UserInteraction.enquireColumnIndex(reader1);
    UserInteraction.enquireColumnIndex(reader2);
    UserInteraction.enquireColumnIndex(reader5);
  }
  
  
  @Test
  public void enquireFleetPlacementMode() {
    UserInteraction.enquireFleetPlacementMode(reader3);
    UserInteraction.enquireFleetPlacementMode(reader4);
    UserInteraction.enquireFleetPlacementMode(reader5);
  }
  
  @Test
  public void enquireGameMode() {
    UserInteraction.enquireGameMode(reader3);
    UserInteraction.enquireGameMode(reader4);
    UserInteraction.enquireGameMode(reader5);
  }
  
  
  @Test
  public void enquireOrientation() {
    UserInteraction.enquireOrientation(reader5);
  }
  
  @Test
  public void enquireStrategy() {
    UserInteraction.enquireStrategy(reader5, player);
  }
  
}