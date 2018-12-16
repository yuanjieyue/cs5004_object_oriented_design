package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractSecretaryTest {
    private Person name1;
    private WorkLoad basicWorkLoad;
    private Salary basicSalary;
    private VocationDays basicVocationDays;

    private ID id1;


    private Seniority seniority1;


    private Integer saIncreAmount;
    private Double bonusForPromotedToLegalSecretary;

    private AbstractSecretary secretary1;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Ashy", "Brandon");
        basicWorkLoad = new WorkLoad(40);
        basicSalary = new Salary(40000.0);
        basicVocationDays = new VocationDays(14);
        id1 = new ID("FFDJ77");
        seniority1 = new Seniority(5, 5, 2);
        bonusForPromotedToLegalSecretary = 500.0;

        secretary1 = new GeneralSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, bonusForPromotedToLegalSecretary);
    }

    @Test
    public void schedualMeeting() {
        String tempStr = new String("Let's schedual meeting!");
        Assert.assertEquals(secretary1.schedualMeeting(), tempStr);
    }
}