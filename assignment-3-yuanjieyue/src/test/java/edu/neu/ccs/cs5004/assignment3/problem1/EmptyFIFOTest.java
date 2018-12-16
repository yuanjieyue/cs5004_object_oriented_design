package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyFIFOTest {

  private Integer element1;
  private Integer element2;
  private EmptyFIFO emptyFIFO;
  private FIFODeque fifoDeque1;
  private FIFODeque fifoDeque2;

  @Before
  public void setUp() throws Exception {
    element1 = 3;
    element2 = 4;
    emptyFIFO = new EmptyFIFO();
    fifoDeque1 = new FIFODeque(element1, emptyFIFO);
    fifoDeque2 = new FIFODeque(element2, fifoDeque1);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFirst() {
    Assert.assertEquals(emptyFIFO.addFirst(element1),
        new String("addFirst() is not supported on EmptyFIFO!"));
  }

  @Test
  public void addLast() {
    Assert.assertEquals(emptyFIFO.addLast(element1), fifoDeque1);
    Assert.assertEquals(fifoDeque1.addLast(element2), new FIFODeque(element1, new FIFODeque
        (element2, new EmptyFIFO())));
  }

  @Test
  public void testToString() {
    String tempStr = new String("EmptyFIFO{}");
    Assert.assertEquals(emptyFIFO.toString(), tempStr);
  }
}