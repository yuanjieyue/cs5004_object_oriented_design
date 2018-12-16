package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a non empty deque.
 */
public abstract class NonEmpty extends ADeque {
  private Integer item;
  private Deque rest;

  /**
   * Create a new non empty deque with its item and rest given as integer and deque respectively.
   *
   * @param item the first item of the deque
   * @param rest the tail of the deque
   */
  public NonEmpty(Integer item, Deque rest) {
    this.item = item;
    this.rest = rest;
  }

  /**
   * Getter for the property 'item'.
   *
   * @return Value for property 'item'
   */
  public Integer getItem() {
    return item;
  }

  /**
   * Getter for the property 'next'.
   *
   * @return Value for property 'next'
   */
  public Deque getRest() {
    return rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public Deque removeFirst() {
    return this.getRest();
  }

  @Override
  public Integer peek() {
    return this.getItem();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    NonEmpty nonEmpty = (NonEmpty) obj;
    return Objects.equals(getItem(), nonEmpty.getItem())
        && Objects.equals(getRest(), nonEmpty.getRest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getItem(), getRest());
  }
}
