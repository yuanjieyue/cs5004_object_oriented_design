package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyTest {

  private Empty emptyLIFO;
  private Empty emptyFIFO;

  @Before
  public void setUp() throws Exception {
    emptyLIFO = new EmptyLIFO();
    emptyFIFO = new EmptyFIFO();
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(emptyLIFO.isEmpty(), new Boolean(true));
    Assert.assertEquals(emptyFIFO.isEmpty(), new Boolean(true));
  }

  @Test
  public void size() {
    Assert.assertEquals(emptyLIFO.size(), new Integer(0));
    Assert.assertEquals(emptyFIFO.size(), new Integer(0));
  }

  @Test(expected = IllegalOperationException.class)
  public void removeFirst() {
    Assert.assertEquals(emptyLIFO.removeFirst(), emptyFIFO);
    Assert.assertEquals(emptyFIFO.removeFirst(), emptyLIFO);
  }

  @Test(expected = java.lang.Error.class)
  public void peek() {
    Assert.assertEquals(emptyLIFO.peek(), new Integer(5));
    Assert.assertEquals(emptyFIFO.peek(), new Integer(5));
  }
}