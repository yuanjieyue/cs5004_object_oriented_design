package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameLogics.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.playmode.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.strategy.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public class GameDemo {
  private static final int DEBUGMODE = 0;
  private static final int GAMEMODE = 1;
  private static final int RANDOMPLACEMENT = 0;
  private static final int USERPLACEMENT = 1;

  private Player humanPlayer;
  private Player computerPlayer;

  public Player getHumanPlayer() {
    return humanPlayer;
  }

  public Player getComputerPlayer() {
    return computerPlayer;
  }

  public void choosePlayMode() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Place choose play mode '0' for DebugMode or '1' for GameMode: ");
    int i = Integer.parseInt(br.readLine());
    while (i < 0 || i > 1) {
      System.out.println("Wrong input, '0' for DebugMode or '1' for GameMode!");
      i = Integer.parseInt(br.readLine());
    }
    if (i == DEBUGMODE) {
      DebugMode debugMode = new DebugMode();
      debugMode.initialize(humanPlayer);
      debugMode.registerObserver(humanPlayer);
      choosePlacement(humanPlayer);
      debugMode.initialize(computerPlayer);
      debugMode.registerObserver(computerPlayer);
      choosePlacement(humanPlayer);
      debugMode.viewMaps();
    } else {
      GameMode gameMode = new GameMode();
      gameMode.initialize(humanPlayer);
      gameMode.registerObserver(humanPlayer);
      choosePlacement(humanPlayer);
      gameMode.initialize(computerPlayer);
      computerPlayer.randomPlacement();
      gameMode.viewMaps();
    }
  }

  public void choosePlacement(Player player) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Place choose How To Place The Ships , '0' for RandomPlacement or '1' for" +
        " " +
        "UserPlacement: ");
    int i = Integer.parseInt(br.readLine());
    while (i < 0 || i > 1) {
      System.out.println("Wrong input, '0' for RandomPlacement or '1' for UserPlacement!");
      i = Integer.parseInt(br.readLine());
    }
    if (i == RANDOMPLACEMENT) {
      player.randomPlacement();
    } else {
      player.userPlacement();
    }
  }

  private Posn chooseStrategy() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please choose your Attack Strategy: ('1' for RandomStrategy, '2' for " +
        "UserStrategy, and '3' for SmartStrategy)");
    int choose = Integer.parseInt(reader.readLine());
    while (choose < 1 || choose > 3) {
      System.out.println("Wrong input, please choose your Attack Strategy: ('1' for " +
          "RandomStrategy, '2' " + "for " + "UserStrategy, and '3' for SmartStrategy), input " +
          "again please!");
      choose = Integer.parseInt(reader.readLine());
    }
    Strategy strategy = null;
    switch (choose) {
      case 1:
        strategy = new RandomStrategy();
        break;
      case 2:
        strategy = new UserStrategy();
        break;
      case 3:
        strategy = new SmartStrategy();
    }
    return strategy.generatePosn();
  }

  public void start() throws IOException {
    choosePlayMode();
    ConsolePrinter printer = new ConsolePrinter();
    while (true) {
      Posn posn = chooseStrategy();
      getHumanPlayer().attack(getComputerPlayer(), posn);
      if (computerPlayer.ifFail()) {
        System.out.println("The game is over, winner is " + humanPlayer.toString());
        return;
      }
      getComputerPlayer().attack(getHumanPlayer(), new RandomStrategy().generatePosn());
      getHumanPlayer().getFleetMap().prettyPrint(printer);
      getHumanPlayer().getAdditionMap().prettyPrint(printer);
      if (humanPlayer.ifFail()) {
        System.out.println("The game is over, winner is " + computerPlayer.toString());
        return;
      }
    }
  }
}
