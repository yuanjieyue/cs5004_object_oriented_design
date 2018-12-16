package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenSeaCellTest {
  private Boolean hit;
  private Boolean notHit;
  private OpenSeaCell cell1;
  private OpenSeaCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    notHit = new Boolean(false);
    cell1 = new OpenSeaCell(hit);
    cell2 = new OpenSeaCell(notHit);
  }

  @Test
  public void isPlacable() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(true));
    Assert.assertEquals(cell2.placeShipOnCell(), new Boolean(true));
  }

  @Test
  public void testToString() {
    String tempStr = new String("OpenSeaCell{isHit=true}");
    Assert.assertEquals(cell1.toString(), tempStr);
  }
}