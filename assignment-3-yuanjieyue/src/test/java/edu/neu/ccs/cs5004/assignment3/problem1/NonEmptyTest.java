package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonEmptyTest {

  private Integer element1;
  private Integer element2;
  private EmptyFIFO emptyFIFO;
  private FIFODeque fifoDeque1;
  private EmptyLIFO emptyLIFO;
  private LIFODeque lifoDeque1;
  private FIFODeque sameRefFIFODeque;
  private FIFODeque sameAsStateFIFODeque;
  private FIFODeque yetanotherFIFODeque;
  private FIFODeque nullFIFODeque;


  @Before
  public void setUp() throws Exception {
    element1 = 9;
    element2 = 10;
    emptyFIFO = new EmptyFIFO();
    emptyLIFO = new EmptyLIFO();
    fifoDeque1 = new FIFODeque(element1, emptyFIFO);
    lifoDeque1 = new LIFODeque(element2, emptyLIFO);
    sameRefFIFODeque = fifoDeque1;
    sameAsStateFIFODeque = new FIFODeque(element1, emptyFIFO);
    yetanotherFIFODeque = new FIFODeque(element1, emptyFIFO);
  }

  @Test
  public void getItem() {
    Assert.assertEquals(fifoDeque1.getItem(), new Integer(9));
    Assert.assertEquals(lifoDeque1.getItem(), new Integer(10));
  }

  @Test
  public void getRest() {
    Assert.assertEquals(fifoDeque1.getRest(), new EmptyFIFO());
    Assert.assertEquals(lifoDeque1.getRest(), new EmptyLIFO());
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(fifoDeque1.isEmpty(), new Boolean(false));
    Assert.assertEquals(lifoDeque1.isEmpty(), new Boolean(false));
  }

  @Test
  public void size() {
    Assert.assertEquals(fifoDeque1.size(), new Integer(1));
    Assert.assertEquals(lifoDeque1.size(), new Integer(1));
  }

  @Test
  public void removeFirst() {
    Assert.assertEquals(fifoDeque1.removeFirst(), emptyFIFO);
    Assert.assertEquals(lifoDeque1.removeFirst(), emptyLIFO);
  }

  @Test
  public void peek() {
    Assert.assertEquals(fifoDeque1.peek(), new Integer(9));
    Assert.assertEquals(lifoDeque1.peek(), new Integer(10));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(fifoDeque1.equals(fifoDeque1));
    Assert.assertTrue(fifoDeque1.equals(sameRefFIFODeque));
    Assert.assertTrue(fifoDeque1.equals(sameAsStateFIFODeque));
    Assert.assertFalse(fifoDeque1.equals(lifoDeque1));
    Assert.assertEquals(fifoDeque1.equals(sameAsStateFIFODeque) && sameAsStateFIFODeque.equals
        (yetanotherFIFODeque), fifoDeque1.equals(yetanotherFIFODeque));
    Assert.assertFalse(fifoDeque1.equals(nullFIFODeque));
    Assert.assertNull(nullFIFODeque);
    Assert.assertFalse(emptyFIFO.equals(emptyLIFO));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(fifoDeque1.equals(sameAsStateFIFODeque), fifoDeque1.hashCode() ==
        sameAsStateFIFODeque.hashCode());
    Assert.assertEquals(fifoDeque1.equals(lifoDeque1), fifoDeque1.hashCode() ==
        lifoDeque1.hashCode());
  }
}