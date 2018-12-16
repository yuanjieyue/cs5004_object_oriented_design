package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HitTest {

  private Hit hit;
  private Hit sameAsRefHit;
  private Hit sameAsStateHit;
  private Hit yetAnotherHit;
  private AttackResult miss;
  private Hit nullHit;

  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    sameAsRefHit = hit;
    sameAsStateHit = new Hit();
    yetAnotherHit = new Hit();
    miss = new Miss();
  }

  @Test
  public void result() {
    String tempStr = new String("Hit the ship!");
    Assert.assertEquals(hit.result(), tempStr);
  }

  @Test
  public void equals() {
    Assert.assertTrue(hit.equals(hit));
    Assert.assertTrue(hit.equals(sameAsRefHit));
    Assert.assertFalse(hit.equals(miss));
    Assert.assertFalse(hit.equals(nullHit));
    Assert.assertEquals(hit.equals(sameAsStateHit) && sameAsStateHit.equals(yetAnotherHit), hit
        .equals(sameAsStateHit));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(hit.equals(sameAsStateHit), hit.hashCode() == sameAsStateHit.hashCode());
    Assert.assertEquals(hit.equals(miss), hit.hashCode() == miss.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("Hit the ship!");
    Assert.assertEquals(hit.toString(), tempStr);
  }
}