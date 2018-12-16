package edu.neu.ccs.cs5004.problem_1;

/**
 * Represents the serving time of a employee.
 */
public class Seniority extends Date {

  /**
   * Create a new date with its year, month and day.
   *
   * @param year  the year, a non negative integer
   * @param month the month ranges [0, 11]
   * @param day   the day ranges [0, 31]
   */
  public Seniority(Integer year, Integer month, Integer day) {
    super(year, month, day);
  }

  @Override
  public String toString() {
    return "Seniority{" + "year=" + this.getYear()
        + ", month=" + this.getMonth() + ", day=" + this.getDay() + '}';
  }
}
