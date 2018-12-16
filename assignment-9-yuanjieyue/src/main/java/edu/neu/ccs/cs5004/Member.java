package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a list of attributes of a single member.
 */
public class Member {

  private List<String> memberInfo;

  public Member() {
    this.memberInfo = new ArrayList<>();
  }

  /**
   * Getter for property 'memberInfo'.
   *
   * @return the value of property 'memberInfo'.
   */
  public List<String> getMemberInfo() {
    return memberInfo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Member member = (Member) obj;

    return memberInfo != null ? memberInfo.equals(member.memberInfo) : member.memberInfo == null;
  }

  @Override
  public int hashCode() {
    return memberInfo != null ? memberInfo.hashCode() : 0;
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("Member{");
    stringBuilder.append("memberInfo=").append(memberInfo);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}
