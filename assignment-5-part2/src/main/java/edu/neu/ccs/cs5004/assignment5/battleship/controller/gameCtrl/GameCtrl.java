package edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.GameModeOptions;

import java.io.BufferedReader;

public interface GameCtrl {
  
  String USER_PLAYER_ID = "Human";
  String AI_PLAYER_ID = "AI";
  
  /**
   * Create a game controller.
   * @param gameModeOptions option of the game modes
   * @return a game controller for the corresponding game controller.
   */
  static GameCtrl createGameCtrl(GameModeOptions gameModeOptions) {
    if (gameModeOptions.equals(GameModeOptions.DEBUG)) {
      return new DebugMode();
    } else {
      return new GameMode();
    }
  }
  
  /**
   * Set up the player's fleet displacement and strategy.
   * @param reader instruction from player
   */
  void setUpPlayerFleet(BufferedReader reader);

  void playCameCtrl(BufferedReader reader);
}
