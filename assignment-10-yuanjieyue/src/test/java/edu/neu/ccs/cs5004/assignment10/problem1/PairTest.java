package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment10.problem1.Pair;

public class PairTest {
  private Pair<Integer, Integer> intPair;
  private Pair<String, String> strPair;
  private Pair<Integer, Integer> intPair2;
  private Pair<Integer, Integer> sameAsRefPair;
  private Pair<Integer, Integer> sameAsStatePair;
  private Pair<Integer, Integer> yetAnotherPair;
  private Pair<Integer, Integer> nullPair;

  @Before
  public void setUp() throws Exception {
    intPair = new Pair<>(1, 2);
    strPair = new Pair<>("1", "2");
    intPair2 = new Pair<>(2, 2);
    sameAsRefPair = intPair;
    sameAsStatePair = new Pair<>(1, 2);
    yetAnotherPair = new Pair<>(1, 2);
  }

  @Test
  public void getFirst() {
    Assert.assertEquals(intPair.getFirst(), new Integer(1));
    Assert.assertEquals(intPair2.getFirst(), new Integer(2));
    Assert.assertEquals(strPair.getFirst(),"1");
  }

  @Test
  public void setFirst() {
    intPair.setFirst(2);
    Assert.assertEquals(intPair.getFirst(), new Integer(2));
    intPair2.setFirst(12);
    Assert.assertEquals(intPair2.getFirst(), new Integer(12));
    strPair.setFirst("3");
    Assert.assertEquals(strPair.getFirst(), "3");
  }

  @Test
  public void getSecond() {
    Assert.assertEquals(intPair.getSecond(), new Integer(2));
    Assert.assertEquals(intPair2.getSecond(), new Integer(2));
    Assert.assertEquals(strPair.getSecond(), "2");
  }

  @Test
  public void setSecond() {
    intPair.setSecond(4);
    Assert.assertEquals(intPair.getSecond(), new Integer(4));
    intPair2.setSecond(8);
    Assert.assertEquals(intPair2.getSecond(), new Integer(8));
    strPair.setSecond("1212");
    Assert.assertEquals(strPair.getSecond(), "1212");
  }

  @Test
  public void equals() {
    Assert.assertTrue(intPair.equals(intPair));
    Assert.assertTrue(intPair.equals(sameAsRefPair));
    Assert.assertTrue(intPair.equals(sameAsStatePair));
    Assert.assertEquals(intPair.equals(sameAsStatePair) && sameAsStatePair.equals
        (yetAnotherPair), yetAnotherPair.equals(intPair));
    Assert.assertFalse(intPair.equals(3));
    Assert.assertFalse(intPair.equals(strPair));
    Assert.assertFalse(intPair.equals(intPair2));
    Assert.assertFalse(intPair.equals(nullPair));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(intPair.equals(sameAsStatePair), intPair.hashCode() == sameAsStatePair
        .hashCode());
    Assert.assertEquals(intPair.equals(intPair2), intPair.hashCode() == intPair2.hashCode());
  }

  @Test
  public void testToString() {
    String res = "Pair{first=1, second=2}";
    Assert.assertEquals(intPair.toString(), res);
  }
}