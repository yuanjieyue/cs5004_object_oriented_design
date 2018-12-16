package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a legal secretary.
 */
public class LegalSecretary extends AbstractSecretary implements ILegalSecretary {

  /**
   * Create a new legal secretary.
   *
   * @param name the name
   * @param identity the identity
   * @param seniority the seniority
   */
  public LegalSecretary(Person name, ID identity, Seniority seniority) {
    super(name, identity, seniority);
  }

  /**
   * Create a new legal secretary who has differ salary and vocation days, with his name, id and
   * seniority.
   *
   * @param name         the name of the legal secretary
   * @param identity     the id of the legal secretary
   * @param seniority    the seniority of the legal secretary
   * @param salary       the salary of the legal secretary
   * @param vocationDays the vocation days of the legal secretary
   */
  LegalSecretary(Person name, ID identity, Seniority seniority, Salary salary,
                          VocationDays vocationDays) {
    super(name, identity, seniority, salary, vocationDays);
  }

  @Override
  Salary getSalary() {
    return new Salary(super.getSalary().getSalary() + HRManager.EXTRASALARYAMOUNTOFLEGALSECRETARY);
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new LegalSecretary(this.getName(), this.getIdentity(), this.getSeniority(),
        new Salary(this.getSalary().getSalary() - HRManager.EXTRASALARYAMOUNTOFLEGALSECRETARY)
        , newVocationDays);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Double extraSalary) {
    return new LegalSecretary(this.getName(), this.getIdentity(), this.getSeniority(),
        new Salary(this
        .getSalary().getSalary() - HRManager.EXTRASALARYAMOUNTOFLEGALSECRETARY + extraSalary),
        this.getVocationDays());
  }

  @Override
  public String prepareLegalDocuments() {
    return "Let's prepare legal documents!";
  }

  @Override
  public String toString() {
    return "LegalSecretary{" + "name=" + this.getName() +  ", id=" + this.getIdentity() + ", "
        + "seniority="
        + this.getSeniority() + ", salary=" + this.getSalary() + ", vocationDays="
        + this.getVocationDays() + ", workLoad=" + this.getWorkLoad() + '}';
  }

}
