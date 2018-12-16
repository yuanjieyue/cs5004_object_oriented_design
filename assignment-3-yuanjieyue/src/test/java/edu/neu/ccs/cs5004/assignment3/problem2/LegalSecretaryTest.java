package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LegalSecretaryTest {

    private Person name1;
    private ID id1;
    private Seniority seniority1;
    private Salary diffSalary;
    private LegalSecretary legalSecretary1;
    private LegalSecretary legalSecretary2;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Tally", "Knight");
        id1 = new ID("FFDJ78");
        seniority1 = new Seniority(8, 2, 30);
        diffSalary = new Salary(30000.0);
        legalSecretary1 = new LegalSecretary(name1, id1, seniority1);
        legalSecretary2 = new LegalSecretary(name1, id1, seniority1, diffSalary,
            HRManager.BASICVOCATIONDAYS);
    }

    @Test
    public void prepareLegalDocuments() {
        String tempStr = new String("Let's prepare legal documents!");
        Assert.assertEquals(legalSecretary1.prepareLegalDocuments(), tempStr);
        Assert.assertEquals(legalSecretary2.prepareLegalDocuments(), tempStr);
    }

    @Test
    public void testToString() {
        String tempStr1 = new String("LegalSecretary{name=Person{first='Tally', "
            + "last='Knight'}, id=ID{id='FFDJ78'}, seniority=Seniority{year=8, "
            + "month=2, day=30}, salary=Salary{salary=50000.0}, "
            + "vocationDays=VocationDays{vocationDays=14}, "
            + "workLoad=WorkLoad{workLoad=40}}");
        String tempStr2 = new String("LegalSecretary{name=Person{first='Tally', "
            + "last='Knight'}, id=ID{id='FFDJ78'}, seniority=Seniority{year=8, "
            + "month=2, day=30}, salary=Salary{salary=40000.0}, "
            + "vocationDays=VocationDays{vocationDays=14}, "
            + "workLoad=WorkLoad{workLoad=40}}");
        Assert.assertEquals(legalSecretary1.toString(), tempStr1);
        Assert.assertEquals(legalSecretary2.toString(), tempStr2);
    }
}