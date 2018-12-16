package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractEmployeeTest {
    private Person name;
    private Person name2;
    private Person name3;
    private Person name4;
    private WorkLoad basicWorkLoad;
    private Salary basicSalary;
    private Salary salary2;
    private VocationDays basicVocationDays;
    private VocationDays vocationDays2;
    private ID id1;
    private ID id2;
    private ID id3;
    private ID id4;
    private Seniority seniority1;
    private Seniority seniority2;
    private Seniority seniority3;
    private Seniority seniority4;
    private Double saIncreFactor;
    private Integer recruitNums;
    private Double bonusPerRecruitment;
    private Integer voIncreAmount;
    private Double saIncreAmount;
    private Double bonusForPromotedToLegalSecretary;

    private Integer addSalary;
    private Integer addVocationDays;

    private AbstractEmployee employee1;
    private AbstractEmployee employee2;
    private AbstractEmployee employee3;
    private AbstractEmployee employee4;
    private AbstractEmployee sameRefEmployee;
    private AbstractEmployee sameAsStateEmployee;
    private AbstractEmployee yetAnotherEmployee;
    private AbstractEmployee nullEmployee;
    private AbstractEmployee differentSalaryEmployee1;
    private AbstractEmployee differentSalaryEmployee2;
    private AbstractEmployee differentSalaryEmployee3;
    private AbstractEmployee differentVocationDaysEmployee1;
    private AbstractEmployee differentVocationDaysEmployee2;
    private AbstractEmployee differentVocationDaysEmployee3;

    @Before
    public void setUp() throws Exception {
        name = new Person("John", "Kelly");
        name2= new Person("Brain", "Stark");
        name3= new Person("Ashy", "Brandon");
        name4 = new Person("Tally", "Knight");
        basicWorkLoad = new WorkLoad(40);
        basicSalary = new Salary(new Double(40000));
        salary2= new Salary(new Double(50000));
        basicVocationDays = new VocationDays(14);
        vocationDays2 = new VocationDays(21);
        id1 = new ID("FFDJ75");
        id2 = new ID("FFDJ76");
        id3 = new ID("FFDJ77");
        id4 = new ID("FFDJ78");
        seniority1 = new Seniority(10, 8, 20);
        seniority2 = new Seniority(2, 3, 10);
        seniority3 = new Seniority(5, 5, 2);
        seniority4 = new Seniority(8, 2, 30);
        saIncreFactor = 2.0;
        recruitNums = 3;
        bonusPerRecruitment = 5000.0;
        voIncreAmount = 7;
        saIncreAmount = 10000.0;
        bonusForPromotedToLegalSecretary = 500.0;

        addSalary = 1000;
        addVocationDays = 10;

        employee1 = new Lawyer(name, basicWorkLoad, basicSalary, basicVocationDays, id1, seniority1,
                saIncreFactor);
        employee2 = new HRManager(name, basicWorkLoad, basicSalary, basicVocationDays, id2,
                seniority2, recruitNums, bonusPerRecruitment, voIncreAmount);
        employee3 = new GeneralSecretary(name, basicWorkLoad, basicSalary, basicVocationDays,
                id3, seniority3, bonusForPromotedToLegalSecretary);
        employee4 = new LegalSecretary(name, basicWorkLoad, basicSalary, basicVocationDays,
                id3, seniority3, saIncreAmount);

        sameRefEmployee = employee1;
        sameAsStateEmployee = new Lawyer(name, basicWorkLoad, basicSalary, basicVocationDays,
            id1, seniority1,
                saIncreFactor);
        yetAnotherEmployee = new Lawyer(name, basicWorkLoad, basicSalary, basicVocationDays,
            id1, seniority1,
                saIncreFactor);
        differentSalaryEmployee1 = (Lawyer)employee1.addSalary(addSalary);
        differentSalaryEmployee2 = (HRManager)employee2.addSalary(addSalary);
        differentSalaryEmployee3 = (LegalSecretary)employee4.addSalary(addSalary);
        differentVocationDaysEmployee1 = (Lawyer)employee1.addVocationDays(addVocationDays);
        differentVocationDaysEmployee2 = (HRManager)employee2.addVocationDays(addVocationDays);
        differentVocationDaysEmployee3 = (LegalSecretary)employee4.addVocationDays(addVocationDays);
    }

    @Test
    public void getName() {
        Assert.assertEquals(employee1.getName(), new Person("John", "Kelly"));
    }

    @Test
    public void getWorkLoad() {
        Assert.assertEquals(employee1.getWorkLoad(), new WorkLoad(40));
    }

    @Test
    public void getSalary() {
        Assert.assertEquals(employee1.getSalary(), new Salary(new Double(80000)));
        Assert.assertEquals(employee2.getSalary(), new Salary(new Double(55000)));
        Assert.assertEquals(employee3.getSalary(), new Salary(new Double(40000)));
        Assert.assertEquals(employee4.getSalary(), new Salary(new Double(50000)));
        Assert.assertEquals(differentSalaryEmployee1.getSalary(), new Salary(new Double(81000)));
        Assert.assertEquals(differentSalaryEmployee2.getSalary(), new Salary(new Double(56000)));
        Assert.assertEquals(differentSalaryEmployee3.getSalary(), new Salary(new Double(51000)));
    }

    @Test
    public void getVocationDays() {
        Assert.assertEquals(employee1.getVocationDays(), new VocationDays(14));
        Assert.assertEquals(employee2.getVocationDays(), new VocationDays(21));
        Assert.assertEquals(employee3.getVocationDays(), new VocationDays(14));
        Assert.assertEquals(employee4.getVocationDays(), new VocationDays(14));
        Assert.assertEquals(differentVocationDaysEmployee1.getVocationDays(), new VocationDays(24));
        Assert.assertEquals(differentVocationDaysEmployee2.getVocationDays(), new VocationDays(31));
        Assert.assertEquals(differentVocationDaysEmployee3.getVocationDays(), new VocationDays(24));

    }

    @Test
    public void getId() {
        Assert.assertEquals(employee1.getId(), new ID("FFDJ75"));
    }

    @Test
    public void getSeniority() {
        Assert.assertEquals(employee1.getSeniority(), new Seniority(10, 8, 20));
    }

    @Test
    public void addSalary() {
        Assert.assertEquals(employee1.addSalary(addSalary), differentSalaryEmployee1);
    }

    @Test
    public void addVocationDays() {
        Assert.assertEquals(employee1.addVocationDays(addVocationDays),
            differentVocationDaysEmployee1);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(employee1.equals(employee1));
        Assert.assertTrue(employee1.equals(sameRefEmployee));
        Assert.assertTrue(employee1.equals(sameAsStateEmployee));
        Assert.assertFalse(employee1.equals(differentSalaryEmployee1));
        Assert.assertFalse(employee1.equals(nullEmployee));
        Assert.assertFalse(employee1.equals(employee3));
        Assert.assertFalse(employee1.equals(employee2));
        Assert.assertEquals(employee1.equals(sameAsStateEmployee) && sameAsStateEmployee
            .equals(yetAnotherEmployee), yetAnotherEmployee.equals(employee1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(employee1.equals(sameAsStateEmployee), employee1.hashCode() ==
                sameAsStateEmployee.hashCode());
        Assert.assertEquals(employee1.equals(differentVocationDaysEmployee1), employee1.
            hashCode()
                == differentVocationDaysEmployee1.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("GeneralSecretary{name=Person{first='John', last='Kelly'}, workLoad=WorkLoad{workLoad=40}, salary=Salary{salary=40000.0}, vocationDays=VocationDays{vocationDays=14}, id=ID{id='FFDJ77'}, seniority=Seniority{year=5, month=5, day=2}, bonusForBeingPromotedToLegalSecretery=500.0}");

        Assert.assertEquals(employee3.toString(), tempStr);
    }
}