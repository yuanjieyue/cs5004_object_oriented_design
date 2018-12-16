package edu.neu.ccs.cs5004.mailtemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Represent common property of letter template and email template.
 */
public abstract class AbsMailTemplate implements MailTemplate {
  List<String> template;

  AbsMailTemplate() {
    template = new LinkedList<>();
  }

  @Override
  public List<String> getTemplate() {
    return this.template;
  }

  @Override
  public void readInMailTemplate(String templateFileName) {
    String line = "";
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(templateFileName))) {
      while ((line = bufferedReader.readLine()) != null) {
        template.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
