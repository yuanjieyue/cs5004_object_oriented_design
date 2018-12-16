package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.printer.ConsolePrinter;

public class GapCellTest {
  private Boolean isHit;
  private Boolean notIsHit;
  private Posn posn1;
  private Posn posn2;
  private GapCell cell1;
  private GapCell cell2;
  private OpenSeaCell cell3;
  private GapCell sameRefAWCell;
  private GapCell sameStateAWCell;
  private GapCell yetAnotherAWCell;
  private GapCell nullAWCell;

  @Before
  public void setUp() throws Exception {
    isHit = new Boolean(true);
    notIsHit = new Boolean(false);
    posn1 = new Posn(3,6);
    posn2 = new Posn(8, 2);
    cell1 = new GapCell(isHit, posn1);
    cell2 = new GapCell(notIsHit, posn2);
    cell3 = new OpenSeaCell(isHit, posn1);
    sameRefAWCell = cell1;
    sameStateAWCell = new GapCell(isHit, posn1);
    yetAnotherAWCell = new GapCell(isHit, posn1);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(cell1.placeShipOnCell(), new Boolean(false));
    Assert.assertEquals(cell2.placeShipOnCell(), new Boolean(false));
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

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cell1.equals(sameStateAWCell), cell1.hashCode() == sameStateAWCell
        .hashCode());
    Assert.assertEquals(cell1.equals(cell2), cell1.hashCode() == cell2.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = new String("GapCell{isHit=true, position=Posn{coordinateX=3, "
        + "coordinateY=6}}");
    Assert.assertEquals(cell1.toString(), tempStr);
  }
}