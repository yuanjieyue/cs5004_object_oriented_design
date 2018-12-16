package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import edu.neu.ccs.cs5004.assignment10.problem1.ClientDataForBank;
import edu.neu.ccs.cs5004.assignment10.problem1.Pair;

public class ClientDataForBankTest {
  private int identity1;
  private int identity2;

  private Pair<BigInteger, BigInteger> publicKey1;
  private Pair<BigInteger, BigInteger> publicKey2;

  private int depositLimit1;
  private int depositLimit2;

  private int withdrawLimit1;
  private int withdrawLimit2;

  private ClientDataForBank client1;
  private ClientDataForBank client2;
  private ClientDataForBank client3;
  private ClientDataForBank client4;
  private ClientDataForBank client5;
  private ClientDataForBank sameAsRefClient;
  private ClientDataForBank sameAsStateClient;
  private ClientDataForBank yetAnotherClient;
  private ClientDataForBank nullClient;

  @Before
  public void setUp() throws Exception {
    identity1 = 11211;
    identity2 = 223223;

    BigInteger n = new BigInteger("23231232");
    BigInteger d1 = new BigInteger("211122");
    BigInteger d2 = new BigInteger("256772");

    publicKey1 = new Pair<>(d1, n);
    publicKey2 = new Pair<>(d2, n);

    depositLimit1 = 1212;
    depositLimit2 = 2323;

    withdrawLimit1 = 2244;
    withdrawLimit2 = 3434;

    client1 = new ClientDataForBank(identity1, publicKey1, depositLimit1, withdrawLimit1);
    client2 = new ClientDataForBank(identity1, publicKey2, depositLimit1, withdrawLimit1);
    client3 = new ClientDataForBank(identity1, publicKey1, depositLimit2, withdrawLimit1);
    client4 = new ClientDataForBank(identity1, publicKey1, depositLimit1, withdrawLimit2);
    client5 = new ClientDataForBank(identity2, publicKey2, depositLimit2, withdrawLimit2);
    sameAsRefClient = client1;
    sameAsStateClient = new ClientDataForBank(identity1, publicKey1, depositLimit1, withdrawLimit1);
    yetAnotherClient = new ClientDataForBank(identity1, publicKey1, depositLimit1, withdrawLimit1);
  }


  @Test
  public void getIdentity() {
    Assert.assertEquals(client1.getIdentity(), 11211);
  }

  @Test
  public void getPublicKey() {
    Assert.assertEquals(client1.getPublicKey(), new Pair<>(new BigInteger("211122"), new
        BigInteger("23231232")));
  }

  @Test
  public void getDepositLimit() {
    Assert.assertEquals(client1.getDepositLimit(), 1212);
  }

  @Test
  public void getWithDrawLimit() {
    Assert.assertEquals(client1.getWithDrawLimit(), 2244);
  }

  @Test
  public void equals() {
    Assert.assertTrue(client1.equals(client1));
    Assert.assertTrue(client1.equals(sameAsRefClient));
    Assert.assertTrue(client1.equals(sameAsStateClient));
    Assert.assertEquals(client1.equals(sameAsStateClient) && sameAsStateClient.equals
        (yetAnotherClient), client1.equals(sameAsStateClient));

    Assert.assertFalse(client1.equals(publicKey1));
    Assert.assertFalse(client1.equals(client2));
    Assert.assertFalse(client1.equals(client3));
    Assert.assertFalse(client1.equals(client4));
    Assert.assertFalse(client1.equals(client5));
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
    String res = "ClientDataForBank{identity=11211, publicKey=Pair{first=211122, second=23231232}, "
        + "depositLimit=1212, withDrawLimit=2244}";
    Assert.assertEquals(client1.toString(), res);
  }
}