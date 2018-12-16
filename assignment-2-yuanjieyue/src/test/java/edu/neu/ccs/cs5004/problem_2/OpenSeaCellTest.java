package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenSeaCellTest {
  private Hitable hit;
  private Hitable notHit;
  private OpenSeaCell cell1;
  private OpenSeaCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new BeingHit();
    notHit = new NotBeingHit();
    cell1 = new OpenSeaCell(hit);
    cell2 = new OpenSeaCell(notHit);
  }

  @Test
  public void isPlacable() {
    Assert.assertEquals(cell1.isPlacable(), new Boolean(true));
    Assert.assertEquals(cell2.isPlacable(), new Boolean(true));
  }

  @Test
  public void testToString() {
    String tempStr = new String("OpenSeaCell{isHit=Being hit}");
    Assert.assertEquals(cell1.toString(), tempStr);
  }
}