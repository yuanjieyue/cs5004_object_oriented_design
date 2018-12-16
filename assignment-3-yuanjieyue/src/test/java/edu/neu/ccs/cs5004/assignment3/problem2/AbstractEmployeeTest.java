package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractEmployeeTest {
  private Person name1;
  private Person name2;
  private Person name3;
  private Person name4;
  private Salary diffsalary;
  private VocationDays diffvocationDays;
  private ID id1;
  private ID id2;
  private ID id3;
  private ID id4;
  private Seniority seniority1;
  private Seniority seniority2;
  private Seniority seniority3;
  private Seniority seniority4;
  private Integer recruitNums;
  private Double extraSalary;
  private Integer extraVocationDays;
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
  private AbstractEmployee differentSalaryEmployee4;
  private AbstractEmployee addSalaryEmployee1;
  private AbstractEmployee addSalaryEmployee2;
  private AbstractEmployee addSalaryEmployee3;
  private AbstractEmployee addSalaryEmployee4;
  private AbstractEmployee differentVocationDaysEmployee1;
  private AbstractEmployee differentVocationDaysEmployee2;
  private AbstractEmployee differentVocationDaysEmployee3;
  private AbstractEmployee differentVocationDaysEmployee4;
  private AbstractEmployee addVocationDaysEmployee1;
  private AbstractEmployee addVocationDaysEmployee2;
  private AbstractEmployee addVocationDaysEmployee3;
  private AbstractEmployee addVocationDaysEmployee4;

  @Before
  public void setUp() throws Exception {
    name1 = new Person("John", "Kelly");
    name2 = new Person("Brain", "Stark");
    name3 = new Person("Ashy", "Brandon");
    name4 = new Person("Tally", "Knight");

    id1 = new ID("FFDJ75");
    id2 = new ID("FFDJ76");
    id3 = new ID("FFDJ77");
    id4 = new ID("FFDJ78");

    seniority1 = new Seniority(10, 8, 20);
    seniority2 = new Seniority(2, 3, 10);
    seniority3 = new Seniority(5, 5, 2);
    seniority4 = new Seniority(8, 2, 30);

    diffsalary = new Salary(50000.0);
    diffvocationDays = new VocationDays(7);
    recruitNums = 3;

    extraSalary = 1000.0;
    extraVocationDays = 10;

    employee1 = new Lawyer(name1, id1, seniority1);
    employee2 = new HRManager(name2, id2, seniority2, recruitNums);
    employee3 = new GeneralSecretary(name3, id3, seniority3);
    employee4 = new LegalSecretary(name4, id4, seniority4);

    sameRefEmployee = employee1;
    sameAsStateEmployee = new Lawyer(name1, id1, seniority1);
    yetAnotherEmployee = new Lawyer(name1, id1, seniority1);

    addSalaryEmployee1 = (Lawyer) employee1.addSalary(extraSalary);
    addSalaryEmployee2 = (HRManager) employee2.addSalary(extraSalary);
    addSalaryEmployee3 = (GeneralSecretary) employee3.addSalary(extraSalary);
    addSalaryEmployee4 = (LegalSecretary) employee4.addSalary(extraSalary);

    differentSalaryEmployee1 = new Lawyer(name1, id1, seniority1, diffsalary, HRManager.BASICVOCATIONDAYS);
    differentSalaryEmployee2 = new HRManager(name2, id2, seniority2, diffsalary, HRManager.BASICVOCATIONDAYS,
        recruitNums);
    differentSalaryEmployee3 = new GeneralSecretary(name3, id3, seniority3, diffsalary,
        HRManager.BASICVOCATIONDAYS);
    differentSalaryEmployee4 = new LegalSecretary(name4, id4, seniority4, diffsalary,
        HRManager.BASICVOCATIONDAYS);
    addVocationDaysEmployee1 = (Lawyer) employee1.addVocationDays(extraVocationDays);
    addVocationDaysEmployee2 = (HRManager) employee2.addVocationDays(extraVocationDays);
    addVocationDaysEmployee3 = (GeneralSecretary) employee3.addVocationDays(extraVocationDays);
    addVocationDaysEmployee4 = (LegalSecretary) employee4.addVocationDays(extraVocationDays);
    differentVocationDaysEmployee1 = new Lawyer(name1, id1, seniority1, HRManager.BASICSALARY,
        diffvocationDays);
    differentVocationDaysEmployee2 = new HRManager(name2, id2, seniority2, HRManager.BASICSALARY,
        diffvocationDays, recruitNums);
    differentVocationDaysEmployee3 = new GeneralSecretary(name3, id3, seniority3, HRManager
        .BASICSALARY, diffvocationDays);
    differentVocationDaysEmployee4 = new LegalSecretary(name4, id4, seniority4, HRManager
        .BASICSALARY, diffvocationDays);
  }

  @Test
  public void getName() {
    Assert.assertEquals(employee1.getName(), new Person("John", "Kelly"));
    Assert.assertEquals(employee2.getName(), new Person("Brain", "Stark"));
    Assert.assertEquals(employee3.getName(), new Person("Ashy", "Brandon"));
    Assert.assertEquals(employee4.getName(), new Person("Tally", "Knight"));
    Assert.assertEquals(addSalaryEmployee1.getName(), new Person("John", "Kelly"));
    Assert.assertEquals(addVocationDaysEmployee2.getName(), new Person("Brain", "Stark"));
  }

  @Test
  public void getWorkLoad() {
    Assert.assertEquals(employee1.getWorkLoad(), new WorkLoad(40));
    Assert.assertEquals(employee2.getWorkLoad(), new WorkLoad(40));
  }

  @Test
  public void getSalary() {
    Assert.assertEquals(employee1.getSalary(), new Salary(new Double(80000)));
    Assert.assertEquals(employee2.getSalary(), new Salary(new Double(55000)));
    Assert.assertEquals(employee3.getSalary(), new Salary(new Double(40000)));
    Assert.assertEquals(employee4.getSalary(), new Salary(new Double(50000)));
    Assert.assertEquals(addSalaryEmployee1.getSalary(), new Salary(new Double(81000)));
    Assert.assertEquals(addSalaryEmployee2.getSalary(), new Salary(new Double(56000)));
    Assert.assertEquals(addSalaryEmployee3.getSalary(), new Salary(new Double(41000)));
    Assert.assertEquals(addSalaryEmployee4.getSalary(), new Salary(new Double(51000)));
    Assert.assertEquals(differentSalaryEmployee1.getSalary(), new Salary(new Double(100000)));
    Assert.assertEquals(differentSalaryEmployee2.getSalary(), new Salary(new Double(65000)));
    Assert.assertEquals(differentSalaryEmployee3.getSalary(), new Salary(new Double(50000)));
    Assert.assertEquals(differentSalaryEmployee4.getSalary(), new Salary(new Double(60000)));
  }

  @Test
  public void getVocationDays() {
    Assert.assertEquals(employee1.getVocationDays(), new VocationDays(14));
    Assert.assertEquals(employee2.getVocationDays(), new VocationDays(21));
    Assert.assertEquals(employee3.getVocationDays(), new VocationDays(14));
    Assert.assertEquals(employee4.getVocationDays(), new VocationDays(14));
    Assert.assertEquals(differentVocationDaysEmployee1.getVocationDays(), new VocationDays(7));
    Assert.assertEquals(differentVocationDaysEmployee2.getVocationDays(), new VocationDays(14));
    Assert.assertEquals(differentVocationDaysEmployee3.getVocationDays(), new VocationDays(7));
    Assert.assertEquals(differentVocationDaysEmployee4.getVocationDays(), new VocationDays(7));
    Assert.assertEquals(addVocationDaysEmployee1.getVocationDays(), new VocationDays(24));
    Assert.assertEquals(addVocationDaysEmployee2.getVocationDays(), new VocationDays(31));
    Assert.assertEquals(addVocationDaysEmployee3.getVocationDays(), new VocationDays(24));
    Assert.assertEquals(addVocationDaysEmployee4.getVocationDays(), new VocationDays(24));

  }

  @Test
  public void getId() {
    Assert.assertEquals(employee1.getIdentity(), new ID("FFDJ75"));
    Assert.assertEquals(employee2.getIdentity(), new ID("FFDJ76"));
  }

  @Test
  public void getSeniority() {
    Assert.assertEquals(employee1.getSeniority(), new Seniority(10, 8, 20));
    Assert.assertEquals(employee4.getSeniority(), new Seniority(8, 2 ,30));
  }

  @Test
  public void name() {
    Assert.assertEquals(employee1.name(), new Person("John", "Kelly"));
    Assert.assertEquals(employee2.name(), new Person("Brain", "Stark"));
    Assert.assertEquals(employee3.name(), new Person("Ashy", "Brandon"));
    Assert.assertEquals(employee4.name(), new Person("Tally", "Knight"));
    Assert.assertEquals(addSalaryEmployee1.name(), new Person("John", "Kelly"));
    Assert.assertEquals(addVocationDaysEmployee2.name(), new Person("Brain", "Stark"));
  }

  @Test
  public void workLoad() {
    Assert.assertEquals(employee1.workLoad(), new WorkLoad(40));
    Assert.assertEquals(employee2.workLoad(), new WorkLoad(40));
  }

  @Test
  public void vocationDays() {
    Assert.assertEquals(employee1.vocationDays(), new VocationDays(14));
    Assert.assertEquals(employee2.vocationDays(), new VocationDays(21));
    Assert.assertEquals(employee3.vocationDays(), new VocationDays(14));
    Assert.assertEquals(employee4.vocationDays(), new VocationDays(14));
    Assert.assertEquals(differentVocationDaysEmployee1.vocationDays(), new VocationDays(7));
    Assert.assertEquals(differentVocationDaysEmployee2.vocationDays(), new VocationDays(14));
    Assert.assertEquals(differentVocationDaysEmployee3.vocationDays(), new VocationDays(7));
    Assert.assertEquals(differentVocationDaysEmployee4.vocationDays(), new VocationDays(7));
    Assert.assertEquals(addVocationDaysEmployee1.vocationDays(), new VocationDays(24));
    Assert.assertEquals(addVocationDaysEmployee2.vocationDays(), new VocationDays(31));
    Assert.assertEquals(addVocationDaysEmployee3.vocationDays(), new VocationDays(24));
    Assert.assertEquals(addVocationDaysEmployee4.vocationDays(), new VocationDays(24));

  }

  @Test
  public void identity() {
    Assert.assertEquals(employee1.identity(), new ID("FFDJ75"));
    Assert.assertEquals(employee2.identity(), new ID("FFDJ76"));
  }

  @Test
  public void seniority() {
    Assert.assertEquals(employee1.seniority(), new Seniority(10, 8, 20));
    Assert.assertEquals(employee4.seniority(), new Seniority(8, 2 ,30));
  }

  @Test
  public void addSalary() {
    Assert.assertEquals(addSalaryEmployee1,
        new Lawyer(name1, id1, seniority1, new Salary((employee1.getSalary().getSalary() +
            extraSalary) / HRManager.EXTRASALARYRATEOFLAWYER), HRManager.BASICVOCATIONDAYS));
  }

  @Test
  public void addVocationDays() {
    Assert.assertEquals(addVocationDaysEmployee2, new HRManager(name2, id2, seniority2, HRManager
        .BASICSALARY, new VocationDays(employee2.getVocationDays().getVocationDays() - HRManager
        .VOINCREOFHR + extraVocationDays), recruitNums));
  }

  @Test
  public void requestSalaryRaise() {
    Assert.assertEquals(employee1.requestSalaryRaise(500.0), new Lawyer(name1, id1, seniority1,
        new Salary(40250.0), HRManager.BASICVOCATIONDAYS));
    Assert.assertEquals(employee2.requestSalaryRaise(700.0), new HRManager(name2, id2,
        seniority2, new Salary(40700.0), HRManager.BASICVOCATIONDAYS, recruitNums));
    Assert.assertEquals(employee3.requestSalaryRaise(1200.0), employee3);
    Assert.assertEquals(employee4.requestSalaryRaise(600.0), new LegalSecretary(name4, id4,
        seniority4, new Salary(40600.0), HRManager.BASICVOCATIONDAYS));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(employee1.equals(employee1));
    Assert.assertTrue(employee1.equals(sameRefEmployee));
    Assert.assertTrue(employee1.equals(sameAsStateEmployee));
    Assert.assertFalse(employee1.equals(addSalaryEmployee1));
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

}