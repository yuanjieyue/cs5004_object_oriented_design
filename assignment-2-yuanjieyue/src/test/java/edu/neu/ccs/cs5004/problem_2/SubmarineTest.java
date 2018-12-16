package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarineTest {

    private Integer size1;

    private Integer numberOfHitCells1;

    private Ship ship1;

    @Before
    public void setUp() throws Exception {
        size1 = new Integer(2);
        numberOfHitCells1 = new Integer(1);
        ship1 = new Submarine(size1, numberOfHitCells1);
    }

    @Test
    public void testToString() {
        String tempStr = new String("Submarine{size=2, numberOfHitCells=1}");
        Assert.assertEquals(ship1.toString(), tempStr);
    }
}