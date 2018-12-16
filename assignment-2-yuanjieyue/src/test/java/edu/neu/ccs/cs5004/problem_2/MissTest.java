package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissTest {

  private Miss miss;
  private Miss sameAsRefMiss;
  private Miss sameAsStateMiss;
  private Miss yetAnotherMiss;
  private AttackResult sunk;
  private Miss nullMiss;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    sameAsRefMiss = miss;
    sameAsStateMiss = new Miss();
    yetAnotherMiss = new Miss();
    sunk = new Sunk();
  }

  @Test
  public void result() {
    String tempStr = new String("Missed the ship!");
    Assert.assertEquals(miss.result(), tempStr);
  }

  @Test
  public void equals() {
    Assert.assertTrue(miss.equals(miss));
    Assert.assertTrue(miss.equals(sameAsRefMiss));
    Assert.assertFalse(miss.equals(sunk));
    Assert.assertFalse(miss.equals(nullMiss));
    Assert.assertEquals(miss.equals(sameAsStateMiss) && sameAsStateMiss.equals(yetAnotherMiss), miss
        .equals(sameAsStateMiss));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(miss.equals(sameAsStateMiss), miss.hashCode() == sameAsStateMiss.hashCode());
    Assert.assertEquals(miss.equals(sunk), miss.hashCode() == sunk.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("Missed the ship!");
    Assert.assertEquals(miss.toString(), tempStr);
  }
}