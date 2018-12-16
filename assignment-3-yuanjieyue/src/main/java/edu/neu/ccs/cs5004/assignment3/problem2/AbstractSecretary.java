package edu.neu.ccs.cs5004.assignment3.problem2;

import org.omg.CORBA.portable.ValueOutputStream;

/**
 * Represents a sectary.
 */
public abstract class AbstractSecretary extends AbstractEmployee implements ISecretary {

  /**
   * Create a new secretary with name, workload, salary，paid vocation, identity and seniority.
   *
   * @param name         the name of the secretary
   * @param identity           the identity of the secretary
   * @param seniority    the seniority of the secretary
   */
  public AbstractSecretary(Person name, ID identity, Seniority seniority) {
    super(name, identity, seniority);
  }

  /**
   * Create a new secretary with name, workload, salary，paid vocation, identity and seniority.
   *
   * @param name         the name of the secretary
   * @param identity           the identity of the secretary
   * @param seniority    the seniority of the secretary
   * @param salary       the salary of the secretary per year
   * @param vocationDays the vocation days of the secretary per year
   */
  public AbstractSecretary(Person name, ID identity, Seniority seniority,
                           Salary salary, VocationDays vocationDays) {
    super(name, identity, seniority, salary, vocationDays);
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
