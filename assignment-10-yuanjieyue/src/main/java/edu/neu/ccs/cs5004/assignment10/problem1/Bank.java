package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents the bank.
 */
public class Bank {
  public static final int MAX_DEPOSIT = 2000;
  public static final int MAX_WITHDRAW = 3000;

  private Map<Integer, ClientDataForBank> clientsData;

  /**
   * Create a new bank.
   */
  public Bank() {
    clientsData = new HashMap<>();
  }

  /**
   * Add clients data into the data pool of the bank.
   * @param clientData the data pool of the bank
   */
  public void addClientsData(ClientDataForBank clientData) {
    clientsData.put(clientData.getIdentity(), clientData);
  }

  /**
   * Getter for the property clients data.
   * @return Value of the property clients data
   */
  public Map<Integer, ClientDataForBank> getClientsData() {
    return clientsData;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Bank bank = (Bank) obj;
    return Objects.equals(getClientsData(), bank.getClientsData());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClientsData());
  }

  @Override
  public String toString() {
    return "Bank{" + "clientsData=" + clientsData + '}';
  }
}
