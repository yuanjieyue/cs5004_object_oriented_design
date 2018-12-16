package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecifiedCellTest {

  private Boolean hit;
  private Boolean sunk;
  private Boolean notSunk;
  private SpecifiedCell cell1;
  private SpecifiedCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    sunk = new Boolean(true);
    notSunk = new Boolean(false);
    cell1 = new SpecifiedCell(hit, sunk);
    cell2 = new SpecifiedCell(hit, notSunk);
  }

  @Test
  public void resultOfAttack() {
    Assert.assertEquals(cell1.attackResult(), new Sunk());
    Assert.assertEquals(cell2.attackResult(), new Hit());
  }

  @Test
  public void testToString() {
    String tempStr = new String("SpecifiedCell{isHit=true, belongToSunk=true}");
    Assert.assertEquals(cell1.toString(), tempStr);
  }
}