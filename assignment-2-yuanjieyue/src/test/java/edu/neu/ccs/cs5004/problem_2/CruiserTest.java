package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {
  private Integer size;
  private Integer numberOfHitCells;
  private Cruiser cruiser;

  @Before
  public void setUp() throws Exception {
    size = new Integer(3);
    numberOfHitCells = new Integer(1);
    cruiser = new Cruiser(size, numberOfHitCells);
  }


  @Test
  public void testToString() {
    String tempStr = new String("Cruiser{size=3, numberOfHitCells=1}");
    Assert.assertEquals(cruiser.toString(), tempStr);
  }
}