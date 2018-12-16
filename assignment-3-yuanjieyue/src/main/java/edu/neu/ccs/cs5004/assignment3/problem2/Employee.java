package edu.neu.ccs.cs5004.assignment3.problem2;

public interface Employee {

  /**
   * Get the name of the employee.
   *
   * @return the name of the employee
   */
  Person name();

  /**
   * Get the workLoad of the employee.
   *
   * @return the workLoad of the employee
   */
  WorkLoad workLoad();

  /**
   * Get the vocation days of the employee.
   *
   * @return the vocation days of the employee
   */
  VocationDays vocationDays();

  /**
   * Get the identity of the employee.
   *
   * @return the identity of the employee
   */
  ID identity();

  /**
   * Get the seniority of the employee.
   *
   * @return the seniority of the employee
   */
  Seniority seniority();

  /**
   * Add some amount to an employee's salary.
   *
   * @param extraAmount the amount to be added on the salary
   * @return the employee with new salary
   */
  Employee addSalary(Double extraAmount);

  /**
   * Add some to an employee's vocation days.
   *
   * @param extraDays the amount to be added on the vocation days
   * @return the new employee with new vocation days
   */
  Employee addVocationDays(Integer extraDays);

  /**
   * Request to get a salary rasie to the HR manager.
   *
   * @param amount the amount salary that the employee would like to raise
   * @return the employee with its salary updated
   */
  Employee requestSalaryRaise(Double amount);


}
