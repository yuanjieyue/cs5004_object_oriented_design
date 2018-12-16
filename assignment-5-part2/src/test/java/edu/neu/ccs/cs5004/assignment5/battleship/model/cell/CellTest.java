package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.UnsupportedOperationException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class CellTest {

  private Boolean isHit;
  private Boolean notIsHit;

  private Boolean isSunk;
  private Boolean notIsSunk;

  private Posn posn1;
  private Posn posn2;
  private Ship ship1;
  private Ship ship2;
  private List<ShipObserver> shipObservers1;
  private List<ShipObserver> shipObservers2;
  private ShipSubject shipSubject1;
  private ShipSubject shipSubject2;

  private Cell cell1;
  private Cell cell2;
  private Cell cell3;
  private Cell cell4;
  private Cell cell5;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    posn1 = new Posn(3, 4);
    posn2 = new Posn( 6, 9);
    cell1 = new OpenSeaCell(isHit, posn1);
    cell2 = new GapCell(notIsHit, posn1);
    cell3 = new EnemyCell(isHit, posn1, isSunk);

    ship1 = new Destroyer(0);
    shipObservers1 = new ArrayList<ShipObserver>();
    shipObservers1.add(cell4);
    shipSubject1 = new ShipSubject(ship1, shipObservers1);

    ship2 = new Destroyer(1);
    shipObservers2 = new ArrayList<ShipObserver>();
    shipObservers2.add(cell5);
    shipSubject2 = new ShipSubject(ship2, shipObservers2);

    cell4 = new SpecifiedCell(isHit, posn1, notIsSunk, shipSubject1);
    cell5 = new SpecifiedCell(isHit, posn1, isSunk, shipSubject2);
  }

  @Test
  public void createOpenSeaCell() {
    Cell cell = Cell.createOpenSeaCell(isHit, posn1);
    Assert.assertEquals(cell, cell1);
  }

  @Test
  public void createGapCell() {
    Cell cell = Cell.createGapCell(notIsHit, posn1);
    Assert.assertEquals(cell, cell2);
  }

  @Test
  public void getIsHit() {
    Assert.assertEquals(cell1.getIsHit(), new Boolean(true));
    Assert.assertEquals(cell2.getIsHit(), new Boolean(false));
  }

  @Test
  public void getPosition() {
    Assert.assertEquals(cell1.getPosition(), new Posn(3, 4));
    Assert.assertEquals(cell5.getPosition(), new Posn(3, 4));
  }

  @Test
  public void setIsHit() {
    cell1.setIsHit(false);
    Assert.assertEquals(cell1.getIsHit(), new Boolean(false));
    cell4.setIsHit(true);
    Assert.assertEquals(cell4.getIsHit(), new Boolean(true));
  }


  @Test
  public void attackCell() {
    cell1.attackCell();
    Assert.assertEquals(cell1, Cell.createOpenSeaCell(true,cell1.getPosition()));
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(true));
    Assert.assertEquals(cell2.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell3.placeShipOnCell(), new Boolean(false));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void attackResult() {
    Assert.assertEquals(cell1.attackResult(), AttackResult.MISS);
    Assert.assertEquals(cell2.attackResult(), AttackResult.MISS);
    Assert.assertEquals(cell3.attackResult(), AttackResult.MISS);
    Assert.assertEquals(cell4.attackResult(), AttackResult.HIT);
    Assert.assertEquals(cell5.attackResult(), AttackResult.SUNK);

  }

  @Test (expected = UnsupportedOperationException.class)
  public void returnCellWhenAttacked() {
    Assert.assertEquals(cell1.returnCellWhenAttacked(), new OpenSeaCell(isHit, posn1));
    Assert.assertEquals(cell2.returnCellWhenAttacked(), new OpenSeaCell(isHit, posn1));
    Assert.assertEquals(cell3.returnCellWhenAttacked(), new EnemyCell(notIsHit, posn1, isSunk));
    Assert.assertEquals(cell4.returnCellWhenAttacked(), new EnemyCell(notIsHit, posn1, isSunk));
    Assert.assertEquals(cell5.returnCellWhenAttacked(), new EnemyCell(isHit, posn1, isSunk));

  }

  @Test
  public void prettyPrint() {
    ConsolePrinter printer = new ConsolePrinter();
    cell1.prettyPrint(printer);
    cell2.prettyPrint(printer);
  }

}