package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {

  private Patient one;
  private Patient two;
  private Patient three;
  private Patient four;
  private Patient five;
  private Patient six;
  private Patient nullName;
  private Patient nullUr;
  private Patient nullTotal;
  private Patient sameOne;

  @Before
  public void setUp() throws Exception {
    one = new Patient(new Urgency(5), new Name("A", "B"), 1);
    two = new Patient(new Urgency(3), new Name("C", "D"), 2);
    three = new Patient(new Urgency(4), new Name("E", "F"), 3);
    four = new Patient(new Urgency(1), new Name("G", "H"), 4);
    five = new Patient(new Urgency(6), new Name("I", "J"), 5);
    six = new Patient(new Urgency(2), new Name("K", "L"), 6);

    sameOne = new Patient(new Urgency(5), new Name("A", "B"), 1);
    nullName = new Patient(new Urgency(1), null, 1);
    nullUr = new Patient(null, new Name("Y", "Z"), 1);
    nullTotal = new Patient(null, null, 1);


  }

  @Test
  public void getUrgency() throws Exception {
    Assert.assertEquals(new Urgency(4), three.getUrgency());
  }

  @Test
  public void getName() throws Exception {
    Assert.assertEquals(new Name("A", "B"), one.getName());
  }

  @Test
  public void getArrivalOrder() throws Exception {
    Assert.assertEquals(6, six.getArrivalOrder());
  }

  @Test
  public void compareTo() throws Exception {
    Assert.assertEquals(-1, four.compareTo(five));
    Assert.assertEquals(1, five.compareTo(one));
    Assert.assertEquals(0, four.compareTo(four));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertEquals(one, one);
    Assert.assertNotEquals(one, two);
    Assert.assertNotEquals(one, nullName);
    Assert.assertNotEquals(one, nullUr);
    Assert.assertNotEquals(one, nullTotal);
    Assert.assertNotEquals(one, null);
    Assert.assertNotEquals(one, "one");
    Assert.assertEquals(one, sameOne);
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
    Assert.assertEquals(one.hashCode(), sameOne.hashCode());

  }

  @Test
  public void toStringTest() throws Exception {
    String test = "Patient{urgency=Urgency{value=5}, name=Name{first=A, last=B}, arrivalOrder=1}";
    Assert.assertEquals(test, one.toString());
  }

}