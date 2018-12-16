package edu.neu.ccs.cs5004.mailtemplate;

import java.util.List;

/**
 * Represent a mail template.
 */
public interface MailTemplate {
  /**
   * Create a new email template.
   *
   * @return a new email template.
   */
  static MailTemplate createEmptyEmailTemplate() {
    return new EmailTemplate();
  }

  /**
   * Create a new letter template.
   *
   * @return a new letter template.
   */
  static MailTemplate createEmptyLetterTemplate() {
    return new LetterTemplate();
  }

  /**
   * Read the input text template.
   *
   * @param templateFileName the path name of template.
   */
  void readInMailTemplate(String templateFileName);

  /**
   * Getter for property 'template'.
   *
   * @return a list of strings after parsing the input text template.
   */
  List<String> getTemplate();
}
