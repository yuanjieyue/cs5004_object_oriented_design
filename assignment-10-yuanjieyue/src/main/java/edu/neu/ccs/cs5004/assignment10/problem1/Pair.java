package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.Objects;

/**
 * Rrepsenets a pair of two given type of objects.
 * @param <X> the type of the first element in the pair
 * @param <Y> the type of the second element in the pair
 */
public class Pair<X, Y> {

  private X first;
  private Y second;

  /**
   * Create a new pair of the given types of objects.
   * @param first the first element in the pair
   * @param second the second element in the pair
   */
  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Getter for the first element in the pair.
   * @return Value of the first element
   */
  public X getFirst() {
    return first;
  }

  /**
   * Setter for the first element in the pair.
   * @param first Value to be set to the first element
   */
  public void setFirst(X first) {
    this.first = first;
  }

  /**
   * Getter of the second element in the pair.
   * @return Value of the second element
   */
  public Y getSecond() {
    return second;
  }

  /**
   * Setter for the second element in the pair.
   * @param second Value to be set to the second element
   */
  public void setSecond(Y second) {
    this.second = second;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Pair<?, ?> pair = (Pair<?, ?>) obj;
    return Objects.equals(getFirst(), pair.getFirst())
        && Objects.equals(getSecond(), pair.getSecond());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getSecond());
  }

  @Override
  public String toString() {
    return "Pair{" + "first=" + first + ", second=" + second + '}';
  }
}
