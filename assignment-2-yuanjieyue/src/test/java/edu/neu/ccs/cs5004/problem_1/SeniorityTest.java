package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorityTest {
    private Integer year;
    private Integer month;
    private Integer day;

    private Seniority seniority;

    @Before
    public void setUp() throws Exception {
        Integer year = new Integer(10);
        Integer month = new Integer(8);
        Integer day = new Integer(20);
        seniority = new Seniority(year, month, day);
    }

    @Test
    public void testToString() {
        String tempStr = new String("Seniority{year=10, month=8, day=20}");
        Assert.assertEquals(seniority.toString(), tempStr);
    }
}