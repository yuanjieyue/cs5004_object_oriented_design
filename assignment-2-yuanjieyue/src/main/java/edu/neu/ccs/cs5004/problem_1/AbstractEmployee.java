package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents an employee with its name, workload, salary and paid vocation.
 */
public abstract class AbstractEmployee implements Employee{

  private Person name;
  private WorkLoad workLoad;
  private Salary salary;
  private VocationDays vocationDays;
  private ID identity;
  private Seniority seniority;

  /**
   * Create a new employee with his name, workload, salary and paid vocation, id and seniority.
   *
   * @param name         the name of the employee
   * @param workLoad     the workload of the employee per week
   * @param salary       the salary of the employee per year
   * @param vocationDays the vocation days of the employee per year
   * @param id           the id of the employee
   * @param seniority    the seniority of the employee
   */
  public AbstractEmployee(Person name, WorkLoad workLoad, Salary salary, VocationDays vocationDays,
                  ID id, Seniority seniority) {
    this.name = name;
    this.workLoad = workLoad;
    this.salary = salary;
    this.vocationDays = vocationDays;
    this.identity = id;
    this.seniority = seniority;
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
   * Getter for property 'workLoad'.
   *
   * @return the workload
   */
  public WorkLoad getWorkLoad() {
    return workLoad;
  }

  /**
   * Getter for the property 'salary'.
   *
   * @return the salary
   */
  public Salary getSalary() {
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

  /**
   * Getter for the property 'id'.
   *
   * @return the id
   */
  public ID getId() {
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
   * Add some amount to an employee's salary.
   *
   * @param extraAmount the amount to be added on the salary
   * @return the employee with new salary
   */
  @Override
  public Employee addSalary(Integer extraAmount) {
    return this.employeeCopyFactory(extraAmount);
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
    return this.employeeCopyFactory(newVocationDays);
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
  protected abstract AbstractEmployee employeeCopyFactory(Integer extraAmount);

  /**
   * Check if an object equals to the employee.
   *
   * @param obj an object to be compared with
   * @return true if they equal to each other, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractEmployee employee = (AbstractEmployee) obj;
    return Objects.equals(getName(), employee.getName())
        && Objects.equals(getWorkLoad(), employee.getWorkLoad())
        && Objects.equals(getSalary(), employee.getSalary())
        && Objects.equals(getVocationDays(), employee.getVocationDays())
        && Objects.equals(getId(), employee.getId())
        && Objects.equals(getSeniority(), employee.getSeniority());
  }

  /**
   * Get the hash code of an employee.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getWorkLoad(), getSalary(), getVocationDays(),
        getId(), getSeniority());
  }

  /**
   * Print the abstract employee.
   *
   * @return the string about the information of the employee
   */
  @Override
  public String toString() {
    return "Employee{" + "name=" + name + ", workLoad=" + workLoad + ", salary=" + salary
        + ", vocationDays=" + vocationDays + ", id=" + identity + ", seniority=" + seniority + '}';
  }
}