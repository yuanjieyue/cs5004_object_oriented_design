package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents a HR manager.
 */
public class HRManager extends AbstractEmployee {
  private Integer recruitNums;
  private Double bonusPerRecruitment;
  private Integer voIncreAmount;

  /**
   * Creates a HR manager with his name, workLoad, salary, vocation days, identity, seniority,
   * recruitment numbers, bonus per recruitment and vocation days increment over the
   * basic vocation days.
   *
   * @param name                the name of the HR manager
   * @param workLoad            the workload of the HR manager per week
   * @param salary              the salary of the HR manager per year
   * @param vocationDays        the vocation days of the HR manager per year
   * @param identity                  the identity of the HR manager
   * @param seniority           the seniority of the HR manager
   * @param recruitNums         the recruitment number of the HR manager
   * @param bonusPerRecruitment the bonus for recruit one talent of the HR manager
   * @param voIncreAmount       the increment days on the vocation days of the HR manager
   */
  public HRManager(Person name, WorkLoad workLoad, Salary salary, VocationDays vocationDays, ID
      identity, Seniority seniority, Integer recruitNums, Double bonusPerRecruitment, Integer
                       voIncreAmount) {
    super(name, workLoad, new Salary(salary.getSalary() + recruitNums * bonusPerRecruitment),
        new VocationDays(vocationDays.getVocationDays() + voIncreAmount), identity, seniority);
    this.recruitNums = recruitNums;
    this.bonusPerRecruitment = bonusPerRecruitment;
    this.voIncreAmount = voIncreAmount;
  }

  /**
   * Getter for property 'recruitNums'.
   *
   * @return the recruitment numbers of talents
   */
  public Integer getRecruitNums() {
    return recruitNums;
  }

  /**
   * Getter for property 'bonusPerRecruitment'.
   *
   * @return the bonus of recruiting each talent
   */
  public Double getBonusPerRecruitment() {
    return bonusPerRecruitment;
  }

  /**
   * Getter for property 'voIncreAmount'.
   *
   * @return the days of increment on the vocation days
   */
  public Integer getVoIncreAmount() {
    return voIncreAmount;
  }


  /**
   * Hunt talents.
   *
   * @return a string
   */
  public String huntTalents() {
    return "Let's hunt talents!";
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new HRManager(this.getName(), this.getWorkLoad(), this.getSalary(),
        new VocationDays(newVocationDays.getVocationDays() - this.getVoIncreAmount()),
        this.getId(), this.getSeniority(), this.recruitNums, this.bonusPerRecruitment,
        this.voIncreAmount);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Integer extraSalary) {
    return new HRManager(this.getName(), this.getWorkLoad(), new Salary(this.getSalary().getSalary()
        - this.getBonusPerRecruitment() * this.getRecruitNums() + extraSalary),
        this.getVocationDays(), this.getId(), this.getSeniority(), this.recruitNums,
        this.bonusPerRecruitment, this.voIncreAmount);
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
    return Objects.equals(getRecruitNums(), hrManager.getRecruitNums())
        && Objects.equals(getBonusPerRecruitment(), hrManager.getBonusPerRecruitment())
        && Objects.equals(getVoIncreAmount(), hrManager.getVoIncreAmount());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getRecruitNums(), getBonusPerRecruitment(),
        getVoIncreAmount());
  }

  @Override
  public String toString() {
    return "HRManager{" + "name=" + this.getName()
        + ", workLoad=" + this.getWorkLoad() + ", salary=" + this.getSalary()
        + ", vocationDays=" + this.getVocationDays() + ", id=" + this.getId()
        + ", seniority=" + this.getSeniority() + ", recruitNums=" + recruitNums
        + ", bonusPerRecruitment=" + bonusPerRecruitment
        + ", voIncreAmount=" + voIncreAmount + '}';
  }
}
