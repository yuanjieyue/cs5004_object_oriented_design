package edu.neu.ccs.cs5004.filereader;

import edu.neu.ccs.cs5004.Member;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represent the implementation of input reader.
 */
public class InputReaderImpl implements InputReader {

  private Map<String, Integer> columnAndIndexMap;
  private List<Member> members;

  InputReaderImpl() {
    this.columnAndIndexMap = new HashMap<>();
    this.members = new ArrayList<>();
  }

  @Override
  public Map<String, Integer> readIncsvFiles(String inputcsvFileName) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputcsvFileName))) {
      String customerFileLine;
      boolean firstRow = true;
      while ((customerFileLine = bufferedReader.readLine()) != null) {
        // remove all the quotes and commas before doing anything
        String[] info = preprocess(customerFileLine);
        if (firstRow) {
          initPlaceHolderMap(info);
          firstRow = false;
        } else {
          Member member = new Member();
          for (String attribute : info) {
            member.getMemberInfo().add(attribute);
          }
          members.add(member);
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    return columnAndIndexMap;
  }

  @Override
  public List<Member> getMembers() {
    return this.members;
  }

  /**
   * Remove all the quotes and commas and split the row into an array of attributes.
   *
   * @param customerFileLine a single row in the csv file.
   * @return a string array which includes all the attibutes.
   */
  private String[] preprocess(String customerFileLine) {
    // there are 2 kinds of splitters: ", and ,".
    String[] split = customerFileLine.split("\",|,\"");
    // after splitting, remove all redundant quotes.
    for (int i = 0; i < split.length; i++) {
      split[i] = split[i].replace("\"", "");
    }
    return split;
  }

  /**
   * Read the first row of the input csv file and process the titles as placeholders.
   *
   * @param info an array of string including all the titles in the first row of the input csv
   *             file.
   */
  private void initPlaceHolderMap(String[] info) {
    for (int i = 0; i < info.length; i++) {
      columnAndIndexMap.put("[[" + info[i] + "]]", i);
    }
  }


}
