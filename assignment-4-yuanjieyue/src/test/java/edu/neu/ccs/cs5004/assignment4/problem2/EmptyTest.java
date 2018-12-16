package edu.neu.ccs.cs5004.assignment4.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyTest {

  private Empty empty;
  private Set empty2;
  private Set cons;
  private Empty sameAsRefEmpty;
  private Empty sameAsStateEmpty;
  private Empty yetanotherEmpty;
  private Empty nullEmpty;

  @Before
  public void setUp() throws Exception {
    empty = new Empty();
    empty2 = Set.emptySet();
    cons = empty.add(3);
    sameAsRefEmpty = empty;
    sameAsStateEmpty = new Empty();
    yetanotherEmpty = new Empty();
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(empty.isEmpty(), new Boolean(true));
    Assert.assertEquals(empty2.isEmpty(), new Boolean(true));
    Assert.assertEquals(sameAsStateEmpty.isEmpty(), new Boolean(true));
  }

  @Test
  public void add() {
    Assert.assertEquals(empty.add(3), cons);
    Assert.assertEquals(empty2.add(3), cons);
  }

  @Test
  public void contains() {
    Assert.assertEquals(empty.contains(3), new Boolean(false));
    Assert.assertEquals(empty2.contains(3), new Boolean(false));
  }

  @Test
  public void remove() {
    Assert.assertEquals(empty.remove(3), empty);
    Assert.assertEquals(empty.remove(5), empty);
    Assert.assertEquals(empty2.remove(3), empty2);
  }

  @Test
  public void size() {
    Assert.assertEquals(empty.size(), new Integer(0));
    Assert.assertEquals(empty2.size(), new Integer(0));
  }

  @Test
  public void union() {
    Assert.assertEquals(empty.union(empty), empty);
    Assert.assertEquals(empty.union(empty2), empty2);
    Assert.assertEquals(empty.union(cons), cons);
  }

  @Test
  public void intersection() {
    Assert.assertEquals(empty.intersection(empty), empty);
    Assert.assertEquals(empty.intersection(empty2), empty);
    Assert.assertEquals(empty.intersection(cons), empty);
  }

  @Test
  public void difference() {
    Assert.assertEquals(empty.difference(empty), empty);
    Assert.assertEquals(empty.difference(empty2), empty);
    Assert.assertEquals(empty.difference(cons), empty);
  }

  @Test
  public void subset() {
    Assert.assertEquals(empty.subset(empty), new Boolean(true));
    Assert.assertEquals(empty.subset(empty2), new Boolean(true));
    Assert.assertEquals(empty.subset(cons), new Boolean(false));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(empty.equals(sameAsStateEmpty), empty.hashCode() == sameAsStateEmpty
        .hashCode());
    Assert.assertEquals(empty.equals(cons), empty.hashCode() == cons.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(empty.equals(empty));
    Assert.assertTrue(empty.equals(empty2));
    Assert.assertTrue(empty.equals(sameAsRefEmpty));
    Assert.assertTrue(empty.equals(sameAsStateEmpty));
    Assert.assertEquals(empty.equals(sameAsStateEmpty) && sameAsStateEmpty.equals
        (yetanotherEmpty), yetanotherEmpty.equals(empty));
    Assert.assertFalse(empty.equals(cons));
    Assert.assertFalse(empty.equals(nullEmpty));
  }

  @Test
  public void testToString() {
    String tempStr = "Empty{}";
    Assert.assertEquals(empty.toString(), tempStr);
  }
}