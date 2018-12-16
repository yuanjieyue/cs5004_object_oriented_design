package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import edu.neu.ccs.cs5004.assignment10.problem1.Bank;
import edu.neu.ccs.cs5004.assignment10.problem1.ClientDataForBank;
import edu.neu.ccs.cs5004.assignment10.problem1.Pair;

public class BankTest {
  private int identity1;
  private int identity2;
  private int identity3;
  private int identity4;

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

  private Map<Integer, ClientDataForBank> clientsData1;
  private Map<Integer, ClientDataForBank> clientsData2;

  private Bank bank;
  private Bank bank1;
  private Bank sameAsRefBank;
  private Bank sameAsStateBank;
  private Bank yetAnotherBank;
  private Bank nullBank;

  @Before
  public void setUp() throws Exception {
    identity1 = 11211;
    identity2 = 112111;
    identity3 = 2232231;
    identity4 = 22322311;

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
    client2 = new ClientDataForBank(identity2, publicKey2, depositLimit1, withdrawLimit1);
    client3 = new ClientDataForBank(identity3, publicKey1, depositLimit2, withdrawLimit1);
    client4 = new ClientDataForBank(identity4, publicKey1, depositLimit1, withdrawLimit2);

    bank = new Bank();
    bank.addClientsData(client1);
    bank.addClientsData(client3);

    bank1 = new Bank();
    bank1.addClientsData(client2);
    bank1.addClientsData(client4);

    sameAsRefBank = bank;
    sameAsStateBank = new Bank();
    sameAsStateBank.addClientsData(client1);
    sameAsStateBank.addClientsData(client3);
    yetAnotherBank = new Bank();
    yetAnotherBank.addClientsData(client1);
    yetAnotherBank.addClientsData(client3);
  }

  @Test
  public void addClientsData() {
    bank.addClientsData(client2);
    Map<Integer, ClientDataForBank> map = new HashMap<>();
    map.put(identity1, client1);
    map.put(identity3, client3);
    map.put(identity2, client2);
    Assert.assertEquals(bank.getClientsData(), map);
  }

  @Test
  public void getClientsData() {
    Map<Integer, ClientDataForBank> map = new HashMap<>();
    map.put(identity1, client1);
    map.put(identity3, client3);
    Assert.assertEquals(bank.getClientsData(), map);
  }

  @Test
  public void equals() {
    Assert.assertTrue(bank.equals(bank));
    Assert.assertTrue(bank.equals(sameAsRefBank));
    Assert.assertTrue(bank.equals(sameAsStateBank));
    Assert.assertEquals(bank.equals(sameAsStateBank) && sameAsRefBank.equals(yetAnotherBank),
        bank.equals(yetAnotherBank));
    Assert.assertFalse(bank.equals(bank1));
    Assert.assertFalse(bank.equals(nullBank));
    Assert.assertFalse(bank.equals(client1));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(bank.equals(sameAsStateBank), bank.hashCode() == sameAsStateBank.hashCode());
    Assert.assertEquals(bank.equals(bank1), bank.hashCode() == bank1.hashCode());
  }

  @Test
  public void testToString() {
    String res = "Bank{clientsData={2232231=ClientDataForBank{identity=2232231, publicKey=Pair{first"
        + "=211122, second=23231232}, depositLimit=2323, withDrawLimit=2244}, 11211=ClientDataForBank"
        + "{identity=11211, publicKey=Pair{first=211122, second=23231232}, depositLimit=1212, "
        + "withDrawLimit=2244}}}";
    Assert.assertEquals(bank.toString(), res);
  }
}