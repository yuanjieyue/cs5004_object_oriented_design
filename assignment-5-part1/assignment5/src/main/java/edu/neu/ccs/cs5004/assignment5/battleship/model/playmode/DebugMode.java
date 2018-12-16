package edu.neu.ccs.cs5004.assignment5.battleship.model.playmode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.printer.ConsolePrinter;

public class DebugMode extends PlayMode {
  private List<Player> observers;

  @Override
  public void initialize(Player player) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please input how many ships do you want to test with");
    Integer size = Integer.parseInt(reader.readLine());

    player = new Player(size);
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
