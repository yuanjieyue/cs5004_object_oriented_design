package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.BoardMap;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a player of the battleship game.
 */
public abstract class APlayer implements Player {

  private String name;
  private BoardMap fleetBoardMap;
  private BoardMap additionBoardMap;
  private ArrayList<ShipSubject> fleet;
  
  
  /**
   * Create an abstract player.
   * @param name name of the player
   * @param fleet the ships of the player
   */
  public APlayer(String name, ArrayList<ShipSubject> fleet) {
    this.name = name;
    this.fleetBoardMap = new BoardMap();
    this.additionBoardMap = new BoardMap();
    this.fleet = fleet;
  }

  @Override
  public String getPlayerName() {
    return this.name;
  }

  @Override
  public BoardMap getFleetBoardMap() {
    return this.fleetBoardMap;
  }

  @Override
  public BoardMap getGuessMap() {
    return this.additionBoardMap;
  }

  @Override
  public ArrayList<ShipSubject> getFleet() {
    return this.fleet;
  }

  @Override
  public void setFleet(ArrayList<ShipSubject> fleet) {
    this.fleet = fleet;
  }
  
  @Override
  public Boolean isFleetSunk() {
    for (ShipSubject shipSubject : getFleet()) {
      if (!shipSubject.getShip().isSunk()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public Cell returnAttackResultToOpponent(Posn posn) {
    return getFleetBoardMap().getCell(posn).returnCellWhenAttacked();
  }

  @Override
  public void updateGuessMapBasedOnAttackResultFromOpponent(Posn posn, Cell returnCell) {
    this.additionBoardMap.setCell(posn, returnCell);
  }

  @Override
  public void updateFleetAfterAttack(Posn posn) {
    this.fleetBoardMap.getCell(posn).attackCell();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    GamePlayer gamePlayer = (GamePlayer) obj;
    return Objects.equals(getPlayerName(), gamePlayer.getPlayerName())
        && Objects.equals(getFleetBoardMap(), gamePlayer.getFleetBoardMap())
        && Objects.equals(getGuessMap(), gamePlayer.getGuessMap())
        && Objects.equals(getFleet(), gamePlayer.getFleet());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPlayerName(), getFleetBoardMap(), getGuessMap(), getFleet());
  }

  @Override
  public String toString() {
    return "GamePlayer{" + "name='" + name + '\'' + ", fleetBoardMap=" + fleetBoardMap
        + ", additionBoardMap=" + additionBoardMap + ", fleet=" + fleet + '}';
  }
}
