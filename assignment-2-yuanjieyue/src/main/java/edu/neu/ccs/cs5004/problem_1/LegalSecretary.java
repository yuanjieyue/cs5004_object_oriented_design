package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents a legal secretary.
 */
public class LegalSecretary extends AbstractSecretary {
  private Double saIncreAmount;

  /**
   * Create a new legal secretary.
   *
   * @param name the name
   * @param workLoad the workload per week
   * @param salary the salary per year
   * @param vocationDays the vocation day per year
   * @param identity the identity
   * @param seniority the seniority
   * @param saIncreAmount the increment amount on salary
   */
  public LegalSecretary(Person name, WorkLoad workLoad, Salary salary, VocationDays
      vocationDays, ID identity, Seniority seniority, Double saIncreAmount) {
    super(name, workLoad, new Salary(salary.getSalary() + saIncreAmount), vocationDays, identity,
        seniority);
    this.saIncreAmount = saIncreAmount;
  }

  public Double getSaIncreAmount() {
    return saIncreAmount;
  }

  /**
   * Prepare legal documents.
   *
   * @return a string
   */
  public String prepareLegalDocuments() {
    return "Let's prepare legal documents!";
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new LegalSecretary(this.getName(), this.getWorkLoad(), this.getSalary(),
        newVocationDays, this.getId(), this.getSeniority(), this.saIncreAmount);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Integer extraSalary) {
    return new LegalSecretary(this.getName(), this.getWorkLoad(), new Salary(this.getSalary()
        .getSalary() - this.getSaIncreAmount() + extraSalary), this.getVocationDays(),
        this.getId(), this.getSeniority(), this.saIncreAmount);
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
    LegalSecretary that = (LegalSecretary) obj;
    return Objects.equals(getSaIncreAmount(), that.getSaIncreAmount());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getSaIncreAmount());
  }

  @Override
  public String toString() {
    return "LegalSecretary{" + "name=" + this.getName()
        + ", workLoad=" + this.getWorkLoad() + ", salary=" + this.getSalary()
        + ", vocationDays=" + this.getVocationDays() + ", id=" + this.getId()
        + ", seniority=" + this.getSeniority() + ", saIncreAmount=" + saIncreAmount + '}';
  }
}
