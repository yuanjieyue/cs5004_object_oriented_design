package edu.neu.ccs.cs5004.assignment10.problem1;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Rrepresents the client.
 */
public class Client {

  private int identity;
  private Pair<BigInteger, BigInteger> privateKey;
  private Pair<BigInteger, BigInteger> publicKey;

  /**
   * Create a new client.
   * @param identity the identity of the client
   * @param privateKey the private key of the client
   * @param publicKey the public key of the client
   */
  public Client(int identity, Pair<BigInteger, BigInteger> privateKey,
                Pair<BigInteger, BigInteger> publicKey) {
    this.identity = identity;
    this.privateKey = privateKey;
    this.publicKey = publicKey;

  }

  /**
   * Getter for property identity.
   * @return Value of the identity
   */
  public int getIdentity() {
    return identity;
  }

  /**
   * Getter for property private key.
   * @return Value of the property private key
   */
  public Pair<BigInteger, BigInteger> getPrivateKey() {
    return privateKey;
  }

  /**
   * Getter for property public key.
   * @return Value of the property public key
   */
  public Pair<BigInteger, BigInteger> getPublicKey() {
    return publicKey;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Client client = (Client) obj;
    return getIdentity() == client.getIdentity()
        && Objects.equals(getPrivateKey(), client.getPrivateKey())
        && Objects.equals(getPublicKey(), client.getPublicKey());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIdentity(), getPrivateKey(), getPublicKey());
  }

  @Override
  public String toString() {
    return "Client{" + "identity=" + identity + ", privateKey=" + privateKey
        + ", publicKey=" + publicKey + '}';
  }
}
