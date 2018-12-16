package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.argumentparser.ArgumentParser;
import edu.neu.ccs.cs5004.filereader.InputReader;
import edu.neu.ccs.cs5004.mailgeneration.MailGenerationSystem;

import java.util.List;
import java.util.Map;

/**
 * Main application class.
 */
public class App {

  /**
   * Run the application.
   *
   * @param args the arguments array.
   */
  public static void main(String[] args) {

    // initialize the ArgumentParser.
    ArgumentParser parser = new ArgumentParser();

    // parse the argument.
    parser.parse(args);

    // initialize file reader.
    InputReader inputReader = InputReader.createEmptyFileReader();

    // read customer csv file.
    Map<String, Integer> map = inputReader.readIncsvFiles(parser.getCustomerFileName());

    // initialize the mail generation system.
    MailGenerationSystem mailGenerationSys =
        MailGenerationSystem.createEmptyMailSystem(parser.getMailType());

    // generate mail.
    List<Member> members = inputReader.getMembers();
    List<List<String>> mailsForAll = mailGenerationSys.generateMailForAllMembers(members, map);

    // output to the target folder.
    mailGenerationSys.writeMail(parser.getOutputDirName(), mailsForAll);
  }

}
