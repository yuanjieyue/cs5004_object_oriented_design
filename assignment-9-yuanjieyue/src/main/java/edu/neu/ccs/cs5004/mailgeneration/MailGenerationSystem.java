package edu.neu.ccs.cs5004.mailgeneration;

import edu.neu.ccs.cs5004.Member;
import edu.neu.ccs.cs5004.mailtype.MailType;

import java.util.List;
import java.util.Map;

/**
 * Represent a mail generation system.
 */
public interface MailGenerationSystem {
  /**
   * Create a new mail generation system.
   *
   * @param mailType the type of the mail generated.
   * @return a new mail generation system.
   */
  static MailGenerationSystem createEmptyMailSystem(MailType mailType) {
    return new MailGenerationSystemImpl(mailType);
  }

  /**
   * Generate the mail for all members.
   *
   * @param members           the list of members.
   * @param columnAndIndexMap the placeholder map.
   * @return the list of all the mails.
   */
  List<List<String>> generateMailForAllMembers(List<Member> members,
                                               Map<String, Integer> columnAndIndexMap);

  /**
   * Output all the mails to the output directory.
   *
   * @param outPutDirPath the output directory.
   * @param mailsForAll   the lsit of all the mails for all members.
   */
  void writeMail(String outPutDirPath, List<List<String>> mailsForAll);


}
