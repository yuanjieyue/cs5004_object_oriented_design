package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ADequeTest {

  private Integer elem1;
  private Integer elem2;
  private ADeque emptyLIFO;
  private ADeque emptyFIFO;
  private ADeque lifo1;
  private ADeque fifo1;
  private ADeque sameAsRefLIFO1;
  private ADeque sameAsStateLIFO1;
  private ADeque yetAnotherLIFO1;

  @Before
  public void setUp() throws Exception {
    elem1 = 5;
    elem2 = 6;
    emptyLIFO = new EmptyLIFO();
    emptyFIFO = new EmptyFIFO();
    lifo1 = new LIFODeque(elem1, emptyLIFO);
    fifo1 = new FIFODeque(elem2, emptyFIFO);
    sameAsRefLIFO1 = lifo1;
    sameAsStateLIFO1 = new LIFODeque(elem1, emptyLIFO);
    yetAnotherLIFO1 = new LIFODeque(elem1, emptyLIFO);
  }


  @Test
  public void testHashCode() {
    Assert.assertEquals(lifo1.equals(sameAsStateLIFO1), lifo1.hashCode() == sameAsStateLIFO1.hashCode());
    Assert.assertEquals(lifo1.equals(fifo1), lifo1.hashCode() == fifo1.hashCode());
    Assert.assertEquals(emptyFIFO.equals(emptyLIFO), emptyFIFO.hashCode() == emptyLIFO.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(lifo1.equals(lifo1));
    Assert.assertTrue(emptyFIFO.equals(emptyFIFO));
    Assert.assertTrue(lifo1.equals(sameAsRefLIFO1));
    Assert.assertFalse(lifo1.equals(emptyLIFO));
    Assert.assertTrue(lifo1.equals(sameAsStateLIFO1));
    Assert.assertEquals(lifo1.equals(sameAsStateLIFO1) && sameAsStateLIFO1.equals(yetAnotherLIFO1)
        , lifo1.equals(yetAnotherLIFO1));
    Assert.assertFalse(lifo1.equals(fifo1));
  }
}