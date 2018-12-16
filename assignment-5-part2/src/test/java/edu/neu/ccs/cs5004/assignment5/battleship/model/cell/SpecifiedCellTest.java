package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class SpecifiedCellTest {

  private Boolean isHit;
  private Boolean notIsHit;

  private Boolean isSunk;
  private Boolean notIsSunk;

  private Posn posn1;
  private Ship ship1;
  private List<ShipObserver> shipObservers1;
  private ShipSubject shipSubject1;
  private Ship ship2;
  private List<ShipObserver> shipObservers2;
  private ShipSubject shipSubject2;

  private SpecifiedCell cell1;
  private SpecifiedCell sameAsRefAC;
  private SpecifiedCell sameAsStateAC;
  private SpecifiedCell yetAnotherAC;
  private SpecifiedCell nullAC;
  private SpecifiedCell cell2;
  private SpecifiedCell cell3;
  private EnemyCell cell4;
  private OpenSeaCell cell5;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    isSunk = new Boolean(true);
    notIsSunk = new Boolean(false);
    posn1 = new Posn(2, 5);
    ship1 = new Destroyer(0);
    ship2 = new Destroyer(1);
    shipObservers1 = new ArrayList<ShipObserver>();
    shipObservers1.add(cell1);
    shipObservers2 = new ArrayList<ShipObserver>();
    shipObservers2.add(cell2);
    shipSubject1 = new ShipSubject(ship1, shipObservers1);
    shipSubject2 = new ShipSubject(ship2, shipObservers2);

    cell1 = new SpecifiedCell(isHit, posn1, isSunk, shipSubject1);
    sameAsRefAC = cell1;
    sameAsStateAC = new SpecifiedCell(isHit, posn1, isSunk, shipSubject1);
    yetAnotherAC = new SpecifiedCell(isHit, posn1, isSunk, shipSubject1);
    cell2 = new SpecifiedCell(isHit, posn1, isSunk, shipSubject2);
    cell3 = new SpecifiedCell(notIsHit, posn1, notIsSunk, shipSubject2);
    cell4 = new EnemyCell(isHit, posn1, isSunk);
    cell5 = new OpenSeaCell(notIsHit, posn1);
  }

  @Test
  public void getShipSubject() {
    Assert.assertEquals(cell1.getShipSubject(), new ShipSubject(ship1, shipObservers1));
    Assert.assertEquals(cell2.getShipSubject(), new ShipSubject(ship2, shipObservers2));
  }

  @Test
  public void markShipCellSunk() {
    cell1.markShipCellSunk();
    Assert.assertEquals(cell1.isSunk(), new Boolean(true));
    cell3.markShipCellSunk();
    Assert.assertEquals(cell3.isSunk(), new Boolean(true));
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(cell1.getIsHit(), new Boolean(true));
    Assert.assertEquals(cell3.getIsHit(), new Boolean(false));
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(cell1.attackResult(), AttackResult.HIT);
    Assert.assertEquals(cell2.attackResult(), AttackResult.SUNK);
    Assert.assertEquals(cell1.attackResult(), AttackResult.HIT);
  }

  @Test
  public void returnCellWhenAttacked() {
    Assert.assertEquals(cell1.returnCellWhenAttacked(), new EnemyCell(isHit, posn1, isSunk));
    Assert.assertEquals(cell3.returnCellWhenAttacked(), new EnemyCell(isHit, posn1, isSunk));
  }

  @Test
  public void update() {
    cell3.update(ship2);
    Assert.assertEquals(cell3.isSunk(), new Boolean(true));
  }

  @Test
  public void prettyPrint() {
    ConsolePrinter printer = new ConsolePrinter();
    cell1.prettyPrint(printer);
    cell3.prettyPrint(printer);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cell1.equals(cell1));
    Assert.assertTrue(cell1.equals(sameAsRefAC));
    Assert.assertTrue(cell1.equals(sameAsStateAC));
    Assert.assertEquals(cell1.equals(sameAsStateAC) && sameAsStateAC.equals(yetAnotherAC),
        cell1.equals(yetAnotherAC));
    Assert.assertFalse(cell1.equals(nullAC));
    Assert.assertFalse(cell1.equals(cell2));
    Assert.assertFalse(cell1.equals(cell3));
    Assert.assertFalse(cell1.equals(cell4));
    Assert.assertFalse(cell1.equals(cell5));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cell1.equals(sameAsStateAC), cell1.hashCode() == sameAsStateAC.hashCode());
    Assert.assertEquals(cell1.equals(cell2)
        , cell1.hashCode() == cell2.hashCode());
  }
}