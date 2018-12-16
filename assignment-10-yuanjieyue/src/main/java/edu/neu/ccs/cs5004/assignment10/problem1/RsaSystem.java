package edu.neu.ccs.cs5004.assignment10.problem1;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * The RSA system that encrypt and decrypt the message.
 */
public class RsaSystem {
  private BigInteger primeP;
  private BigInteger primeQ;
  private BigInteger modN;
  private BigInteger phi;
  private BigInteger keyE;
  private BigInteger keyD;

  /**
   * Create a new RSA system.
   */
  public RsaSystem() {
    Random rand = new SecureRandom();
    int bitLength = 1024;
    primeP = generatePrime(bitLength, rand);
    primeQ = generatePrime(bitLength, rand);
    modN = primeP.multiply(primeQ);
    phi = primeP.subtract(BigInteger.ONE).multiply(primeQ.subtract(BigInteger.ONE));
    keyE = generatePrime(bitLength / 2, rand);
    while (phi.gcd(keyE).compareTo(BigInteger.ONE) > 0 && keyE.compareTo(phi) < 0) {
      keyE = keyE.add(BigInteger.ONE);
    }
    keyD = keyE.modInverse(phi);
  }

  /**
   * Getter for the property mod_N.
   * @return Value of the mod_N
   */
  public BigInteger getModN() {
    return modN;
  }

  /**
   * Getter for the property key_e.
   * @return Value of the key_e
   */
  public BigInteger getKeyE() {
    return keyE;
  }

  /**
   * Getter for the property key_d.
   * @return Value of the key_d
   */
  public BigInteger getKeyD() {
    return keyD;
  }

  /**
   * Generate a random prime number of the given {@code bits}.
   * @param bits the numbe of the binary bits of the generated number
   * @param rand the rand generator
   * @return a large definite prime
   */
  private BigInteger generatePrime(int bits, Random rand) {
    BigInteger prime = new BigInteger("4");
    while (!isPrime(prime)) {
      prime = BigInteger.probablePrime(bits, rand);
    }
    return prime;
  }

  /**
   * Check if a given large number is prime or not.
   * @param num the number to be checked if is a prime
   * @return true if the given {@code num} is prime, false otherwise
   */
  private Boolean isPrime(BigInteger num) {
    //for case num=2, function returns true. detailed explanation underneath
    if (num.intValue() == 2) {
      return true;
    }
    //loops through 2 to sqrt(num). All you need to check- efficient
    for (int i = 2; i <= (int)Math.sqrt(num.intValue()) + 1; i++) {
      //if a divisor is found, its not prime. returns false
      if (num.intValue() % i == 0) {
        return false;
      }
    }
    //if all cases don't divide num, it is prime.
    return true;
  }

  /**
   * Generate key pairs
     1. Alice generates two distinct large primes p and q, and then computes φ(n) = (p − 1)(q − 1),
     and n = p · q.
     2. Alice generates a random integer a that satisfy gcd (a, n) = 1 and gcd (a, φ(n)) = 1, where
     gcd denotes a greatest common divisor.
     3. Alice computes b such that ab ≡ 1 mod φ(n).
     4. Alice’s public key PKA is given by (b, n). Her private key is SKA = (a, n), she keeps it as
     a secret.
   * @return the pair of private key pair and public key pair
   */
  public Pair<Pair<BigInteger, BigInteger>, Pair<BigInteger, BigInteger>> generateKeyPair() {
    Pair<BigInteger, BigInteger> privateKey = new Pair<>(keyE, modN);
    Pair<BigInteger, BigInteger> publicKey = new Pair<>(keyD, modN);
    return new Pair<>(privateKey, publicKey);
  }

  /**
   * Generate digital signature.
   * @param message the original message that the client sends to the bank
   * @param privateKey the private key of the client
   * @return the digital signature of the client
   */
  public String generateSignature(String message, Pair<BigInteger, BigInteger> privateKey) {
    BigInteger plainText = new BigInteger(message.getBytes());
    BigInteger cipherText = encrypt(plainText, privateKey);
    return cipherText.toString();
  }

  /**
   * Encrypt the message.
   * @param plainText the message that to be encrypted
   * @param privateKey the private key of the client
   * @return the encrypted text
   */
  private BigInteger encrypt(BigInteger plainText, Pair<BigInteger, BigInteger> privateKey) {
    BigInteger baseE = privateKey.getFirst();
    BigInteger mod = privateKey.getSecond();
    return plainText.modPow(baseE, mod);
  }

  /**
   * Verify the message.
   * @param message the original message
   * @param signature the digital signature of the client
   * @param publicKey the publickey of the client
   * @return true if the decrypted message of the bank is the same as the original message
   */
  public boolean verifyMessage(String message, String signature,
                               Pair<BigInteger, BigInteger> publicKey) {
    System.out.println("<Method verifyMessage in RsaSystem starts: >");
    System.out.println("..........................................\n");

    System.out.println("-> Original Message is :" + message);
    BigInteger cipherText = new BigInteger(signature);
    System.out.println("-> cipherText/signature is: " +  cipherText);
    BigInteger decipherText = decrypt(cipherText, publicKey);
    System.out.println("-> decipherText is: " + decipherText);
    String decrpytMessage = new String(decipherText.toByteArray());

    boolean verified = message.compareTo(decrpytMessage) == 0;
    if (verified) {
      System.out.println("-> VERIFIED");
    } else {
      System.out.println("-> NOT VERIFIED");
    }
    System.out.println("\n..........................................");
    System.out.println("<Method verifyMessage in RsaSystem ends: >");
    return message.compareTo(decrpytMessage) == 0;
  }

  /**
   * Decrypt message.
   * @param cipherMessage the cipher message generated by the encrypted process
   * @param publicKey the public key of the client
   * @return the decipher message
   */
  private BigInteger decrypt(BigInteger cipherMessage, Pair<BigInteger, BigInteger> publicKey) {
    BigInteger baseD = publicKey.getFirst();
    BigInteger mod = publicKey.getSecond();
    return cipherMessage.modPow(baseD, mod);
  }

  /*
  public static void main(String[] args) throws IOException
  {
    RsaSystem rsa = new RsaSystem();
    rsa.printData();
    Pair<Pair<BigInteger, BigInteger>, Pair<BigInteger, BigInteger>> keyPairs =
        new Pair<>(new Pair<>(rsa.getKey_e(), rsa.getMod_N()), new Pair<>(rsa
            .getKey_d(), rsa.getMod_N()));

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the plain text:");

    String origin;
    origin = scanner.nextLine();
    BigInteger a = new BigInteger(origin);

    BigInteger b = rsa.encrypt(a, keyPairs.getFirst());
    String signature = new String(b.toByteArray());
    BigInteger c = new BigInteger(signature.getBytes());

    BigInteger d = rsa.decrypt(c, keyPairs.getSecond());
    String fnal = new String(d.toByteArray());

    BigInteger d2 = rsa.decrypt(b, keyPairs.getSecond());
    String fnal2 = d2.toString();

    System.out.println("Origin String is " + origin + "\n");
    System.out.println("Origin BigInteger is " + a +"\n");
    System.out.println("Cipher BigInteger is " + b + "\n");
    System.out.println("Signature is " + signature + "\n");
    System.out.println("Signature biginteger is " + c + "\n");
    System.out.println("Decipher Biginteger is " + d + "\n");
    System.out.println("Decipher String is " + fnal + "\n");

    System.out.println("2 Decipher Biginteger is " + d2 + "\n");
    System.out.println("2 Decipher String is " + fnal2 + "\n");
  }
  */
}
