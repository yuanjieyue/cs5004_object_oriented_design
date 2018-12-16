package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {

  private Boolean hit;
  private Boolean notHit;
  private AbstractWaterCell cell1;
  private AbstractWaterCell cell2;
  private AbstractWaterCell sameRefAWCell;
  private AbstractWaterCell sameStateAWCell;
  private AbstractWaterCell yetAnotherAWCell;
  private AbstractWaterCell nullAWCell;


  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    notHit = new Boolean(false);
    cell1 = new OpenSeaCell(hit);
    cell2 = new OpenSeaCell(notHit);
    sameRefAWCell = cell1;
    sameStateAWCell = new OpenSeaCell(hit);
    yetAnotherAWCell = new OpenSeaCell(hit);
  }

  @Test
  public void resultOfAttack() {
    Assert.assertEquals(cell1.attackResult(), new Miss());
    Assert.assertEquals(cell2.attackResult(), new Miss());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cell1.equals(cell1));
    Assert.assertTrue(cell1.equals(sameStateAWCell));
    Assert.assertTrue(cell1.equals(sameRefAWCell));
    Assert.assertEquals(cell1.equals(sameStateAWCell) && sameStateAWCell.equals
        (yetAnotherAWCell), yetAnotherAWCell.equals(cell1));
    Assert.assertFalse(cell1.equals(cell2));
    Assert.assertFalse(cell1.equals(nullAWCell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cell1.equals(sameStateAWCell), cell1.hashCode() == sameStateAWCell
        .hashCode());
    Assert.assertEquals(cell1.equals(cell2), cell1.hashCode() == cell2.hashCode());
  }
}