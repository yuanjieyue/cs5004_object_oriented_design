package edu.neu.ccs.cs5004.mailtype;

import edu.neu.ccs.cs5004.Member;
import edu.neu.ccs.cs5004.mailtemplate.MailTemplate;

import java.util.List;
import java.util.Map;

/**
 * Represent a mail type.
 */
public interface MailType {

  /**
   * Generate mail for a member given the template.
   *
   * @param oneMember         the member, which is a list of strings including the information
   *                          titles.
   * @param columnAndIndexMap the map of placeholders.
   * @return a list of string
   */
  List<String> generateMail(Member oneMember,
                            Map<String, Integer> columnAndIndexMap);

  /**
   * Get the corresponding template of this mail type.
   *
   * @return the mail template of current mail type.
   */
  MailTemplate getMailTemplate();
}
