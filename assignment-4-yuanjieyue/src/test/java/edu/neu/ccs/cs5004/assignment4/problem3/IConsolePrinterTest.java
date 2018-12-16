package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IConsolePrinterTest {

  private ConsolePrinter printer;
  private Map map;

  @Before
  public void setUp() throws Exception {
    printer = new ConsolePrinter();
    map = new Map();
  }

  @Test
  public void toConsole() {
    printer.toConsole(map);
  }
}