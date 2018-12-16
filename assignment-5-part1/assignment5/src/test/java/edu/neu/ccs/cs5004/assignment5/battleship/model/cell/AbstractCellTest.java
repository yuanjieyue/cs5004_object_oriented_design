package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractCellTest {

  private Boolean hit;
  private Boolean notHit;

  private Boolean sunk;
  private Boolean notSunk;

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
  private AbstractCell cell8;
  private AbstractCell cell9;
  private AbstractCell cell10;
  private AbstractCell cell11;
  private AbstractCell cell12;

  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    notHit = new Boolean(false);
    sunk = new Boolean(true);
    notSunk = new Boolean(false);

    cell1 = new OpenSeaCell(hit);
    sameAsRefAC = cell1;
    sameAsStateAC = new OpenSeaCell(hit);
    yetAnotherAC = new OpenSeaCell(hit);
    cell2 = new OpenSeaCell(notHit);
    cell3 = new GapCell(hit);
    cell4 = new GapCell(notHit);
    cell5 = new SpecifiedCell(hit, sunk);
    cell6 = new SpecifiedCell(notHit, notSunk);
    cell7 = new SpecifiedCell(hit, notSunk);
    cell8 = new SpecifiedCell(notHit, sunk);
    cell9 = new EnemyCell(hit, sunk);
    cell10 = new EnemyCell(notHit, notSunk);
    cell11 = new EnemyCell(hit, notSunk);
    cell12 = new EnemyCell(notHit, sunk);
  }

  @Test
  public void getIshit() {
    Assert.assertEquals(cell1.getIsHit(), new Boolean(true));
    Assert.assertEquals(cell2.getIsHit(), new Boolean(false));
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(true));
    Assert.assertEquals(cell3.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell5.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell9.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell10.placeShipOnCell(), new Boolean(false));
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(cell2.attackCell(), new OpenSeaCell(hit));
    Assert.assertEquals(cell4.attackCell(), new GapCell(hit));
    Assert.assertEquals(cell6.attackCell(), new SpecifiedCell(hit, notSunk));
    Assert.assertEquals(cell8.attackCell(), new SpecifiedCell(hit, sunk));
    Assert.assertEquals(cell9.attackCell(), new EnemyCell(hit, sunk));
    Assert.assertEquals(cell11.attackCell(), new EnemyCell(hit, notSunk));
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
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cell1.equals(sameAsStateAC), cell1.hashCode() == sameAsStateAC.hashCode());
    Assert.assertEquals(cell1.equals(cell2)
        , cell1.hashCode() == cell2.hashCode());
  }
}