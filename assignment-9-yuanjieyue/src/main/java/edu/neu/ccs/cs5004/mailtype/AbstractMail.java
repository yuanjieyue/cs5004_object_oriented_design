package edu.neu.ccs.cs5004.mailtype;

import edu.neu.ccs.cs5004.Member;
import edu.neu.ccs.cs5004.mailtemplate.MailTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represent common property of letter and email.
 */
public abstract class AbstractMail implements MailType {
  MailTemplate mailTemplate;

  @Override
  public MailTemplate getMailTemplate() {
    return this.mailTemplate;
  }


  @Override
  public List<String> generateMail(Member member, Map<String, Integer> macroMap) {

    List<String> lines = this.mailTemplate.getTemplate();
    List<String> newLines = new ArrayList<>();

    int len = lines.size();

    for(int i = 0; i < len; i++) {
      String line = lines.get(i);

      int macroStart = 0;
      int macroEnd = 0;
      int newMacroStart;
      int newMacroEnd;

      String replacedLine = line;

      while ((newMacroEnd = line.indexOf("]]", macroStart)) != -1) {
        newMacroStart = line.indexOf("[[", macroEnd);

        String macro = line.substring(newMacroStart, newMacroEnd + 2);

        if (macroMap.containsKey(macro)) {
          replacedLine =
              replacedLine.replace(macro,  member.getMemberInfo().get(macroMap.get(macro)));
        }

        macroStart = newMacroEnd + 2;
        macroEnd = newMacroEnd + 2;
      }

      newLines.add(replacedLine);
    }
    return newLines;
  }

  /**
  * Represent a letter.
  */
  public static class Letter extends AbstractMail {
    public Letter() {
      this.mailTemplate = MailTemplate.createEmptyLetterTemplate();
    }

  }

  /**
  * Represent an email.
  */
  public static class Email extends AbstractMail {
    public Email() {
      this.mailTemplate = MailTemplate.createEmptyEmailTemplate();
    }

  }

}
