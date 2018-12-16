package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LegalSecretaryTest {

    private Person name1;
    private WorkLoad basicWorkLoad;
    private Salary basicSalary;
    private Salary salary2;
    private VocationDays basicVocationDays;
    private VocationDays vocationDays2;
    private ID id1;

    private Seniority seniority1;

    private Double saIncreAmount;
    private Double bonusForPromotedToLegalSecretary;

    private LegalSecretary legalSecretary1;
    private LegalSecretary sameRefLegalSecretary;
    private LegalSecretary sameAsStateLegalSecretary;
    private LegalSecretary yetAnotherLegalSecretary;
    private LegalSecretary nullLegalSecretary;
    private LegalSecretary differentLegalSecretary;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Tally", "Knight");
        basicWorkLoad = new WorkLoad(40);
        basicSalary = new Salary(40000.0);
        salary2= new Salary(50000.0);
        basicVocationDays = new VocationDays(14);
        vocationDays2 = new VocationDays(21);
        id1 = new ID("FFDJ78");
        seniority1 = new Seniority(8, 2, 30);
        saIncreAmount = 10000.0;

        legalSecretary1 = new LegalSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, saIncreAmount);

        sameRefLegalSecretary = legalSecretary1;
        sameAsStateLegalSecretary = new LegalSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, saIncreAmount);
        yetAnotherLegalSecretary = new LegalSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, saIncreAmount);
        differentLegalSecretary = new LegalSecretary(name1, basicWorkLoad, salary2, vocationDays2,
                id1, seniority1, saIncreAmount);
    }

    @Test
    public void getSaIncreAmount() {
        Assert.assertEquals(legalSecretary1.getSaIncreAmount(), new Double(10000));
    }

    @Test
    public void prepareLegalDocuments() {
        String tempStr = new String("Let's prepare legal documents!");
        Assert.assertEquals(legalSecretary1.prepareLegalDocuments(), tempStr);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(legalSecretary1.equals(legalSecretary1));
        Assert.assertTrue(legalSecretary1.equals(sameRefLegalSecretary));
        Assert.assertTrue(legalSecretary1.equals(sameAsStateLegalSecretary));
        Assert.assertFalse(legalSecretary1.equals(differentLegalSecretary));
        Assert.assertEquals(legalSecretary1.equals(sameAsStateLegalSecretary) &&
                sameAsStateLegalSecretary.equals(yetAnotherLegalSecretary),
                yetAnotherLegalSecretary.equals(legalSecretary1));
        Assert.assertFalse(legalSecretary1.equals(nullLegalSecretary));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(legalSecretary1.equals(sameAsStateLegalSecretary),
                legalSecretary1.hashCode() == sameAsStateLegalSecretary.hashCode());
        Assert.assertEquals(legalSecretary1.equals(differentLegalSecretary),
                legalSecretary1.hashCode() == differentLegalSecretary.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("LegalSecretary{name=Person{first='Tally', " +
                "last='Knight'}," +
                " workLoad=WorkLoad{workLoad=40}, salary=Salary{salary=50000}, " +
                "vocationDays=VocationDays{vocationDays=14}, " +
                "id=ID{id='FFDJ78'}, seniority=Seniority{year=8, month=2, day=30}, " +
                "saIncreAmount=10000}");
    }
}