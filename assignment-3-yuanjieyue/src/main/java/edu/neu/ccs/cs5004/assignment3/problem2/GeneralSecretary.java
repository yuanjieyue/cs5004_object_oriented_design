package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a general secretary.
 */
public class GeneralSecretary extends AbstractSecretary implements IGeneralSecretary {

  /**
   * Create a new secretary with his name, identity and seniority.
   *
   * @param name      the name of the general secretary
   * @param identity  the identity of the general secretary
   * @param seniority the seniority of the general secretary
   */
  public GeneralSecretary(Person name, ID identity, Seniority seniority) {
    super(name, identity, seniority);
  }

  /**
   * Create a new general secretary who has differ salary and vocation days, with his name
   * , id and seniority.
   *
   * @param name         the name of the general secretary
   * @param identity     the id of the general secretary
   * @param seniority    the seniority of the general secretary
   * @param salary       the salary of the general secretary
   * @param vocationDays the vocation days of the general secretary
   */
  GeneralSecretary(Person name, ID identity, Seniority seniority, Salary salary,
                   VocationDays vocationDays) {
    super(name, identity, seniority, salary, vocationDays);
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new GeneralSecretary(this.getName(), this.getIdentity(), this.getSeniority(),
        this.getSalary(), newVocationDays);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Double extraSalary) {
    return new GeneralSecretary(this.getName(), this.getIdentity(), this.getSeniority(),
        new Salary(this.getSalary().getSalary() + extraSalary), this.getVocationDays());
  }

  @Override
  public String toString() {
    return "GeneralSecretary{"
        + "name=" + this.getName() + ", id=" + this.getIdentity() + ", seniority=" + this.getSeniority()
        + ", salary=" + this.getSalary() + ", vocationDays=" + this.getVocationDays()
        + ", workLoad=" + this.getWorkLoad() + '}';
  }

}
