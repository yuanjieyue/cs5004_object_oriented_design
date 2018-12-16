package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class OpenSeaCellTest {
  private Boolean isHit;
  private Boolean notIsHit;
  private Posn posn1;
  private Posn posn2;
  private OpenSeaCell cell1;
  private OpenSeaCell cell2;
  private GapCell cell3;
  private OpenSeaCell sameRefAWCell;
  private OpenSeaCell sameStateAWCell;
  private OpenSeaCell yetAnotherAWCell;
  private OpenSeaCell nullAWCell;
  private OpenSeaCell cell4;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    posn1 = new Posn(3,6);
    posn2 = new Posn(8, 2);
    cell1 = new OpenSeaCell(isHit, posn1);
    cell2 = new OpenSeaCell(notIsHit, posn2);
    cell3 = new GapCell(isHit, posn1);
    cell4 = new OpenSeaCell(isHit, (Posn) null);
    sameRefAWCell = cell1;
    sameStateAWCell = new OpenSeaCell(isHit, posn1);
    yetAnotherAWCell = new OpenSeaCell(isHit, posn1);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(true));
    Assert.assertEquals(cell2.placeShipOnCell(), new Boolean(true));
  }

  @Test
  public void prettyPrint() {
    ConsolePrinter printer = new ConsolePrinter();
    cell1.prettyPrint(printer);
    cell2.prettyPrint(printer);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cell1.equals(cell1));
    Assert.assertTrue(cell1.equals(sameStateAWCell));
    Assert.assertTrue(cell1.equals(sameRefAWCell));
    Assert.assertFalse(cell1.equals(cell3));
    Assert.assertEquals(cell1.equals(sameStateAWCell) && sameStateAWCell.equals
        (yetAnotherAWCell), yetAnotherAWCell.equals(cell1));
    Assert.assertFalse(cell1.equals(cell2));
    Assert.assertFalse(cell1.equals(nullAWCell));
    Assert.assertNotEquals(cell1, cell4);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cell1.equals(sameStateAWCell), cell1.hashCode() == sameStateAWCell
        .hashCode());
    Assert.assertEquals(cell1.equals(cell2), cell1.hashCode() == cell2.hashCode());
    Assert.assertNotEquals(cell1.hashCode(), cell4.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("OpenSeaCell{isHit=true, position=Posn{coordinateX=3, "
        + "coordinateY=6}}");
    Assert.assertEquals(cell1.toString(), tempStr);
  }
}