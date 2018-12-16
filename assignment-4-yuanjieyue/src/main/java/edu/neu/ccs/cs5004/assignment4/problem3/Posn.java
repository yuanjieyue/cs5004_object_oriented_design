package edu.neu.ccs.cs5004.assignment4.problem3;

import java.util.Objects;

/**
 * Represents a posn with x coordinate and y coordinate.
 */
public class Posn {
  private Integer coordinateX;
  private Integer coordinateY;

  /**
   * Create a new position with x and y coordinate given as integer.
   *
   * @param coordinateX the x coordinate
   * @param coordinateY the y coordinate
   */
  public Posn(Integer coordinateX, Integer coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  /**
   * Getter for the property 'coordinateX'.
   *
   * @return Value for the property 'coordinateX'
   */
  public Integer getCoordinateX() {
    return coordinateX;
  }

  /**
   * Getter for the property 'coordinateY'.
   *
   * @return Value for the property 'coordinateY'
   */
  public Integer getCoordinateY() {
    return coordinateY;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Posn posn = (Posn) obj;
    return Objects.equals(getCoordinateX(), posn.getCoordinateX())
        && Objects.equals(getCoordinateY(), posn.getCoordinateY());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCoordinateX(), getCoordinateY());
  }

  @Override
  public String toString() {
    return "Posn{" + "coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + '}';
  }
}
