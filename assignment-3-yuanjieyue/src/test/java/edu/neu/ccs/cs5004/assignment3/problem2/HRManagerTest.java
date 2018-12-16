package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HRManagerTest {

  private Person name1;
  private Person name2;
  private Person name3;
  private Person name4;
  private ID id1;
  private ID id2;
  private ID id3;
  private ID id4;
  private Seniority seniority1;
  private Seniority seniority2;
  private Seniority seniority3;
  private Seniority seniority4;
  private Salary diffsalary;
  private VocationDays diffvocationDays;
  private Integer recruitNums;

  private Lawyer employee1;
  private HRManager employee2;
  private GeneralSecretary employee3;
  private LegalSecretary employee4;
  private Lawyer differentSalaryEmployee1;
  private HRManager differentSalaryEmployee2;
  private GeneralSecretary differentSalaryEmployee3;
  private LegalSecretary differentSalaryEmployee4;
  private HRManager differentVocationDaysEmployee2;

  private HRManager sameRefHRManger;
  private HRManager sameAsStateHRManager;
  private HRManager yetAnotherHRManager;
  private HRManager nullHRManager;
  private Employee[] employees;
  private Double[] amounts;


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

    employee1 = new Lawyer(name1, id1, seniority1);
    employee2 = new HRManager(name2, id2, seniority2, recruitNums);
    employee3 = new GeneralSecretary(name3, id3, seniority3);
    employee4 = new LegalSecretary(name4, id4, seniority4);

    sameRefHRManger = employee2;
    sameAsStateHRManager = new HRManager(name2, id2, seniority2, recruitNums);
    yetAnotherHRManager = new HRManager(name2, id2, seniority2, recruitNums);

    differentSalaryEmployee1 = new Lawyer(name1, id1, seniority1, diffsalary,
        HRManager.BASICVOCATIONDAYS);
    differentSalaryEmployee2 = new HRManager(name2, id2, seniority2, diffsalary,
        HRManager.BASICVOCATIONDAYS,
        recruitNums);
    differentSalaryEmployee3 = new GeneralSecretary(name3, id3, seniority3, diffsalary,
        HRManager.BASICVOCATIONDAYS);
    differentSalaryEmployee4 = new LegalSecretary(name4, id4, seniority4, diffsalary,
        HRManager.BASICVOCATIONDAYS);
    differentVocationDaysEmployee2 = new HRManager(name2, id2, seniority2, HRManager.BASICSALARY,
        diffvocationDays, recruitNums);

    employees = new Employee[]{employee1, employee2, employee3, employee4};
    amounts = new Double[]{500.0, 600.0, 1200.0, 1000.0};
  }

  @Test
  public void staticGetSalary() {
    Assert.assertEquals(IHRManager.getSalary(employee1), new Salary(80000.0));
    Assert.assertEquals(IHRManager.getSalary(employee2), new Salary(55000.0));
    Assert.assertEquals(IHRManager.getSalary(employee3), new Salary(40000.0));
    Assert.assertEquals(IHRManager.getSalary(employee4), new Salary(50000.0));
    Assert.assertEquals(IHRManager.getSalary(differentSalaryEmployee1), new Salary(100000.0));
    Assert.assertEquals(IHRManager.getSalary(differentSalaryEmployee2), new Salary(65000.0));
    Assert.assertEquals(IHRManager.getSalary(differentSalaryEmployee3), new Salary(50000.0));
    Assert.assertEquals(IHRManager.getSalary(differentSalaryEmployee4), new Salary(60000.0));
  }

  @Test
  public void staticGetVocationDays() {
    Assert.assertEquals(IHRManager.getVocationDays(employee1), new VocationDays(14));
    Assert.assertEquals(IHRManager.getVocationDays(employee2), new VocationDays(21));
    Assert.assertEquals(IHRManager.getVocationDays(employee3), new VocationDays(14));
    Assert.assertEquals(IHRManager.getVocationDays(employee4), new VocationDays(14));
    Assert.assertEquals(IHRManager.getVocationDays(differentVocationDaysEmployee2), new
        VocationDays(14));
  }

  @Test
  public void replyToSalaryRaise() {
    Assert.assertEquals(HRManager.replyToSalaryRaise(200.0), new String("Yes"));
    Assert.assertEquals(HRManager.replyToSalaryRaise(1200.0), new String("No"));
  }

  @Test
  public void raiseSalary() {
    Assert.assertEquals(HRManager.raiseSalary(employee1, 400.0), new Lawyer(
        name1, id1, seniority1, new Salary(40200.0), new VocationDays(14)));
    Assert.assertEquals(HRManager.raiseSalary(employee2, 400.0), new HRManager(
        name2, id2, seniority2, new Salary(40400.0), new VocationDays(14), recruitNums));
    Assert.assertEquals(HRManager.raiseSalary(employee3, 400.0), new GeneralSecretary(
        name3, id3, seniority3, new Salary(40400.0), new VocationDays(14)));
    Assert.assertEquals(HRManager.raiseSalary(employee4, 400.0), new LegalSecretary(
        name4, id4, seniority4, new Salary(40400.0), new VocationDays(14)));
  }

  @Test
  public void requestSalaryRaise() {
    Employee[] temp = IHRManager.requestSalaryRaise(employees, amounts);
    Employee[] target = new Employee[]{
        (Lawyer)employee1.addSalary(500.0), (HRManager)employee2.addSalary(600.0),
        employee3, employee4.addSalary(1000.0)};
    for (int i = 0; i < employees.length; i++) {
      Assert.assertEquals(temp[i], target[i]);
    }
  }

  @Test
  public void getRecruitNums() {
    Assert.assertEquals(employee2.getRecruitNums(), new Integer(3));
  }

  @Test
  public void getSalary() {
    Assert.assertEquals(employee2.getSalary(), new Salary(55000.0));
    Assert.assertEquals(differentSalaryEmployee2.getSalary(), new Salary(65000.0));
  }

  @Test
  public void getVocationDays() {
    Assert.assertEquals(employee2.getVocationDays(), new VocationDays(21));
    Assert.assertEquals(differentVocationDaysEmployee2.getVocationDays(), new VocationDays(14));
  }

  @Test
  public void promoteGeneralToLegal() {
    Assert.assertEquals(employee2.promoteGeneralToLegal(employee3), new LegalSecretary(name3,
        id3, seniority3));
    Assert.assertEquals(differentSalaryEmployee2.promoteGeneralToLegal(employee3),
        new LegalSecretary(name3, id3, seniority3, employee3.getSalary(),
            employee3.getVocationDays()));
  }

  @Test
  public void huntTalents() {
    String tempStr = new String("Let's hunt talents!");
    Assert.assertEquals(employee2.huntTalents(), tempStr);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(employee2.equals(employee2));
    Assert.assertTrue(employee2.equals(sameRefHRManger));
    Assert.assertTrue(employee2.equals(sameAsStateHRManager));
    Assert.assertTrue(employee2.equals(yetAnotherHRManager));
    Assert.assertEquals(employee2.equals(sameAsStateHRManager) && sameAsStateHRManager
        .equals(yetAnotherHRManager), yetAnotherHRManager.equals(employee2));
    Assert.assertFalse(employee2.equals(nullHRManager));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(employee2.equals(sameAsStateHRManager), employee2.hashCode() ==
        sameAsStateHRManager.hashCode());
    Assert.assertEquals(employee2.equals(differentSalaryEmployee2), employee2.hashCode() ==
        differentSalaryEmployee2.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("HRManager{name=Person{first='Brain', last='Stark'}, " +
        "id=ID{id='FFDJ76'}, seniority=Seniority{year=2, month=3, day=10}, "
        + "salary=Salary{salary=65000.0}, vocationDays=VocationDays{vocationDays=21}, "
        + "workLoad=WorkLoad{workLoad=40}, recruitNums=3}");
    Assert.assertEquals(differentSalaryEmployee2.toString(), tempStr);
  }
}
