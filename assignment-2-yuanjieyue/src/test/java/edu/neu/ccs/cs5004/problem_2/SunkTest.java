package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SunkTest {
  private Sunk sunk;
  private Sunk sameAsRefSunk;
  private Sunk sameAsStateSunk;
  private Sunk yetAnotherSunk;
  private AttackResult miss;
  private Sunk nullSunk;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    sameAsRefSunk = sunk;
    sameAsStateSunk = new Sunk();
    yetAnotherSunk = new Sunk();
    miss = new Miss();
  }

  @Test
  public void result() {
    String tempStr = new String("The ship is sunk!");
    Assert.assertEquals(sunk.result(), tempStr);
  }

  @Test
  public void equals() {
    Assert.assertTrue(sunk.equals(sunk));
    Assert.assertTrue(sunk.equals(sameAsRefSunk));
    Assert.assertFalse(sunk.equals(miss));
    Assert.assertFalse(sunk.equals(nullSunk));
    Assert.assertEquals(sunk.equals(sameAsStateSunk) && sameAsStateSunk.equals(yetAnotherSunk), sunk
        .equals(sameAsStateSunk));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(sunk.equals(sameAsStateSunk), sunk.hashCode() == sameAsStateSunk.hashCode());
    Assert.assertEquals(sunk.equals(miss), sunk.hashCode() == miss.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("The ship is sunk!");
    Assert.assertEquals(sunk.toString(), tempStr);
  }
}