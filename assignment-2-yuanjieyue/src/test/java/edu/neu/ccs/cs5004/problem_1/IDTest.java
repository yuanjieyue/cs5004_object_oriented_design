package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IDTest{
    private String id1;
    private String id2;

    private ID iD;
    private ID sameRefID;
    private ID sameAsStateID;
    private ID yetAnotherPID;
    private ID diffID;
    private ID nullID;

    @Before
    public void setUp() throws Exception {
        id1 = new String("FDJJ75");
        id2 = new String("SDSK20");
        iD = new ID(id1);
        sameRefID = iD;
        sameAsStateID = new ID(id1);
        yetAnotherPID = new ID(id1);
        diffID = new ID(id2);
    }

    @Test
    public void getId() {
        Assert.assertEquals(iD.getId(), new String("FDJJ75"));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(iD.equals(iD));
        Assert.assertTrue(iD.equals(sameRefID));
        Assert.assertTrue(iD.equals(sameAsStateID));
        Assert.assertFalse(iD.equals(diffID));
        Assert.assertEquals(iD.equals(sameAsStateID) && sameAsStateID.equals(yetAnotherPID),
                yetAnotherPID.equals(iD));
        Assert.assertNull(nullID);
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(iD.equals(sameAsStateID), iD.hashCode() == sameAsStateID.hashCode());
        Assert.assertEquals(iD.equals(diffID), iD.hashCode() == diffID.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("ID{id='FDJJ75'}");
        Assert.assertEquals(iD.toString(), tempStr);
    }
}