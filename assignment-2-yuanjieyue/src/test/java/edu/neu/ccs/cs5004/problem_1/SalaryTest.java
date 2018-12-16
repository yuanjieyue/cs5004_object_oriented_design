package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryTest {
    private Double salary1;
    private Double salary2;
    private Double incrementFactor;
    private Double incrementAmount;
    private Salary s1;
    private Salary s2;
    private Salary s3;
    private Salary sameRefSalary;
    private Salary sameAsStateSalary;
    private Salary yetAnotherSalary;
    private Salary diffSalary;
    private Salary nullSalary;

    @Before
    public void setUp() throws Exception {
        salary1 = new Double(40000);
        salary2 = new Double(50000);
        incrementFactor = new Double(2);
        incrementAmount = new Double(5000);
        s1 = new Salary(salary1);
        s2 = s1.alterByFactor(incrementFactor);
        s3 = s1.alterByAmount(incrementAmount);
        sameRefSalary = s1;
        sameAsStateSalary = new Salary(salary1);
        yetAnotherSalary = new Salary(salary1);
        diffSalary = new Salary(salary2);
    }

    @Test
    public void getSalary() {
        Assert.assertEquals(s1.getSalary(), new Double(40000));
    }

    @Test
    public void alterByFactor() {
        Assert.assertEquals(s2, new Salary(new Double(80000)));
    }


    @Test
    public void alterByAmount() {
        Assert.assertEquals(s3, new Salary(new Double(45000)));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(s1.equals(s1));
        Assert.assertTrue(s1.equals(sameRefSalary));
        Assert.assertTrue(s1.equals(sameAsStateSalary));
        Assert.assertFalse(s1.equals(diffSalary));
        Assert.assertFalse(s1.equals(nullSalary));
        Assert.assertEquals(s1.equals(sameAsStateSalary) && sameAsStateSalary.equals
                (yetAnotherSalary), s1.equals(yetAnotherSalary));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(s1.equals(sameAsStateSalary), s1.hashCode() == sameAsStateSalary.hashCode());
        Assert.assertEquals(s1.equals(diffSalary), s1.hashCode() == diffSalary.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = "Salary{salary=40000.0}";
        Assert.assertEquals(s1.toString(), tempStr);
    }

}