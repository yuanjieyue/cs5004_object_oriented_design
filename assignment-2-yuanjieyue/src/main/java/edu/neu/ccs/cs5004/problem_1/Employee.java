package edu.neu.ccs.cs5004.problem_1;

public interface Employee {

  /**
   * Add some amount to an employee's salary.
   *
   * @param extraAmount the amount to be added on the salary
   * @return the employee with new salary
   */
  Employee addSalary(Integer extraAmount);

  /**
   * Add some to an employee's vocation days.
   *
   * @param extraDays the amount to be added on the vocation days
   * @return the new employee with new vocation days
   */
  Employee addVocationDays(Integer extraDays);
}
