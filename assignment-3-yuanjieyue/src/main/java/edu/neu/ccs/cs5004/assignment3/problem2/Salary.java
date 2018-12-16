package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;

/**
 * Represents a salary.
 */
public class Salary{
  private Double salary;

  /**
   * Create a new salary with its salary given as a string.
   *
   * @param salary the salary
   */
  public Salary(Double salary) {
    this.salary = salary;
  }

  /**
   * Getter for the property 'salary'.
   *
   * @return the salary
   */
  public Double getSalary() {
    return this.salary;
  }

  /**
   * Alter the salary by factor.
   *
   * @param factor the factor that the salary will be altered
   * @return the new salary after alter
   */
  public Salary alterByFactor(Double factor) {
    return new Salary(this.getSalary() * factor);
  }

  /**
   * Alter the salary by amount.
   *
   * @param amount the factor that the salary will be altered
   * @return the new salary after alter
   */
  public Salary alterByAmount(Double amount) {
    return new Salary(this.getSalary() + amount);
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
    Salary salary1 = (Salary) obj;
    return Objects.equals(getSalary(), salary1.getSalary());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getSalary());
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Salary{" + "salary=" + salary + '}';
  }
}
