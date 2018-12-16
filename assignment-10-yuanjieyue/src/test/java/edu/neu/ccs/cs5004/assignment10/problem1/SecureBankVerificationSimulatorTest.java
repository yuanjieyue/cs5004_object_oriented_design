package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment10.problem1.SecureBankVerificationSimulator;

public class SecureBankVerificationSimulatorTest {
  private SecureBankVerificationSimulator simulator;
  private int numOfClients;
  private int numOfVerifications;
  private double percentageOfInvalidMessage;
  private String nameOfOutput;

  @Before
  public void setUp() throws Exception {
    simulator = new SecureBankVerificationSimulator();
    numOfClients = 30;
    numOfVerifications = 15;
    percentageOfInvalidMessage = 50.0;
    nameOfOutput = "out.csv";
    simulator.setNumOfClients(numOfClients);
    simulator.setNumOfSignatureVerfication(numOfVerifications);
    simulator.setPercentageOfInvalidMessage(percentageOfInvalidMessage);
    simulator.setNameOfOutPutFile(nameOfOutput);
  }

  @Test
  public void getNumOfClients() {
    Assert.assertEquals(simulator.getNumOfClients(), 30);
  }

  @Test
  public void setNumOfClients() {
    simulator.setNumOfClients(40);
    Assert.assertEquals(simulator.getNumOfClients(), 40);

  }

  @Test
  public void getNumOfSignatureVerfication() {
    Assert.assertEquals(simulator.getNumOfSignatureVerfication(), 15);
  }

  @Test
  public void setNumOfSignatureVerfication() {
    simulator.setNumOfSignatureVerfication(40);
    Assert.assertEquals(simulator.getNumOfSignatureVerfication(), 40);
  }

  @Test
  public void getPercentageOfInvalidMessage() {
    Assert.assertEquals(simulator.getPercentageOfInvalidMessage(),50.0, 0.001);
  }

  @Test
  public void setPercentageOfInvalidMessage() {
    simulator.setPercentageOfInvalidMessage(70);
    Assert.assertEquals(simulator.getPercentageOfInvalidMessage(), 70, 0.001);
  }

  @Test
  public void getNameOfOutPutFile() {
    Assert.assertEquals(simulator.getNameOfOutPutFile(), "out.csv");
  }

  @Test
  public void setNameOfOutPutFile() {
    simulator.setNameOfOutPutFile("record.csv");
    Assert.assertEquals(simulator.getNameOfOutPutFile(), "record.csv");
  }

  @Test
  public void testToString() {
    String res = "SecureBankVerificationSimulator{numOfClients=30, numOfSignatureVerfication=15, "
        + "percentageOfInvalidMessage=50.0, nameOfOutPutFile='out.csv}";
    Assert.assertEquals(simulator.toString(), res);
  }
}