package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {

  private Cell shipCell1;
  private Cell shipCell2;
  private Cell shipCell3;
  private Cell shipCell4;
  private Cell waterCell;
  private Map map;
  private Map map2;
  private Map sameAsRefMap;
  private Map sameAsStateMap;
  private Map yetAnotherMap;
  private Map nullMap;
  private ConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    shipCell1 = new SpecifiedCell(false, false);
    shipCell2 = new SpecifiedCell(false, true);
    shipCell3 = new SpecifiedCell(true, false);
    shipCell4 = new SpecifiedCell(true, true);
    waterCell = new OpenSeaCell(false);
    map = new Map();
    map2 = new Map();
    sameAsRefMap = map;
    sameAsStateMap = new Map();
    yetAnotherMap = new Map();
    printer = new ConsolePrinter();
  }

  @Test
  public void createMap() {
    Assert.assertEquals(map, IMap.createMap());
    Assert.assertEquals(new Map(), IMap.createMap());
  }

  @Test(expected = IncorrcetIndexException.class)
  public void getCell() {
    Assert.assertEquals(map.getCell(new Posn(2, 2)), waterCell);
    map.setCell(new Posn(9, 9), shipCell1);
    Assert.assertEquals(map.getCell(new Posn(9, 9)), shipCell1);
    map.setCell(new Posn(7, 7), shipCell2);
    Assert.assertEquals(map.getCell(new Posn(7, 7)), shipCell2);
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
    map.setCell(new Posn(1,1), shipCell1);
    map.setCell(new Posn(2,2), shipCell1);
    map.setCell(new Posn(3,3), shipCell1);
    map.setCell(new Posn(3,4), shipCell1);
    map.setCell(new Posn(3,5), shipCell1);
    map.setCell(new Posn(4,6), shipCell1);
    map.setCell(new Posn(5,6), shipCell1);
    map.setCell(new Posn(3,2), shipCell1);
    map.setCell(new Posn(1,6), shipCell1);
    map.setCell(new Posn(2,8), shipCell1);
    map.setCell(new Posn(4,7), shipCell1);
    map.setCell(new Posn(7,2), shipCell1);
    map.setCell(new Posn(8,8), shipCell1);
    map.setCell(new Posn(4,9), shipCell1);
    map.setCell(new Posn(7,5), shipCell1);
    map.setCell(new Posn(5,9), shipCell1);
    map.setCell(new Posn(10,10), shipCell1);
    map.setCell(new Posn(9,2), shipCell1);
    map.setCell(new Posn(8,3), shipCell1);
    printer.toConsole(map);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(map.equals(map));
    Assert.assertTrue(map.equals(sameAsRefMap));
    Assert.assertTrue(map.equals(sameAsStateMap));
    Assert.assertEquals(map.equals(sameAsStateMap) && sameAsStateMap.equals(yetAnotherMap),
        yetAnotherMap.equals(map));
    Assert.assertFalse(map.equals(nullMap));
    map.setCell(new Posn(4,4), shipCell2);
    Assert.assertFalse(map.equals(map2));
    map2.setCell(new Posn(4,4), shipCell3);
    Assert.assertFalse(map.equals(map2));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(map.equals(sameAsStateMap), map.hashCode() == sameAsStateMap.hashCode());
    map.setCell(new Posn(3,3), shipCell4);
    Assert.assertEquals(map.equals(map2), map.hashCode() == map2.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = ("Map{row=10, column=10, fields:\n"
        + "Posn{x=1, y=1} -> SpecifiedCell{isHit=false, belongToSunk=false}\n"
        + "Posn{x=1, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=1, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=2} -> SpecifiedCell{isHit=false, belongToSunk=false}\n"
        + "Posn{x=2, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=2, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=3} -> SpecifiedCell{isHit=false, belongToSunk=false}\n"
        + "Posn{x=3, y=4} -> SpecifiedCell{isHit=false, belongToSunk=false}\n"
        + "Posn{x=3, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=3, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=4, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=5, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=6, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=7, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=8, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=9, y=10} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=1} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=2} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=3} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=4} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=5} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=6} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=7} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=8} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=9} -> OpenSeaCell{isHit=false}\n"
        + "Posn{x=10, y=10} -> OpenSeaCell{isHit=false}\n"
        + "}");
    map.setCell(new Posn(1,1), shipCell1);
    map.setCell(new Posn(2,2), shipCell1);
    map.setCell(new Posn(3,3), shipCell1);
    map.setCell(new Posn(3,4), shipCell1);
    Assert.assertEquals(map.toString(), tempStr);
  }
}