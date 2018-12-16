package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IMapTest {


  private Cell shipCell1;
  private Cell shipCell2;
  private Cell shipCell3;
  private Cell shipCell4;
  private Cell waterCell;
  private IMap map;
  private ConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    shipCell1 = new SpecifiedCell(false, false);
    shipCell2 = new SpecifiedCell(false, true);
    shipCell3 = new SpecifiedCell(true, false);
    shipCell4 = new SpecifiedCell(true, true);
    waterCell = new OpenSeaCell(false);
    map = new Map();
    printer = new ConsolePrinter();
  }

  @Test
  public void createMap() {
    Assert.assertEquals(map, IMap.createMap());
    Assert.assertEquals(new Map(), IMap.createMap());
  }

  @Test(expected = IncorrcetIndexException.class)
  public void getCell() {
    Assert.assertEquals(map.getCell(new Posn(1, 2)), waterCell);
    map.setCell(new Posn(9, 9), shipCell1);
    Assert.assertEquals(map.getCell(new Posn(9, 9)), shipCell1);
    map.setCell(new Posn(7, 7), shipCell2);
    Assert.assertEquals(map.getCell(new Posn(0, 7)), shipCell2);
    Assert.assertEquals(map.getCell(new Posn(7, 17)), shipCell2);
    Assert.assertEquals(map.getCell(new Posn(-1, 7)), shipCell2);
  }

  @Test(expected = IncorrcetIndexException.class)
  public void setCell() {
    map.setCell(new Posn(9, 9), shipCell1);
    Assert.assertEquals(map.getCell(new Posn(9, 9)), shipCell1);
    map.setCell(new Posn(7, 7), shipCell2);
    Assert.assertEquals(map.getCell(new Posn(7, 7)), shipCell2);
    map.setCell(new Posn(0, 2), shipCell2);
    map.setCell(new Posn(2, 12), shipCell2);
    map.setCell(new Posn(0, 12), shipCell2);
  }

  @Test
  public void prettyPrint() {
    printer.toConsole(map);
  }
}