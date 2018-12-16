package edu.neu.ccs.cs5004.assignment4.problem2;

public class Empty implements Set {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Set add(Integer elem) {
    return new Cons(elem, this);
  }

  @Override
  public Boolean contains(Integer elem) {
    return false;
  }

  @Override
  public Set remove(Integer elem) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Set union(Set set) {
    return set;
  }

  @Override
  public Set intersection(Set set) {
    return this;
  }

  @Override
  public Set difference(Set set) {
    return this;
  }

  @Override
  public Boolean subset(Set set) {
    if (set.equals(this)) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 41;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Empty{}";
  }
}
