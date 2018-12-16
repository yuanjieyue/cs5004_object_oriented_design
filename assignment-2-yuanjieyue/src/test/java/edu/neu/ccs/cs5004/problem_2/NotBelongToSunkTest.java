package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotBelongToSunkTest {
  private NotBelongToSunk NotelongToSunk;
  private NotBelongToSunk sameAsRefNBTS;
  private NotBelongToSunk sameAsStateNBTS;
  private NotBelongToSunk yetAnotherNBTS;
  private NotBelongToSunk nullNBTS;

  @Before
  public void setUp() throws Exception {
    NotelongToSunk = new NotBelongToSunk();
    sameAsRefNBTS = NotelongToSunk;
    sameAsStateNBTS = new NotBelongToSunk();
    yetAnotherNBTS = new NotBelongToSunk();
  }

  @Test
  public void belongToSunk() {
    String tempStr = new String("Not belong to Sunk");
    Assert.assertEquals(NotelongToSunk.belongToSunk(), tempStr);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(NotelongToSunk.equals(sameAsStateNBTS), NotelongToSunk.hashCode() ==
        sameAsStateNBTS.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(NotelongToSunk.equals(sameAsRefNBTS));
    Assert.assertTrue(NotelongToSunk.equals(sameAsStateNBTS));
    Assert.assertFalse(NotelongToSunk.equals(nullNBTS));
    Assert.assertEquals(NotelongToSunk.equals(sameAsStateNBTS) && sameAsRefNBTS.equals
        (yetAnotherNBTS), yetAnotherNBTS.equals(NotelongToSunk));

  }

  @Test
  public void testToString() {
    String tempStr = new String("Not belong to Sunk");
    Assert.assertEquals(NotelongToSunk.toString(), tempStr);
  }
}