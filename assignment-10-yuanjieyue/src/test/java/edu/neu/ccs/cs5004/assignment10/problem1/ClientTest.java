package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import edu.neu.ccs.cs5004.assignment10.problem1.Client;
import edu.neu.ccs.cs5004.assignment10.problem1.Pair;

public class ClientTest {
  private int identity1;
  private int identity2;


  private Pair<BigInteger, BigInteger> privateKey1;
  private Pair<BigInteger, BigInteger> privateKey2;
  private Pair<BigInteger, BigInteger> publicKey1;
  private Pair<BigInteger, BigInteger> publicKey2;

  private Client client1;
  private Client client2;
  private Client client3;
  private Client client4;
  private Client sameAsRefClient;
  private Client sameAsStateClient;
  private Client yetAnotherClient;
  private Client nullClient;

  @Before
  public void setUp() throws Exception {
    identity1 = 11211;
    identity2 = 223223;
    BigInteger e1 = new BigInteger("2323");
    BigInteger e2 = new BigInteger("23231");
    BigInteger n = new BigInteger("23231232");
    BigInteger d1 = new BigInteger("211122");
    BigInteger d2 = new BigInteger("256772");
    privateKey1 = new Pair<>(e1, n);
    privateKey2 = new Pair<>(e2, n);
    publicKey1 = new Pair<>(d1, n);
    publicKey2 = new Pair<>(d2, n);

    client1 = new Client(identity1, privateKey1, publicKey1);
    client2 = new Client(identity2, privateKey1, publicKey1);
    client3 = new Client(identity1, privateKey2, publicKey1);
    client4 = new Client(identity1, privateKey1, publicKey2);
    sameAsRefClient = client1;
    sameAsStateClient = new Client(identity1, privateKey1, publicKey1);
    yetAnotherClient = new Client(identity1, privateKey1, publicKey1);
  }

  @Test
  public void getIdentity() {
    Assert.assertEquals(client1.getIdentity(), 11211);
  }

  @Test
  public void getPrivateKey() {
    Assert.assertEquals(client1.getPrivateKey(), new Pair<>(new BigInteger("2323"), new BigInteger
        ("23231232")));
  }

  @Test
  public void getPublicKey() {
    Assert.assertEquals(client1.getPublicKey(), new Pair<>(new BigInteger("211122"), new BigInteger
        ("23231232")));
  }

  @Test
  public void equals() {
    Assert.assertTrue(client1.equals(client1));
    Assert.assertTrue(client1.equals(sameAsRefClient));
    Assert.assertTrue(client1.equals(sameAsStateClient));
    Assert.assertEquals(client1.equals(sameAsStateClient) && sameAsStateClient.equals
        (yetAnotherClient), client1.equals(sameAsStateClient));

    Assert.assertFalse(client1.equals(client2));
    Assert.assertFalse(client1.equals(client3));
    Assert.assertFalse(client1.equals(client4));
    Assert.assertFalse(client1.equals(identity1));
    Assert.assertFalse(client1.equals(nullClient));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(client1.equals(sameAsStateClient), client1.hashCode() ==
        sameAsStateClient.hashCode());
    Assert.assertEquals(client1.equals(client2), client1.hashCode() == client2.hashCode());
  }

  @Test
  public void testToString() {
    String res = "Client{identity=11211, privateKey=Pair{first=2323, second=23231232}, "
        + "publicKey=Pair{first=211122, second=23231232}}";
    Assert.assertEquals(client1.toString(), res);
  }
}