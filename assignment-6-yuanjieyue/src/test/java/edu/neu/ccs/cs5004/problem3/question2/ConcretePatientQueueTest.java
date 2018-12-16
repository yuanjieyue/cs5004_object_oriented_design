package edu.neu.ccs.cs5004.problem3.question2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcretePatientQueueTest {
  
  private ConcretePatientQueue patientQueue;
  private ConcretePatientQueue emptyPatientQueue;
  private ConcretePatientQueue singlePatientQueue;
  private ConcretePatientQueue middleElemDiffQueue;
  private ConcretePatientQueue samePatientQueue;

  private Patient one;
  private Patient two;
  private Patient three;
  private Patient four;
  private Patient five;
  private Patient six;

  @Before
  public void setUp() throws Exception {

    patientQueue = new ConcretePatientQueue();
    middleElemDiffQueue = new ConcretePatientQueue();
    samePatientQueue = new ConcretePatientQueue();
    emptyPatientQueue = new ConcretePatientQueue();
    singlePatientQueue = new ConcretePatientQueue();

    one = new Patient(new Urgency(5), new Name("A", "B"), 1);
    two = new Patient(new Urgency(3), new Name("C", "D"), 2);
    three = new Patient(new Urgency(4), new Name("E", "F"), 3);
    four = new Patient(new Urgency(1), new Name("G", "H"), 4);
    five = new Patient(new Urgency(6), new Name("I", "J"), 5);
    six = new Patient(new Urgency(2), new Name("K", "L"), 6);

    patientQueue.add(one);
    patientQueue.add(two);
    patientQueue.add(three);
    patientQueue.add(four);
    patientQueue.add(five);

    samePatientQueue.add(one);
    samePatientQueue.add(two);
    samePatientQueue.add(three);
    samePatientQueue.add(four);
    samePatientQueue.add(five);

    middleElemDiffQueue.add(one);
    middleElemDiffQueue.add(two);
    middleElemDiffQueue.add(three);
    middleElemDiffQueue.add(four);
    middleElemDiffQueue.add(six);

    singlePatientQueue.add(six);
  }

  @Test
  public void equals() throws Exception {
    Assert.assertNotEquals(patientQueue, "gru");
    Assert.assertEquals(patientQueue, patientQueue);
    Assert.assertNotEquals(patientQueue, null);

    Assert.assertNotEquals(patientQueue, singlePatientQueue);
    Assert.assertEquals(patientQueue, samePatientQueue);
    Assert.assertNotEquals(patientQueue, emptyPatientQueue);

    Assert.assertNotEquals(patientQueue, middleElemDiffQueue);

  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(patientQueue.hashCode(), emptyPatientQueue.hashCode());
    Assert.assertEquals(patientQueue.hashCode(), samePatientQueue.hashCode());
    Assert.assertNotEquals(patientQueue.hashCode(), middleElemDiffQueue.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    String test = "ConcretePatientQueue{patientQueue=[Patient{urgency=Urgency{value=6}, name=Name{first=I, last=J}, arrivalOrder=5} Patient{urgency=Urgency{value=5}, name=Name{first=A, last=B}, arrivalOrder=1} Patient{urgency=Urgency{value=4}, name=Name{first=E, last=F}, arrivalOrder=3} Patient{urgency=Urgency{value=3}, name=Name{first=C, last=D}, arrivalOrder=2} Patient{urgency=Urgency{value=1}, name=Name{first=G, last=H}, arrivalOrder=4} ]}";
    Assert.assertEquals(test, patientQueue.toString());
  }

}