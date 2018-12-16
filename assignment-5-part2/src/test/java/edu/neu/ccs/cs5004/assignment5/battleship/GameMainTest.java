package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Before;
import org.junit.Test;

import sun.applet.Main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class GameMainTest {
  private BufferedReader reader;
  
  private String input;
  
  private InputStream mockInputStream;
  
  @Before
  public void setUp() throws Exception {
    input = ("0\n0\n1\n-1\n1\n-1\nH\nA\n1\n0\n0");
  
    mockInputStream = new ByteArrayInputStream(
      
        // 'UTF-8' is the encoding using which the bytes should be read
        input.getBytes("UTF-8")
    );
  
    reader = new BufferedReader(new InputStreamReader(mockInputStream));
  }
  
  @Test
  public void main() {
    System.setIn(mockInputStream);
    GameMain.main(null);
    
  }
}