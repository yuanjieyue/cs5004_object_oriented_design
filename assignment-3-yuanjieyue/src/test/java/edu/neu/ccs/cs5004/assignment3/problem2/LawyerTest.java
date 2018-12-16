package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LawyerTest {
    private Person name;
    private Person name2;
    private ID id = new ID("FFDJ75");
    private Seniority seniority;
    private Salary diffSalary;
    private Double extraAmount;
    private Lawyer lawyer;
    private Lawyer lawyer2;

    @Before
    public void setUp() throws Exception {
        name = new Person("John", "Kelly");
        id = new ID("FFDJ75");
        seniority = new Seniority(10, 8, 20);
        diffSalary = new Salary(30000.0);
        extraAmount = 1900.0;
        lawyer = new Lawyer(name, id, seniority);
        lawyer2 = new Lawyer(name, id, seniority, diffSalary, HRManager.BASICVOCATIONDAYS);
    }

    @Test
    public void getSalary() {
        Assert.assertEquals(lawyer.getSalary(), new Salary(80000.0));
        Assert.assertEquals(lawyer2.getSalary(), new Salary(60000.0));
        Assert.assertEquals(((Lawyer)lawyer.addSalary(extraAmount)).getSalary(),
            new Salary(81900.0));
        Assert.assertEquals(((Lawyer)lawyer2.addSalary(extraAmount)).getSalary(),
            new Salary(61900.0));
    }

    @Test
    public void sue() {
        String tempStr = new String("Let's sue!");
        Assert.assertEquals(lawyer.sue(), tempStr);
    }

    @Test
    public void testToString() {
        String tempStr = new String("Layer{name=Person{first='John', "
            + "last='Kelly'}ID{id='FFDJ75'}, seniority=Seniority{year=10, month=8, day=20}, "
            + "salary=Salary{salary=80000.0}, vocationDays=VocationDays{vocationDays=14}, id=, "
            + "workLoad=WorkLoad{workLoad=40}}");
        Assert.assertEquals(lawyer.toString(), tempStr);
    }
}