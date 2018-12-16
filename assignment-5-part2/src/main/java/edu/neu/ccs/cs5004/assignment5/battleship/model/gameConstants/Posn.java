package edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants;

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
  public Integer getX() {
    return coordinateX;
  }

  /**
   * Getter for the property 'coordinateY'.
   *
   * @return Value for the property 'coordinateY'
   */
  public Integer getY() {
    return coordinateY;
  }

  /**
   * Move coordinate x to the right for dx distance.
   *
   * @param dcoordx the distance to be moved
   * @return the updated posn with its coordinate x move towards right for dx distance
   */
  public Posn moveX(Integer dcoordx) {
    return new Posn(coordinateX + dcoordx, coordinateY);
  }

  /**
   * Move coordinate y down for dx distance.
   *
   * @param dcoordy the distance to be moved
   * @return the updated posn with its coordinate y move down for dy distance
   */
  public Posn moveY(Integer dcoordy) {
    return new Posn(coordinateX, coordinateY + dcoordy);
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
    return Objects.equals(getX(), posn.getX())
        && Objects.equals(getY(), posn.getY());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY());
  }

  @Override
  public String toString() {
    return "Posn{" + "coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + '}';
  }
}
