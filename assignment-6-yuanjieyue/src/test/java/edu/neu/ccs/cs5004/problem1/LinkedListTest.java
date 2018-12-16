package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

  private LinkedList<String> stringList;
  private LinkedList<Integer> integerList;
  private LinkedList<Integer> emptyIntegerList;
  private LinkedList<Integer> singleIntegerList;
  private LinkedList<Integer> anotherIntegerList;
  private LinkedList<Integer> middleElemDiffList;
  private LinkedList<Integer> sameIntegerList;

  @Before
  public void setUp() throws Exception {
    stringList = new LinkedList<>();
    integerList = new LinkedList<>();
    anotherIntegerList = new LinkedList<>();
    middleElemDiffList = new LinkedList<>();
    sameIntegerList = new LinkedList<>();
    emptyIntegerList = new LinkedList<>();
    singleIntegerList = new LinkedList<>();


    stringList.add("c");
    stringList.add("b");
    stringList.add("a");
    integerList.add(3);
    integerList.add(2);
    integerList.add(1);
    anotherIntegerList.add(4);
    anotherIntegerList.add(2);
    anotherIntegerList.add(7);
    singleIntegerList.add(56);
    middleElemDiffList.add(3);
    middleElemDiffList.add(59);
    middleElemDiffList.add(1);

    sameIntegerList.add(3);
    sameIntegerList.add(2);
    sameIntegerList.add(1);
  }

  @Test
  public void equals() throws Exception {
    Assert.assertNotEquals(integerList, "gru");
    Assert.assertEquals(integerList, integerList);
    Assert.assertNotEquals(integerList, null);
    Assert.assertNotEquals(integerList, stringList);

    Assert.assertNotEquals(integerList, singleIntegerList);
    Assert.assertNotEquals(integerList, anotherIntegerList);
    Assert.assertNotEquals(integerList, emptyIntegerList);

    Assert.assertNotEquals(integerList, middleElemDiffList);
    Assert.assertEquals(integerList, sameIntegerList);

  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(integerList.hashCode(), emptyIntegerList.hashCode());
    Assert.assertNotEquals(integerList.hashCode(), stringList.hashCode());
    Assert.assertNotEquals(integerList.hashCode(), anotherIntegerList.hashCode());
    Assert.assertEquals(integerList.hashCode(), sameIntegerList.hashCode());
  }


  @Test
  public void toStringTest() throws Exception {
    String test = "[123]";
    Assert.assertEquals(integerList.toString(), test);
  }

}