package edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.WaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipObserver;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.ShipSubject;

public class ConsolePrinterTest {
  private ConsolePrinter printer;
  private ConsolePrinter sameAsRefPrinter;
  private ConsolePrinter sameAsStatePrinter;
  private ConsolePrinter yetAnotherPrinter;
  private ConsolePrinter nullPrinter;
  private Map map;
  private WaterCell waterCell1;
  private WaterCell waterCell2;
  private WaterCell waterCell3;
  private SpecifiedCell specifiedCell;
  private EnemyCell enemyCell1;
  private EnemyCell enemyCell2;
  private EnemyCell enemyCell3;
  private ShipSubject shipSubject;

  @Before
  public void setUp() throws Exception {
    printer = new ConsolePrinter();
    sameAsRefPrinter = printer;
    sameAsStatePrinter = new ConsolePrinter();
    yetAnotherPrinter = new ConsolePrinter();

    waterCell1 = (WaterCell) Cell.createOpenSeaCell(true, new Posn(2,1));
    waterCell2 = (WaterCell) Cell.createOpenSeaCell(false, new Posn(3, 4));
    waterCell2 = (WaterCell) Cell.createGapCell(false, new Posn(5, 4));
    shipSubject = new ShipSubject(Ship.createBattleShip(), new ArrayList<ShipObserver>());
    specifiedCell = (SpecifiedCell) Cell.createSpecifiedCell(false, new Posn(6, 7), false, shipSubject);
    enemyCell1 = (EnemyCell) Cell.createEnemyCell(false, new Posn(2,8), false);
    enemyCell2 = (EnemyCell) Cell.createEnemyCell(true, new Posn(3,8), false);
    enemyCell3 = (EnemyCell) Cell.createEnemyCell(true, new Posn(4,8), true);
    map = Map.createMap();
    map.setCell(new Posn(2, 1), waterCell1);
    map.setCell(new Posn(3, 4), waterCell2);
    map.setCell(new Posn(5,4), waterCell3);
    map.setCell(new Posn(6, 7), specifiedCell);
    map.setCell(new Posn(2, 8), enemyCell1);
    map.setCell(new Posn(3, 8), enemyCell2);
    map.setCell(new Posn(4, 8), enemyCell3);
  }

  @Test
  public void toConsole() {
    printer.toConsole(map);
  }

  @Test
  public void toConsole1() {
    printer.toConsole(waterCell1);
    printer.toConsole(waterCell1);
    printer.toConsole(waterCell1);
  }

  @Test
  public void toConsole2() {
    printer.toConsole(specifiedCell);
  }

  @Test
  public void toConsole3() {
    printer.toConsole(enemyCell1);
    printer.toConsole(enemyCell2);
    printer.toConsole(enemyCell3);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(printer.equals(sameAsStatePrinter), printer.hashCode() ==
        sameAsStatePrinter.hashCode());
    Assert.assertEquals(printer.equals(map), printer.hashCode() ==
        map.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(printer.equals(printer));
    Assert.assertTrue(printer.equals(sameAsRefPrinter));
    Assert.assertTrue(printer.equals(sameAsStatePrinter));
    Assert.assertEquals(printer.equals(sameAsStatePrinter) && sameAsStatePrinter.equals
        (yetAnotherPrinter), yetAnotherPrinter.equals(printer));
    Assert.assertFalse(printer.equals(nullPrinter));
    Assert.assertFalse(printer.equals(map));
  }

  @Test
  public void testToString() {
    String tempStr = "ConsolePrinter={}";
    Assert.assertEquals(printer.toString(), tempStr);
  }
}