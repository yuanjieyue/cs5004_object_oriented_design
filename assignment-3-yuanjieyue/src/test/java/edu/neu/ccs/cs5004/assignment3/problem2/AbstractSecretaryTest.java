package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractSecretaryTest {
    private Person name1;
    private ID id1;
    private Seniority seniority1;
    private AbstractSecretary secretary1;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Ashy", "Brandon");
        id1 = new ID("FFDJ77");
        seniority1 = new Seniority(5, 5, 2);
        secretary1 = new GeneralSecretary(name1, id1, seniority1);
    }

    @Test
    public void schedualMeeting() {
        String tempStr = new String("Let's schedual meeting!");
        Assert.assertEquals(secretary1.schedualMeeting(), tempStr);
    }
}