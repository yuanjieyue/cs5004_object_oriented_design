package edu.neu.ccs.cs5004.problem_1;

import java.util.Objects;

/**
 * Represents a layer.
 */
public class Lawyer extends AbstractEmployee {
  private Double extraSalaryRate;

  /**
   * Creates a layer with his name, workLoad, salary, vocation days, identity, seniority and salary
   * increment factor over the basic salary.
   *
   * @param name              the name of the layer
   * @param workLoad          the workload of the layer per week
   * @param salary            the salary of the layer per year
   * @param vocationDays      the vocation days of the layer per year
   * @param identity                the identity of the layer
   * @param seniority         the seniority of the layer
   * @param extraSalaryRate the salary increment factor over the basic salary of the layer
   */
  public Lawyer(Person name, WorkLoad workLoad, Salary salary, VocationDays vocationDays, ID identity,
               Seniority seniority, Double extraSalaryRate) {
    super(name, workLoad, new Salary(salary.getSalary() * extraSalaryRate), vocationDays,
        identity, seniority);
    this.extraSalaryRate = extraSalaryRate;
  }

  /**
   * Getter for the property 'salaryIncreFactor'.
   *
   * @return the extraSalaryRate
   */
  public Double getExtraSalaryRate() {
    return extraSalaryRate;
  }

  /**
   * Sue.
   *
   * @return a string
   */
  public String sue() {
    return "Let's sue!";
  }


  /**
   * Copies an employee with new vocation days.
   *
   * @param newVocationDays of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(VocationDays newVocationDays) {
    return new Lawyer(this.getName(), this.getWorkLoad(), new Salary(this.getSalary().getSalary()
        / this.getExtraSalaryRate()), newVocationDays, this.getId(), this.getSeniority(),
        this.extraSalaryRate);
  }

  /**
   * Copies an employee with new salary.
   *
   * @param extraSalary of a copied employee
   * @return copied employee
   */
  @Override
  protected AbstractEmployee employeeCopyFactory(Integer extraSalary) {
    return new Lawyer(this.getName(), this.getWorkLoad(), new Salary((this.getSalary().getSalary()
        + extraSalary) / this.getExtraSalaryRate()), this.getVocationDays(), this.getId(),
        this.getSeniority(), this.extraSalaryRate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    Lawyer layer = (Lawyer) obj;
    return Objects.equals(getExtraSalaryRate(), layer.getExtraSalaryRate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getExtraSalaryRate());
  }

  @Override
  public String toString() {
    return "Layer{" + "name=" + this.getName() + ", workLoad=" + this.getWorkLoad()
        + ", salary=" + this.getSalary()
        + ", vocationDays=" + this.getVocationDays()
        + ", id=" + this.getId() + ", seniority=" + this.getSeniority()
        + ", extraSalaryRate=" + extraSalaryRate + '}';
  }
}
