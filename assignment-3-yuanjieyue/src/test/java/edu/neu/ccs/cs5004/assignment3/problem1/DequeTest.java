package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {

  private Integer elem1;
  private Integer elem2;
  private Integer elem3;
  private Integer elem4;
  private Deque emptyLIFO;
  private Deque emptyFIFO;
  private Deque empty1;
  private Deque empty2;
  private Deque lifo1;
  private Deque lifo2;
  private Deque fifo1;
  private Deque fifo2;
  private ADeque aDeque1;
  private ADeque aDeque2;
  private Empty aEmpty1;
  private Empty aEmpty2;

  @Before
  public void setUp() throws Exception {
    elem1 = 5;
    elem2 = 6;
    elem3 = 7;
    elem4 = 8;
    emptyLIFO = new EmptyLIFO();
    emptyFIFO = new EmptyFIFO();
    empty1 = new EmptyLIFO();
    empty2 = new EmptyFIFO();
    lifo1 = new LIFODeque(elem1, emptyLIFO);
    lifo2 = new LIFODeque(elem2, empty1);
    fifo1 = new FIFODeque(elem3, emptyFIFO);
    fifo2 = new FIFODeque(elem4, empty2);
    aEmpty1 = new EmptyLIFO();
    aEmpty2 = new EmptyFIFO();
    aDeque1 = new LIFODeque(elem1, aEmpty1);
    aDeque2 = new FIFODeque(elem2, aEmpty2);
  }

  @Test
  public void emptyFIFODeque() {
    Assert.assertEquals(Deque.emptyFIFODeque(), new EmptyFIFO());
  }

  @Test
  public void emptyLIFODeque() {
    Assert.assertEquals(Deque.emptyLIFODeque(), new EmptyLIFO());
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(empty1.isEmpty(), new Boolean(true));
    Assert.assertEquals(empty2.isEmpty(), new Boolean(true));
    Assert.assertEquals(emptyLIFO.isEmpty(), new Boolean(true));
    Assert.assertEquals(emptyFIFO.isEmpty(), new Boolean(true));
    Assert.assertEquals(lifo1.isEmpty(), new Boolean(false));
    Assert.assertEquals(lifo2.isEmpty(), new Boolean(false));
    Assert.assertEquals(fifo1.isEmpty(), new Boolean(false));
    Assert.assertEquals(fifo2.isEmpty(), new Boolean(false));
    Assert.assertEquals(aEmpty1.isEmpty(), new Boolean(true));
    Assert.assertEquals(aEmpty2.isEmpty(), new Boolean(true));
    Assert.assertEquals(aDeque1.isEmpty(), new Boolean(false));
    Assert.assertEquals(aDeque2.isEmpty(), new Boolean(false));
  }

  @Test
  public void size() {
    Assert.assertEquals(empty1.size(), new Integer(0));
    Assert.assertEquals(empty2.size(), new Integer(0));
    Assert.assertEquals(emptyLIFO.size(), new Integer(0));
    Assert.assertEquals(emptyFIFO.size(), new Integer(0));
    Assert.assertEquals(lifo1.size(), new Integer(1));
    Assert.assertEquals(lifo2.size(), new Integer(1));
    Assert.assertEquals(fifo1.size(), new Integer(1));
    Assert.assertEquals(fifo2.size(), new Integer(1));
    Assert.assertEquals(aEmpty1.size(), new Integer(0));
    Assert.assertEquals(aEmpty2.size(), new Integer(0));
    Assert.assertEquals(aDeque1.size(), new Integer(1));
    Assert.assertEquals(aDeque2.size(), new Integer(1));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFirst() {
    Assert.assertEquals(lifo1.addFirst(elem2), new LIFODeque(elem2, lifo1));
    Assert.assertEquals(lifo2.addFirst(elem1), new LIFODeque(elem1, lifo2));

    Assert.assertEquals(empty1.addFirst(elem1), new LIFODeque(elem1, empty1));
    Assert.assertEquals(emptyLIFO.addFirst(elem1), new LIFODeque(elem1, emptyLIFO));
    Assert.assertEquals(aEmpty1.addFirst(elem1), new LIFODeque(elem1, aEmpty1));
    Assert.assertEquals(aDeque1.addFirst(elem1), new LIFODeque(elem1, aDeque1));

    Assert.assertEquals(empty2.addFirst(elem1), new FIFODeque(elem1, empty2));
    Assert.assertEquals(emptyFIFO.addFirst(elem1), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(fifo1.addFirst(elem4), new FIFODeque(elem4, fifo1));
    Assert.assertEquals(fifo2.addFirst(elem3), new FIFODeque(elem3, fifo2));
    Assert.assertEquals(emptyFIFO.addFirst(elem1), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(aEmpty2.addFirst(elem1), new FIFODeque(elem1, aEmpty2));
    Assert.assertEquals(aDeque2.addFirst(elem1), new FIFODeque(elem1, aDeque2));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addLast() {
    Assert.assertEquals(empty2.addLast(elem1), new FIFODeque(elem1, empty2));
    Assert.assertEquals(emptyFIFO.addLast(elem1), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(fifo1.addLast(elem4), new FIFODeque(elem3, new FIFODeque(elem4, new
        EmptyFIFO())));
    Assert.assertEquals(fifo2.addLast(elem3), new FIFODeque(elem4, new FIFODeque(elem3, new
        EmptyFIFO())));
    Assert.assertEquals(emptyFIFO.addLast(elem1), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(aEmpty2.addLast(elem1), new FIFODeque(elem1, aEmpty2));
    Assert.assertEquals(aDeque2.addLast(elem1), new FIFODeque(elem2, new FIFODeque(elem1, new
        EmptyFIFO())));
    Assert.assertEquals(lifo1.addLast(elem2), new LIFODeque(elem2, lifo1));
    Assert.assertEquals(lifo2.addLast(elem1), new LIFODeque(elem1, lifo2));

    Assert.assertEquals(empty1.addLast(elem1), new LIFODeque(elem1, empty1));
    Assert.assertEquals(emptyLIFO.addLast(elem1), new LIFODeque(elem1, emptyLIFO));
    Assert.assertEquals(aEmpty1.addLast(elem1), new LIFODeque(elem1, aEmpty1));
    Assert.assertEquals(aDeque1.addLast(elem1), new LIFODeque(elem1, aDeque1));
  }

  @Test(expected = IllegalOperationException.class)
  public void removeFirst() {
    Assert.assertEquals(empty2.removeFirst(), new FIFODeque(elem1, empty2));
    Assert.assertEquals(emptyFIFO.removeFirst(), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(emptyFIFO.removeFirst(), new FIFODeque(elem1, emptyFIFO));
    Assert.assertEquals(aEmpty2.removeFirst(), new FIFODeque(elem1, aEmpty2));
    Assert.assertEquals(empty1.removeFirst(), new LIFODeque(elem1, empty1));
    Assert.assertEquals(emptyLIFO.removeFirst(), new LIFODeque(elem1, emptyLIFO));
    Assert.assertEquals(aEmpty1.removeFirst(), new LIFODeque(elem1, aEmpty1));

    Assert.assertEquals(lifo1.removeFirst(), new EmptyLIFO());
    Assert.assertEquals(lifo2.removeFirst(), new EmptyLIFO());
    Assert.assertEquals(fifo1.removeFirst(), new EmptyFIFO());
    Assert.assertEquals(fifo2.removeFirst(), new EmptyFIFO());

    Assert.assertEquals(aDeque1.removeFirst(), new EmptyLIFO());
    Assert.assertEquals(aDeque2.removeFirst(), new EmptyFIFO());
  }

  @Test(expected = java.lang.Error.class)
  public void peek() {
    Assert.assertEquals(fifo1.peek(), new Integer(elem3));
    Assert.assertEquals(fifo2.peek(), new Integer(elem4));
    Assert.assertEquals(lifo1.peek(), new Integer(elem1));
    Assert.assertEquals(lifo2.peek(), new Integer(elem2));
    Assert.assertEquals(aDeque1.peek(), new Integer(elem1));
    Assert.assertEquals(aDeque2.peek(), new Integer(elem2));

    Assert.assertEquals(empty2.peek(), new Integer(elem1));
    Assert.assertEquals(emptyFIFO.peek(), new Integer(elem1));
    Assert.assertEquals(emptyFIFO.peek(), new Integer(elem1));
    Assert.assertEquals(aEmpty2.peek(), new Integer(elem1));
    Assert.assertEquals(empty1.peek(), new Integer(elem2));
    Assert.assertEquals(emptyLIFO.peek(), new Integer(elem2));
    Assert.assertEquals(aEmpty1.peek(), new Integer(elem2));

  }
}