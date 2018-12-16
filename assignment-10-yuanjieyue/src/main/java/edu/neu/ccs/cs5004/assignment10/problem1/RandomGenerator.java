package edu.neu.ccs.cs5004.assignment10.problem1;

import java.util.Random;

/**
 * Represents a random number generator.
 */
public class RandomGenerator {

  private static final Random RAND = new Random();

  /**
   * Generate a random integer in the range of [0, {@code upperBound}].
   * @param upperBound the upper bound of the generated integer
   * @return the random integer
   */
  public int generateRandInt(int upperBound) {
    return RAND.nextInt(upperBound + 1);
  }

  /**
   * Generate a random double number in the range of [0, {@code upperBound}].
   * @param upperBound the upper bound of the generated double
   * @return the random double
   */
  public double generateRandDouble(double upperBound) {
    double ret = RAND.nextDouble() * (upperBound + 1);
    return ret > upperBound ? upperBound : ret;
  }

  /**
   * Main method that runs the random generator.
   * @param args the command line arguments
   */
  /*
  public static void main(String[] args) {
    RandomGenerator generator = new RandomGenerator();

    int nextInt = generator.generateRandInt(100);
    double nextDouble = generator.generateRandDouble(100);

    System.out.println(nextInt);
    System.out.println(nextDouble);
  }
  */
}
