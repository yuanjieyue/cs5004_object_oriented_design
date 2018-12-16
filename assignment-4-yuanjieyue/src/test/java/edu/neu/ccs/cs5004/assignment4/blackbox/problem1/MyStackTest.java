/*
package edu.neu.ccs.cs5004.assignment4.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

  private int elem1;
  private int elem2;
  private int elem3;
  private int elem4;
  private Stack emptyStack;
  private Stack testStack1;
  private Stack testStack2;
  private Stack sameRefStack;
  private Stack sameAsStateStack;
  private Stack yetAnotherStack;
  private Stack nullStack;

  @Before
  public void setUp() throws Exception {
    elem1 = 2;
    elem2 = 3;
    elem3 = 5;
    elem4 = 20;
    emptyStack = Stack.createEmpty();
    testStack1 = Stack.createEmpty();
    testStack2 = Stack.createEmpty().push(elem3);
    sameRefStack = testStack2;
    sameAsStateStack = Stack.createEmpty().push(elem3);
    yetAnotherStack = Stack.createEmpty().push(elem3);
  }

  @Test
  public void push() {
    Assert.assertEquals(testStack1.push(elem1), Stack.createEmpty().push(2));
    Assert.assertEquals(testStack1.push(elem2), Stack.createEmpty().push(2).push(3));
    Assert.assertEquals(testStack1.push(elem3), Stack.createEmpty().push(2).push(3).push(5));
    Assert.assertEquals(testStack1.push(elem4), Stack.createEmpty().push(2).push(3).push(5).push
        (20));
  }

  @Test
  public void pop() {
    Assert.assertEquals(testStack1.push(elem3).pop(), Stack.createEmpty());
    Assert.assertEquals(testStack1.push(elem3).push(elem4).pop(), Stack.createEmpty().push(elem3));
  }

  @Test
  public void top() {
    Assert.assertEquals(testStack1.push(elem2).push(elem3).top(), 5);
    Assert.assertEquals(testStack1.top(), 5);
    Assert.assertEquals(testStack1.pop().top(), 3);
    Assert.assertEquals(testStack1.top(), 3);
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(testStack1.isEmpty(), true);
    testStack1.push(elem3);
    Assert.assertEquals(testStack1.isEmpty(), false);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(emptyStack.equals(Stack.createEmpty()));
    Assert.assertTrue(emptyStack.equals(emptyStack));
    Assert.assertTrue(testStack1.equals(testStack1));
    Assert.assertTrue(testStack2.equals(testStack2));
    Assert.assertTrue(testStack2.equals(sameRefStack));
    Assert.assertTrue(testStack2.equals(sameAsStateStack));
    Assert.assertEquals(testStack2.equals(sameAsStateStack) && sameAsStateStack.equals
        (yetAnotherStack), testStack2.equals(yetAnotherStack));
    Assert.assertFalse(testStack1.equals(testStack2));
    Assert.assertFalse(testStack2.equals(nullStack));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testStack2.equals(sameAsStateStack), testStack2.hashCode() ==
        sameAsStateStack.hashCode());
    Assert.assertEquals(testStack2.equals(emptyStack), testStack2.hashCode() == emptyStack
    .hashCode());
  }

}
*/