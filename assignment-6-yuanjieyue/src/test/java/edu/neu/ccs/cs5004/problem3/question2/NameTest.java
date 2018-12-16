package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
  private Name john;
  private Name jane;
  private Name sameJohn;
  private Name nullFirst;
  private Name nullLast;
  private Name nullTotal;

  @Before
  public void setUp() throws Exception {
    john = new Name("John", "Doe");
    jane = new Name("Jane", "Jenny");
    sameJohn = new Name("John", "Doe");
    nullFirst = new Name(null, "Doe");
    nullLast = new Name("John", null);
    nullTotal = new Name(null, null);
  }

  @Test
  public void equals() throws Exception {
    Assert.assertEquals(john, john);
    Assert.assertEquals(john, sameJohn);
    Assert.assertNotEquals(john, jane);
    Assert.assertNotEquals(john, null);
    Assert.assertNotEquals(john, "john");
    Assert.assertNotEquals(john, nullFirst);
    Assert.assertNotEquals(john, nullLast);
    Assert.assertNotEquals(john, nullTotal);

  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(john.hashCode(), jane.hashCode());
    Assert.assertEquals(john.hashCode(), sameJohn.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    String test = "Name{" + "first=" + "John" + ", last=" + "Doe" + '}';
    Assert.assertEquals(test, john.toString());
  }

}