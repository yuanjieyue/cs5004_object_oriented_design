package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VocationDaysTest {
    private Integer vocationDays;
    private Integer vocationDays2;
    private Integer incrementAmount;

    private VocationDays vd1;
    private VocationDays vd2;
    private VocationDays sameRefVD;
    private VocationDays sameAsStateVD;
    private VocationDays yetAnotherVD;
    private VocationDays diffVD;
    private VocationDays nullVD;
    @Before
    public void setUp() throws Exception {
        Integer vocationDays = new Integer(14);
        Integer vocationDays2 = new Integer(21);
        Integer incrementAmount = 7;
        vd1 = new VocationDays(vocationDays);
        vd2 = vd1.alterByAmount(incrementAmount);
        sameRefVD = vd1;
        sameAsStateVD = new VocationDays(vocationDays);
        yetAnotherVD = new VocationDays(vocationDays);
        diffVD = new VocationDays(vocationDays2);
    }

    @Test
    public void getVocationDays() {
        Assert.assertEquals(vd1.getVocationDays(), new Integer(14));
    }

    @Test
    public void alterByAmount() {
        Assert.assertEquals(vd2, new VocationDays(new Integer(21)));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(vd1.equals(vd1));
        Assert.assertTrue(vd1.equals(sameRefVD));
        Assert.assertTrue(vd1.equals(sameAsStateVD));
        Assert.assertFalse(vd1.equals(diffVD));
        Assert.assertNull(nullVD);
        Assert.assertEquals(vd1.equals(sameAsStateVD) && sameAsStateVD.equals(yetAnotherVD),
                yetAnotherVD.equals(vd1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(vd1.equals(sameAsStateVD), vd1.hashCode() == sameAsStateVD.hashCode());
        Assert.assertEquals(vd1.equals(diffVD), vd1.hashCode() == diffVD.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = "VocationDays{vocationDays=14}";
        Assert.assertEquals(vd1.toString(), tempStr);
    }
}