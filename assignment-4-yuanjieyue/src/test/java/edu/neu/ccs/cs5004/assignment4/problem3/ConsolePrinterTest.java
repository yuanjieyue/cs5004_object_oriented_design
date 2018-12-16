package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsolePrinterTest {

  private ConsolePrinter printer;
  private ConsolePrinter sameAsRefPrinter;
  private ConsolePrinter sameAsStatePrinter;
  private ConsolePrinter yetAnotherPrinter;
  private ConsolePrinter nullPrinter;
  private Map map;

  @Before
  public void setUp() throws Exception {
    printer = new ConsolePrinter();
    sameAsRefPrinter = printer;
    sameAsStatePrinter = new ConsolePrinter();
    yetAnotherPrinter = new ConsolePrinter();
    map = new Map();
  }

  @Test
  public void toConsole() {
    printer.toConsole(map);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(printer.equals(sameAsStatePrinter), printer.hashCode() ==
        sameAsStatePrinter.hashCode());

  }

  @Test
  public void testEquals() {
    Assert.assertTrue(printer.equals(printer));
    Assert.assertTrue(printer.equals(sameAsRefPrinter));
    Assert.assertTrue(printer.equals(sameAsStatePrinter));
    Assert.assertEquals(printer.equals(sameAsStatePrinter) && sameAsStatePrinter.equals
        (yetAnotherPrinter), yetAnotherPrinter.equals(printer));
    Assert.assertFalse(printer.equals(nullPrinter));
  }

  @Test
  public void testToString() {
    String tempStr = "ConsolePrinter={}";
    Assert.assertEquals(printer.toString(), tempStr);
  }
}