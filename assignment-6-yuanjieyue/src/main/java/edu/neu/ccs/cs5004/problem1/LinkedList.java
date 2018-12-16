package edu.neu.ccs.cs5004.problem1;

/**
 * Represents an implementation of List by using LinkedList.
 */
public class LinkedList<E> implements List<E> {

  private ListNode<E> head;
  private int listSize;

  /**
   * Construct a new LinkedList. Initialize the head, tail node as null and listSize as zero.
   */
  public LinkedList() {
    this.head = null;
    this.listSize = 0;
  }

  ListNode<E> getHead() {
    return head;
  }

  private void setHead(ListNode<E> head) {
    this.head = head;
  }

  private void setListSize(int listSize) {
    this.listSize = listSize;
  }

  @Override
  public void add(E element) {
    if (element == null) {
      throw new IllegalArgumentException("LinkedList add(): the element is null");
    } else {
      ListNode newHead = new ListNode(element);
      newHead.setNext(getHead());
      if (getHead() != null) {
        getHead().setPrev(newHead);
      }
      setHead(newHead);
      setListSize(size() + 1);
    }
  }

  @Override
  public void add(int index, E element) {
    if (element == null) {
      throw new IllegalArgumentException("LinkedList add(index, element): the element is null");
    }
    if (!indexOutOfBoundAdd(index)) {
      if (index == 0) {
        this.add(element);
      } else {
        ListNode newNode = new ListNode(element);

        ListNode ptr = getHead();
        for (int i = 0; i < index - 1; i++) {
          ptr = ptr.getNext();
        }
        ListNode next = ptr.getNext();
        ptr.setNext(newNode);
        newNode.setPrev(ptr);
        newNode.setNext(next);
        if (next != null) {
          next.setPrev(newNode);
        }
        setListSize(size() + 1);
      }
    }
  }


  @Override
  public E get(int index) {
    ListNode<E> current = getHead();
    if (!indexOutOfBound(index)) {
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
      return current.getElement();
    }
    return null;
  }

  @Override
  public int indexOf(E element) {
    if (element == null) {
      throw new IllegalArgumentException("LinkedList indexOf(): the element is null");
    }
    if (this.isEmpty()) {
      throw new EmptyListException("LinkedList indexOf(): the list is empty");
    }
    ListNode ptr = getHead();
    int index = 0;
    while (ptr != null) {
      if (ptr.getElement().equals(element)) {
        return index;
      }
      ptr = ptr.getNext();
      index++;
    }
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void remove(int index) {
    if (this.isEmpty()) {
      throw new EmptyListException("LinkedList remove(): the list is empty.");
    }
    if (!indexOutOfBound(index)) {
      if (index == 0) {
        setHead(getHead().getNext());
      } else {
        ListNode toBeDeleted = getHead();
        for (int i = 0; i < index; i++) {
          toBeDeleted = toBeDeleted.getNext();
        }
        if (toBeDeleted.getNext() != null) {
          toBeDeleted.getNext().setPrev(toBeDeleted.getPrev());
        }
        if (toBeDeleted.getPrev() != null) {
          toBeDeleted.getPrev().setNext(toBeDeleted.getNext());
        }
      }
      setListSize(size() - 1);
      // setTail();
    }
  }

  @Override
  public int size() {
    return this.listSize;
  }

  @Override
  public boolean contains(E element) {
    if (element == null) {
      throw new IllegalArgumentException("LinkedList indexOf(): the element is null");
    }
    if (this.isEmpty()) {
      return false;
    }
    ListNode headPtr = getHead();

    while (headPtr != null) {
      if (headPtr.getElement().equals(element)) {
        return true;
      } else {
        headPtr = headPtr.getNext();
      }
    }
    return false;
  }

  /**
   * check if the index is out of bound.
   *
   * @param index the given index.
   * @return false if the index is valid.
   * @throws IndexOutOfBoundsException if the index is out of bound of this LinkedList.
   */
  private boolean indexOutOfBound(int index) {
    if (index >= size() || index < 0) {
      throw new IndexOutOfBoundsException("indexOutOfBound: index = " + index);
    }
    return false;
  }

  /**
   * check if the index is out of bound when adding or removing element at a given index.
   *
   * @param index the given index.
   * @return false if the index is valid.
   * @throws IndexOutOfBoundsException if the index is out of bound of range of adding new nodes.
   */
  private boolean indexOutOfBoundAdd(int index) {
    if (index > size() || index < 0) {
      throw new IndexOutOfBoundsException("indexOutOfBoundAdd: index = " + index);
    }
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    LinkedList<?> that = (LinkedList<?>) other;

    if (listSize != that.listSize) {
      return false;
    }
    if (head != null ? !head.equals(that.head) : that.head != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = head != null ? head.hashCode() : 0;
    result = 31 * result + listSize;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    for (int i = 0; i < size(); i++) {
      stringBuilder.append(get(i));
    }
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}
