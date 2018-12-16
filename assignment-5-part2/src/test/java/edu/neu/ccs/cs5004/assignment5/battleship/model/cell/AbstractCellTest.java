package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class AbstractCellTest {
  private Boolean isHit;
  private Boolean notIsHit;

  private Boolean isSunk;
  private Boolean notIsunk;

  private Posn posn1;
  private Posn posn2;
  private Ship ship;
  private List<ShipObserver> shipObservers;
  private ShipSubject shipSubject;

  private AbstractCell cell1;
  private AbstractCell sameAsRefAC;
  private AbstractCell sameAsStateAC;
  private AbstractCell yetAnotherAC;
  private AbstractCell nullAC;
  private AbstractCell cell2;
  private AbstractCell cell3;
  private AbstractCell cell4;
  private AbstractCell cell5;
  private AbstractCell cell6;
  private AbstractCell cell7;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    isSunk = new Boolean(true);
    notIsunk = new Boolean(false);
    posn1 = new Posn(3, 4);
    posn2 = new Posn( 6, 9);
    ship = Ship.createDestroyer();
    shipObservers = new ArrayList<ShipObserver>();
    shipSubject = new ShipSubject(ship, shipObservers);

    cell1 = new OpenSeaCell(isHit, posn1);
    sameAsRefAC = cell1;
    sameAsStateAC = new OpenSeaCell(isHit, posn1);
    yetAnotherAC = new OpenSeaCell(isHit, posn1);
    cell2 = new OpenSeaCell(notIsHit, posn1);
    cell3 = new OpenSeaCell(isHit, posn2);
    cell4 = new GapCell(isHit,posn2);
    cell5 = new GapCell(notIsHit, posn2);
    cell6 = new SpecifiedCell(isHit, posn1, isSunk, shipSubject);
    cell7 = new EnemyCell(isHit, posn2, notIsunk);
  }

  @Test
  public void getIsHit() {
    Assert.assertEquals(cell1.getIsHit(), new Boolean(true));
    Assert.assertEquals(cell2.getIsHit(), new Boolean(false));
  }

  @Test
  public void getPosition() {
    Assert.assertEquals(cell1.getPosition(), new Posn(3, 4));
    Assert.assertEquals(cell6.getPosition(), new Posn(3, 4));
  }

  @Test
  public void setIsHit() {
    cell1.setIsHit(false);
    Assert.assertEquals(cell1.getIsHit(), new Boolean(false));
    cell4.setIsHit(true);
    Assert.assertEquals(cell5.getIsHit(), new Boolean(false));
  }

//  @Test
//  public void testEquals() {
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
    String str = "OpenSeaCell{isHit=true, position=Posn{coordinateX=3, coordinateY=4}}";
    Assert.assertEquals(cell1.toString(), str);
  }
}