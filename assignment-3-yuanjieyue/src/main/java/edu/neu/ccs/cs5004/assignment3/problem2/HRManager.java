package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;
/**
 * Represents a HR manager.
 */
public class HRManager extends AbstractEmployee implements IHRManager {

  static final Salary BASICSALARY = new Salary(40000.0);
  static final VocationDays BASICVOCATIONDAYS = new VocationDays(14);
  static final Integer EXTRASALARYRATEOFLAWYER = 2;
  static final Double EXTRASALARYAMOUNTOFLEGALSECRETARY = 10000.0;
  static final Double BONUSPERRECRUITMENTOFHR = 5000.0;
  static final Integer VOINCREOFHR = 7;

  private Integer recruitNums;

  /**
   * Reply to the request of raising salary from the employees.
   *
   * @param amount the amount of salary that the employee requested
   * @return "Yes" if the granted, otherwise "No"
   */
  static String replyToSalaryRaise(Double amount) {
    if (amount <= 1000) {
      return "Yes";
    }
    return "No";
  }

  /**
   * Raise the Salary of the employee{@code e} by a specific amount{@code amount}.
   *
   * @param e the employee whose salary is going to be raised
   * @param amount the amount of salary is going to be raised
   * @return the employee with the salary updated
   */
  static Employee raiseSalary(Employee e, Double amount) {
    if (e instanceof Lawyer) {
      Lawyer lawyer = (Lawyer) e;
      return new Lawyer(lawyer.getName(), lawyer.getIdentity(), lawyer.getSeniority(),
          new Salary((lawyer.getSalary().getSalary() + amount) / HRManager.EXTRASALARYRATEOFLAWYER)
          , lawyer.getVocationDays());
    } else if (e instanceof HRManager) {
      HRManager hRManager = (HRManager) e;
      return new HRManager(hRManager.getName(), hRManager.getIdentity(), hRManager.getSeniority(),
          new Salary(hRManager.getSalary().getSalary() - HRManager.BONUSPERRECRUITMENTOFHR
              * ((HRManager) e).getRecruitNums() + amount), new VocationDays(hRManager
          .getVocationDays().getVocationDays() - HRManager.VOINCREOFHR),
          hRManager.getRecruitNums());
    } else if (e instanceof GeneralSecretary) {
      GeneralSecretary generalSecretary = (GeneralSecretary) e;
      return new GeneralSecretary(generalSecretary.getName(), generalSecretary.getIdentity(),
          generalSecretary.getSeniority(), new Salary(generalSecretary.getSalary().getSalary()
          + amount), generalSecretary.getVocationDays());
    } else if (e instanceof LegalSecretary) {
      LegalSecretary legalSecretary = (LegalSecretary) e;
      return new LegalSecretary(legalSecretary.getName(), legalSecretary.getIdentity(),
          legalSecretary.getSeniority(), new Salary(legalSecretary.getSalary().getSalary()
          - HRManager.EXTRASALARYAMOUNTOFLEGALSECRETARY + amount),
          legalSecretary.getVocationDays());
    }
    return e;
  }

  /**
   * Creates a HR manager with his name, identity, seniority, recruitment numbers.
   *
   * @param name                the name of the HR manager
   * @param identity                  the identity of the HR manager
   * @param seniority           the seniority of the HR manager
   * @param recruitNums         the recruitment number of the HR manager
   */
  public HRManager(Person name, ID identity, Seniority seniority, Integer recruitNums) {
    super(name, identity, seniority);
    this.recruitNums = recruitNums;
  }

  /**
   * Create a new hr manager who has differ salary and vocation days, with his name, id and
   * seniority.
   *
   * @param name         the name of the hr
   * @param identity     the id of the hr
   * @param seniority    the seniority of the hr
   * @param salary       the salary of the hr
   * @param vocationDays the vocation days of the hr
   * @param recruitNums  the recruitment number of hr
   */
  HRManager(Person name, ID identity, Seniority seniority, Salary salary, VocationDays
      vocationDays, Integer recruitNums) {
    super(name, identity, seniority, salary, vocationDays);
    this.recruitNums = recruitNums;
  }

  /**
   * Getter for property 'recruitNums'.
   *
   * @return the recruitment numbers of talents
   */
  public Integer getRecruitNums() {
    return recruitNums;
  }

  @Override
  Salary getSalary() {
    return new Salary(super.getSalary().getSalary() + BONUSPERRECRUITMENTOFHR * recruitNums);
  }

  @Override
  public VocationDays getVocationDays() {
    return new VocationDays(super.getVocationDays().getVocationDays() + VOINCREOFHR);
  }

  @Override
  public Integer recruitNums() {
    return getRecruitNums();
  }

  /**
   * Hunt talents.
   *
   * @return a string
   */
  public String huntTalents() {
    return "Let's hunt talents!";
  }

  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new HRManager(this.getName(), this.getIdentity(), this.getSeniority(),
        new Salary(this.getSalary().getSalary() - BONUSPERRECRUITMENTOFHR * recruitNums),
        new VocationDays(newVocationDays.getVocationDays() - VOINCREOFHR),this.recruitNums);
  }

  @Override
  protected AbstractEmployee employeeCopyFactory(Double extraSalary) {
    return new HRManager(this.getName(), this.getIdentity(), this.getSeniority(),
        new Salary(this.getSalary().getSalary() - BONUSPERRECRUITMENTOFHR * this.getRecruitNums()
            + extraSalary), new VocationDays(this.getVocationDays().getVocationDays()
        - VOINCREOFHR), this.getRecruitNums());
  }

  @Override
  public LegalSecretary promoteGeneralToLegal(GeneralSecretary generalSecretary) {
    return new LegalSecretary(generalSecretary.getName(), generalSecretary.getIdentity(),
        generalSecretary.getSeniority(), generalSecretary.getSalary(),
        generalSecretary.getVocationDays());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    HRManager hrManager = (HRManager) obj;
    return Objects.equals(getRecruitNums(), hrManager.getRecruitNums());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getRecruitNums());
  }

  @Override
  public String toString() {
    return "HRManager{" + "name=" + this.getName()
        + ", id=" + this.getIdentity() + ", seniority=" + this.getSeniority()
        + ", salary=" + this.getSalary() + ", vocationDays=" + this.getVocationDays()
        + ", workLoad=" + this.getWorkLoad() + ", recruitNums=" + recruitNums + '}';
  }
}
