package edu.neu.ccs.cs5004.problem2BlackBox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem2.ConcretePriorityQueue;
import edu.neu.ccs.cs5004.problem2.EmptyQueueException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

public class PriorityQueueTest {
  private PriorityQueue<String> stringPriorityQueue;
  private PriorityQueue<Integer> integerPriorityQueue;
  private PriorityQueue<Character> characterPriorityQueue;
  private PriorityQueue<Long> longPriorityQueue;

  private PriorityQueue<String> testStringQueue;
  private PriorityQueue<Integer> testIntegerQueue;
  private PriorityQueue<Character> testCharacterQueue;
  private PriorityQueue<Long> testLongQueue;


  @Before
  public void setUp() throws Exception {
    stringPriorityQueue = PriorityQueue.createEmptyPriorityQueue();
    integerPriorityQueue = PriorityQueue.createEmptyPriorityQueue();
    characterPriorityQueue = PriorityQueue.createEmptyPriorityQueue();
    longPriorityQueue = PriorityQueue.createEmptyPriorityQueue();

    testStringQueue = PriorityQueue.createEmptyPriorityQueue();
    testLongQueue = PriorityQueue.createEmptyPriorityQueue();
    testIntegerQueue = PriorityQueue.createEmptyPriorityQueue();
    testCharacterQueue = PriorityQueue.createEmptyPriorityQueue();


    stringPriorityQueue.insert("abc");
    stringPriorityQueue.insert("adc");
    stringPriorityQueue.insert("acd");

    integerPriorityQueue.insert(3);
    integerPriorityQueue.insert(7);
    integerPriorityQueue.insert(6);
    integerPriorityQueue.insert(4);
    integerPriorityQueue.insert(5);

    characterPriorityQueue.insert('c');
    characterPriorityQueue.insert('b');
    characterPriorityQueue.insert('a');

    longPriorityQueue.insert(3L);
  }

  @Test
  public void insert() throws Exception {
    testLongQueue.insert(3L);
    Assert.assertEquals(testLongQueue.toString(), longPriorityQueue.toString());

  }

  @Test
  public void remove() throws Exception {
    testCharacterQueue.insert('b');
    testCharacterQueue.insert('a');
    characterPriorityQueue.remove();
    Assert.assertEquals(testCharacterQueue.toString(), characterPriorityQueue.toString());

    testIntegerQueue.insert(3);
    testIntegerQueue.insert(4);
    testIntegerQueue.insert(5);
    testIntegerQueue.insert(6);
    integerPriorityQueue.remove();
    Assert.assertEquals(testIntegerQueue.toString(), integerPriorityQueue.toString());
  }
  @Test(expected = EmptyQueueException.class)
  public void removeEmptyQueue() throws Exception {
    testLongQueue.remove();
  }

  @Test
  public void front() throws Exception {
    Assert.assertEquals(new Integer(7), integerPriorityQueue.front());
    Assert.assertEquals(new Long(3L), longPriorityQueue.front());
    Assert.assertEquals("adc", stringPriorityQueue.front());
    Assert.assertEquals(new Character('c'), characterPriorityQueue.front());
  }

  @Test(expected = EmptyQueueException.class)
  public void frontEmptyQueue() throws Exception {
    int test = testCharacterQueue.front();
  }

  @Test
  public void isEmpty() throws Exception {
    Assert.assertTrue(testStringQueue.isEmpty());
    Assert.assertTrue(testIntegerQueue.isEmpty());
    Assert.assertTrue(testCharacterQueue.isEmpty());
    Assert.assertTrue(testLongQueue.isEmpty());
    Assert.assertFalse(stringPriorityQueue.isEmpty());
    Assert.assertFalse(longPriorityQueue.isEmpty());
  }

  @Test
  public void size() throws Exception {
    Assert.assertEquals(3, stringPriorityQueue.size());
    Assert.assertEquals(0, testIntegerQueue.size());
    Assert.assertEquals(1, longPriorityQueue.size());
  }

}