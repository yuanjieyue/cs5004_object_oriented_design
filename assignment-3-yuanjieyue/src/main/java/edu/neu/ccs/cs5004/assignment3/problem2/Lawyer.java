package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a lawyer.
 */
public class Lawyer extends AbstractEmployee implements ILawyer {

  /**
   * Creates a lawyer with his name, identity, seniority.
   *
   * @param name      the name of the lawyer
   * @param identity  the identity of the lawyer
   * @param seniority the seniority of the lawyer
   */
  public Lawyer(Person name, ID identity, Seniority seniority) {
    super(name, identity, seniority);
  }

  /**
   * Create a new lawyer who has differ salary and vocation days, with his name, id and seniority.
   *
   * @param name         the name of the lawyer
   * @param identity     the id of the lawyer
   * @param seniority    the seniority of the lawyer
   * @param salary       the salary of the lawyer
   * @param vocationDays the vocation days of the lawyer
   */
  Lawyer(Person name, ID identity, Seniority seniority, Salary salary, VocationDays vocationDays) {
    super(name, identity, seniority, salary, vocationDays);
  }

  @Override
  Salary getSalary() {
    return new Salary(super.getSalary().getSalary() * HRManager.EXTRASALARYRATEOFLAWYER);
  }

  @Override
  public String sue() {
    return "Let's sue!";
  }

  @Override
  public String toString() {
    return "Layer{" + "name=" + this.getName() + this.getIdentity() + ", seniority=" + this.getSeniority()
        + ", salary=" + this.getSalary() + ", vocationDays=" + this.getVocationDays()
        + ", id=" + ", workLoad=" + this.getWorkLoad() + '}';
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new Lawyer(this.getName(), this.getIdentity(), this.getSeniority(), new Salary(this
        .getSalary().getSalary() / HRManager.EXTRASALARYRATEOFLAWYER), newVocationDays);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Double extraSalary) {
    return new Lawyer(this.getName(), this.getIdentity(), this.getSeniority(), new Salary((this
        .getSalary().getSalary() + extraSalary) / HRManager.EXTRASALARYRATEOFLAWYER), this
        .getVocationDays());
  }
}
