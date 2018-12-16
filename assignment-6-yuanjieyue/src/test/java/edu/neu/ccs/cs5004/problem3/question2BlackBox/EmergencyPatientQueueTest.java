package edu.neu.ccs.cs5004.problem3.question2BlackBox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem3.question2.EmergencyPatientQueue;
import edu.neu.ccs.cs5004.problem3.question2.EmptyPatientQueueException;
import edu.neu.ccs.cs5004.problem3.question2.Name;
import edu.neu.ccs.cs5004.problem3.question2.Patient;
import edu.neu.ccs.cs5004.problem3.question2.Urgency;

import static org.junit.Assert.*;

public class EmergencyPatientQueueTest {

  private EmergencyPatientQueue emptyPQ;
  private EmergencyPatientQueue pq;
  private EmergencyPatientQueue testPQ;

  private Patient one;
  private Patient two;
  private Patient three;
  private Patient four;
  private Patient five;
  private Patient six;

  @Before
  public void setUp() throws Exception {
    one = new Patient(new Urgency(5), new Name("A", "B"), 1);
    two = new Patient(new Urgency(3), new Name("C", "D"), 2);
    three = new Patient(new Urgency(4), new Name("E", "F"), 3);
    four = new Patient(new Urgency(1), new Name("G", "H"), 4);
    five = new Patient(new Urgency(6), new Name("I", "J"), 5);
    six = new Patient(new Urgency(2), new Name("K", "L"), 6);

    emptyPQ = EmergencyPatientQueue.createEmptyPatientQueue();
    pq = EmergencyPatientQueue.createEmptyPatientQueue();
    testPQ = EmergencyPatientQueue.createEmptyPatientQueue();

    pq.add(one);
    pq.add(two);
    pq.add(three);
    pq.add(four);
    pq.add(five);
    pq.add(six);
  }

  @Test
  public void nextPatient() throws Exception {
    Assert.assertEquals(one, pq.nextPatient());
  }

  @Test(expected = EmptyPatientQueueException.class)
  public void nextPatientEmpty() throws Exception {
    emptyPQ.nextPatient();
  }

  @Test
  public void removeNext() throws Exception {
    testPQ.add(three);
    testPQ.add(four);
    testPQ.add(five);
    testPQ.add(six);

    pq.removeNext();
    pq.removeNext();
    Assert.assertEquals(testPQ, pq);

  }

  @Test(expected = EmptyPatientQueueException.class)
  public void removeNextEmpty() throws Exception {
    emptyPQ.removeNext();
  }

  @Test
  public void nextMostUrgent() throws Exception {
    Assert.assertEquals(five, pq.nextMostUrgent());
    pq.removeMostUrgent();

  }

  @Test(expected = EmptyPatientQueueException.class)
  public void nextMostUrgentEmpty() throws Exception {
    emptyPQ.nextMostUrgent();
  }

  @Test
  public void removeMostUrgent() throws Exception {
    testPQ.add(two);
    testPQ.add(three);
    testPQ.add(four);
    testPQ.add(one);
    testPQ.add(six);

    pq.removeMostUrgent();
    Assert.assertEquals(testPQ, pq);
  }

  @Test(expected = EmptyPatientQueueException.class)
  public void removeMostUrgentEmpty() throws Exception {
    emptyPQ.removeMostUrgent();
  }

  @Test
  public void add() throws Exception {
    emptyPQ.add(one);
    emptyPQ.add(two);
    emptyPQ.add(three);

    testPQ.add(two);
    testPQ.add(three);
    testPQ.add(one);

    Assert.assertEquals(emptyPQ, testPQ);

  }

  @Test
  public void isEmpty() throws Exception {
    Assert.assertTrue(emptyPQ.isEmpty());
    Assert.assertFalse(pq.isEmpty());
  }


  @Test
  public void size() throws Exception {
    Assert.assertEquals(0, emptyPQ.size());
    Assert.assertEquals(6, pq.size());
    pq.removeMostUrgent();
    Assert.assertEquals(5, pq.size());
  }

  @Test
  public void timeTest() throws Exception {
    long startTime, estimatedTime;

    startTime = System.nanoTime();
    Patient nextPa = pq.nextPatient();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for nextPatient() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    pq.removeNext();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for removeNext() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    Patient nextMU = pq.nextMostUrgent();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for nextMostUrgent() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    pq.add(one);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for add() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    pq.removeMostUrgent();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for removeMostUrgent() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    pq.isEmpty();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for isEmpty() is: " + estimatedTime + "ns.");

    startTime = System.nanoTime();
    pq.size();
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("The time for size() is: " + estimatedTime + "ns.");

  }

}