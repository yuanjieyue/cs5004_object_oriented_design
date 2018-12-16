package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

public class AbstractWaterCellTest {
  private Boolean isHit;
  private Boolean notIsHit;
  private Posn posn1;
  private Posn posn2;
  private Ship ship;
  private AbstractWaterCell cell1;
  private AbstractWaterCell cell2;
  private AbstractWaterCell cell3;
  private AbstractWaterCell cell4;
  private AbstractWaterCell sameRefAWCell;
  private AbstractWaterCell sameStateAWCell;
  private AbstractWaterCell yetAnotherAWCell;
  private AbstractWaterCell nullAWCell;


  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    posn1 = new Posn(3,6);
    posn2 = new Posn(8, 2);
    ship = new BattleShip(0);
    cell1 = new OpenSeaCell(isHit, posn1);
    cell2 = new OpenSeaCell(notIsHit, posn1);
    cell3 = new OpenSeaCell(isHit, posn2);
    cell4 = new GapCell(notIsHit, posn2);
    sameRefAWCell = cell1;
    sameStateAWCell = new OpenSeaCell(isHit, posn1);
    yetAnotherAWCell = new OpenSeaCell(isHit, posn1);
  }

  @Test
  public void attackCell() {
    cell1.attackCell();
    Assert.assertEquals(cell1, Cell.createOpenSeaCell(true, posn1));
    cell3.attackCell();
    Assert.assertEquals(cell4, Cell.createGapCell(false, posn2));
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(cell1.attackResult(), AttackResult.MISS);
    Assert.assertEquals(cell2.attackResult(), AttackResult.MISS);
    Assert.assertEquals(cell4.attackResult(), AttackResult.MISS);
  }

  @Test
  public void returnCellWhenAttacked() {
    Assert.assertEquals(cell1.returnCellWhenAttacked(), new OpenSeaCell(isHit, posn1));
    Assert.assertEquals(cell2.returnCellWhenAttacked(), new OpenSeaCell(isHit, posn1));
  }

  @Test
  public void update() {
    cell1.update(ship);
    Assert.assertEquals(cell1, new OpenSeaCell(isHit, posn1));
  }

//  @Test
//  public void testEquals() {
//    Assert.assertEquals(cell1, sameRefAWCell);
//    Assert.assertEquals(cell1, sameStateAWCell);
//    Assert.assertEquals(cell1, yetAnotherAWCell);
//    Assert.assertNotEquals(cell1, nullAWCell);
//    Assert.assertNotEquals(cell1, cell2);
//    Assert.assertNotEquals(cell1, cell3);
//    Assert.assertNotEquals(cell1, cell4);
//  }
//
//  @Test
//  public void testHshCode() {
//    Assert.assertEquals(cell1.equals(sameStateAWCell), cell1.hashCode() == sameStateAWCell
//        .hashCode());
//    Assert.assertEquals(cell1.equals(cell2), cell1.hashCode() == cell2.hashCode());
//  }

  @Test
  public void testToString() {
    String str = "OpenSeaCell{isHit=true, position=Posn{coordinateX=3, coordinateY=6}}";
    Assert.assertEquals(cell1.toString(), str);
  }
}