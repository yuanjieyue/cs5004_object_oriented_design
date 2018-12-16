package edu.neu.ccs.cs5004.assignment4.problem2;

public class Cons implements Set {

  private Integer item;
  private Set rest;

  /**
   * Create a new cons with its item and rest.
   *
   * @param item the first item of the cons
   * @param rest the rest part of the cons
   */
  public Cons(Integer item, Set rest) {
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
   * Getter for the property 'rest'.
   *
   * @return the rest
   */
  public Set getRest() {
    return rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Set add(Integer elem) {
    if (this.contains(elem)) {
      return this;
    }
    return new Cons(elem, this);
  }

  @Override
  public Boolean contains(Integer elem) {
    if (this.item.equals(elem)) {
      return true;
    }
    return this.rest.contains(elem);
  }

  @Override
  public Set remove(Integer elem) {
    if (this.item.equals(elem)) {
      return this.rest;
    }
    return new Cons(this.item, this.rest.remove(elem));
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public Set union(Set set) {
    if (set.equals(new Empty())) {
      return this;
    }
    Set res = this;
    Set tmp = set;
    while (! tmp.equals(new Empty())) {
      Cons cons = (Cons) tmp;
      res = res.add(cons.getItem());
      tmp = cons.getRest();
    }
    return res;
  }

  @Override
  public Set intersection(Set set) {
    if (set.equals(new Empty())) {
      return new Empty();
    }
    Set res = new Empty();
    Set tmp = set;
    while (! tmp.equals(new Empty())) {
      Cons cons = (Cons)tmp;
      if (this.contains(cons.getItem())) {
        res = res.add(cons.getItem());
      }
      tmp = cons.getRest();
    }
    return res;
  }

  @Override
  public Set difference(Set set) {
    if (set.equals(new Empty())) {
      return this;
    }
    Set res = this;
    Set tmp = set;
    while (! tmp.equals(new Empty())) {
      Cons cons = (Cons)tmp;
      if (res.contains(cons.getItem())) {
        res = res.remove(cons.getItem());
      }
      tmp = cons.getRest();
    }
    return res;
  }

  @Override
  public Boolean subset(Set set) {
    if (set.equals(new Empty())) {
      return true;
    }
    Set tmp = set;
    while (!tmp.equals(new Empty())) {
      Cons cons = (Cons)tmp;
      if (!this.contains(cons.getItem())) {
        return false;
      }
      tmp = cons.getRest();

    }
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Cons cons = (Cons) obj;
    if (!this.size().equals(cons.size())) {
      return false;
    }
    Cons consA = this;
    Cons consB = cons;
    return checkIfTheSame(consA, consB);
  }

  private Boolean checkIfTheSame(Set setA, Set setB) {
    if (setA.equals(new Empty()) && setB.equals(new Empty())) {
      return true;
    }
    if (setA.equals(new Empty()) || setB.equals(new Empty())) {
      return false;
    }
    Cons consA = (Cons) setA;
    Cons consB = (Cons) setB;
    if (! consA.contains(consB.getItem())) {
      return false;
    }
    return checkIfTheSame(consA.remove(consB.getItem()), consB.getRest());
  }

  @Override
  public int hashCode() {
    int res = 31;
    res = 31 * res + getItem().hashCode();
    res = 31 * res + getRest().hashCode();
    return res;
  }

  @Override
  public String toString() {
    return "Cons{" + "item=" + item + ", rest=" + rest + '}';
  }
}
