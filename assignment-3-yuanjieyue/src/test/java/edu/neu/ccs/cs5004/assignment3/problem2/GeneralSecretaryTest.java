package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneralSecretaryTest {
    private Person name1;
    private ID id1;
    private Seniority seniority1;
    private Salary diffSalary;
    private GeneralSecretary generalSecretary;
    private GeneralSecretary generalSecretary2;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Ashy", "Brandon");
        id1 = new ID("FFDJ77");
        seniority1 = new Seniority(5, 5, 2);
        diffSalary = new Salary(30000.0);
        generalSecretary = new GeneralSecretary(name1, id1, seniority1);
        generalSecretary2 = new GeneralSecretary(name1, id1, seniority1, diffSalary,
            HRManager.BASICVOCATIONDAYS);
    }

    @Test
    public void testToString() {
        String tempStr = new String("GeneralSecretary{name=Person{first='Ashy', "
            + "last='Brandon'}, " + "id=ID{id='FFDJ77'}, seniority=Seniority{year=5, month=5, "
            + "day=2}," + " salary=Salary{salary=40000.0}, "
            + "vocationDays=VocationDays{vocationDays=14}, workLoad=WorkLoad{workLoad=40}}");
        String tempStr2 = new String("GeneralSecretary{name=Person{first='Ashy', "
            + "last='Brandon'}, " + "id=ID{id='FFDJ77'}, seniority=Seniority{year=5, month=5, "
            + "day=2}," + " salary=Salary{salary=30000.0}, "
            + "vocationDays=VocationDays{vocationDays=14}, workLoad=WorkLoad{workLoad=40}}");
        Assert.assertEquals(generalSecretary.toString(), tempStr);
        Assert.assertEquals(generalSecretary2.toString(), tempStr2);
    }
}