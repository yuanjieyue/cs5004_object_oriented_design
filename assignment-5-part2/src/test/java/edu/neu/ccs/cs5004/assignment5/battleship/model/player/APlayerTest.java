package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Cruiser;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class APlayerTest {
  private String name1;
  private String name2;
  private Map fleetMap1;
  private Map fleetMap2;
  private Map guessMap1;
  private Map guessMap2;

  private Ship ship1;
  private Ship ship2;
  private ShipObserver cell1;
  private ShipObserver cell2;
  private ShipObserver cell3;
  private ShipObserver cell4;
  private List<ShipObserver> observers1;
  private List<ShipObserver> observers2;
  private ShipSubject shipSubject1;
  private ShipSubject shipSubject2;

  private ArrayList<ShipSubject> fleet1;
  private ArrayList<ShipSubject> fleet2;
  private APlayer player1;
  private APlayer player2;
  private APlayer sameAsRefPlayer;
  private APlayer sameAsStatePlayer;
  private APlayer yetAnotherPlayer;
  private APlayer nullPlayer;

  @Before
  public void setUp() throws Exception {
    name1 = "HumanPlayer";
    name2 = "AIPlayer";
    fleetMap1 = Map.createMap();
    fleetMap2 = Map.createMap();
    guessMap1 = Map.createMap();
    guessMap2 = Map.createMap();

    ship1 = new BattleShip(0);
    ship2 = new Cruiser(3);
    cell1 = new SpecifiedCell(false, new Posn(2,1), false, shipSubject1);
    cell2 = new SpecifiedCell(false, new Posn(2,2), false, shipSubject1);
    cell3 = new SpecifiedCell(false, new Posn(2,3), false, shipSubject1);
    cell4 = new SpecifiedCell(false, new Posn(2,4), false, null);

    observers1 = new ArrayList<>();
    observers1.add(cell1);
    observers1.add(cell2);
    observers1.add(cell3);

    observers2 = new ArrayList<>();
    observers2.add(cell1);
    observers2.add(cell2);
    observers2.add(cell3);

    shipSubject1 = new ShipSubject(ship1, observers1);
    shipSubject2 = new ShipSubject(ship2, observers2);

    fleet1 = new ArrayList<ShipSubject>();
    fleet2 = new ArrayList<ShipSubject>();
    fleet1.add(shipSubject1);
    fleet1.add(shipSubject2);
    fleet2.add(shipSubject2);

    player1 = new GamePlayer(name1, fleet1);
    player2 = new GamePlayer(name2, fleet2);
    sameAsRefPlayer = player1;
    sameAsStatePlayer = new GamePlayer(name1, fleet1);
    yetAnotherPlayer = new GamePlayer(name1, fleet1);
  }

  @Test
  public void getPlayerName() {
    Assert.assertEquals(player1.getPlayerName(), new String("HumanPlayer"));
    Assert.assertEquals(player2.getPlayerName(), new String("AIPlayer"));
  }

  @Test
  public void getFleetBoardMap() {
    Assert.assertEquals(player1.getFleetBoardMap(), fleetMap1);
    Assert.assertEquals(player2.getFleetBoardMap(), fleetMap2);
  }

  @Test
  public void getGuessMap() {
    Assert.assertEquals(player1.getGuessMap(), guessMap1);
    Assert.assertEquals(player2.getGuessMap(), guessMap2);
  }

  @Test
  public void getFleet() {
    Assert.assertEquals(player1.getFleet(), fleet1);
    Assert.assertEquals(player2.getFleet(), fleet2);
  }

  @Test
  public void setFleet() {
    player1.setFleet(fleet2);
    Assert.assertEquals(player1.getFleet(), fleet2);

    player2.setFleet(fleet1);
    Assert.assertEquals(player2.getFleet(), fleet1);
  }

  @Test
  public void isFleetSunk() {
    Assert.assertEquals(player1.isFleetSunk(), new Boolean(false));
    Assert.assertEquals(player2.isFleetSunk(), new Boolean(true));
  }

  @Test
  public void returnAttackResultToOpponent() {
    Assert.assertEquals(player1.returnAttackResultToOpponent(new Posn(2, 1))
        , new OpenSeaCell(true, new Posn(2, 1)));
  }

  @Test
  public void updateGuessMapBasedOnAttackResultFromOpponent() {
    player1.updateGuessMapBasedOnAttackResultFromOpponent(new Posn(2, 1)
        , new EnemyCell(false, new Posn(2,1), false));
    Assert.assertEquals(player1.getGuessMap().getCell(new Posn(2, 1)), new EnemyCell(false,
        new Posn(2,1), false));
  }

  @Test
  public void updateFleetAfterAttack() {
    player1.updateFleetAfterAttack(new Posn(2, 1));
    Assert.assertEquals(player1.getFleetBoardMap().getCell(new Posn(2,1))
        , new OpenSeaCell(true, new Posn(2, 1)));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(player1.equals(player1));
    Assert.assertTrue(player1.equals(sameAsRefPlayer));
    Assert.assertTrue(player1.equals(sameAsStatePlayer));
    Assert.assertEquals(player1.equals(sameAsStatePlayer) && (sameAsStatePlayer.equals
        (yetAnotherPlayer)), yetAnotherPlayer.equals(player1));
    Assert.assertFalse(player1.equals(player2));
    Assert.assertFalse(player1.equals(ship1));
    Assert.assertFalse(player1.equals(nullPlayer));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(player1.equals(sameAsStatePlayer), player1.hashCode() ==
        sameAsStatePlayer.hashCode());
    Assert.assertEquals(player1.equals(player2), player1.hashCode() == player2.hashCode());
  }

  @Test
  public void testToString() {
    String str = ("GamePlayer{name='HumanPlayer', fleetBoardMap=BoardMap{row=10, column=10, " +
        "fields:\n" +
        "Posn{x=1, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=1}}\n" +
        "Posn{x=1, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=2}}\n" +
        "Posn{x=1, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=3}}\n" +
        "Posn{x=1, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=4}}\n" +
        "Posn{x=1, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=5}}\n" +
        "Posn{x=1, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=6}}\n" +
        "Posn{x=1, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=7}}\n" +
        "Posn{x=1, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=8}}\n" +
        "Posn{x=1, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=9}}\n" +
        "Posn{x=1, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=10}}\n" +
        "Posn{x=2, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=1}}\n" +
        "Posn{x=2, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=2}}\n" +
        "Posn{x=2, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=3}}\n" +
        "Posn{x=2, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=4}}\n" +
        "Posn{x=2, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=5}}\n" +
        "Posn{x=2, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=6}}\n" +
        "Posn{x=2, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=7}}\n" +
        "Posn{x=2, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=8}}\n" +
        "Posn{x=2, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=9}}\n" +
        "Posn{x=2, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=10}}\n" +
        "Posn{x=3, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=1}}\n" +
        "Posn{x=3, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=2}}\n" +
        "Posn{x=3, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=3}}\n" +
        "Posn{x=3, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=4}}\n" +
        "Posn{x=3, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=5}}\n" +
        "Posn{x=3, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=6}}\n" +
        "Posn{x=3, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=7}}\n" +
        "Posn{x=3, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=8}}\n" +
        "Posn{x=3, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=9}}\n" +
        "Posn{x=3, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=10}}\n" +
        "Posn{x=4, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=1}}\n" +
        "Posn{x=4, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=2}}\n" +
        "Posn{x=4, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=3}}\n" +
        "Posn{x=4, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=4}}\n" +
        "Posn{x=4, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=5}}\n" +
        "Posn{x=4, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=6}}\n" +
        "Posn{x=4, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=7}}\n" +
        "Posn{x=4, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=8}}\n" +
        "Posn{x=4, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=9}}\n" +
        "Posn{x=4, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=10}}\n" +
        "Posn{x=5, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=1}}\n" +
        "Posn{x=5, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=2}}\n" +
        "Posn{x=5, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=3}}\n" +
        "Posn{x=5, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=4}}\n" +
        "Posn{x=5, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=5}}\n" +
        "Posn{x=5, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=6}}\n" +
        "Posn{x=5, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=7}}\n" +
        "Posn{x=5, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=8}}\n" +
        "Posn{x=5, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=9}}\n" +
        "Posn{x=5, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=10}}\n" +
        "Posn{x=6, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=1}}\n" +
        "Posn{x=6, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=2}}\n" +
        "Posn{x=6, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=3}}\n" +
        "Posn{x=6, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=4}}\n" +
        "Posn{x=6, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=5}}\n" +
        "Posn{x=6, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=6}}\n" +
        "Posn{x=6, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=7}}\n" +
        "Posn{x=6, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=8}}\n" +
        "Posn{x=6, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=9}}\n" +
        "Posn{x=6, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=10}}\n" +
        "Posn{x=7, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=1}}\n" +
        "Posn{x=7, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=2}}\n" +
        "Posn{x=7, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=3}}\n" +
        "Posn{x=7, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=4}}\n" +
        "Posn{x=7, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=5}}\n" +
        "Posn{x=7, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=6}}\n" +
        "Posn{x=7, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=7}}\n" +
        "Posn{x=7, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=8}}\n" +
        "Posn{x=7, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=9}}\n" +
        "Posn{x=7, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=10}}\n" +
        "Posn{x=8, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=1}}\n" +
        "Posn{x=8, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=2}}\n" +
        "Posn{x=8, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=3}}\n" +
        "Posn{x=8, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=4}}\n" +
        "Posn{x=8, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=5}}\n" +
        "Posn{x=8, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=6}}\n" +
        "Posn{x=8, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=7}}\n" +
        "Posn{x=8, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=8}}\n" +
        "Posn{x=8, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=9}}\n" +
        "Posn{x=8, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=10}}\n" +
        "Posn{x=9, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=1}}\n" +
        "Posn{x=9, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=2}}\n" +
        "Posn{x=9, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=3}}\n" +
        "Posn{x=9, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=4}}\n" +
        "Posn{x=9, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=5}}\n" +
        "Posn{x=9, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=6}}\n" +
        "Posn{x=9, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=7}}\n" +
        "Posn{x=9, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=8}}\n" +
        "Posn{x=9, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=9}}\n" +
        "Posn{x=9, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=10}}\n" +
        "Posn{x=10, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=1}}\n" +
        "Posn{x=10, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=2}}\n" +
        "Posn{x=10, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=3}}\n" +
        "Posn{x=10, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=4}}\n" +
        "Posn{x=10, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=5}}\n" +
        "Posn{x=10, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=6}}\n" +
        "Posn{x=10, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=7}}\n" +
        "Posn{x=10, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=8}}\n" +
        "Posn{x=10, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=9}}\n" +
        "Posn{x=10, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=10}}\n" +
        "}, additionBoardMap=BoardMap{row=10, column=10, fields:\n" +
        "Posn{x=1, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=1}}\n" +
        "Posn{x=1, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=2}}\n" +
        "Posn{x=1, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=3}}\n" +
        "Posn{x=1, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=4}}\n" +
        "Posn{x=1, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=5}}\n" +
        "Posn{x=1, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=6}}\n" +
        "Posn{x=1, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=7}}\n" +
        "Posn{x=1, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=8}}\n" +
        "Posn{x=1, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=9}}\n" +
        "Posn{x=1, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=1, coordinateY=10}}\n" +
        "Posn{x=2, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=1}}\n" +
        "Posn{x=2, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=2}}\n" +
        "Posn{x=2, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=3}}\n" +
        "Posn{x=2, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=4}}\n" +
        "Posn{x=2, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=5}}\n" +
        "Posn{x=2, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=6}}\n" +
        "Posn{x=2, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=7}}\n" +
        "Posn{x=2, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=8}}\n" +
        "Posn{x=2, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=9}}\n" +
        "Posn{x=2, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=2, coordinateY=10}}\n" +
        "Posn{x=3, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=1}}\n" +
        "Posn{x=3, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=2}}\n" +
        "Posn{x=3, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=3}}\n" +
        "Posn{x=3, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=4}}\n" +
        "Posn{x=3, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=5}}\n" +
        "Posn{x=3, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=6}}\n" +
        "Posn{x=3, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=7}}\n" +
        "Posn{x=3, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=8}}\n" +
        "Posn{x=3, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=9}}\n" +
        "Posn{x=3, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=3, coordinateY=10}}\n" +
        "Posn{x=4, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=1}}\n" +
        "Posn{x=4, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=2}}\n" +
        "Posn{x=4, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=3}}\n" +
        "Posn{x=4, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=4}}\n" +
        "Posn{x=4, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=5}}\n" +
        "Posn{x=4, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=6}}\n" +
        "Posn{x=4, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=7}}\n" +
        "Posn{x=4, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=8}}\n" +
        "Posn{x=4, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=9}}\n" +
        "Posn{x=4, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=4, coordinateY=10}}\n" +
        "Posn{x=5, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=1}}\n" +
        "Posn{x=5, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=2}}\n" +
        "Posn{x=5, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=3}}\n" +
        "Posn{x=5, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=4}}\n" +
        "Posn{x=5, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=5}}\n" +
        "Posn{x=5, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=6}}\n" +
        "Posn{x=5, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=7}}\n" +
        "Posn{x=5, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=8}}\n" +
        "Posn{x=5, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=9}}\n" +
        "Posn{x=5, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=5, coordinateY=10}}\n" +
        "Posn{x=6, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=1}}\n" +
        "Posn{x=6, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=2}}\n" +
        "Posn{x=6, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=3}}\n" +
        "Posn{x=6, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=4}}\n" +
        "Posn{x=6, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=5}}\n" +
        "Posn{x=6, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=6}}\n" +
        "Posn{x=6, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=7}}\n" +
        "Posn{x=6, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=8}}\n" +
        "Posn{x=6, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=9}}\n" +
        "Posn{x=6, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=6, coordinateY=10}}\n" +
        "Posn{x=7, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=1}}\n" +
        "Posn{x=7, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=2}}\n" +
        "Posn{x=7, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=3}}\n" +
        "Posn{x=7, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=4}}\n" +
        "Posn{x=7, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=5}}\n" +
        "Posn{x=7, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=6}}\n" +
        "Posn{x=7, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=7}}\n" +
        "Posn{x=7, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=8}}\n" +
        "Posn{x=7, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=9}}\n" +
        "Posn{x=7, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=7, coordinateY=10}}\n" +
        "Posn{x=8, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=1}}\n" +
        "Posn{x=8, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=2}}\n" +
        "Posn{x=8, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=3}}\n" +
        "Posn{x=8, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=4}}\n" +
        "Posn{x=8, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=5}}\n" +
        "Posn{x=8, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=6}}\n" +
        "Posn{x=8, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=7}}\n" +
        "Posn{x=8, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=8}}\n" +
        "Posn{x=8, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=9}}\n" +
        "Posn{x=8, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=8, coordinateY=10}}\n" +
        "Posn{x=9, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=1}}\n" +
        "Posn{x=9, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=2}}\n" +
        "Posn{x=9, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=3}}\n" +
        "Posn{x=9, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=4}}\n" +
        "Posn{x=9, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=5}}\n" +
        "Posn{x=9, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=6}}\n" +
        "Posn{x=9, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=7}}\n" +
        "Posn{x=9, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=8}}\n" +
        "Posn{x=9, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=9}}\n" +
        "Posn{x=9, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=9, coordinateY=10}}\n" +
        "Posn{x=10, y=1} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=1}}\n" +
        "Posn{x=10, y=2} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=2}}\n" +
        "Posn{x=10, y=3} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=3}}\n" +
        "Posn{x=10, y=4} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=4}}\n" +
        "Posn{x=10, y=5} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=5}}\n" +
        "Posn{x=10, y=6} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=6}}\n" +
        "Posn{x=10, y=7} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=7}}\n" +
        "Posn{x=10, y=8} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=8}}\n" +
        "Posn{x=10, y=9} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=9}}\n" +
        "Posn{x=10, y=10} -> OpenSeaCell{isHit=false, position=Posn{coordinateX=10, coordinateY=10}}\n" +
        "}, fleet=[ShipSubject{ship=BattleShip{size=4, numberOfHitCells=0}, observers=[SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=1}, belongToSunk=false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=2}, belongToSunk=false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=3}, belongToSunk=false}]}, ShipSubject{ship=Cruiser{size=3, numberOfHitCells=3}, observers=[SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=1}, belongToSunk=false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=2}, belongToSunk=false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=3}, belongToSunk=false}]}]}");
    Assert.assertEquals(player1.toString(), str);
  }
}