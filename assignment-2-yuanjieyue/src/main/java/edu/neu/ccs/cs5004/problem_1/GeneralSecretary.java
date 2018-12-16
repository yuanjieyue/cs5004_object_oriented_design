package edu.neu.ccs.cs5004.problem_1;


import java.util.Objects;

/**
 * Represents a general secretary.
 */
public class GeneralSecretary extends AbstractSecretary {

  private Double bonusForBeingPromotedToLegalSecretery;

  /**
   * Create a new secretary with his name, workload, salary and paid vocation, identity and seniority.
   *
   * @param name                                  the name of the general secretary
   * @param workLoad                              the workload of the per week
   * @param salary                                the salary of per year
   * @param vocationDays                          the vocation days of per year
   * @param identity                                    the identity of the general secretary
   * @param seniority                             the seniority of the general secretary
   * @param bonusForBeingPromotedToLegalSecretery the bonus for being promoted to legal secretary
   */
  public GeneralSecretary(Person name, WorkLoad workLoad, Salary salary, VocationDays
      vocationDays, ID identity, Seniority seniority, Double bonusForBeingPromotedToLegalSecretery) {
    super(name, workLoad, salary, vocationDays, identity, seniority);
    this.bonusForBeingPromotedToLegalSecretery = bonusForBeingPromotedToLegalSecretery;
  }

  public Double getBonusForBeingPromotedToLegalSecretery() {
    return bonusForBeingPromotedToLegalSecretery;
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new GeneralSecretary(this.getName(), this.getWorkLoad(), this.getSalary(),
        newVocationDays, this.getId(), this.getSeniority(),
        this.bonusForBeingPromotedToLegalSecretery);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Integer extraSalary) {
    return new GeneralSecretary(this.getName(), this.getWorkLoad(), new Salary(this.getSalary()
        .getSalary() + extraSalary), this.getVocationDays(), this.getId(),
        this.getSeniority(), this.bonusForBeingPromotedToLegalSecretery);
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
    GeneralSecretary that = (GeneralSecretary) obj;
    return Objects.equals(getBonusForBeingPromotedToLegalSecretery(),
        that.getBonusForBeingPromotedToLegalSecretery());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getBonusForBeingPromotedToLegalSecretery());
  }

  @Override
  public String toString() {
    return "GeneralSecretary{"
        + "name=" + this.getName() + ", workLoad=" + this.getWorkLoad()
        + ", salary=" + this.getSalary() + ", vocationDays=" + this.getVocationDays()
        + ", id=" + this.getId() + ", seniority=" + this.getSeniority()
        + ", bonusForBeingPromotedToLegalSecretery=" + bonusForBeingPromotedToLegalSecretery
        + '}';
  }
}
