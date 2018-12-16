package edu.neu.ccs.cs5004.problem1;

/**
 * Represents a list node of LinkedList.
 */
public class ListNode<E> {

  private E element;
  private ListNode next;
  private ListNode prev;

  /**
   * Construct a new ListNode with only data provided. The reference of next and previous ListNode
   * is null by default.
   *
   * @param element the given data of the new ListNode.
   */
  ListNode(E element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }

  /**
   * Getter for property 'element'.
   *
   * @return the value of element.
   */
  E getElement() {
    return element;
  }

  /**
   * Get the reference for the next ListNode of this node.
   *
   * @return the reference for the next ListNode.
   */
  ListNode getNext() {
    return next;
  }

  /**
   * Set the reference for the next ListNode to a new ListNode.
   *
   * @param next the new next ListNode.
   */
  void setNext(ListNode next) {
    this.next = next;
  }

  /**
   * Get the reference for the previous ListNode of this node.
   *
   * @return the reference for the previous ListNode.
   */
  ListNode getPrev() {
    return prev;
  }

  /**
   * Set the reference for the previous ListNode to a new ListNode.
   *
   * @param prev the new previous ListNode.
   */

  void setPrev(ListNode prev) {
    this.prev = prev;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    ListNode<?> listNode = (ListNode<?>) other;

    if (next == null && listNode.next == null) {
      return element.equals(listNode.element);
    } else if (next == null || listNode.next == null) {
      return false;
    }
    return element.equals(listNode.element) && next.equals(listNode.next);
  }

  @Override
  public int hashCode() {
    int result = element != null ? element.hashCode() : 0;
    result = 31 * result + (next != null ? next.hashCode() : 0);
    return result;
  }


}
