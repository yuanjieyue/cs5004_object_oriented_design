package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;

/**
 * Represents a vocation days.
 */
public class VocationDays {
  private Integer vocationDays;

  /**
   * Create a new vocation days that with vocation days given as integer.
   *
   * @param vocationDays the vocation days
   */
  public VocationDays(Integer vocationDays) {
    this.vocationDays = vocationDays;
  }

  /**
   * Getter for property 'vocationDays'.
   *
   * @return the vocation days
   */
  public Integer getVocationDays() {
    return vocationDays;
  }

  /**
   * Alter vocation days by amount.
   *
   * @param amount the amount that vocation days going to alter
   * @return the new vocations after alter
   */
  public VocationDays alterByAmount(Integer amount) {
    return new VocationDays(this.getVocationDays() + amount);
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
    VocationDays that = (VocationDays) obj;
    return Objects.equals(getVocationDays(), that.getVocationDays());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {

    return Objects.hash(getVocationDays());
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "VocationDays{" + "vocationDays=" + vocationDays + '}';
  }
}
