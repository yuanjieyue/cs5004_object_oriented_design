package edu.neu.ccs.cs5004.argumentparser;

import edu.neu.ccs.cs5004.mailtype.AbstractMail;
import edu.neu.ccs.cs5004.mailtype.MailType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Parse the arguments.
 */
public class ArgumentParser {
  private boolean mailTypeFlag;
  private MailType mailType;
  private String customerFileName;
  private String outputDirName;
  private Map<String, String> argMap;
  private String rootDir;

  /**
   * Parse the input string array and extract information inside the argument array.
   */
  public ArgumentParser() {
    this.mailTypeFlag = false;
    this.mailType = null;
    this.customerFileName = null;
    this.outputDirName = null;
    this.argMap = new HashMap<>();
    this.rootDir = "src\\main\\java\\edu\\neu\\ccs\\cs5004\\";
  }

  /**
   * Getter for property 'mailType'.
   *
   * @return the value of mailType.
   */
  public MailType getMailType() {
    return mailType;
  }

  /**
   * Setter for property 'mailType'.
   *
   * @param mailType the new mailType.
   */

  public void setMailType(MailType mailType) {
    this.mailType = mailType;
  }

  /**
   * Getter for property 'customerFileName'.
   *
   * @return the value of 'customerFileName'.
   */
  public String getCustomerFileName() {
    return customerFileName;
  }

  /**
   * Setter for property 'customerFileName'.
   *
   * @param customerFileName new value of 'customerFileName'.
   */
  public void setCustomerFileName(String customerFileName) {
    this.customerFileName = customerFileName;
  }

  /**
   * Getter for property 'outputDirName'.
   *
   * @return the value of 'outputDirName'.
   */
  public String getOutputDirName() {
    return outputDirName;
  }

  /**
   * Setter for property 'outputDirName'.
   *
   * @param outputDirName the new value of property 'outputDirName'.
   */
  public void setOutputDirName(String outputDirName) {
    this.outputDirName = outputDirName;
  }

  /**
   * Parse the argument. There are 2 kinds of arguments: action and switch. Action: --email and
   * --letter; Switch: --email-template, --letter-template, --output-dir, --csv-file.
   *
   * @param args the argument string array.
   */
  public void parse(String[] args) {
    int ptr = 0;
    while (ptr < args.length) {
      String curArg = args[ptr];
      // prevent duplicate argument input.
      // wrong msg: "--email-template one.txt --email-template two.txt"
      if (argMap.containsKey(curArg)) {
        System.err.println("The " + curArg + " argument has appeared before.");
        printRightMsg();
        throw new DuplicateArgumentException("Duplicate argument.");
      }
      if (isAction(curArg)) {
        System.out.println("Action: " + curArg);
        ptr = parseAction(curArg, ptr);
      } else if (isSwitch(curArg)) {
        System.out.println("Switch: " + curArg);
        ptr = parseSwitch(curArg, args, ptr);
      } else {
        // exclude invalid arguments such as: --default, --send-all, --summon-monster......
        System.err.println("OMG. Invalid argument: " + curArg);
        printRightMsg();
        throw new IllegalArgumentException("The argument is " + curArg);
      }
    }
    // After traversing the string argument array,
    // Check if both the output dir and csv file dir exist.
    checkIoDirExist();
    // Check if template dependency is valid.
    checkTemplateDependency();
  }

  /**
   * Check if the input and output directory are both included in the argument.
   */
  private void checkIoDirExist() {
    if (!argMap.containsKey("--output-dir")) {
      // if "--output-dir" is not in the args
      System.err.println("Output directory undefined.");
      printRightMsg();
      throw new MissingArgumentException("Output directory undefined.");
    }
    if (!argMap.containsKey("--csv-file")) {
      // if "--csv-file" is not in the args
      System.err.println("Input directory undefined.");
      printRightMsg();
      throw new MissingArgumentException("Input directory undefined.");
    }
  }

  /**
   * Check if the action builds valid dependencies with the template.
   */
  private void checkTemplateDependency() {
    if (!mailTypeFlag) {
      // missing --email or --letter in the entire args.
      System.err.println("Define a type of mail.");
      printRightMsg();
      throw new MissingArgumentException("The mail type arg is missing.");
    }
    String action = (getMailType() instanceof AbstractMail.Email) ? "--email" : "--letter";
    String actionTemplate = action + "-template";

    if (!argMap.containsKey(actionTemplate)) {
      // Only action defined. The template is missing.
      // wrong msg: "--email" without defining the template.
      System.err.println(action + "provided but no " + actionTemplate + " was given.");
      printRightMsg();
      throw new MissingArgumentException("The" + actionTemplate + " arg is missing.");
    } else {
      // the template exists. Set template!
      getMailType().getMailTemplate().readInMailTemplate(argMap.get(actionTemplate));
    }
  }

  /**
   * Parse the argument when the argument designates the mail type.
   *
   * @param arg the action argument string.
   * @param ptr the index of that argument in the argument array.
   * @return the updated index of the next argument in the argument array.
   */
  private int parseAction(String arg, int ptr) {
    // Only two actions: --email and --letter.
    // Must make sure that the mail type is never assigned before.
    if (mailTypeFlag) {
      // if the mail type has been assigned before, then print an error message and throw exception.
      // wrong msg: "--email --letter" is an invalid argument.
      String appearedAction = (arg.equals("--email")) ? "letter" : "email";
      System.err.println("The mail type is already assigned with " + appearedAction);
      printRightMsg();
      throw new DuplicateActionException(appearedAction + "is assigned");
    }
    if (arg.equals("--email")) {
      // assign mail type as email
      setMailType(new AbstractMail.Email());
      System.out.println("The mail type is assigned as email.");

    } else {
      // assign mail type as letter
      setMailType(new AbstractMail.Letter());
      System.out.println("The mail type is assigned as letter.");
    }
    argMap.put(arg, "");
    // update the mail type flag: the mail type is assigned now.
    mailTypeFlag = !mailTypeFlag;
    // update the ptr.
    return ptr + 1;
  }

  /**
   * Parse the switch argument.
   *
   * @param arg  the current switch argument.
   * @param args the argument string array.
   * @param ptr  the index of current switch argument.
   * @return the updated index of next argument to process.
   */
  private int parseSwitch(String arg, String[] args, int ptr) {
    int nextArgIndex = ptr + 1;
    // check if there is a path name existing after this switch.
    checkPathArgExistence(args, nextArgIndex);

    // two categories: input (path must exist in directory)
    //                 output (path can be created if not exist).
    String absolutePath = rootDir + args[nextArgIndex];
    File file = new File(absolutePath);
    if (arg.equals("--output-dir")) {
      // output category.
      if (!file.exists() && !file.mkdir()) {
          System.err.println("folder creation failed.");
      } // if the folder does not exist, just create a new folder.
      setOutputDirName(absolutePath);
    } else {
      // input category.
      if (!file.exists()) {
        // if the file name is not right.
        // (the argument file name is different from real template file name)
        // wrong msg: "--email-template some-other-file.txt".
        System.err.println("The file name does not exist: " + arg);
        printRightMsg();
        throw new NoFileException("The file name does not exist: " + arg);
      }
      // parse --csv-file, --email-template, -letter-template.
      parseValidInputSwitchArgs(arg, absolutePath);

    }
    // put the command and the path name in the map.
    argMap.put(arg, absolutePath);
    return nextArgIndex + 1;
  }

  /**
   * Parse the switch argument for --csv-file, --email-template, --letter-template.
   *
   * @param arg          the switch argument.
   * @param absolutePath path of the file after the switch command.
   * @throws IllegalArgumentException when the arg is not one of --csv-file, --email-template,
   *                                  --letter-template.
   */
  private void parseValidInputSwitchArgs(String arg, String absolutePath) {
    switch (arg) {
      case ("--csv-file"):
        setCustomerFileName(absolutePath);
        break;
      case ("--email-template"):
        System.out.println("The email template is set");
        break;
      case ("--letter-template"):
        System.out.println("The letter template is set");
        break;
      default:
        throw new IllegalArgumentException("parseSwitch(): invalid argument");
    }
  }

  /**
   * Check if there is a path name behind the switch argument.
   *
   * @param args         the string array representing the arguments.
   * @param nextArgIndex the index of args where is supposed to have a path name.
   * @throws NoFileException when args[nextArgIndex] is not a path name.
   */
  private void checkPathArgExistence(String[] args, int nextArgIndex) {
    if (nextArgIndex >= args.length
        || (nextArgIndex < args.length && args[nextArgIndex].startsWith("--"))) {
      // wrong msg: "--email-template --output-dir emails". no path defined after --email-template.
      System.err.println("There's no path after this switch.");
      printRightMsg();
      throw new NoFileException("There's no path after this switch.");
    }
  }

  /**
   * Check if the input argument string is an action.
   *
   * @param arg the input argument string.
   * @return true if the argument represents "--email" or "--letter"; false otherwise.
   */
  private boolean isAction(String arg) {
    return arg.equals("--email") || arg.equals("--letter");
  }

  /**
   * Check if the input argument string is a valid switch.
   *
   * @param arg the input argument string.
   * @return true if the argument is one of "--email-template", "--letter-template", "--output-dir",
   *         "--csv-file"; false otherwise.
   */
  private boolean isSwitch(String arg) {
    return arg.equals("--email-template") || arg.equals("--letter-template")
        || arg.equals("--output-dir") || arg.equals("--csv-file");
  }

  /**
   * Print messages when there is invalid arguments.
   */
  private void printRightMsg() {
    printUsageMessages();
    printExampleInputArgs();
  }

  /**
   * Print the usage messages to users so that user can know which kinds of arguments to input.
   */
  private void printUsageMessages() {
    System.out.println("Usage:");
    System.out.println("--email                  only generate email messages");
    System.out.println("--email-template <file>  accepts a filename that holds the email template");
    System.out.println("--letter                 only generate letters");
    System.out.println("--letter-template <file> accepts a filename that holds the email template");
    System.out.println("--output-dir <path>      "
        + "accepts the name of a folder, all output is placed in this folder");
    System.out.println("--csv-file <path>        accepts the name of the csv file to process");
  }

  /**
   * Print the input examples to user.
   */
  private void printExampleInputArgs() {
    System.out.println("Example:");
    System.out.println("--email --email-template email-template.txt "
        + "--output-dir emails --csv-file customer.csv");
    System.out.println("--letter --letter-template letter-template.txt "
        + "--output-dir letters --csv-file customer.csv");
  }


}
