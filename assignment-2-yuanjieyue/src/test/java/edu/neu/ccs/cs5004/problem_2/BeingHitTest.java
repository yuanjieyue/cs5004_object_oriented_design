package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeingHitTest {
    private BeingHit hit1;
    private BeingHit hit2;
    private BeingHit sameAsRefHit;
    private BeingHit sameAsStateHit;
    private BeingHit yetAnotherHit;
    private BeingHit nullHit;

    @Before
    public void setUp() throws Exception {
        hit1 = new BeingHit();
        hit2 = new BeingHit();
        sameAsRefHit = hit1;
        sameAsStateHit = new BeingHit();
        yetAnotherHit = new BeingHit();
    }

    @Test
    public void isHit() {
        Assert.assertEquals(hit1.isHit(), new String("Being hit"));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(hit1.equals(sameAsStateHit), hit1.hashCode() == sameAsStateHit.hashCode());
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(hit1.equals(hit1));
        Assert.assertTrue(hit1.equals(sameAsRefHit));
        Assert.assertTrue(hit1.equals(sameAsStateHit));
        Assert.assertTrue(hit1.equals(yetAnotherHit));
        Assert.assertFalse(hit1.equals(nullHit));
    }

    @Test
    public void testToString() {
        String tempStr = new String("Being hit");
        Assert.assertEquals(hit1.toString(), tempStr);

    }
}