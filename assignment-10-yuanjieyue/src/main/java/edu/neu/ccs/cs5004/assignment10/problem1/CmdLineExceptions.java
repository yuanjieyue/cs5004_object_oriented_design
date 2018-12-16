package edu.neu.ccs.cs5004.assignment10.problem1;


/**
 * Class to handle all Command Line Arguments related exceptions.
 */
public abstract class CmdLineExceptions extends RuntimeException {
  private static String[] flags;
  private static String[][] explanations;
  private static String usageHelp;

  /**
   * This constructor prints the error message on command line and exits successfully.
   * @param msg Error message
   */
  public CmdLineExceptions(String msg) {
    super(msg + "\n" + usageHelp);
  }


  /**
   * Class to handle errors related to missing command line arguments.
   */
  public static class MissingCommandException extends CmdLineExceptions {
    /**
     * This constructor passes the error message to its super class.
     * @param msg Error message
     */
    public MissingCommandException(String msg) {
      super(msg);
    }
  }

  /**
   * Class to handle errors related to unnecessary arguments passed in command line arguments.
   */
  public static class ExtraArgumentException extends CmdLineExceptions {
    public ExtraArgumentException(String msg) {
      super(msg);
    }
  }

  /**
   * Class to handle errors related to illegal values to command line flags.
   */
  public static class IllegalValueException extends CmdLineExceptions {
    public IllegalValueException(String msg) {
      super(msg);
    }
  }

  //Used for USAGE help generation
  static {
    flags = new String[]{
        "REQUIRED ARGUMENTS",
        "Num of Clients",
        "Num of digital verification",
        "Percentage of invalid message",
        "Name of outputfile"
    };
    explanations = new String[][]{
        {"EXPLANATION"},
        {"The num of clients that the bank has, in the range of [0, "
            + SecureBankVerificationSimulator.MAX_NUM_OF_CLIENTS + "]"},
        {"The num of different digital signature verfications, in the range of [0, "
            + SecureBankVerificationSimulator.MAX_NUM_OF_VERIFICATION + "]"},
        {"The percentage of invalid message, in the range of [0, "
            + SecureBankVerificationSimulator.MAX_PERCENTAGE_OF_INVALID_MESSAGE + "]"},
        {"Provide the name of the outputfile."},
    };
  }

  //Used to represent USAGE help report in tabular form
  static {
    usageHelp = "Usage:";
    usageHelp += DisplayHelper.createTable(
        new int[]{flags.length, explanations[0].length},
        flags,
        explanations);
  }
}

