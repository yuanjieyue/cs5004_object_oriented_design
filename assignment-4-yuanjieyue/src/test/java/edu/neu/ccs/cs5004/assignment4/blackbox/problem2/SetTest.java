package edu.neu.ccs.cs5004.assignment4.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetTest {

  private Set empty;
  private Set cons1;
  private Set cons2;
  private Set cons3;
  private Set diffOrderCons;

  @Before
  public void setUp() throws Exception {
    empty = Set.emptySet();
    cons1 = empty.add(1).add(3).add(5).add(7).add(9).add(11);
    cons2 = empty.add(5).add(9).add(13).add(11).add(17).add(23);
    cons3 = empty.add(1).add(5).add(9);
    diffOrderCons = empty.add(3).add(5).add(7).add(1).add(11).add(9);
  }

  @Test
  public void emptySet() {
    Assert.assertEquals(empty, Set.emptySet());
    Assert.assertEquals(Set.emptySet(), Set.emptySet());
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(empty.isEmpty(), new Boolean(true));
    Assert.assertEquals(cons1.isEmpty(), new Boolean(false));
    Assert.assertEquals(cons2.isEmpty(), new Boolean(false));
  }

  @Test
  public void add() {
    Assert.assertEquals(empty.add(3), new Cons(3, empty));
    Assert.assertEquals(cons1.add(2), new Cons(2, cons1));
    Assert.assertEquals(cons2.add(4), new Cons(4, cons2));
    Assert.assertEquals(cons3.add(3), new Cons(1, new Cons(3, new Cons(9,
        new Cons(5, new Empty())))));
  }

  @Test
  public void contains() {
    Assert.assertEquals(empty.contains(3), new Boolean(false));
    Assert.assertEquals(cons1.contains(7), new Boolean(true));
    Assert.assertEquals(cons2.contains(15), new Boolean(false));
  }

  @Test
  public void remove() {
    Assert.assertEquals(empty.remove(3), Set.emptySet());
    Assert.assertEquals(cons1.remove(2), cons1);
    Assert.assertEquals(cons3.remove(5), empty.add(1).add(9));
  }

  @Test
  public void size() {
    Assert.assertEquals(empty.size(), new Integer(0));
    Assert.assertEquals(cons1.size(), new Integer(6));
    Assert.assertEquals(cons2.size(), new Integer(6));
  }

  @Test
  public void union() {
    Assert.assertEquals(empty.union(cons1), cons1);
    Assert.assertEquals(empty.union(empty), empty);
    Assert.assertEquals(cons1.union(empty), cons1);
    Assert.assertEquals(cons1.union(cons1), cons1);
    Assert.assertEquals(cons1.union(cons2), empty.add(1).add(3).add(5).add(7).add(9).add(11).add
        (13).add(17).add(23));
    Assert.assertEquals(cons2.union(cons1), empty.add(1).add(3).add(5).add(7).add(9).add(11).add
        (13).add(17).add(23));
  }

  @Test
  public void intersection() {
    Assert.assertEquals(empty.intersection(cons1), empty);
    Assert.assertEquals(empty.intersection(empty), empty);
    Assert.assertEquals(cons1.intersection(empty), empty);
    Assert.assertEquals(cons1.intersection(cons1), cons1);
    Assert.assertEquals(cons1.intersection(cons2), empty.add(5).add(9).add(11));
    Assert.assertEquals(cons2.intersection(cons1), empty.add(5).add(9).add(11));
  }

  @Test
  public void difference() {
    Assert.assertEquals(empty.difference(cons1), empty);
    Assert.assertEquals(empty.difference(empty), empty);
    Assert.assertEquals(cons1.difference(empty), cons1);
    Assert.assertEquals(cons1.difference(cons1), empty);
    Assert.assertEquals(cons1.difference(cons2), empty.add(1).add(3).add(7));
    Assert.assertEquals(cons2.difference(cons1), empty.add(13).add(17).add(23));
  }

  @Test
  public void subset() {
    Assert.assertEquals(empty.subset(empty), new Boolean(true));
    Assert.assertEquals(empty.subset(cons1), new Boolean(false));
    Assert.assertEquals(cons1.subset(empty), new Boolean(true));
    Assert.assertEquals(cons1.subset(cons1), new Boolean(true));
    Assert.assertEquals(cons1.subset(cons2), new Boolean(false));
    Assert.assertEquals(cons2.subset(cons1), new Boolean(false));
    Assert.assertEquals(cons1.subset(cons3), new Boolean(true));
  }
}