package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractWaterCellTest {

  private Hitable hit;
  private Hitable notHit;
  private AbstractWaterCell cell1;
  private AbstractWaterCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new BeingHit();
    notHit = new NotBeingHit();
    cell1 = new OpenSeaCell(hit);
    cell2 = new OpenSeaCell(notHit);
  }

  @Test
  public void resultOfAttack() {
    Assert.assertEquals(cell1.resultOfAttack(), new Miss());
    Assert.assertEquals(cell2.resultOfAttack(), new Miss());
  }

}