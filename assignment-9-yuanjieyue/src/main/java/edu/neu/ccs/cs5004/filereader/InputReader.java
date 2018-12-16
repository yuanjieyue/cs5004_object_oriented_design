package edu.neu.ccs.cs5004.filereader;

import edu.neu.ccs.cs5004.Member;

import java.util.List;
import java.util.Map;

public interface InputReader {
  /**
   * Create a new file reader.
   *
   * @return a new file reader.
   */
  static InputReader createEmptyFileReader() {
    return new InputReaderImpl();
  }

  /**
   * Read the member csv file.
   *
   * @param inputcsvFileName the name of the input csv file.
   * @return a map where key is placeholder text, value is index.
   */
  Map<String, Integer> readIncsvFiles(String inputcsvFileName);

  /**
   * Getter for property 'members'.
   *
   * @return the value of list 'members'.
   */
  List<Member> getMembers();

}
