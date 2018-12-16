package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkLoadTest {
    private Integer load;
    private Integer load2;
    private Integer incrementFactor;
    private Integer incrementAmount;
    private WorkLoad w1;
    private WorkLoad w2;
    private WorkLoad w3;
    private WorkLoad sameRefWL;
    private WorkLoad sameAsStateWL;
    private WorkLoad yetAnotherWL;
    private WorkLoad diffWL;
    private WorkLoad nullWL;

    @Before
    public void setUp() throws Exception {
        load = new Integer(40);
        load2 = new Integer(50);
        incrementFactor = new Integer(2);
        incrementAmount = new Integer(20);
        w1 = new WorkLoad(load);
        w2 = new WorkLoad(load * incrementFactor);
        w3 = new WorkLoad(load + incrementAmount);
        sameRefWL = w1;
        sameAsStateWL = new WorkLoad(load);
        yetAnotherWL = new WorkLoad(load);
        diffWL = new WorkLoad(load2);
    }

    @Test
    public void getWorkLoad() {
        Assert.assertEquals(w1.getWorkLoad(), new Integer(40));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(w1.equals(w1));
        Assert.assertTrue(w1.equals(sameRefWL));
        Assert.assertTrue(w1.equals(sameAsStateWL));
        Assert.assertEquals(w1.equals(sameAsStateWL) && sameAsStateWL.equals
                (yetAnotherWL), w1.equals(yetAnotherWL));
        Assert.assertFalse(w1.equals(nullWL));
        Assert.assertFalse(w1.equals(diffWL));
        Assert.assertFalse(w1.equals(nullWL));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(w1.equals(sameAsStateWL), w1.hashCode() == sameAsStateWL.hashCode());
        Assert.assertEquals(w1.equals(sameAsStateWL), w1.hashCode()== sameAsStateWL.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = "WorkLoad{workLoad=40}";
        Assert.assertEquals(w1.toString(), tempStr);
    }
}