package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GapCellTest {

  private Hitable hit;
  private Hitable notHit;
  private GapCell cell1;
  private GapCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new BeingHit();
    notHit = new NotBeingHit();
    cell1 = new GapCell(hit);
    cell2 = new GapCell(notHit);
  }

  @Test
  public void isPlacable() {
    Assert.assertEquals(cell1.isPlacable(), new Boolean(false));
    Assert.assertEquals(cell2.isPlacable(), new Boolean(false));
  }

  @Test
  public void testToString() {
    String tempStr = new String("GapCell{isHit=Not being hit}");
    Assert.assertEquals(cell2.toString(), tempStr);
  }
}