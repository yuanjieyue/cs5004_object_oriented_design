package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.*;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.UnsupportedOperationException;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class EnemyCellTest {
  private Ship ship;
  private EnemyCell enemyCell;
  private EnemyCell sameRef;
  private EnemyCell sameState;
  private EnemyCell diff1;
  private EnemyCell diff2;
  private Posn p1;
  
  @Before
  public void setUp() throws Exception {
    p1 = new Posn(1, 1);
    ship = Ship.createBattleShip();
    enemyCell = new EnemyCell(true, p1, false);
    sameRef = enemyCell;
    sameState = new EnemyCell(true, p1, false);
    diff1 = new EnemyCell(true, new Posn(2, 2), false);
    diff2 = new EnemyCell(true, p1, true);
    
  }
  
  @Test
  public void markShipCellSunk() {
    enemyCell.markShipCellSunk();
    Assert.assertTrue(enemyCell.isSunk());
  }
  
  @Test (expected = UnsupportedOperationException.class)
  public void attackCell() {
    enemyCell.attackCell();
  }
  
  @Test (expected = UnsupportedOperationException.class)
  public void attackResult() {
    enemyCell.attackResult();
  }
  
  
  @Test
  public void prettyPrint() {
    enemyCell.prettyPrint(new ConsolePrinter());
  }
  
  @Test
  public void equals() {
    Assert.assertEquals(enemyCell, sameRef);
    Assert.assertEquals(enemyCell, sameState);
    Assert.assertNotEquals(enemyCell, (EnemyCell) null);
    Assert.assertNotEquals(enemyCell, "enemy");
    Assert.assertNotEquals(enemyCell, diff1);
    Assert.assertNotEquals(enemyCell, diff2);
  }
  
  
  
  @Test
  public void testToString() {
    System.out.println(enemyCell.toString());
  }
  
}