package edu.neu.ccs.cs5004.assignment10.problem1;

/**
 * A helper class to help display text on stdout in an interesting way.
 */
public class DisplayHelper {

  /**
   * Helper method to present some information in tabular form.
   *
   * @param dimensions dimensions of the table
   * @param headers    Name of each row
   * @param values     Values in each row
   * @return String representation of a table
   * @throws IllegalArgumentException If the dimensions of all the parameters do not match
   */
  public static String createTable(int[] dimensions, String[] headers, String[][] values) {
    if (dimensions == null || headers == null || values == null) {
      throw new IllegalArgumentException("Cannot pass NULL as an argument");
    }

    if (dimensions.length != 2) {
      throw new IllegalArgumentException("We only support 2D table!");
    }
    if (dimensions[0] != headers.length) {
      throw new IllegalArgumentException(
          "Number of header values should equal to number of rows!");
    }
    if (dimensions[0] != values.length) {
      throw new IllegalArgumentException(
          "Number of arrays for values should equal to number of rows!");
    }

    for (String[] arr : values) {
      if (arr == null) {
        throw new IllegalArgumentException("Values of a row cannot be null");
      }
    }

    String table = "";
    int maxHeader = maxLength(headers);
    int maxValues = maxLength(values);
    int lineCount = (maxHeader + 3) + (maxValues + 3) * dimensions[1] - 1;

    table = "\n";
    for (int row = 0; row < dimensions[0]; ++row) {
      if (!headers[row].equals("")) {
        table += createLine("-", lineCount);
      }
      table += String.format(" %" + maxHeader + "s |", headers[row]);
      for (int col = 0; col < dimensions[1]; ++col) {
        table += String.format(" %" + maxValues + "s |", values[row][col]);
      }
      table += "\n";
    }
    table += createLine("-", lineCount);

    return table;
  }

  /**
   * Helper method to draw a line on stdout.
   *
   * @param character Character to be used for creating the line
   * @param count     Length of the line
   * @return String representing the line
   */
  public static String createLine(String character, int count) {
    StringBuilder line = new StringBuilder("");
    for (int i = 0; i < count; ++i) {
      line.append(character);
    }
    line.append("\n");

    return line.toString();
  }

  /**
   * Helper method to calculate the length of maximum string in an array of strings.
   *
   * @param strings Array of string
   * @return Length of longest string in the given array
   */
  private static int maxLength(String[] strings) {
    int max = 0;
    for (String str : strings) {
      if (str.length() > max) {
        max = str.length();
      }
    }
    return max;
  }

  /**
   * Helper method to calculate the length of maximum string in an array of array of string.
   *
   * @param arrayOfStrings Array of array of strings
   * @return Length of longest string in the given 2D array
   */
  private static int maxLength(String[][] arrayOfStrings) {
    int max = 0;
    for (String[] strings : arrayOfStrings) {
      int localMax = maxLength(strings);
      if (localMax > max) {
        max = localMax;
      }
    }
    return max;
  }
}
