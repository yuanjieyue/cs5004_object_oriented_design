package edu.neu.ccs.cs5004.assignment5.battleship;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl.GameCtrl;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor.UserInteraction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


/**
 * Represent the main function of the battleship game.
 * Thanks for Jerry Hao and Qi Zhang for discussion.
 *
 * @author Tao Xu and Yuanjie Yue
 *
 */
public class GameMain {
  
  /**
   * Represnet the main function of battleshp game.
   * @param args arguments of the game
   */
  public static void main(String[] args) {
    
    UserInteraction.greetingAndGameInstruction();
  
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,
        Charset.defaultCharset()));
  
    GameModeOptions gameModeOptions = UserInteraction.enquireGameMode(reader);
  
    GameCtrl gameCtrl = GameCtrl.createGameCtrl(gameModeOptions);
    
    gameCtrl.setUpPlayerFleet(reader);
    
    gameCtrl.playCameCtrl(reader);
    
  }
  
}
