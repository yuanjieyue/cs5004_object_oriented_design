package edu.neu.ccs.cs5004.assignment5.battleship.model.playmode;

import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public class GameMode extends PlayMode {
  private List<Player> observers;

  @Override
  public void initialize(Player player) {
    player = new Player();
  }

  @Override
  public void registerObserver(Player observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Player observer) {
    observers.remove(observer);
  }

  @Override
  public void viewMaps() {
    ConsolePrinter printer = new ConsolePrinter();
    for (Player player : observers) {
      player.getFleetMap().prettyPrint(printer);
      System.out.println();
    }
  }
}
