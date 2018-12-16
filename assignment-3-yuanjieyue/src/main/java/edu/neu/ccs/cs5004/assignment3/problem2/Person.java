package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;


/**
 * Represent a person with his first and last name.
 */
public class Person {
  private String first;
  private String last;

  /**
   * Construct a person with his first and last name given as string.
   *
   * @param first the first name of a person
   * @param last  the last name of a person
   */
  public Person(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Getter for property 'first'.
   *
   * @return the first name of a person
   */
  public String getFirst() {
    return first;
  }


  /**
   * Getter for property 'last'.
   *
   * @return the last name of a person
   */
  public String getLast() {
    return last;
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
    Person person = (Person) obj;
    return Objects.equals(getFirst(), person.getFirst())
        && Objects.equals(getLast(), person.getLast());
  }

  /**
   * Get the hash code.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getLast());
  }

  /**
   * Print the instance with its fields in string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Person{"
        + "first='" + first + '\''
        + ", last='" + last + '\''
        + '}';
  }
}
