package edu.neu.ccs.cs5004.assignment10.problem1;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents the data struct that the bank keeps records of its clients.
 */
public class ClientDataForBank {

  private int identity;
  private Pair<BigInteger, BigInteger> publicKey;
  private int depositLimit;
  private int withDrawLimit;

  /**
   * Create a new client data for bank.
   *
   * @param identity the identity of hte client of the bank
   * @param publicKey the public key of the client
   * @param depositLimit the deposit limit that the bank set for the client
   * @param withDrawLimit the withdraw limit that the bank set for the client
   */
  public ClientDataForBank(int identity, Pair<BigInteger, BigInteger> publicKey, int depositLimit,
                           int withDrawLimit) {
    this.identity = identity;
    this.publicKey = publicKey;
    this.depositLimit = depositLimit;
    this.withDrawLimit = withDrawLimit;
  }

  /**
   * Getter for property identity.
   * @return Value of property identity
   */
  public int getIdentity() {
    return identity;
  }

  /**
   * Getter of for the property public key.
   * @return Value of property public key
   */
  public Pair<BigInteger, BigInteger> getPublicKey() {
    return publicKey;
  }

  /**
   * Getter of the property deposit limit.
   *
   * @return Value of property deposit limit
   */
  public int getDepositLimit() {
    return depositLimit;
  }

  /**
   * Getter for the property withdraw limit.
   *
   * @return Value of property withdraw limit
   */
  public int getWithDrawLimit() {
    return withDrawLimit;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ClientDataForBank that = (ClientDataForBank) obj;
    return getIdentity() == that.getIdentity()
        && getDepositLimit() == that.getDepositLimit()
        && getWithDrawLimit() == that.getWithDrawLimit()
        && Objects.equals(getPublicKey(), that.getPublicKey());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIdentity(), getPublicKey(), getDepositLimit(), getWithDrawLimit());
  }

  @Override
  public String toString() {
    return "ClientDataForBank{" + "identity=" + identity + ", publicKey=" + publicKey
        + ", depositLimit=" + depositLimit + ", withDrawLimit=" + withDrawLimit + '}';
  }
}
