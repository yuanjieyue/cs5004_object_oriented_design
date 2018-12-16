package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BelongToSunkTest {

  private BelongToSunk belongToSunk;
  private BelongToSunk sameAsRefBTS;
  private BelongToSunk sameAsStateBTS;
  private BelongToSunk yetAnotherBTS;
  private BelongToSunk nullBTS;

  @Before
  public void setUp() throws Exception {
    belongToSunk = new BelongToSunk();
    sameAsRefBTS = belongToSunk;
    sameAsStateBTS = new BelongToSunk();
    yetAnotherBTS = new BelongToSunk();
  }

  @Test
  public void belongToSunk() {
    String tempStr = new String("Belong to Sunk");
    Assert.assertEquals(belongToSunk.belongToSunk(), tempStr);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(belongToSunk.equals(sameAsStateBTS), belongToSunk.hashCode() ==
        sameAsStateBTS.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(belongToSunk.equals(sameAsRefBTS));
    Assert.assertTrue(belongToSunk.equals(sameAsStateBTS));
    Assert.assertFalse(belongToSunk.equals(nullBTS));
    Assert.assertEquals(belongToSunk.equals(sameAsStateBTS) && sameAsRefBTS.equals
        (yetAnotherBTS), yetAnotherBTS.equals(belongToSunk));

  }

  @Test
  public void testToString() {
    String tempStr = new String("Belong to Sunk");
    Assert.assertEquals(belongToSunk.toString(), tempStr);
  }
}