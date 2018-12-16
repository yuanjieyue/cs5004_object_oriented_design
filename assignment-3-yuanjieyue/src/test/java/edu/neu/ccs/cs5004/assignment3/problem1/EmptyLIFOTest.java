package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyLIFOTest {

  private EmptyLIFO emptyLIFO;
  private LIFODeque lifoDeque1;
  private LIFODeque lifoDeque2;
  private Integer element1;
  private Integer element2;


  @Before
  public void setUp() throws Exception {
    emptyLIFO = new EmptyLIFO();
    lifoDeque1 = new LIFODeque(element1, emptyLIFO);
    lifoDeque2 = new LIFODeque(element2, lifoDeque1);
  }

  @Test
  public void addFirst() {
    Assert.assertEquals(emptyLIFO.addFirst(element1), lifoDeque1);
    Assert.assertEquals(lifoDeque1.addFirst(element2), lifoDeque2);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addLast() {
    Assert.assertEquals(emptyLIFO.addLast(element1), new String("The addLast() is not supported on " +
        "EmptyLIFO"));
  }

  @Test
  public void testToString() {
    String tempStr = new String("EmptyLIFO{}");
    Assert.assertEquals(emptyLIFO.toString(), tempStr);
  }
}