package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private String first1;
    private String first2;
    private String last1;
    private Person p1;
    private Person sameRefPerson;
    private Person sameAsStatePerson;
    private Person yetAnotherPerson;
    private Person diffPerson;
    private Person nullPerson;

    @Before
    public void setUp() throws Exception {
        first1 = new String("John");
        last1 = new String("Kelly");
        first2 = new String("Brain");
        p1 = new Person(first1, last1);
        sameRefPerson = new Person(first1, last1);
        sameAsStatePerson = new Person(first1, last1);
        yetAnotherPerson = new Person(first1, last1);
        diffPerson = new Person(first2, last1);
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(new String("John"), p1.getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals(new String("Kelly"), p1.getLast());
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(p1.equals(p1));
        Assert.assertTrue(p1.equals(sameRefPerson));
        Assert.assertTrue(p1.equals(sameAsStatePerson));
        Assert.assertEquals(p1.equals(sameAsStatePerson) && sameAsStatePerson.equals
                (yetAnotherPerson), p1.equals(yetAnotherPerson));
        Assert.assertFalse(p1.equals(diffPerson));
        Assert.assertFalse(p1.equals(nullPerson));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(p1.equals(sameAsStatePerson), p1.hashCode() == (sameAsStatePerson.hashCode()));
        Assert.assertEquals(p1.equals(diffPerson), p1.hashCode() == diffPerson.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = "Person{first='John', last='Kelly'}";
        Assert.assertEquals(p1.toString(), tempStr);

    }
}