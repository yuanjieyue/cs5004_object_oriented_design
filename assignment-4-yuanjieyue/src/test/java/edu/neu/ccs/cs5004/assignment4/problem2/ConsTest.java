package edu.neu.ccs.cs5004.assignment4.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsTest {

  private Cons cons1;
  private Empty empty;
  private Cons cons2;
  private Cons cons3;
  private Cons sameAsRefCons;
  private Cons sameAsStateCons;
  private Cons yetAnotherCons;
  private Cons nullCons;

  @Before
  public void setUp() throws Exception {
    empty = new Empty();
    cons1 = new Cons(1, new Cons(3, new Cons(5, new Cons(7,
        new Cons(9, new Cons(11, new Empty()))))));
    cons2 = new Cons(5, new Cons(9, new Cons(13, new Cons(11,
        new Cons(17, new Cons(23, new Empty()))))));
    cons3 = new Cons(1, new Cons(5, new Cons(9, new Empty())));
    sameAsRefCons = cons1;
    sameAsStateCons = new Cons(1, new Cons(3, new Cons(5, new Cons(7,
        new Cons(9, new Cons(11, new Empty()))))));
    yetAnotherCons = new Cons(1, new Cons(3, new Cons(5, new Cons(7,
        new Cons(9, new Cons(11, new Empty()))))));
  }

  @Test
  public void getItem() {
    Assert.assertEquals(cons1.getItem(), new Integer(1));
    Assert.assertEquals(cons2.getItem(), new Integer(5));
    Assert.assertEquals(cons3.getItem(), new Integer(1));
  }

  @Test
  public void getRest() {
    Assert.assertEquals(cons1.getRest(), new Cons(3, new Cons(5, new Cons(7,
        new Cons(9, new Cons(11, new Empty()))))));
    Assert.assertEquals(cons2.getRest(), new Cons(9, new Cons(13, new Cons(11,
        new Cons(17, new Cons(23, new Empty()))))));
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(cons1.isEmpty(), new Boolean(false));
    Assert.assertEquals(cons2.isEmpty(), new Boolean(false));
  }

  @Test
  public void add() {
    Assert.assertEquals(cons1.add(2), new Cons(2, new Cons(1, new Cons(3,
        new Cons(5, new Cons(7, new Cons(9, new Cons(11, new Empty()))))))));
    Assert.assertEquals(cons3.add(2), new Cons(2, new Cons(1, new Cons(5, new Cons(9, new
        Empty())))));
  }

  @Test
  public void contains() {
    Assert.assertEquals(cons1.contains(3), new Boolean(true));
    Assert.assertEquals(cons1.contains(23), new Boolean(false));
    Assert.assertEquals(cons2.contains(23), new Boolean(true));
    Assert.assertEquals(cons2.contains(3), new Boolean(false));
  }

  @Test
  public void remove() {
    Assert.assertEquals(cons1.remove(9),new Cons(1, new Cons(3, new Cons(5,
        new Cons(7, new Cons(11, new Empty()))))));
    Assert.assertEquals(cons1.remove(8),new Cons(1, new Cons(3, new Cons(5,
        new Cons(7, new Cons(9, new Cons(11, new Empty())))))));
    Assert.assertEquals(cons3.remove(5), new Cons(1, new Cons(9, new Empty())));
    Assert.assertEquals(cons3.remove(2), new Cons(1, new Cons(5,
        new Cons(9, new Empty()))));
  }

  @Test
  public void size() {
    Assert.assertEquals(cons1.size(), new Integer(6));
    Assert.assertEquals(cons2.size(), new Integer(6));
  }

  @Test
  public void union() {
    Assert.assertEquals(cons1.union(empty), cons1);
    Assert.assertEquals(cons1.union(cons1), cons1);
    Assert.assertEquals(cons1.union(cons2), empty.add(1).add(3).add(5).add(7).add(9).add(11).add
        (13).add(17).add(23));
    Assert.assertEquals(cons2.union(cons1), empty.add(1).add(3).add(5).add(7).add(9).add(11).add
        (13).add(17).add(23));
  }

  @Test
  public void intersection() {
    Assert.assertEquals(cons1.intersection(empty), empty);
    Assert.assertEquals(cons1.intersection(cons1), cons1);
    Assert.assertEquals(cons1.intersection(cons2), empty.add(5).add(9).add(11));
    Assert.assertEquals(cons2.intersection(cons1), empty.add(5).add(9).add(11));
  }

  @Test
  public void difference() {
    Assert.assertEquals(cons1.difference(empty), cons1);
    Assert.assertEquals(cons1.difference(cons1), empty);
    Assert.assertEquals(cons1.difference(cons2), empty.add(1).add(3).add(7));
    Assert.assertEquals(cons2.difference(cons1), empty.add(13).add(17).add(23));
  }

  @Test
  public void subset() {
    Assert.assertEquals(cons1.subset(empty), new Boolean(true));
    Assert.assertEquals(cons1.subset(cons1), new Boolean(true));
    Assert.assertEquals(cons1.subset(cons2), new Boolean(false));
    Assert.assertEquals(cons2.subset(cons1), new Boolean(false));
    Assert.assertEquals(cons1.subset(cons3), new Boolean(true));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cons1.equals(sameAsStateCons), cons1.hashCode() == sameAsStateCons.hashCode());
    Assert.assertEquals(cons1.equals(cons2), cons1.hashCode() == cons2.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cons1.equals(cons1));
    Assert.assertTrue(cons1.equals(sameAsRefCons));
    Assert.assertTrue(cons1.equals(sameAsStateCons));
    Assert.assertEquals(cons1.equals(sameAsStateCons) && sameAsStateCons.equals(yetAnotherCons),
        yetAnotherCons.equals(cons1));
    Assert.assertFalse(cons1.equals(cons2));
    Assert.assertFalse(cons1.equals(nullCons));
  }

  @Test
  public void testToString() {
    String tempStr = "Cons{item=1, rest=Cons{item=5, rest=Cons{item=9, rest=Empty{}}}}";
    Assert.assertEquals(cons3.toString(), tempStr);
  }
}