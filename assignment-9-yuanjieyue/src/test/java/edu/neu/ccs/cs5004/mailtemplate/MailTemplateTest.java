package edu.neu.ccs.cs5004.mailtemplate;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class MailTemplateTest {
  MailTemplate letter1;

  @Before
  public void setUp() throws Exception {
    letter1 = new LetterTemplate();
    letter1.readInMailTemplate("src\\main\\java\\edu\\neu\\ccs\\cs5004\\"+"letter-template.txt");
  }

  @Test
  public void createEmptyEmailTemplate() {
  }

  @Test
  public void createEmptyLetterTemplate() {
  }

  @Test
  public void readInMailTemplate() {
    List<String> letter = letter1.getTemplate();
    Iterator<String> iterator = letter.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void getTemplate() {
  }
}