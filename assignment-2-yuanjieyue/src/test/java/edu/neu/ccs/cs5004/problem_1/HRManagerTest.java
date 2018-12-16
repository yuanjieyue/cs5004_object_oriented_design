package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HRManagerTest {

    private Person name1;
    private WorkLoad basicWorkLoad;
    private Salary basicSalary;
    private Salary salary2;
    private VocationDays basicVocationDays;
    private VocationDays vocationDays2;
    private ID id1;
    private Seniority seniority1;

    private Integer recruitNums;
    private Double bonusPerRecruitment;
    private Integer voIncreAmount;

    private HRManager HRManager1;
    private HRManager sameRefHRManger;
    private HRManager sameAsStateHRManager;
    private HRManager yetAnotherHRManager;
    private HRManager differentHRManager;
    private HRManager nullHRManager;

    @Before
    public void setUp() throws Exception {
        name1 = new Person("Brain", "Stark");
        basicWorkLoad = new WorkLoad(40);
        basicSalary = new Salary(40000.0);
        salary2= new Salary(50000.0);
        basicVocationDays = new VocationDays(14);
        vocationDays2 = new VocationDays(21);
        id1 = new ID("FFDJ75");

        seniority1 = new Seniority(10, 8, 20);
        recruitNums = 3;
        bonusPerRecruitment = 5000.0;
        voIncreAmount = 7;

        HRManager1 = new HRManager(name1, basicWorkLoad, basicSalary, basicVocationDays, id1,
                seniority1, recruitNums, bonusPerRecruitment, voIncreAmount);
        sameRefHRManger = HRManager1;
        sameAsStateHRManager = new HRManager(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1,
                seniority1, recruitNums, bonusPerRecruitment, voIncreAmount);
        yetAnotherHRManager = new HRManager(name1, basicWorkLoad, basicSalary, basicVocationDays,
                id1,
                seniority1, recruitNums, bonusPerRecruitment, voIncreAmount);
        differentHRManager = new HRManager(name1, basicWorkLoad, salary2, vocationDays2, id1,
                seniority1, recruitNums, bonusPerRecruitment, voIncreAmount);
    }


    @Test
    public void getRecruitNums() {
        Assert.assertEquals(HRManager1.getRecruitNums(), new Integer(3));
    }

    @Test
    public void getBonusPerRecruitment() {
        Assert.assertEquals(HRManager1.getBonusPerRecruitment(), new Double(5000));
    }

    @Test
    public void getVoIncreAmount() {
        Assert.assertEquals(HRManager1.getVoIncreAmount(), new Integer(7));
    }

    @Test
    public void huntTalents() {
        String tempStr = new String("Let's hunt talents!");
        Assert.assertEquals(HRManager1.huntTalents(), tempStr);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(HRManager1.equals(HRManager1));
        Assert.assertTrue(HRManager1.equals(sameRefHRManger));
        Assert.assertTrue(HRManager1.equals(sameAsStateHRManager));
        Assert.assertTrue(HRManager1.equals(yetAnotherHRManager));
        Assert.assertEquals(HRManager1.equals(sameAsStateHRManager) && sameAsStateHRManager
                .equals(yetAnotherHRManager), yetAnotherHRManager.equals(HRManager1));
        Assert.assertFalse(HRManager1.equals(nullHRManager));
        Assert.assertFalse(HRManager1.equals(differentHRManager));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(HRManager1.equals(sameAsStateHRManager), HRManager1.hashCode() ==
                sameAsStateHRManager.hashCode());
        Assert.assertEquals(HRManager1.equals(differentHRManager), HRManager1.hashCode() ==
                differentHRManager.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("HRManager{name=Person{first='Brain', last='Stark'}, " +
                "workLoad=WorkLoad{workLoad=40}, salary=Salary{salary=55000.0}, " +
                "vocationDays=VocationDays{vocationDays=21}, " +
                "id=ID{id='FFDJ75'}, seniority=Seniority{year=10, month=8, day=20}, " +
                "recruitNums=3, bonusPerRecruitment=5000.0, voIncreAmount=7}");
        Assert.assertEquals(HRManager1.toString(), tempStr);
    }
}
