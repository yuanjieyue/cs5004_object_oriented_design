/*
package edu.neu.ccs.cs5004.assignment4.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

  private int elem1;
  private int elem2;
  private int elem3;
  private int elem4;
  private Queue emptyQueue;
  private Queue testQueue1;
  private Queue testQueue2;
  private Queue sameRefQueue;
  private Queue sameAsStateQueue;
  private Queue yetAnotherQueue;
  private Queue nullQueue;

  @Before
  public void setUp() throws Exception {
    elem1 = 2;
    elem2 = 3;
    elem3 = 5;
    elem4 = 20;
    emptyQueue = Queue.createEmpty();
    testQueue1 = Queue.createEmpty();
    testQueue2 = Queue.createEmpty().enqueue(elem3);
    sameRefQueue = testQueue2;
    sameAsStateQueue = Queue.createEmpty().enqueue(elem3);
    yetAnotherQueue = Queue.createEmpty().enqueue(elem3);
  }

  @Test
  public void enqueue() {
    Assert.assertEquals(testQueue1.enqueue(elem1), Queue.createEmpty().enqueue(2));
    Assert.assertEquals(testQueue1.enqueue(elem2), Queue.createEmpty().enqueue(2).enqueue(3));
    Assert.assertEquals(testQueue1.enqueue(elem3), Queue.createEmpty().enqueue(2).enqueue(3)
    .enqueue(5));
    Assert.assertEquals(testQueue1.enqueue(elem4), Queue.createEmpty().enqueue(2).enqueue(3).
    enqueue(5).enqueue(20));
  }

  @Test
  public void dequeue() {
    Assert.assertEquals(testQueue1.enqueue(elem3).dequeue(), Queue.createEmpty());
    Assert.assertEquals(testQueue1.enqueue(elem3).enqueue(elem4).dequeue(), Queue.createEmpty()
        .enqueue(20));
  }

  @Test
  public void front() {
    Assert.assertEquals(testQueue1.enqueue(elem2).enqueue(elem3).front(), 3);
    Assert.assertEquals(testQueue1.front(), 3);
    Assert.assertEquals(testQueue1.dequeue().front(), 5);
    Assert.assertEquals(testQueue1.front(), 5);
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(testQueue1.isEmpty(), true);
    testQueue1.enqueue(elem3);
    Assert.assertEquals(testQueue1.isEmpty(), false);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(emptyQueue.equals(Queue.createEmpty()));
    Assert.assertTrue(emptyQueue.equals(emptyQueue));
    Assert.assertTrue(testQueue1.equals(testQueue1));
    Assert.assertTrue(testQueue2.equals(testQueue2));
    Assert.assertTrue(testQueue2.equals(sameRefQueue));
    Assert.assertTrue(testQueue2.equals(sameAsStateQueue));
    Assert.assertEquals(testQueue2.equals(sameAsStateQueue) && sameAsStateQueue.equals
        (yetAnotherQueue), testQueue2.equals(yetAnotherQueue));
    Assert.assertFalse(testQueue1.equals(testQueue2));
    Assert.assertFalse(testQueue2.equals(nullQueue));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testQueue2.equals(sameAsStateQueue), testQueue2.hashCode() ==
        sameAsStateQueue.hashCode());
    Assert.assertEquals(testQueue2.equals(emptyQueue), testQueue2.hashCode() == emptyQueue
    .hashCode());
  }

}
*/
