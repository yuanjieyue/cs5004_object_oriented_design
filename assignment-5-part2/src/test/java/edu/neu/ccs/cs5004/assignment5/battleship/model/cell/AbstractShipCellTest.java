package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class AbstractShipCellTest {

  private Boolean isHit;
  private Boolean notIsHit;

  private Boolean isSunk;
  private Boolean notIsSunk;

  private Posn posn1;
  private Posn posn2;
  private Ship ship1;
  private List<ShipObserver> shipObservers1;
  private ShipSubject shipSubject1;
  private Ship ship2;
  private List<ShipObserver> shipObservers2;
  private ShipSubject shipSubject2;

  private AbstractShipCell cell1;
  private AbstractShipCell sameAsRefAC;
  private AbstractShipCell sameAsStateAC;
  private AbstractShipCell yetAnotherAC;
  private AbstractShipCell nullAC;
  private AbstractShipCell cell2;
  private AbstractShipCell cell3;
  private AbstractShipCell cell4;
  private AbstractShipCell cell5;
  private AbstractShipCell cell6;
  private AbstractWaterCell cell7;
  private AbstractShipCell cell8;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    isSunk = new Boolean(true);
    notIsSunk = new Boolean(false);
    posn1 = new Posn(2, 5);
    posn2 = new Posn( 1, 3);
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
    cell2 = new SpecifiedCell(notIsHit, posn1, isSunk, shipSubject1);
    cell3 = new SpecifiedCell(isHit, posn2, isSunk, shipSubject1);
    cell4 = new SpecifiedCell(isHit, posn1, notIsSunk, shipSubject1);
    cell5 = new SpecifiedCell(isHit, posn1, isSunk, shipSubject2);
    cell6 = new EnemyCell(isHit, posn2, isSunk);
    cell7 = new OpenSeaCell(notIsHit, posn2);
    cell8 = new SpecifiedCell(isHit, (Posn) null, isSunk, shipSubject1);
  }

  @Test
  public void getIsSunk() {
    Assert.assertEquals(cell1.isSunk(), new Boolean(true));
    Assert.assertEquals(cell3.isSunk(), new Boolean(true));
    Assert.assertEquals(cell4.isSunk(), new Boolean(false));
  }

  @Test
  public void isSunk() {
    Assert.assertEquals(cell1.isSunk(), new Boolean(true));
    Assert.assertEquals(cell3.isSunk(), new Boolean(true));
    Assert.assertEquals(cell4.isSunk(), new Boolean(false));
  }

  @Test
  public void setSunk() {
    cell1.setSunk(false);
    Assert.assertEquals(cell1.isSunk(), new Boolean(false));
    cell3.setSunk(true);
    Assert.assertEquals(cell3.isSunk(), new Boolean(true));

  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell3.placeShipOnCell(), new Boolean(false));
  }

//  @Test
//  public void testEquals() {
//    Assert.assertEquals(cell1, cell1);
//    Assert.assertEquals(cell1, sameAsRefAC);
//    Assert.assertEquals(cell1, sameAsStateAC);
//    Assert.assertEquals(cell1, yetAnotherAC);
//    Assert.assertNotEquals(cell1, nullAC);
//    Assert.assertNotEquals(cell1, cell2);
//    Assert.assertNotEquals(cell1, cell3);
//    Assert.assertNotEquals(cell1, cell4);
//    Assert.assertNotEquals(cell1, cell5);
//    Assert.assertNotEquals(cell1, cell6);
//    Assert.assertNotEquals(cell1, cell7);
//    Assert.assertNotEquals(cell1, cell8);
//  }
//
//  @Test
//  public void testHashCode() {
//    Assert.assertEquals(cell1.equals(sameAsStateAC), cell1.hashCode() == sameAsStateAC.hashCode());
//    Assert.assertEquals(cell1.equals(cell2)
//        , cell1.hashCode() == cell2.hashCode());
//  }

  @Test
  public void testToString() {
    String str = "SpecifiedCell{isHit=true, position=Posn{coordinateX=2, "
        + "coordinateY=5}, belongToSunk=true}";
    Assert.assertEquals(cell1.toString(), str);
  }
}