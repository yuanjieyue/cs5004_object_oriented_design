package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotBeingHitTest {

    private NotBeingHit hit1;
    private NotBeingHit hit2;
    private NotBeingHit sameAsRefHit;
    private NotBeingHit sameAsStateHit;
    private NotBeingHit yetAnotherHit;
    private NotBeingHit nullHit;

    @Before
    public void setUp() throws Exception {
        hit1 = new NotBeingHit();
        hit2 = new NotBeingHit();
        sameAsRefHit = hit1;
        sameAsStateHit = new NotBeingHit();
        yetAnotherHit = new NotBeingHit();
    }

    @Test
    public void isHit() {
        Assert.assertEquals(hit1.isHit(), new String("Not being hit"));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(hit1.equals(sameAsStateHit), hit1.hashCode() == sameAsStateHit.hashCode());
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(hit1.equals(hit1));
        Assert.assertTrue(hit1.equals(sameAsRefHit));
        Assert.assertTrue(hit1.equals(yetAnotherHit));
        Assert.assertFalse(hit1.equals(nullHit));
    }

    @Test
    public void testToString() {
        String tempStr = new String("Not being hit");
        Assert.assertEquals(hit1.toString(), tempStr);

    }
}