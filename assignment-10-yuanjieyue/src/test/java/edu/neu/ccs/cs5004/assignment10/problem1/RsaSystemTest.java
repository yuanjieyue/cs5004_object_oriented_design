package edu.neu.ccs.cs5004.assignment10.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import edu.neu.ccs.cs5004.assignment10.problem1.Pair;
import edu.neu.ccs.cs5004.assignment10.problem1.RsaSystem;

public class RsaSystemTest {

  private BigInteger mod_N;
  private BigInteger key_e;
  private BigInteger key_d;

  private RsaSystem rsa;
  private String origin;

  @Before
  public void setUp() throws Exception {
    rsa = new RsaSystem();
    mod_N = rsa.getModN();
    key_e = rsa.getKeyE();
    key_d = rsa.getKeyD();
    origin = "1234";
  }

  @Test
  public void getMod_N() {
    Assert.assertEquals(rsa.getModN(), mod_N);
  }

  @Test
  public void getKey_e() {
    Assert.assertEquals(rsa.getKeyE(),key_e);
  }

  @Test
  public void getKey_d() {
    Assert.assertEquals(rsa.getKeyD(), key_d);
  }

  @Test
  public void generateKeyPair() {
    Pair<BigInteger, BigInteger> privateKey = new Pair<>(key_e, mod_N);
    Pair<BigInteger, BigInteger> publicKey = new Pair<>(key_d, mod_N);
    Assert.assertEquals(rsa.generateKeyPair(), new Pair<>(privateKey, publicKey));
  }

  @Test
  public void generateSignature() {
    BigInteger plainText = new BigInteger(origin.getBytes());
    BigInteger cipherText = plainText.modPow(key_e, mod_N);
    String sig = cipherText.toString();
    Pair<BigInteger, BigInteger> privateKey = rsa.generateKeyPair().getFirst();
    Assert.assertEquals(rsa.generateSignature(origin, privateKey), sig);
  }

  @Test
  public void verifyMessage() {
    Pair<BigInteger, BigInteger> privateKey = rsa.generateKeyPair().getFirst();
    Pair<BigInteger, BigInteger> publicKey = rsa.generateKeyPair().getSecond();
    String sig = rsa.generateSignature(origin, privateKey);
    Assert.assertTrue(rsa.verifyMessage(origin, sig, publicKey));
  }
}