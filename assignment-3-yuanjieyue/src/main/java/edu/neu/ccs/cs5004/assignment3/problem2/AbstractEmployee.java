package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;

/**
 * Represents an employee with its name, workload, salary and paid vocation.
 */
public abstract class AbstractEmployee implements Employee{

  private Person name;
  private ID identity;
  private Seniority seniority;
  private Salary salary;
  private VocationDays vocationDays;
  private WorkLoad workLoad;


  /**
   * Create a new employee who has basic salary and vocation days, with his name, id and seniority.
   *
   * @param name         the name of the employee
   * @param id           the id of the employee
   * @param seniority    the seniority of the employee
   */
  public AbstractEmployee(Person name, ID id, Seniority seniority) {
    this.name = name;
    this.identity = id;
    this.seniority = seniority;
    workLoad = new WorkLoad(40);
    salary = HRManager.BASICSALARY;
    vocationDays = HRManager.BASICVOCATIONDAYS;
  }

  /**
   * Create a new employee who has differ salary and vocation days, with his name, id and seniority.
   *
   * @param name         the name of the employee
   * @param id           the id of the employee
   * @param seniority    the seniority of the employee
   * @param salary       the salary of the employee
   * @param vocationDays the vocation days of the employee
   */
  AbstractEmployee(Person name, ID id, Seniority seniority, Salary salary, VocationDays
                          vocationDays) {
    this.name = name;
    this.identity = id;
    this.seniority = seniority;
    this.salary = salary;
    this.vocationDays = vocationDays;
    workLoad = new WorkLoad(40);
  }

  /**
   * Getter for property 'workLoad'.
   *
   * @return the workload
   */
  public WorkLoad getWorkLoad() {
    return workLoad;
  }

  /**
   * Getter for property 'name'.
   *
   * @return the name
   */
  public Person getName() {
    return name;
  }
  
  /**
   * Getter for the property 'id'.
   *
   * @return the id
   */
  public ID getIdentity() {
    return identity;
  }

  /**
   * Getter for the property 'seniority'.
   *
   * @return the id
   */
  public Seniority getSeniority() {
    return seniority;
  }

  /**
   * Getter for the property 'salary'.
   *
   * @return the salary
   */
  Salary getSalary() {
    return salary;
  }

  /**
   * Getter for the property 'vocationDays'.
   *
   * @return the vocation days
   */
  public VocationDays getVocationDays() {
    return vocationDays;
  }

  @Override
  public Person name() {
    return getName();
  }

  @Override
  public VocationDays vocationDays() {
    return getVocationDays();
  }

  @Override
  public ID identity() {
    return getIdentity();
  }

  @Override
  public WorkLoad workLoad() {
    return getWorkLoad();
  }

  @Override
  public Seniority seniority() {
    return getSeniority();
  }

  /**
   * Add some amount to an employee's salary.
   *
   * @param extraAmount the amount to be added on the salary
   * @return the employee with new salary
   */
  @Override
  public Employee addSalary(Double extraAmount) {
    return employeeCopyFactory(extraAmount);
  }

  /**
   * Add some to an employee's vocation days.
   *
   * @param extraDays the amount to be added on the vocation days
   * @return the new employee with new vocation days
   */
  @Override
  public Employee addVocationDays(Integer extraDays) {
    VocationDays newVocationDays = new VocationDays(this.getVocationDays().getVocationDays()
        + extraDays);
    return employeeCopyFactory(newVocationDays);
  }

  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  protected abstract AbstractEmployee employeeCopyFactory(VocationDays newVocationDays);

  /**
   * Copies an employee with new salary.
   *
   * @param extraAmount of a copied employee
   * @return copied employee
   */
  protected abstract AbstractEmployee employeeCopyFactory(Double extraAmount);

  /**
   * Request to get a salary rasie to the HR manager.
   *
   * @param amount the amount salary that the employee would like to raise
   * @return the employee with its salary updated
   */
  @Override
  public Employee requestSalaryRaise(Double amount) {
    if (HRManager.replyToSalaryRaise(amount) == "Yes") {
      return HRManager.raiseSalary(this, amount);
    }
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    AbstractEmployee that = (AbstractEmployee) obj;
    return Objects.equals(getName(), that.getName())
        && Objects.equals(getIdentity(), that.getIdentity())
        && Objects.equals(getSeniority(), that.getSeniority())
        && Objects.equals(getSalary(), that.getSalary())
        && Objects.equals(getVocationDays(), that.getVocationDays())
        && Objects.equals(getWorkLoad(), that.getWorkLoad());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getName(), getIdentity(), getSeniority(), getSalary(), getVocationDays(),
        getWorkLoad());
  }
}