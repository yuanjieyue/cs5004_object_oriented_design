package edu.neu.ccs.cs5004.assignment3.problem2;

public interface IHRManager {
  /**
   * Getter for all employees of their salary.
   *
   * @param e the employee
   * @return the salary of this employee
   */
  static Salary getSalary(Employee e) {
    if (e instanceof Lawyer)
    {
      Lawyer lawyer = (Lawyer) e;
      return lawyer.getSalary();
    } else if (e instanceof HRManager)
    {
      HRManager hRManager = (HRManager) e;
      return hRManager.getSalary();
    } else if (e instanceof GeneralSecretary)
    {
      GeneralSecretary generalSecretary = (GeneralSecretary) e;
      return generalSecretary.getSalary();
    } else if (e instanceof LegalSecretary)
    {
      LegalSecretary legalSecretary = (LegalSecretary) e;
      return legalSecretary.getSalary();
    }
    return HRManager.BASICSALARY;
  }

  /**
   * Getter for all employees of their vocation days.
   *
   * @param employee the employee
   * @return the vocation days of the employee
   */

  static VocationDays getVocationDays(Employee employee) {
    if (employee instanceof Lawyer)
    {
      Lawyer lawyer = (Lawyer) employee;
      return lawyer.getVocationDays();
    } else if (employee instanceof HRManager)
    {
      HRManager hRManager = (HRManager) employee;
      return hRManager.getVocationDays();
    } else if (employee instanceof GeneralSecretary)
    {
      GeneralSecretary generalSecretary = (GeneralSecretary) employee;
      return generalSecretary.getVocationDays();
    } else if (employee instanceof LegalSecretary)
    {
      LegalSecretary legalSecretary = (LegalSecretary) employee;
      return legalSecretary.getVocationDays();
    }
    return HRManager.BASICVOCATIONDAYS;
  }

  /**
   * Deal with more than request of raising salary at one time.
   *
   * @param employees the employees who are requesting for a salary raise
   * @param amounts   the amounts of salary that the employees are asking to raise
   * @return the employees with their salary updated according to their request
   */
  static Employee[] requestSalaryRaise(Employee[] employees, Double[] amounts) {
    Employee[] result = new Employee[employees.length];
    for (int i = 0; i < employees.length; i++) {
      result[i] = employees[i].requestSalaryRaise(amounts[i]);
    }
    return result;
  }

  /**
   * Get the recruitment number of the hr manager.
   *
   * @return the recruitment number
   */
  Integer recruitNums();

  /**
   * Hunt talents.
   *
   * @return a string
   */
  String huntTalents();

  /**
   * Promote a general secretary to legal secretary.
   *
   * @param e the general secretary
   * @return the promoted general secretary, which is a new legal secretary
   */
  LegalSecretary promoteGeneralToLegal(GeneralSecretary e);
}
