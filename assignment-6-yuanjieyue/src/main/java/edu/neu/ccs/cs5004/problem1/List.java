package edu.neu.ccs.cs5004.problem1;

/**
 * Represents a generic list.
 */
public interface List<E> {

  /**
   * Create a new empty List.
   *
   * @return a new empty List.
   */
  static List createEmptyList() {
    return new LinkedList<>();
  }

  /**
   * adds an element to the front of the list.
   * time complexity: o(1).
   *
   * @param element the element to be added.
   */
  void add(E element);

  /**
   * Adds an element at the specified index.
   * Time complexity: O(n).
   *
   * @param index   the specified index of new element.
   * @param element the new element to be added.
   */
  void add(int index, E element);

  /**
   * Gets an element located at the specified index (the list remains unaltered).
   * Time complexity: O(n).
   *
   * @param index the specified index.
   * @return the element at the location of the index.
   */
  E get(int index);

  /**
   * Retrieves the element in the list and returns the respective index in the list. if the given
   * element is not in the list, return -1.
   * Time complexity: O(n);
   *
   * @param element the given element.
   * @return the respective index in the list, -1 if the given element is not in the list.
   */
  int indexOf(E element);

  /**
   * Check if the list is empty.
   * Time complexity: O(1).
   *
   * @return true if the list is empty and false otherwise.
   */
  boolean isEmpty();

  /**
   * Removes the element located at the specified index from the list.
   * Time complexity: O(n).
   *
   * @param index the given index of the element to be removed.
   */
  void remove(int index);

  /**
   * Get the size of the list.
   * Time complexity: O(1).
   *
   * @return the size of the list
   */
  int size();

  /**
   * Check if the given element is in the list.
   * Time complexity: O(n).
   *
   * @param element the given list.
   * @return true if the list contains the specified element, false otherwise.
   */
  boolean contains(E element);
}
