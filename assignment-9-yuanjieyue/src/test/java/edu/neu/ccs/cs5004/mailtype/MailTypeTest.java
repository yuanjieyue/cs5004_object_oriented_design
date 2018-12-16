package edu.neu.ccs.cs5004.mailtype;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.Member;
import java.util.*;

public class MailTypeTest {
  MailType mt1;
  MailType mt2;
  Member member;
  //MailTemplate mailTemplate;
  Map<String,Integer> map = new HashMap<>();
  @Before
  public void setUp() throws Exception {
    mt1 = new AbstractMail.Email();
    mt2 = new AbstractMail.Letter();
    mt1.getMailTemplate().readInMailTemplate("src\\main\\java\\edu\\neu\\ccs\\cs5004\\"+"email-template.txt");
    //mailTemplate =new EmailTemplate();
    //mailTemplate.readInMailTemplate("email_template.txt");
    member = new Member();
    member.getMemberInfo().add("Shufan");
    member.getMemberInfo().add("Xing");
    member.getMemberInfo().add("02");
    member.getMemberInfo().add("03");
    member.getMemberInfo().add("04");
    member.getMemberInfo().add("05");
    member.getMemberInfo().add("06");
    member.getMemberInfo().add("07");
    member.getMemberInfo().add("08");
    member.getMemberInfo().add("09");
    member.getMemberInfo().add("010");
    member.getMemberInfo().add("shufan.xing@shufan");
    map.put("[[first_name]]", 0);
    map.put("[[last_name]]", 1);
    map.put("[[as]]", 3);
    map.put("[[cd]]", 4);
    map.put("[[5]]", 5);
    map.put("[[6]]", 6);
    map.put("[[7]]", 7);
    map.put("[[8]]", 8);
    map.put("[[9]]", 9);
    map.put("[[10]]", 10);
    map.put("[[email]]", 11);
    map.put("[[web]]", 12);
  }

  @Test
  public void generateMail() {
    List<String> email;
    email = mt1.generateMail( member,map);
    Iterator<String> iterator;
    iterator = email.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void getMailTemplate() {
  }
}