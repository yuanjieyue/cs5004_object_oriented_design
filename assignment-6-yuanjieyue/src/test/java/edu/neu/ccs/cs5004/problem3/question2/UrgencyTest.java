package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrgencyTest {
  Urgency one = new Urgency(11);
  Urgency two = new Urgency(22);
  Urgency nullUr = new Urgency(null);
  Urgency sameOne = new Urgency(11);

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getValue() throws Exception {
    Assert.assertEquals(new Integer(11), one.getValue());
  }

  @Test
  public void equals() throws Exception {
    Assert.assertEquals(one, one);
    Assert.assertEquals(one, sameOne);
    Assert.assertNotEquals(one, two);
    Assert.assertNotEquals(one, nullUr);
    Assert.assertNotEquals(one, null);
    Assert.assertNotEquals(one, "11");
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    String test = "Urgency{value=11}";
    Assert.assertEquals(test, one.toString());
  }

}