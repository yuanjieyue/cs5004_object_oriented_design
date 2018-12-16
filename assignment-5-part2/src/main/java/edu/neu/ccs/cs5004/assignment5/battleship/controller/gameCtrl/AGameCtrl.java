package edu.neu.ccs.cs5004.assignment5.battleship.controller.gamectrl;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.Strategy;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.userinteractor.UserInteraction;

import java.io.BufferedReader;

/**
 * Represent an abstract game controller.
 */
public abstract class AGameCtrl implements GameCtrl {
  
  
  private Player humanPlayer;
  private Player artificialPlayer;
  private Strategy humanStrategy;
  private Strategy aiStrategy;
  
  /**
   * Constructor of the game controller.
   */
  public AGameCtrl() {
    humanPlayer = Player.initiatePlayer(USER_PLAYER_ID);
    artificialPlayer = Player.initiatePlayer(AI_PLAYER_ID);
    humanStrategy = null;
    aiStrategy = null;
  }
  
  /**
   * Get the human player of the game.
   * @return the human player object
   */
  public Player getHumanPlayer() {
    return humanPlayer;
  }
  
  /**
   * Get the ai player of the game.
   * @return the ai player
   */
  public Player getArtificialPlayer() {
    return artificialPlayer;
  }
  
  @Override
  public void playCameCtrl(BufferedReader reader) {
    
    humanStrategy = Strategy.initiateStrategy(reader, humanPlayer);
    aiStrategy = Strategy.initiateStrategy(reader, artificialPlayer);
    
    System.out.println("Human Player goes first to guess.");
    Player curPlayer = humanPlayer;
    boolean currentPlayerWin = false;
    while (!currentPlayerWin) {
      currentPlayerWin = executeASingleGuess(curPlayer);
      if (currentPlayerWin) {
        UserInteraction.announceWinner(curPlayer);
      } else {
        curPlayer = switchTurn(curPlayer);
        System.out.println("Switch player.\nIt's " + curPlayer.getPlayerName()
            + "'s turn to guess.");
      }
    }
  
  }
  
  private boolean executeASingleGuess(Player currentPlayer) {
    Posn posToBeAttacked;
    if (currentPlayer.getPlayerName().equals(USER_PLAYER_ID)) {
      posToBeAttacked = humanStrategy.generateAttackPosn();
    } else {
      posToBeAttacked = aiStrategy.generateAttackPosn();
    }
    Player opponent = switchTurn(currentPlayer);
    
    // the opponent answer the the result cell after attack.
    Cell resultCell = opponent.returnAttackResultToOpponent(posToBeAttacked);
    
    // the opponent update his own cell.
    opponent.updateFleetAfterAttack(posToBeAttacked);
    
    // current player update his guess map.
    currentPlayer.updateGuessMapBasedOnAttackResultFromOpponent(posToBeAttacked, resultCell);
    
    //print out maps
    printMaps(currentPlayer, opponent);
    
    if (opponent.isFleetSunk()) {
      return true;
    }
    return false;
  }
  
  
  /**
   * Get the opponent of the current gamePlayer.
   *
   * @param player current gamePlayer
   * @return the opponent gamePlayer
   */
  private Player switchTurn(Player player) {
    if (player.getPlayerName().equals(USER_PLAYER_ID)) {
      return artificialPlayer;
    }
    return humanPlayer;
  }
  
  /**
   * Print out the maps of the game.
   *
   * @param player   current gamePlayer
   * @param opponent the opponent gamePlayer
   */
  public void printMaps(Player player, Player opponent) {
    printMapsFactory(player, opponent);
  }
  
  /**
   * Helper function to printMaps.
   *
   * @param player   current gamePlayer
   * @param opponent the opponent gamePlayer
   */
  public abstract void printMapsFactory(Player player, Player opponent);
  
}