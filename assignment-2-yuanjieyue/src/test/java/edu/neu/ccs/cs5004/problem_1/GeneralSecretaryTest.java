package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneralSecretaryTest {
    private Person name1;
    private WorkLoad basicWorkLoad;
    private Salary basicSalary;
    private Salary salary2;
    private VocationDays basicVocationDays;
    private VocationDays vocationDays2;
    private ID id1;

    private Seniority seniority1;
    private Double bonusForPromotedToLegalSecretary;

    private GeneralSecretary generalSecretary;
    private GeneralSecretary sameRefGeneralSecretary;
    private GeneralSecretary sameAsStateGeneralSecretary;
    private GeneralSecretary yetAnotherGeneralSecretary;
    private GeneralSecretary nullGeneralSecretary;
    private GeneralSecretary differentGeneralSecretary;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Ashy", "Brandon");
        basicWorkLoad = new WorkLoad(40);
        basicSalary = new Salary(40000.0);
        salary2= new Salary(50000.0);
        basicVocationDays = new VocationDays(14);
        vocationDays2 = new VocationDays(21);
        id1 = new ID("FFDJ77");
        seniority1 = new Seniority(5, 5, 2);
        bonusForPromotedToLegalSecretary = new Double(500);

        generalSecretary = new GeneralSecretary(name1, basicWorkLoad, basicSalary,
                basicVocationDays,
                id1, seniority1, bonusForPromotedToLegalSecretary);
        sameRefGeneralSecretary = generalSecretary;
        sameAsStateGeneralSecretary = new GeneralSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, bonusForPromotedToLegalSecretary);
        yetAnotherGeneralSecretary = new GeneralSecretary(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1, seniority1, bonusForPromotedToLegalSecretary);
        differentGeneralSecretary = new GeneralSecretary(name1, basicWorkLoad, salary2, vocationDays2,
                id1, seniority1, bonusForPromotedToLegalSecretary);
    }

    @Test
    public void getBonusForBeingPromotedToLegalSecretery() {
        Assert.assertEquals(generalSecretary.getBonusForBeingPromotedToLegalSecretery(), new
            Double(500));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(generalSecretary.equals(generalSecretary));
        Assert.assertTrue(generalSecretary.equals(sameRefGeneralSecretary));
        Assert.assertTrue(generalSecretary.equals(sameAsStateGeneralSecretary));
        Assert.assertNull(nullGeneralSecretary);
        Assert.assertTrue(generalSecretary.equals(yetAnotherGeneralSecretary));
        Assert.assertEquals(generalSecretary.equals(sameAsStateGeneralSecretary) &&
                sameAsStateGeneralSecretary.equals(yetAnotherGeneralSecretary),
                yetAnotherGeneralSecretary.equals(generalSecretary));
        Assert.assertFalse(generalSecretary.equals(differentGeneralSecretary));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(generalSecretary.equals(sameAsStateGeneralSecretary),
                generalSecretary.hashCode() == sameAsStateGeneralSecretary.hashCode());
        Assert.assertEquals(generalSecretary.equals(differentGeneralSecretary), generalSecretary
                .hashCode() == differentGeneralSecretary.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("GeneralSecretary{name=Person{first='Ashy', last='Brandon'}," +
                " workLoad=WorkLoad{workLoad=40}, salary=Salary{salary=40000.0}, " +
                "vocationDays=VocationDays{vocationDays=14}, " +
                "id=ID{id='FFDJ77'}, seniority=Seniority{year=5, month=5, day=2}, " +
                "bonusForBeingPromotedToLegalSecretery=500.0}");
        Assert.assertEquals(generalSecretary.toString(), tempStr);
    }
}