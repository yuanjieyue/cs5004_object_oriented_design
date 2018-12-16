package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GapCellTest {

  private Boolean hit;
  private Boolean notHit;
  private GapCell cell1;
  private GapCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    notHit = new Boolean(false);
    cell1 = new GapCell(hit);
    cell2 = new GapCell(notHit);
  }

  @Test
  public void isPlacable() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell2.placeShipOnCell(), new Boolean(false));
  }

  @Test
  public void testToString() {
    String tempStr = new String("GapCell{isHit=false}");
    Assert.assertEquals(cell2.toString(), tempStr);
  }
}