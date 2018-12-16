package edu.neu.ccs.cs5004.problem_1;

/**
 * Represents a sectary.
 */
public abstract class AbstractSecretary extends AbstractEmployee implements Secretary {

  /**
   * Create a new secretary with his name, workload, salary and paid vocation, id and seniority.
   *
   * @param name         the name of the secretary
   * @param workLoad     the workload of the secretary per week
   * @param salary       the salary of the secretary per year
   * @param vocationDays the vocation days of the secretary per year
   * @param id           the id of the secretary
   * @param seniority    the seniority of the secretary
   */
  public AbstractSecretary(Person name, WorkLoad workLoad, Salary salary, VocationDays vocationDays, ID
      id, Seniority seniority) {
    super(name, workLoad, salary, vocationDays, id, seniority);
  }


  /**
   * Schedual a meeting.
   *
   * @return a string
   */
  @Override
  public String schedualMeeting() {
    return "Let's schedual meeting!";
  }
}
