package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LIFODequeTest {
  private Integer element1;
  private Integer element2;
  private EmptyLIFO emptyLIFO;
  private LIFODeque lifoDeque1;
  private LIFODeque lifoDeque2;
  private LIFODeque sameRefLIFODeque;
  private LIFODeque sameAsStateLIFODeque;
  private LIFODeque yetanotherLIFODeque;
  private LIFODeque nullLIFODeque;

  @Before
  public void setUp() throws Exception {
    element1 = 7;
    element2 = 8;
    emptyLIFO = new EmptyLIFO();
    lifoDeque1 = new LIFODeque(element1, emptyLIFO);
    lifoDeque2 = new LIFODeque(element2, lifoDeque1);
    sameRefLIFODeque = lifoDeque1;
    sameAsStateLIFODeque = new LIFODeque(element1, emptyLIFO);
    yetanotherLIFODeque = new LIFODeque(element1, emptyLIFO);
  }

  @Test
  public void getItem() {
    Assert.assertEquals(lifoDeque1.getItem(), new Integer(7));
    Assert.assertEquals(lifoDeque2.getItem(), new Integer(8));
  }

  @Test
  public void getRest() {
    Assert.assertEquals(lifoDeque1.getRest(), new EmptyLIFO());
    Assert.assertEquals(lifoDeque2.getRest(), new LIFODeque(7, new EmptyLIFO()));
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(lifoDeque1.isEmpty(), new Boolean(false));
    Assert.assertEquals(lifoDeque2.isEmpty(), new Boolean(false));
  }

  @Test
  public void size() {
    Assert.assertEquals(lifoDeque1.size(), new Integer(1));
    Assert.assertEquals(lifoDeque2.size(), new Integer(2));
  }

  @Test
  public void addFirst() {
    Assert.assertEquals(lifoDeque1.addFirst(element2), lifoDeque2);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addLast() {
    Assert.assertEquals(lifoDeque1.addLast(element2), lifoDeque2);
  }

  @Test
  public void removeFirst() {
    Assert.assertEquals(lifoDeque1.removeFirst(), emptyLIFO);
    Assert.assertEquals(lifoDeque2.removeFirst(), lifoDeque1);
  }

  @Test
  public void peek() {
    Assert.assertEquals(lifoDeque1.peek(), new Integer(7));
    Assert.assertEquals(lifoDeque2.peek(), new Integer(8));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(lifoDeque1.equals(lifoDeque1));
    Assert.assertTrue(lifoDeque1.equals(sameRefLIFODeque));
    Assert.assertTrue(lifoDeque1.equals(sameAsStateLIFODeque));
    Assert.assertFalse(lifoDeque1.equals(lifoDeque2));
    Assert.assertEquals(lifoDeque1.equals(sameAsStateLIFODeque) && sameAsStateLIFODeque.equals
        (yetanotherLIFODeque), lifoDeque1.equals(yetanotherLIFODeque));
    Assert.assertFalse(lifoDeque1.equals(nullLIFODeque));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(lifoDeque1.equals(sameAsStateLIFODeque), lifoDeque1.hashCode() ==
        sameAsStateLIFODeque.hashCode());
    Assert.assertEquals(lifoDeque1.equals(lifoDeque2), lifoDeque1.hashCode() ==
        lifoDeque2.hashCode());
  }

  @Test
  public void testToString() {
    //"FIFODeque{" + "item=" + item + ", rest=" + rest + '}';
    String tempStr1 = new String("LIFODeque{item=7, rest=EmptyLIFO{}}");
    String tempStr2 = new String("LIFODeque{item=8, rest=LIFODeque{item=7, rest=EmptyLIFO{}}}");
    Assert.assertEquals(lifoDeque1.toString(), tempStr1);
    Assert.assertEquals(lifoDeque2.toString(), tempStr2);
  }
}