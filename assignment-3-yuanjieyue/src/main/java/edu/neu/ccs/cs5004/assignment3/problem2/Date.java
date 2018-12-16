package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;

/**
 * Represents a date with year, month and day.
 */
public class Date {
  private Integer year;
  private Integer month;
  private Integer day;

  /**
   * Create a new date with its year, month and day.
   *
   * @param year  the year, a non negative integer
   * @param month the month ranges [0, 11]
   * @param day   the day ranges [0, 31]
   */
  public Date(Integer year, Integer month, Integer day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  /**
   * Getter for property 'year'.
   *
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Getter for property 'month'.
   *
   * @return the month
   */
  public Integer getMonth() {
    return month;
  }

  /**
   * Getter for property 'day'.
   *
   * @return the day
   */
  public Integer getDay() {
    return day;
  }

  /**
   * Check if the given object equals to the instance.
   *
   * @param obj the object to be compared
   * @return true if they are of the same class and have exactly the same fields.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Date date = (Date) obj;
    return Objects.equals(getYear(), date.getYear())
        && Objects.equals(getMonth(), date.getMonth())
        && Objects.equals(getDay(), date.getDay());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getYear(), getMonth(), getDay());
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Date{" + "year=" + year + ", month=" + month + "" + ", day=" + day + '}';
  }
}
