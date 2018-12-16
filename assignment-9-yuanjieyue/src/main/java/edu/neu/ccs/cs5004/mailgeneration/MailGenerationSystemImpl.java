package edu.neu.ccs.cs5004.mailgeneration;

import edu.neu.ccs.cs5004.Member;
import edu.neu.ccs.cs5004.mailtype.MailType;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Implementation of a mail generation system.
 */
public class MailGenerationSystemImpl implements MailGenerationSystem {
  private MailType mailType;

  /**
   * Create a new mail generation system given a designated mail type.
   *
   * @param mailType the given mail type.
   */
  MailGenerationSystemImpl(MailType mailType) {
    this.mailType = mailType;
  }

  @Override
  public List<List<String>> generateMailForAllMembers(List<Member> members,
                                                      Map<String, Integer> columnAndIndexMap) {
    Iterator<Member> iterator = members.iterator();
    List<List<String>> mailsForAll = new ArrayList<>();
    while (iterator.hasNext()) {
      Member member = iterator.next();
      List<String> oneMail = mailType.generateMail(member, columnAndIndexMap);
      mailsForAll.add(oneMail);
    }
    return mailsForAll;
  }

  @Override
  public void writeMail(String outPutDirPath, List<List<String>> mailsForAll) {
    int mailNum = mailsForAll.size();
    for (int i = 0; i < mailNum; i++) {
      String outputFileName = outPutDirPath + "\\" + "mail" + String.valueOf(i) + ".txt";
      List<String> oneMail = mailsForAll.get(i);
      try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(outputFileName), "UTF-8"))) {
        for (String str : oneMail) {
          writer.write(str + System.lineSeparator());
        }
        writer.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }
}
