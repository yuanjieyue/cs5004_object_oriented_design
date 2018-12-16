package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    private Integer year;
    private Integer year2;
    private Integer month;
    private Integer day;
    private Date d1;
    private Date sameRefDate;
    private Date sameAsStateDate;
    private Date yetAnotherDate;
    private Date diffDate;
    private Date nullDate;

    @Before
    public void setUp() throws Exception {
        year = new Integer(10);
        year2 = new Integer(12);
        month = new Integer(8);
        day = new Integer(20);
        d1 = new Date(year, month, day);
        sameRefDate = d1;
        sameAsStateDate = new Date(year, month, day);
        yetAnotherDate = new Date(year, month, day);
        diffDate = new Date(year2, month, day);
    }

    @Test
    public void getYear() {
        Assert.assertEquals(d1.getYear(), new Integer(10));
    }

    @Test
    public void getMonth() {
        Assert.assertEquals(d1.getMonth(), new Integer(8));
    }

    @Test
    public void getDay() {
        Assert.assertEquals(d1.getDay(), new Integer(20));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(d1.equals(d1));
        Assert.assertTrue(d1.equals(sameRefDate));
        Assert.assertTrue(d1.equals(sameAsStateDate));
        Assert.assertNull(nullDate);
        Assert.assertEquals(d1.equals(sameAsStateDate) && sameAsStateDate.equals(yetAnotherDate),
                yetAnotherDate.equals(d1));
        Assert.assertFalse(d1.equals(diffDate));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(d1.equals(sameAsStateDate), d1.hashCode() == sameAsStateDate.hashCode());
        Assert.assertEquals(d1.equals(diffDate), d1.hashCode() == diffDate.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("Date{year=10, month=8, day=20}");
        Assert.assertEquals(d1.toString(), tempStr);
    }
}