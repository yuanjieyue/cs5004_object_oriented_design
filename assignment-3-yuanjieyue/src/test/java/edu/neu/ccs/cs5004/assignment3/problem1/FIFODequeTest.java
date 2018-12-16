package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FIFODequeTest {
  private Integer element1;
  private Integer element2;
  private EmptyFIFO emptyFIFO;
  private FIFODeque fifoDeque1;
  private FIFODeque fifoDeque2;
  private FIFODeque sameRefFIFODeque;
  private FIFODeque sameAsStateFIFODeque;
  private FIFODeque yetanotherFIFODeque;
  private FIFODeque nullFIFODeque;

  @Before
  public void setUp() throws Exception {
    element1 = 5;
    element2 = 6;
    emptyFIFO = new EmptyFIFO();
    fifoDeque1 = new FIFODeque(element1, emptyFIFO);
    fifoDeque2 = new FIFODeque(element2, fifoDeque1);
    sameRefFIFODeque = fifoDeque1;
    sameAsStateFIFODeque = new FIFODeque(element1, emptyFIFO);
    yetanotherFIFODeque = new FIFODeque(element1, emptyFIFO);
  }

  @Test
  public void getItem() {
    Assert.assertEquals(fifoDeque1.getItem(), new Integer(5));
    Assert.assertEquals(fifoDeque2.getItem(), new Integer(6));
  }

  @Test
  public void getRest() {
    Assert.assertEquals(fifoDeque1.getRest(), new EmptyFIFO());
    Assert.assertEquals(fifoDeque2.getRest(), new FIFODeque(5, new EmptyFIFO()));
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(fifoDeque1.isEmpty(), new Boolean(false));
    Assert.assertEquals(fifoDeque2.isEmpty(), new Boolean(false));
  }

  @Test
  public void size() {
    Assert.assertEquals(fifoDeque1.size(), new Integer(1));
    Assert.assertEquals(fifoDeque2.size(), new Integer(2));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFirst() {
    Assert.assertEquals(fifoDeque1.addFirst(element2), fifoDeque2);
  }

  @Test
  public void addLast() {
    Assert.assertEquals(fifoDeque1.addLast(element2), new FIFODeque(element1, new FIFODeque
        (element2, new EmptyFIFO())));
  }

  @Test
  public void removeFirst() {
    Assert.assertEquals(fifoDeque1.removeFirst(), emptyFIFO);
    Assert.assertEquals(fifoDeque2.removeFirst(), fifoDeque1);
  }

  @Test
  public void peek() {
    Assert.assertEquals(fifoDeque1.peek(), new Integer(5));
    Assert.assertEquals(fifoDeque2.peek(), new Integer(6));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(fifoDeque1.equals(fifoDeque1));
    Assert.assertTrue(fifoDeque1.equals(sameRefFIFODeque));
    Assert.assertTrue(fifoDeque1.equals(sameAsStateFIFODeque));
    Assert.assertFalse(fifoDeque1.equals(nullFIFODeque));
    Assert.assertFalse(fifoDeque2.equals(nullFIFODeque));
    Assert.assertFalse(fifoDeque1.equals(fifoDeque2));
    Assert.assertEquals(fifoDeque1.equals(sameAsStateFIFODeque) && sameAsStateFIFODeque.equals
        (yetanotherFIFODeque), fifoDeque1.equals(yetanotherFIFODeque));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(fifoDeque1.equals(sameAsStateFIFODeque), fifoDeque1.hashCode() ==
        sameAsStateFIFODeque.hashCode());
    Assert.assertEquals(fifoDeque1.equals(fifoDeque2), fifoDeque1.hashCode() ==
        fifoDeque2.hashCode());
  }

  @Test
  public void testToString() {
    //"FIFODeque{" + "item=" + item + ", rest=" + rest + '}';
    String tempStr1 = new String("FIFODeque{item=5, rest=EmptyFIFO{}}");
    String tempStr2 = new String("FIFODeque{item=6, rest=FIFODeque{item=5, rest=EmptyFIFO{}}}");
    String tempStr3 = new String("FIFODeque{item=5, rest=FIFODeque{item=6, rest=EmptyFIFO{}}}");
    Assert.assertEquals(fifoDeque1.toString(), tempStr1);
    Assert.assertEquals(fifoDeque2.toString(), tempStr2);
    Assert.assertEquals(fifoDeque1.addLast(element2).toString(), tempStr3);
  }
}