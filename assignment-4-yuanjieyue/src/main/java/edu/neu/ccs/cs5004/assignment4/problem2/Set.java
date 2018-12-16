package edu.neu.ccs.cs5004.assignment4.problem2;

/**
 * Represents a set.
 */
public interface Set {

  /**
   * Create an empty set.
   *
   * @return the empty set
   */
  static Set emptySet() {
    return new Empty();
  }

  /**
   * Check if the set is empty or not.
   *
   * @return true if the set is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * Add an element to the set.
   *
   * @param elem the element to be added to the set
   * @return the updated set after the addition
   */
  Set add(Integer elem);

  /**
   * Check if the set contains the given element or not.
   *
   * @param elem the element to be checked
   * @return true if the set contains the element, false otherwise
   */
  Boolean contains(Integer elem);

  /**
   * Remove the given element.
   *
   * @param elem the element to be removed
   * @return the updated set after the element removed
   */
  Set remove(Integer elem);

  /**
   * Get the number of elements that are in the set.
   *
   * @return the size of the set
   */
  Integer size();

  /**
   * Union the set with the given set.
   *
   * @param set the set to be united
   * @return the updated set after the union
   */
  Set union(Set set);

  /**
   * Intersect the set with the given set.
   *
   * @param set the set to be intersected
   * @return the updated set after intersection
   */
  Set intersection(Set set);

  /**
   * Get the set updated by keeping all the elements that are not contained in the given set.
   *
   * @param set the set to be compared with
   * @return the updated set after difference operation
   */
  Set difference(Set set);

  /**
   * Check if the given set is a subset of this set of not.
   *
   * @param set the set to be checked
   * @return true if the given set is a subset of this set, false otherwise
   */
  Boolean subset(Set set);

}
