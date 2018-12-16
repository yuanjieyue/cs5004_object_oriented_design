package edu.neu.ccs.cs5004.assignment10.problem1;

import static java.lang.System.exit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  The simulator that simulate a secure bank verification process.
 */
public class SecureBankVerificationSimulator {
  // Constant variables of the simulator
  public static final int NUM_OF_ARGS = 4;
  public static final int MAX_NUM_OF_CLIENTS = 50000;
  public static final int MAX_NUM_OF_VERIFICATION = 10000;
  public static final int MAX_PERCENTAGE_OF_INVALID_MESSAGE = 100;
  public static final int MAX_VALUE_OF_MESSAGE = 30000;
  public static final int MAX_VALUE_OF_RANDOM_SIGNATURE = 30000;

  private int numOfClients;
  private int numOfSignatureVerfication;
  private double percentageOfInvalidMessage;
  private String nameOfOutPutFile;

  /**
   * Getter for the number of clients of the bank.
   * @return the number of clients that the bank has
   */
  public int getNumOfClients() {
    return numOfClients;
  }

  /**
   * Setter for the property number of clients.
   * @param numOfClients the number of clients to be the given {@code numOfClients}
   */
  public void setNumOfClients(int numOfClients) {
    this.numOfClients = numOfClients;
  }

  /**
   * Getter for the number of signature verifications that we simulate by the simulator.
   * @return the number of signature verifications
   */
  public int getNumOfSignatureVerfication() {
    return numOfSignatureVerfication;
  }

  /**
   * Setter for the property signature verification.
   * @param numOfSignatureVerfication the value to be set to the property
   */
  public void setNumOfSignatureVerfication(int numOfSignatureVerfication) {
    this.numOfSignatureVerfication = numOfSignatureVerfication;
  }

  /**
   * Getter for the percentage of invalid message.
   * @return the percentage of invalide message for the clients that we simulate
   */
  public double getPercentageOfInvalidMessage() {
    return percentageOfInvalidMessage;
  }

  /**
   * Setter for the percentage of invalid message.
   * @param percentageOfInvalidMessage the Value to be set to the property
   */
  public void setPercentageOfInvalidMessage(double percentageOfInvalidMessage) {
    this.percentageOfInvalidMessage = percentageOfInvalidMessage;
  }

  /**
   * Getter for property name of the output file that stores the result of our simulation.
   * @return the name of the output file
   */
  public String getNameOfOutPutFile() {
    return nameOfOutPutFile;
  }

  /**
   * Setter for the property name of output file.
   * @param nameOfOutPutFile the Value to be set to the property
   */
  public void setNameOfOutPutFile(String nameOfOutPutFile) {
    this.nameOfOutPutFile = nameOfOutPutFile;
  }

  @Override
  public String toString() {
    return "SecureBankVerificationSimulator{" + "numOfClients=" + numOfClients
        + ", numOfSignatureVerfication=" + numOfSignatureVerfication
        + ", percentageOfInvalidMessage=" + percentageOfInvalidMessage
        + ", nameOfOutPutFile='" + nameOfOutPutFile + '}';
  }

  /**
   * This is the main method that run the simulator.
   * @param args the command line arguments
   * @throws IOException if one argument is missing, throw proper exception
   */
  public static void main(String[] args) throws IOException {

    SecureBankVerificationSimulator simulator = new SecureBankVerificationSimulator();

    //The first part, parse the command line argument, stores the arguments in the simulator.
    simulator.processArguments(args);
    System.out.println(simulator);
    // A welcome message
    System.out.println("Welcome to the SecureBankVerificationSimulator!");

    // Initialize a random generator, a Rsa system and a bank.
    RandomGenerator generator = new RandomGenerator();
    RsaSystem rsa = new RsaSystem();
    Bank bank = new Bank();

    Map<Integer, Client> clientsPool = new HashMap<>();

    // Generate the number of clients for to simulate randomly, done by a generator.
    System.out.println("Generate the clients");
    simulator.generateClients(generator, rsa, bank, clientsPool);

    // Prepare the output file.
    System.out.println("Dealing with output file");
    File file = new File(simulator.getNameOfOutPutFile());
    if (!file.exists()) {
      System.out.println("file does not exist, create a new one");
      file.createNewFile();
    }
    FileWriter writer = new FileWriter(file, true);
    String header = "Transaction_Num\tDate_and_Time\tClient ID\tMessage\tDigital"
        + "_Signature\tVerified\tTransaction_Status\n";
    writer.write(header);
    System.out.println("Header has been written to the output file");

    // A list that store the ids of all the clients
    List<Integer> keys = new ArrayList<>(clientsPool.keySet());
    System.out.println("The keys choosen: \n" + keys);
    int num = 0;
    while (num < simulator.getNumOfSignatureVerfication()) {
      Integer randomKey = keys.get(generator.generateRandInt(keys.size() - 1));
      Client client = clientsPool.get(randomKey);
      int flag = generator.generateRandInt(100);
      // Generate the number of unique pairs
      Pair<String, String> pair = simulator.generatePair(generator, rsa, client, flag);
      // For every pairs, we go through the the simulation process.
      // Write the result into the output file
      System.out.println("The " + num + " th signature verification is: " + ", randomkey is "
          + randomKey + ", flag is " + flag + ", Pair is " + pair);
      System.out.println("processPair: " + pair);
      simulator.processPair(writer, rsa, client, bank, pair, num);
      num++;
    }
    writer.close();
    System.out.println("A round of simulation completed");
  }

  private void processPair(FileWriter writer, RsaSystem rsa, Client client, Bank bank,
                           Pair<String, String> messageSigPair, int transNum) {
    System.out.println("Method processPair() starts: ");
    Integer identity = client.getIdentity();
    String originMessage = messageSigPair.getFirst();
    String signature = messageSigPair.getSecond();
    Pair<BigInteger, BigInteger> publicKey = bank.getClientsData().get(identity).getPublicKey();

    boolean verified = rsa.verifyMessage(originMessage, signature, publicKey);
    System.out.println("Message verification is : " + verified);
    Pair<String, Boolean> transStatus = getTransStatus(originMessage, client, bank, verified);
    Date date = new Date();
    String record = prepareRecord(transNum, date, identity, originMessage, signature, verified,
        transStatus);

    System.out.println("Record is " + record);

    try {
      writer.write(record);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Method processPair() ends");
  }

  private String prepareRecord(int transNum, Date date, Integer identity, String message,
                                String signature, boolean verified,
                               Pair<String, Boolean> transStatus) {
    System.out.println("Method prepareRecord() starts: ");
    StringBuilder builder = new StringBuilder();

    builder.append(Integer.toString(transNum));
    builder.append("\t");
    builder.append(date.toString());
    builder.append("\t");
    builder.append(Integer.toString(identity));
    builder.append("\t");
    builder.append(message);
    builder.append("\t");
    builder.append(signature);
    builder.append("\t");
    if (verified) {
      builder.append("yes");
    } else {
      builder.append("no");
    }
    builder.append("\t");
    builder.append(transStatus.getFirst());
    if (transStatus.getSecond()) {
      builder.append(" accpeted");
    } else {
      builder.append(" rejected");
    }
    builder.append("\n");
    System.out.println("Method prepareRecord() ends: record is " + builder.toString());
    return builder.toString();
  }


  private Pair<String, Boolean> getTransStatus(String message, Client client, Bank bank,
                                               boolean verified) {
    System.out.println("Method getTransStatus() starts: ");
    int depositLimit = bank.getClientsData().get(client.getIdentity()).getDepositLimit();
    int withdrawLimit = bank.getClientsData().get(client.getIdentity()).getWithDrawLimit();

    int parseMessage = Integer.parseInt(message);
    int lastDigit = parseMessage % 10;
    int transValue = parseMessage / 10;

    String transDirect = "";
    if (lastDigit >= 0 && lastDigit <= 4) {
      transDirect = "Deposit";
    } else {
      transDirect = "Withdraw";
    }

    boolean permitOrNot = false;
    if (verified && transDirect.compareTo("Deposit") == 0 && transValue < depositLimit) {
      permitOrNot = true;
    }
    if (verified && transDirect.compareTo("Withdraw") == 0 && transValue < withdrawLimit) {
      permitOrNot = true;
    }

    System.out.println("Method getTransStatus() ends: pair is " + transDirect + " "
        + permitOrNot);
    return new Pair<>(transDirect, permitOrNot);
  }

  private Pair<String, String> generatePair(RandomGenerator generator, RsaSystem rsa,
                                            Client client, int flag) {
    /*
    In here, we generate the requested number of (message, digital signature) pairs
    The number is supplied as an argument.

    1. Generate a Message, which is randomly choose by The Simulator in [0, 3000], no need to be
    unique for every transaction.
    Last digit is a flay digit: (it should be included for computation of digital signature)
    * 0 - 4 means requesting a deposit
    * 5 - 9 means requesting a withdrawal

    2. Generate a Digital Signature, which has two ways, depending on a message is invalid or not
    * If a message is deemed invalid, then a digit signature should be a randomly generated integer
    * If a message is deemed valid, then a digit signature should be generated by RSA
    */

    System.out.println("Method generatePair() starts: ");
    int randNum = generator.generateRandInt(MAX_VALUE_OF_MESSAGE);
    String message = Integer.toString(randNum);
    // Signature has two situation:
    // 1. the message is valid
    // 2. the message is invalid
    String signature = "";
    if (flag < (int) getPercentageOfInvalidMessage()) {
      int rand = generator.generateRandInt(MAX_VALUE_OF_RANDOM_SIGNATURE);
      signature = Integer.toString(rand);
      System.out.println("Message is invalid");
    } else {
      signature = rsa.generateSignature(message, client.getPrivateKey());
      System.out.println("Message is valid");
    }
    System.out.println("Method generatePair() ends: ");
    return new Pair<>(message,signature);
  }

  private void generateClients(RandomGenerator generator, RsaSystem rsa, Bank bank,
                               Map<Integer, Client> clientsPool) {
    System.out.println("Method: generateClients()");
    System.out.print("Total num of clients is: ");
    System.out.println(numOfClients);
    int num = 0;
    while (num < numOfClients) {
      int clientId = 0;
      do {
        clientId = generator.generateRandInt(MAX_NUM_OF_CLIENTS * 100);
      } while (clientsPool.containsKey(clientId));
      Pair<Pair<BigInteger, BigInteger>, Pair<BigInteger, BigInteger>> rsaPair
          = rsa.generateKeyPair();

      int deposit = generator.generateRandInt(Bank.MAX_DEPOSIT);
      int withdraw = generator.generateRandInt(Bank.MAX_WITHDRAW);
      System.out.print("The " + num + " th client's id is " + clientId + ", deposit limit is "
          + deposit + ", withdraw limit is " + withdraw + "\n");

      clientsPool.put(clientId, new Client(clientId, rsaPair.getFirst(), rsaPair.getSecond()));

      bank.addClientsData(new ClientDataForBank(clientId, rsaPair.getSecond(), deposit, withdraw));
      num++;
    }
    System.out.println("Method generateClients() complete!");
  }


  private void processArguments(String[] args) {
    /*
     Takes in four different arguments.
     1. The number of unique clients that the bank has, in [0, 50000]
     2. The number of distinct digital signature verifications that the bank needs to perform,
        in [0, 10000] for each client.
     3. The percentage of invalid messages, double in [0, 100]:
        0 represents all the messages are correct;
        100 represents all the messages are incorrect.
     4. Output file: A String, represents the name of the output csv.file.
        If the output file does not exist, it should generate automatically.
     The order of the four arguments should be the same.
    */
    if (args.length < NUM_OF_ARGS) {
      throw new CmdLineExceptions.MissingCommandException("You miss some arguments. Please Check "
          + "the Usage.");
    }
    if (args.length > NUM_OF_ARGS) {
      throw new CmdLineExceptions.ExtraArgumentException("You supplied extra arguments. Please "
          + "check the Usage.");
    }
    int clients = 0;
    int verifications = 0;
    double percentage = 0;
    String output = "";
    try {
      clients = Integer.parseInt(args[0]);
      if (clients < 0 || clients > MAX_NUM_OF_CLIENTS) {
        throw new CmdLineExceptions.IllegalValueException("The number of clients should be in the"
            + " range of 0 to " + MAX_NUM_OF_CLIENTS +  " inclusively.");
      }

      verifications = Integer.parseInt(args[1]);
      if (verifications < 0 || verifications > MAX_NUM_OF_VERIFICATION) {
        throw new CmdLineExceptions.IllegalValueException("The number of verifications should be "
            + "in the range of 0 to " + MAX_NUM_OF_VERIFICATION + " inclusively.");
      }

      percentage = Double.parseDouble(args[2]);
      if (percentage < 0 || percentage > MAX_PERCENTAGE_OF_INVALID_MESSAGE) {
        throw new CmdLineExceptions.IllegalValueException("The number of percentage should be in "
            + "the range of 0 to " + MAX_PERCENTAGE_OF_INVALID_MESSAGE + " inclusively.");
      }

      output = args[3];
    } catch (NumberFormatException e) {
      System.err.println("NumberFormatException occurs: " + e.getMessage());
      exit(1);
    }
    setNumOfClients(clients);
    setNumOfSignatureVerfication(verifications);
    setPercentageOfInvalidMessage(percentage);
    setNameOfOutPutFile(output);
  }

}