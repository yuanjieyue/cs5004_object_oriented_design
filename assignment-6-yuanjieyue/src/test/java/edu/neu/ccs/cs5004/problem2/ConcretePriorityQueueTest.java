package edu.neu.ccs.cs5004.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcretePriorityQueueTest {

  private ConcretePriorityQueue<String> stringQueue;
  private ConcretePriorityQueue<Integer> integerQueue;
  private ConcretePriorityQueue<Integer> emptyIntegerQueue;
  private ConcretePriorityQueue<Integer> singleIntegerQueue;
  private ConcretePriorityQueue<Integer> anotherIntegerQueue;
  private ConcretePriorityQueue<Integer> middleElemDiffQueue;
  private ConcretePriorityQueue<Integer> sameIntegerQueue;

  @Before
  public void setUp() throws Exception {

    stringQueue = new ConcretePriorityQueue<>();
    integerQueue = new ConcretePriorityQueue<>();
    anotherIntegerQueue = new ConcretePriorityQueue<>();
    middleElemDiffQueue = new ConcretePriorityQueue<>();
    sameIntegerQueue = new ConcretePriorityQueue<>();
    emptyIntegerQueue = new ConcretePriorityQueue<>();
    singleIntegerQueue = new ConcretePriorityQueue<>();

    stringQueue.insert("add");
    stringQueue.insert("bus");
    stringQueue.insert("car");

    integerQueue.insert(3);
    integerQueue.insert(7);
    integerQueue.insert(6);
    integerQueue.insert(4);
    integerQueue.insert(5);

    sameIntegerQueue.insert(3);
    sameIntegerQueue.insert(7);
    sameIntegerQueue.insert(6);
    sameIntegerQueue.insert(4);
    sameIntegerQueue.insert(5);

    anotherIntegerQueue.insert(5);
    anotherIntegerQueue.insert(7);
    anotherIntegerQueue.insert(4);
    anotherIntegerQueue.insert(6);
    anotherIntegerQueue.insert(3);

    middleElemDiffQueue.insert(5);
    middleElemDiffQueue.insert(7);
    middleElemDiffQueue.insert(8);
    middleElemDiffQueue.insert(6);
    middleElemDiffQueue.insert(3);

    singleIntegerQueue.insert(1);

  }

  @Test
  public void equals() throws Exception {

    Assert.assertNotEquals(integerQueue, "gru");
    Assert.assertEquals(integerQueue, integerQueue);
    Assert.assertNotEquals(integerQueue, null);
    Assert.assertNotEquals(integerQueue, stringQueue);

    Assert.assertNotEquals(integerQueue, singleIntegerQueue);
    Assert.assertEquals(integerQueue, anotherIntegerQueue);
    Assert.assertNotEquals(integerQueue, emptyIntegerQueue);

    Assert.assertNotEquals(integerQueue, middleElemDiffQueue);
    Assert.assertEquals(integerQueue, sameIntegerQueue);

  }


  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(integerQueue.hashCode(), emptyIntegerQueue.hashCode());
    Assert.assertNotEquals(integerQueue.hashCode(), stringQueue.hashCode());
    Assert.assertEquals(integerQueue.hashCode(), anotherIntegerQueue.hashCode());
    Assert.assertEquals(integerQueue.hashCode(), sameIntegerQueue.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    String test = "[7 6 5 4 3 ]";
    Assert.assertEquals(integerQueue.toString(), test);
  }

}